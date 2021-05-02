package fr.istic.assoumou.manivoule.jaxrs.service;

import fr.istic.assoumou.manivoule.jaxrs.business.Section;
import fr.istic.assoumou.manivoule.jaxrs.business.TableauKanban;
import fr.istic.assoumou.manivoule.jaxrs.dao.SectionDao;
import fr.istic.assoumou.manivoule.jaxrs.dao.TableauKanbanDao;
import fr.istic.assoumou.manivoule.jaxrs.dto.TableauKanbanDto;

import java.util.Collection;
import java.util.List;

public class TableauKanbanService {
    TableauKanbanDao tableauKanbanDao = new TableauKanbanDao();
    SectionDao sectionDao = new SectionDao();

    public List<TableauKanban> getTbkDao() {
        return tableauKanbanDao.findAll();
    }

    public TableauKanbanDto getTableauKanbanDao(int id_kanban) {
        TableauKanban tk = tableauKanbanDao.findById(id_kanban).get(0);
        TableauKanbanDto tkDto = new TableauKanbanDto();
        if (tk != null) {
            tkDto.setId_tableau(tk.getId_tableau());
            tkDto.setName(tk.getName());
            tkDto.setSection(tk.getSection());
        }
        return tkDto;
    }

    public TableauKanbanDto createTbk(TableauKanbanDto tbkDto) {
        TableauKanban tbk = new TableauKanban(tbkDto.getName());
        tableauKanbanDao.save(tbk);
        return tbkDto;
    }

    public boolean addSectionToTbk(int idTbk, int idSec) {
        Section section = sectionDao.findById(idSec);
        TableauKanban tk = tableauKanbanDao.findById(idTbk).get(0);
        if (section == null || tk == null) return false;

        Collection<Section> sectionTbk = tk.getSection();
        sectionTbk.add(section);
        tk.setSection(sectionTbk);
        return true;
    }
}
