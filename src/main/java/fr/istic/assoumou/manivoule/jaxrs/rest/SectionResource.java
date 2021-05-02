package fr.istic.assoumou.manivoule.jaxrs.rest;

import fr.istic.assoumou.manivoule.jaxrs.business.Section;
import fr.istic.assoumou.manivoule.jaxrs.dto.SectionDto;
import fr.istic.assoumou.manivoule.jaxrs.dto.TableauKanbanDto;
import fr.istic.assoumou.manivoule.jaxrs.service.SectionService;
import fr.istic.assoumou.manivoule.jaxrs.service.TableauKanbanService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Path("/section")
public class SectionResource {
    SectionService sectionService = new SectionService();
    TableauKanbanService tableauKanbanService = new TableauKanbanService();

    class ReponseFormat {
        int id;
        int count;
        Section result[];

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public Section[] getResult() {
            return result;
        }

        public void setResult(Section[] result) {
            this.result = result;
        }
    }

    @GET
    @Path("/home")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHomeSection() {
        return Response.status(200).entity("Ok").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSection() {

        List<Section> sectionList = sectionService.getSectionDao();

        ReponseFormat reponseFormat = new ReponseFormat();
        reponseFormat.id = 1;
        reponseFormat.count = sectionList.size();
        reponseFormat.result = new Section[reponseFormat.count];

        sectionList.toArray(reponseFormat.result);

        //reponseFormat.result
        return Response.status(200)
                .entity(reponseFormat)
                .build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addSection(SectionDto sectionDto) {
        boolean success = false;
        if (sectionService.createSection(sectionDto) != null) {
            success = true;
        }
        return Response.status(200)
                .entity(success).build();
    }

    @POST
    @Path("/kanban")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addSectionToKanban(@RequestBody SectionDto sectionDto) {
        //return Response.status(200).entity(sectionDto).build();
        return Response.status(200).entity(sectionService.addSectionToKanban(sectionDto.getId_section(), sectionDto.getId_tableau())).build();
    }

}
