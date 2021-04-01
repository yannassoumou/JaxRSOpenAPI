package fr.istic.assoumou.manivoule.jaxrs.dto;

import fr.istic.assoumou.manivoule.jaxrs.business.Fiche;

import java.util.ArrayList;
import java.util.Collection;

public class CollaborateurDto {

    private String matricule;
    private String email;
    private String name;

    private Collection<Fiche> fiche = new ArrayList<Fiche>();

    public CollaborateurDto(String matricule, String email, String name, Collection<Fiche> fiche) {
        this.matricule = matricule;
        this.email = email;
        this.name = name;
        this.fiche = fiche;
    }

    public CollaborateurDto() {}

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Fiche> getFiche() {
        return fiche;
    }

    public void setFiche(Collection<Fiche> fiche) {
        this.fiche.addAll(fiche);
    }


}
