package fr.istic.assoumou.manivoule.jaxrs.service;

import fr.istic.assoumou.manivoule.jaxrs.business.Section;
import fr.istic.assoumou.manivoule.jaxrs.business.TableauKanban;
import fr.istic.assoumou.manivoule.jaxrs.dao.SectionDao;
import fr.istic.assoumou.manivoule.jaxrs.dao.TableauKanbanDao;
import fr.istic.assoumou.manivoule.jaxrs.dto.SectionDto;
import fr.istic.assoumou.manivoule.jaxrs.dto.TableauKanbanDto;

import java.util.Collection;
import java.util.List;

public class SectionService {

    SectionDao sectionDao = new SectionDao();
    TableauKanbanDao tableauKanbanDao = new TableauKanbanDao();


    public SectionDto createSection(SectionDto sectionDto) {
        Section section = new Section(sectionDto.getName_section(), sectionDto.getState());
        sectionDao.save(section);
        return sectionDto;
    }

    public List<Section> getSectionDao() {
        return sectionDao.findAll();
    }


    public boolean addSectionToKanban(int id_section, int id_tableau) {
        Section section = sectionDao.findById(id_section);
        TableauKanban tk = tableauKanbanDao.findById(id_tableau);

        SectionDto sectionDto;
        TableauKanbanDto tableauKanbanDto;

        if (section != null && tk != null) {
            Collection<Section> listSection = tk.getSection();


            if (!listSection.contains(section)) {
                listSection.add(section);
            }
            tk.setSection(listSection);
        } else {
            return false;
        }

        sectionDao.update(section);
        tableauKanbanDao.update(tk);
        return true;
    }

}
