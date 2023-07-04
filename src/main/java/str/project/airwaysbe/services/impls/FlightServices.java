package str.project.airwaysbe.services.impls;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import str.project.airwaysbe.database.FligTable;
import str.project.airwaysbe.models.Flight;
import str.project.airwaysbe.utils.Response;
import str.project.airwaysbe.services.FlightContracts;

@Service
@AllArgsConstructor
public class FlightServices implements FlightContracts {
    
    private FligTable flights;

    public Response<List<Flight>> getByPlace(String from, String to){
        List<Flight> resFlights = flights.findBySourceAndDestination(from, to);
        return new Response<List<Flight>>(resFlights, "Flights fetched successfully", HttpStatus.ACCEPTED, true);
    }

    public Response<List<Flight>> searchByName(String fliName){
        List<Flight> resFlights = flights.findByFlightNameContainingIgnoreCase(fliName);
        return new Response<List<Flight>>(resFlights, "Flights fetched successfully", HttpStatus.ACCEPTED, true);
    }

    public Response<List<Flight>> searchByPlace(String from, String to){
        List<Flight> resFlights = flights.findBySourceOrDestinationContainingIgnoreCase(from, to);
        return new Response<List<Flight>>(resFlights, "Flights fetched successfully", HttpStatus.ACCEPTED, true);
    }
    
}
