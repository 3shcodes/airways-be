package str.project.airwaysbe.services.impls;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import str.project.airwaysbe.database.TickTable;
import str.project.airwaysbe.models.Ticket;
import str.project.airwaysbe.services.TicketContracts;
import str.project.airwaysbe.utils.Response;


@Service
@AllArgsConstructor
public class TicketServices implements TicketContracts{

    private TickTable tickets;

    @Override
    public Response<Ticket> bookTicket(Ticket newTicket){


        Date cd = new Date();
        long stMills = cd.getTime();
        newTicket.setPnrNo(Long.toString(stMills));

        Ticket resTicket = tickets.save(newTicket);

        return new Response<Ticket>( resTicket, "Successfully booked", HttpStatus.OK, true );

    }


    @Override
    public Response<Ticket> cancelTicket(String pnrNo){

        List<Ticket> resTicks = tickets.findBypnrNo(pnrNo);
        if ( resTicks.size() != 1 ) {
            return new Response<Ticket>(null, pnrNo, HttpStatus.BAD_REQUEST, false);
        }

        tickets.deleteByPnrNo(null);
        
        return new Response<Ticket>(null, "Successfully cancelled", HttpStatus.OK, true);

    }
}
