package fr.istic.assoumou.manivoule.jaxrs.service;

import fr.istic.assoumou.manivoule.jaxrs.business.Collaborateur;
import fr.istic.assoumou.manivoule.jaxrs.business.Fiche;
import fr.istic.assoumou.manivoule.jaxrs.business.Section;
import fr.istic.assoumou.manivoule.jaxrs.dao.CollaborateurDao;
import fr.istic.assoumou.manivoule.jaxrs.dao.FicheDao;
import fr.istic.assoumou.manivoule.jaxrs.dao.SectionDao;
import fr.istic.assoumou.manivoule.jaxrs.dto.CollaborateurDto;
import fr.istic.assoumou.manivoule.jaxrs.dto.FicheDto;
import fr.istic.assoumou.manivoule.jaxrs.dto.MoveFicherequest;

import java.util.ArrayList;
import java.util.List;

public class FicheService {
    FicheDao ficheDao = new FicheDao();
    SectionDao sectionDao = new SectionDao();

    public List<FicheDto> getFiches() {
        List<Fiche> fiches = ficheDao.findAll();
        return formatListFiche(fiches);
    }

    public List<FicheDto> getFicheByRespEmail(String respEmail) {
        List<Fiche> fiches = ficheDao.findByResponsable(respEmail);
        return formatListFiche(fiches);
    }

    public List<FicheDto> getFicheBySection(int sectionId) {
        List<Fiche> fiches = ficheDao.findBySection(sectionId);

        return formatListFiche(fiches);
    }

    public List<FicheDto> getFicheBySectionByRespEmail(int sectionId, String respEmail) {
        List<Fiche> fiches = ficheDao.findBySectionByRespEmail(sectionId, respEmail);

        return formatListFiche(fiches);
    }


    public List<FicheDto> formatListFiche(List<Fiche> fiches) {
        List<FicheDto> res = new ArrayList<>();
        if (!fiches.isEmpty()) {
            fiches.forEach(f -> {
                FicheDto uneFiche = new FicheDto(f.getId_fiche(), f.getLibelle(), f.getDateFin(),
                        f.getTimeTodo(), f.getLieu(), f.getUrl(), f.getNote(),
                         f.getSection(), f.getFicheTag());
                if (f.getResponsable() != null) {
                    uneFiche.setResponsable(f.getResponsable());
                }
                res.add(uneFiche);
            });
        }
        return res;
    }


    public Boolean createFiche(FicheDto ficheDto) {

        Collaborateur coll = null;
        if (ficheDto.getEmailResp() != null) {
            CollaborateurDao collDao = new CollaborateurDao();
            coll = collDao.findOne(ficheDto.getEmailResp());
        }
        SectionDao sectionDao = new SectionDao();
        Section section = sectionDao.findById(ficheDto.getSectionId());

        Fiche newFiche = new Fiche(
                ficheDto.getLibelle(), ficheDto.getDateFin(), ficheDto.getTimeTodo(),
                ficheDto.getLieu(), ficheDto.getUrl(), ficheDto.getNote(),
                coll, section, ficheDto.getFicheTag()
        );
        ficheDao.save(newFiche);
        if (section == null) return false;
        return true;
    }

    public List<FicheDto> moveFiche(int id_fiche, int section_from, int section_to) {
        List<Fiche> fiches = new ArrayList<>();
        if (id_fiche != 0) {
            fiches.add(ficheDao.findById(id_fiche));
        }
        //Section from = sectionDao.findById(request.getSection_from_id());
        Section to = sectionDao.findById(section_to);
//
        if (fiches.get(0) != null) {
            fiches.get(0).setSection(to);
        }

        ficheDao.update(fiches.get(0));

        return formatListFiche(fiches);
    }

    public boolean deleteFicheById(int id_fiche) {
        Fiche f = ficheDao.findById(id_fiche);
        ficheDao.delete(f);
        return f != null;
    }



}
