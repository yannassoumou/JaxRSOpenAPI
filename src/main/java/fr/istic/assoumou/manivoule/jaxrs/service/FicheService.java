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

    public List<FicheDto> getFiche() {
        List<Fiche> fiches = ficheDao.findAll();
        return formatListFiche(fiches);
    }

    public List<FicheDto> getFicheByRespEmail(String respEmail) {
        List<Fiche> fiches = ficheDao.findByRespEmail(respEmail);
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
                        f.getResponsable(), f.getSection(), f.getFicheTag());
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
        return true;
    }

    public Fiche moveFiche(MoveFicherequest request) {
        Fiche fiche = null;
        if (request.getId_fiche() != 0) {
            fiche = ficheDao.findOne(request.getId_fiche());
        }
        //Section from = sectionDao.findById(request.getSection_from_id());
        //Section to = sectionDao.findById(request.getSection_to_id());
//
        //if (fiche != null) {
        //    fiche.setSection(to);
        //}

        return fiche;
    }


}
