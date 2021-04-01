package fr.istic.assoumou.manivoule.jaxrs.service;

import fr.istic.assoumou.manivoule.jaxrs.business.Collaborateur;
import fr.istic.assoumou.manivoule.jaxrs.dao.CollaborateurDao;
import fr.istic.assoumou.manivoule.jaxrs.dto.CollaborateurDto;
import fr.istic.assoumou.manivoule.jaxrs.rest.CollaborateurResource;

import java.util.ArrayList;
import java.util.List;

public class CollaborateurService {

    CollaborateurDao collaborateurDao = new CollaborateurDao();

    public CollaborateurDto getCollaborateurByEmail(String email) {
        Collaborateur collab = collaborateurDao.findOne(email);
        CollaborateurDto collabDto = null;
        if(collab != null ) {
            collabDto = new CollaborateurDto();
            collabDto.setEmail(collab.getEmail());
            collabDto.setMatricule(collab.getMatricule());
            collabDto.setName(collab.getName());

        }
        return collabDto;
    }

    public List<CollaborateurDto> getCollaborateurs() {
        List<Collaborateur> collab = collaborateurDao.findAll();
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

        collaborateurDao.save(c);

        return collab;
    }
}
