package str.project.airwaysbe.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import str.project.airwaysbe.models.Ticket;
import str.project.airwaysbe.services.TicketContracts;
import str.project.airwaysbe.utils.Response;



@RestController
@RequestMapping("/ticket")
@AllArgsConstructor
public class TicketController {
    
    private TicketContracts tickServs;

    @PostMapping("/book")
    public ResponseEntity<Object> bookTicket (@RequestBody Ticket newTicket) {

        if ( newTicket.preValid() == false ) {
            return Response.send(null, "No data to enter", HttpStatus.BAD_REQUEST, false);
        }

        Response<Ticket> resp = tickServs.bookTicket(newTicket);
        return resp.send();
    }

    @DeleteMapping("/cancel")
    public ResponseEntity<Object> cancelTicket (@RequestParam String pnrNo) {

        if ( pnrNo.equals("")) {
            return Response.send(null, "No PNR no provided", HttpStatus.BAD_REQUEST, false);
        }

        Response<Ticket> resp = tickServs.cancelTicket(pnrNo);
        return resp.send();
    }
}
