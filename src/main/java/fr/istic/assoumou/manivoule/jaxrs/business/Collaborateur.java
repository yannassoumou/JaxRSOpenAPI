package fr.istic.assoumou.manivoule.jaxrs.business;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_collaborateur")
@DiscriminatorValue("Collaborateur")
public class Collaborateur implements Serializable {

    private String matricule;
    private String email;
    private String name;

    Collection<Fiche> fiche = new ArrayList<Fiche>();

    public Collaborateur(String matricule, String mail, String name) {
        this.name = name;
        this.email = mail;
        this.matricule = matricule;
    }

    public Collaborateur() {

    }
    public void setEmail(String id) {
        this.email = email;
    }

    @Id
    public String getEmail() {
        return email;
    }

    @OneToMany(mappedBy = "responsable")
    public Collection<Fiche> getFiche() {
        return fiche;
    }

    public void setFiche(Collection<Fiche> fiche) {
        this.fiche = fiche;
    }

    public void setOneFiche(Fiche f) {
        if (f != null && !fiche.contains(f)) {
            f.setResponsable(this);
            fiche.add(f);
        }
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
