package fr.pantheonsorbonne.ufr27.miage.resources;

import fr.pantheonsorbonne.ufr27.miage.service.TicketingService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("ticket")
public class TicketResource {


    @Inject
    TicketingService ticketingService;

    @Path(("/validity"))
    @POST
    @Produces({MediaType.TEXT_PLAIN})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public boolean isTicketValid(Ticket t) {
        return ticketingService.validateTicket(t);
    }

}
