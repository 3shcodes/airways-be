package str.project.airwaysbe.services;

import java.util.List;

import str.project.airwaysbe.models.Ticket;
import str.project.airwaysbe.utils.Response;

public interface TicketContracts {
    Response<List<Ticket>> getTickets(String userName);
    Response<Ticket> bookTicket(Ticket newTicket);
    Response<Ticket> cancelTicket(String pnrNo);
}
