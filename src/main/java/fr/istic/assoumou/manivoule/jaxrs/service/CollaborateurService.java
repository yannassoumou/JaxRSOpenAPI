package fr.istic.assoumou.manivoule.jaxrs.service;

import fr.istic.assoumou.manivoule.jaxrs.business.Collaborateur;
import fr.istic.assoumou.manivoule.jaxrs.dao.CollaborateurDao;
import fr.istic.assoumou.manivoule.jaxrs.dto.CollaborateurDto;
import fr.istic.assoumou.manivoule.jaxrs.rest.CollaborateurResource;

import java.util.ArrayList;
import java.util.List;

public class CollaborateurService {

    CollaborateurDao dao = new CollaborateurDao();

    public CollaborateurDto getCollaborateurByEmail(String email) {
        Collaborateur collab = dao.findOne(email);
        CollaborateurDto dto = null;
        if(collab != null ) {
            dto = new CollaborateurDto();
            dto.setEmail(collab.getEmail());
            dto.setMatricule(collab.getMatricule());
            dto.setName(collab.getName());

        }
        return dto;
    }

    public List<CollaborateurDto> getCollaborateurs() {
        List<Collaborateur> collab = dao.findAll();
        List<CollaborateurDto> res = new ArrayList<>();
        collab.forEach(r -> {
            CollaborateurDto dto = new CollaborateurDto();
            dto.setEmail(r.getEmail());
            dto.setMatricule(r.getMatricule());
            dto.setName(r.getName());
            res.add(dto);
        });
        return res;
    }



    public CollaborateurDto createCollaborateur(CollaborateurDto collab) {
        Collaborateur c = new Collaborateur(collab.getMatricule(), collab.getEmail(), collab.getName());

        dao.save(c);

        return collab;
    }
}
