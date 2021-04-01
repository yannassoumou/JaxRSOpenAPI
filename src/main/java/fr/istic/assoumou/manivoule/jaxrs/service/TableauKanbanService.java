package fr.istic.assoumou.manivoule.jaxrs.service;

import fr.istic.assoumou.manivoule.jaxrs.business.TableauKanban;
import fr.istic.assoumou.manivoule.jaxrs.dao.TableauKanbanDao;
import fr.istic.assoumou.manivoule.jaxrs.dto.TableauKanbanDto;

public class TableauKanbanService {
    TableauKanbanDao tableauKanbanDao = new TableauKanbanDao();

    public TableauKanbanDto getTableauKanbanDao(int id_kanban) {
        TableauKanban tk = tableauKanbanDao.findById(id_kanban);
        TableauKanbanDto tkDto= null;
        if (tk !=null){
            tkDto.setName(tk.getName());
            }
        return tkDto;
    }
}
