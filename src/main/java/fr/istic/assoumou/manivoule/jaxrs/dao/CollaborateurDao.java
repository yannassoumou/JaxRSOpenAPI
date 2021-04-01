package fr.istic.assoumou.manivoule.jaxrs.dao;

import fr.istic.assoumou.manivoule.jaxrs.business.Collaborateur;

import java.util.ArrayList;
import java.util.List;

public class CollaborateurDao extends AbstractJpaDao<String, Collaborateur>  {

    public Collaborateur findOne(String email) {
        List<Collaborateur> coll = new ArrayList<>();
                coll = this.entityManager.createQuery("select c from Collaborateur as c where c.email = :email")
                .setParameter("email", email).getResultList();
        if (! coll.isEmpty())
            return coll.get(0);
        else
            return null;
    }

    public List<Collaborateur> findAll() {
        List<Collaborateur> coll = this.entityManager.createQuery("select c from Collaborateur as c").getResultList();
        return coll;
    }



}
