package fr.istic.assoumou.manivoule.jaxrs.rest;

import fr.istic.assoumou.manivoule.jaxrs.business.Collaborateur;
import fr.istic.assoumou.manivoule.jaxrs.business.Fiche;
import fr.istic.assoumou.manivoule.jaxrs.dao.CollaborateurDao;
import fr.istic.assoumou.manivoule.jaxrs.dao.SectionDao;
import fr.istic.assoumou.manivoule.jaxrs.dto.FicheDto;
import fr.istic.assoumou.manivoule.jaxrs.dto.MoveFicherequest;
import fr.istic.assoumou.manivoule.jaxrs.service.FicheService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/fiche")
public class FicheResource {

    FicheService ficheService = new FicheService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFiches() {
        List<FicheDto> res = ficheService.getFiches();

        if (!res.isEmpty()) {
            return Response.status(200)
                    .entity(res).build();
        } else {
            return Response.status(200).entity("Ce collaborateure n'a aucune fiche !").build();
        }
    }

    @GET
    @Path("resp/{email}")
    @Produces( MediaType.APPLICATION_JSON)
    public Response getFicheByRespEmail(@PathParam("email") String respEmail) {
        List<FicheDto> res = ficheService.getFicheByRespEmail(respEmail);

        if (!res.isEmpty()) {
            return Response.status(200)
                    .entity(res).build();
        } else {
            return Response.status(200).entity("Ce collaborateure n'a aucune fiche !").build();
        }
    }

    @GET
    @Path("section/{section_id}")
    @Produces( MediaType.APPLICATION_JSON)
    public Response getFicheBySection(@PathParam("section_id") Integer section_id) {
        List<FicheDto> res = ficheService.getFicheBySection(section_id);

        if (!res.isEmpty()) {
            return Response.status(200)
                    .entity(res).build();
        } else {
            return Response.status(200).entity("Ce collaborateure n'a aucune fiche !").build();
        }
    }

    @GET
    @Path("section/{section_id}/resp/{resp_email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFicheBySectionByResp(@PathParam("section_id") Integer section_id, @PathParam("resp_email") String resp_email) {
        List<FicheDto> res = ficheService.getFicheBySectionByRespEmail(section_id, resp_email);

        if (!res.isEmpty()) {
            return Response.status(200)
                    .entity(res).build();
        } else {
            return Response.status(200).entity("Ce collaborateure n'a aucune fiche !").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createFiche(FicheDto ficheDto) {
        boolean res = ficheService.createFiche(ficheDto);
        if (res) {
            return Response.status(200)
                    .entity(res).build();
        } else {
            return Response.status(200).entity("Erreur d'ajout !").build();
        }
        //return Response.status(200)
        //        .entity(ficheDto.getFicheTag()).build();
    }

    @PUT
    @Path("/{id_fiche}/{from}/{to}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response moveFiche(@PathParam("id_fiche") Integer id_fiche,
                              @PathParam("from") Integer from ,
                              @PathParam("to") Integer to) {

        List<FicheDto> res = ficheService.moveFiche(id_fiche, from, to);
        if (res != null) {
            return Response.status(200)
                    .entity(res).build();
        } else {
            return Response.status(200).entity("Erreur d'ajout !").build();
        }

    }

    @DELETE
    @Path("/{id_fiche}")
    @Produces( MediaType.APPLICATION_JSON)
    public Response deleteFiche(@PathParam("id_fiche") Integer id_fiche) {
        boolean res = ficheService.deleteFicheById(id_fiche);

        if (res) {
            return Response.status(204)
                    .entity(res).build();
        } else {
            return Response.status(200).entity("La fiche n'a pas été supprimée !").build();
        }
    }

    @PUT
    @Path("/{id_fiche}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces( MediaType.APPLICATION_JSON)
    public Response updateFiche(@PathParam("id_fiche") Integer id_fiche, FicheDto ficheDto) {
        FicheDto res = ficheService.updateFiche(id_fiche, ficheDto);
        if (res != null) {
            return Response.status(200)
                    .entity(res).build();
        } else {
            return Response.status(200).entity("La fiche n'a pas été supprimée !").build();
        }
    }


}
