package fr.istic.assoumou.manivoule.jaxrs.business;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("Manager")
public class Manager extends Collaborateur{

    private List<Developpeur> equipe = new ArrayList<>();

    public Manager() {}
    public Manager(String matricule, String mail, String name) {
        super(matricule, mail, name);
    }

    @OneToMany
    public List<Developpeur> getEquipe() {
        return equipe;
    }

    public void setEquipe(List<Developpeur> equipe) {
        this.equipe = equipe;
    }

}
