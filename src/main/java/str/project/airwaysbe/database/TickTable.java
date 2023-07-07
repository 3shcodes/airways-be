package str.project.airwaysbe.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import str.project.airwaysbe.models.Ticket;
import java.util.*;


public interface TickTable extends JpaRepository<Ticket,Integer>{
    
    List<Ticket> findBypnrNo(String pnrNo);
    List<Ticket> findByusername(String username);
    void deleteByPnrNo(String pnrNo);
    @Query( 
        value =  "SELECT ticket.id as id, username, flight.flight_number as flight_number, pnr_no, seats_booked, amount, fly_at, flight.source, flight.destination, flight.dept_time, flight.arr_time, flight.flight_name FROM ticket INNER JOIN flight ON ticket.flight_number = flight.flight_number WHERE ticket.username=:uname ",
        // value =  "SELECT username, pnr_no, seats_booked, amount, fly_at, source, destination, dept_time, arr_time, flight_name FROM ticket INNER JOIN flight ON ticket.flight_number = flight.flight_number WHERE ticket.username=:uname ",
        nativeQuery = true
    )
    List<Ticket> findJoined(@Param("uname") String uname);
    

}
