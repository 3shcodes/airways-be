package str.project.airwaysbe.services;

import str.project.airwaysbe.models.Ticket;
import str.project.airwaysbe.utils.Response;

public interface TicketContracts {
    Response<Ticket> bookTicket(Ticket newTicket);
    Response<Ticket> cancelTicket(String pnrNo);
}
