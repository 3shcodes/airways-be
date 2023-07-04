package str.project.airwaysbe.database;

import org.springframework.data.jpa.repository.JpaRepository;

import str.project.airwaysbe.models.Ticket;
import java.util.*;


public interface TickTable extends JpaRepository<Ticket,Integer>{
    
    List<Ticket> findBypnrNo(String pnrNo);
    void deleteByPnrNo(String pnrNo);

}
