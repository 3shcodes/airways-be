package str.project.airwaysbe.services;

import java.util.List;

import str.project.airwaysbe.models.Flight;
import str.project.airwaysbe.utils.Response;

public interface FlightContracts {
    Response<List<Flight>> getByPlace(String from, String to);
    Response<List<Flight>> searchByName(String fliName);
    Response<List<Flight>> searchByPlace(String from, String to);
}
