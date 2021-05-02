package fr.istic.assoumou.manivoule.jaxrs.rest;

import fr.istic.assoumou.manivoule.jaxrs.business.Section;
import fr.istic.assoumou.manivoule.jaxrs.business.TableauKanban;
import fr.istic.assoumou.manivoule.jaxrs.dto.TableauKanbanDto;
import fr.istic.assoumou.manivoule.jaxrs.service.TableauKanbanService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/kanban")
public class TableauKanbanResource {

    TableauKanbanService tbkService = new TableauKanbanService();

    class ReponseFormat {
        int id;
        int count;
        TableauKanban result[];

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

        public TableauKanban[] getResult() {
            return result;
        }

        public void setResult(TableauKanban[] result) {
            this.result = result;
        }
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllTableauKanban() {

        List<TableauKanban> tbkList= tbkService.getTbkDao();

        ReponseFormat reponseFormat= new ReponseFormat();
        reponseFormat.id=1;
        reponseFormat.count= tbkList.size();
        reponseFormat.result= new TableauKanban[reponseFormat.count];

        tbkList.toArray(reponseFormat.result);

        return Response.status(200).entity(reponseFormat).build();
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createTableauKanban(TableauKanbanDto tbkDto){
        boolean success = false;
        if (tbkService.createTbk(tbkDto)!=null){
            success=true;
        }
        return Response.status(200)
                .entity(success).build();
    }
    @POST
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOneTbk(@PathParam("id")int idTbk){
        return Response.status(200)
                .entity(tbkService.getTableauKanbanDao(idTbk)).build();

    }

    //Useless
    @POST
    @Path("/{id}/{idsection}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addSectionToTbk(@PathParam("id")int idTbk ,@PathParam("idsection")int idSec){
        return Response.status(200)
                .entity(tbkService.addSectionToTbk(idTbk,idSec)).build();

    }
}
