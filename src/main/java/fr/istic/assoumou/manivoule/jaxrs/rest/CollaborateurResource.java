package fr.istic.assoumou.manivoule.jaxrs.rest;


import fr.istic.assoumou.manivoule.jaxrs.dto.CollaborateurDto;
import fr.istic.assoumou.manivoule.jaxrs.service.CollaborateurService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/collab")
public class CollaborateurResource {

    CollaborateurService collaborateurService = new CollaborateurService();

    @GET
    @Path("{email}")
    @Produces( MediaType.APPLICATION_JSON)
    public Response getCollaborateurByEmail(@PathParam("email") String email) {
        CollaborateurDto res = collaborateurService.getCollaborateurByEmail(email);
        if (res == null) {
            return Response.status(200).entity("Ce collaborateure n'existe pas !").build();
        }
        return Response.status(200)
                .entity(collaborateurService.getCollaborateurByEmail(email)).build();
    }

    @GET
    @Produces( MediaType.APPLICATION_JSON)
    public Response getCollaborateurs() {
        //return Response.ok(service.getCollaborateurByEmail(email)).build();
        return Response.status(200)
                .entity(collaborateurService.getCollaborateurs()).build();
    }

    @POST
    @Produces( MediaType.APPLICATION_JSON)
    @Consumes( MediaType.APPLICATION_JSON)
    public CollaborateurDto createCollaborateur(CollaborateurDto collab) {
        CollaborateurDto res = collaborateurService.createCollaborateur(collab);
        return res;
    }

}
