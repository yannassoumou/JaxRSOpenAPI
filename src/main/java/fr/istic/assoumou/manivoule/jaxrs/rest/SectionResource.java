package fr.istic.assoumou.manivoule.jaxrs.rest;

import fr.istic.assoumou.manivoule.jaxrs.business.Section;
import fr.istic.assoumou.manivoule.jaxrs.dto.SectionDto;
import fr.istic.assoumou.manivoule.jaxrs.dto.TableauKanbanDto;
import fr.istic.assoumou.manivoule.jaxrs.service.SectionService;
import fr.istic.assoumou.manivoule.jaxrs.service.TableauKanbanService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/section")
public class SectionResource {
    SectionService sectionService = new SectionService();
    TableauKanbanService tableauKanbanService = new TableauKanbanService();

    @GET
    @Path("/{section_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSectionById(@PathParam("section_id") Integer section_id) {
        Section section = sectionService.getSectionByIdDao(section_id);
        return Response.status(200).entity(section).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSection() {
        List<Section> sectionList = sectionService.getSectionDao();
        return Response.status(200).entity(sectionList).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addSection(SectionDto sectionDto) {
        return Response.status(200).entity(sectionService.createSection(sectionDto)).build();
    }

    @POST
    @Path("/kanban")
    @Produces( MediaType.APPLICATION_JSON)
    @Consumes( MediaType.APPLICATION_JSON)
    public Response addSectionToKanban(@RequestBody SectionDto sectionDto ){
        return Response.status(200).entity(sectionService.addSectionToKanban(sectionDto.getId_section(),sectionDto.getId_tableau())).build();
    }

}
