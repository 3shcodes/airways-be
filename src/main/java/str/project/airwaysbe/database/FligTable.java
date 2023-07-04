package str.project.airwaysbe.database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import str.project.airwaysbe.models.Flight;

public interface FligTable extends JpaRepository<Flight,Integer>{
    List<Flight> findBySourceAndDestination(String source, String destination);
    List<Flight> findByFlightNameContainingIgnoreCase(String fliName);
    List<Flight> findBySourceOrDestinationContainingIgnoreCase(String from, String to);
}
