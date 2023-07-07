package str.project.airwaysbe.services.impls;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import str.project.airwaysbe.database.FligTable;
import str.project.airwaysbe.database.TickTable;
import str.project.airwaysbe.models.CustomTicket;
import str.project.airwaysbe.models.Flight;
import str.project.airwaysbe.models.Ticket;
import str.project.airwaysbe.services.TicketContracts;
import str.project.airwaysbe.utils.Response;


@Service
@AllArgsConstructor
public class TicketServices implements TicketContracts{

    @Autowired
    private TickTable tickets;
    @Autowired
    private FligTable flights;

    @Override
    public Response<List<Ticket>> getTickets(String userName){

        List<Ticket> ticks = tickets.findJoined(userName);
        return new Response<List<Ticket>>(ticks, "Tickets fetched successfully", HttpStatus.ACCEPTED, true);
    };


    @Override
    public Response<Ticket> bookTicket(Ticket newTicket){


        Date cd = new Date();
        long stMills = cd.getTime();
        newTicket.setPnrNo(Long.toString(stMills));

        Ticket resTicket = tickets.save(newTicket);

        List<Flight> resFlights = flights.findByFlightNumber(resTicket.getFlightNumber());
        Flight thatFlight = resFlights.get(0);

        thatFlight.setSeatAvailability(thatFlight.getSeatAvailability()-resTicket.getSeatsBooked());
        flights.save(thatFlight);
        

        return new Response<Ticket>( resTicket, "Successfully booked", HttpStatus.OK, true );

    }


    @Override
    public Response<Ticket> cancelTicket(String pnrNo){

        List<Ticket> resTicks = tickets.findBypnrNo(pnrNo);
        if ( resTicks.size() != 1 ) {
            return new Response<Ticket>(null, pnrNo, HttpStatus.BAD_REQUEST, false);
        }

        Ticket resTick = resTicks.get(0);
        int seatsBooked = resTick.getSeatsBooked();

        tickets.deleteById(resTick.getId());
        
        List<Flight> resFlights = flights.findByFlightNumber(resTick.getFlightNumber());
        Flight thatFlight = resFlights.get(0);

        thatFlight.setSeatAvailability(thatFlight.getSeatAvailability()+seatsBooked);
        flights.save(thatFlight);
        return new Response<Ticket>(null, "Successfully cancelled", HttpStatus.OK, true);

    }
}
