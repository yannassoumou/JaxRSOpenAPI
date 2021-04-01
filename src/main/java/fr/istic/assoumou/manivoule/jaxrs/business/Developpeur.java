package fr.istic.assoumou.manivoule.jaxrs.business;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("Developpeur")
public class Developpeur extends Collaborateur{

    private Manager manager;

    public Developpeur(String matricule, String mail, String name) {
        super(matricule, mail, name);
    }

    public Developpeur() {

    }

    @OneToOne
    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

}
