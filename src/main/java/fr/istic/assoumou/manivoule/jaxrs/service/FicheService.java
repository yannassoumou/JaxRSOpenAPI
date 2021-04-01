package fr.istic.assoumou.manivoule.jaxrs.service;

import fr.istic.assoumou.manivoule.jaxrs.business.Collaborateur;
import fr.istic.assoumou.manivoule.jaxrs.dao.CollaborateurDao;
import fr.istic.assoumou.manivoule.jaxrs.dao.FicheDao;
import fr.istic.assoumou.manivoule.jaxrs.dto.CollaborateurDto;
import fr.istic.assoumou.manivoule.jaxrs.dto.FicheDto;

import java.util.ArrayList;
import java.util.List;

public class FicheService {
    FicheDao dao = new FicheDao();

    public List<FicheDto> getFicheByRespEmail(String resp_email) {

        return null;
    }

    public List<FicheDto> getFicheBySection(String section_name) {

        return null;
    }

    public List<FicheDto> getFicheBySectionByRespEmail(String section, String email) {

        return null;
    }


}
