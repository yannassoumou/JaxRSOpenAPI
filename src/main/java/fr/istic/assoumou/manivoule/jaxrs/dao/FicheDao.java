package fr.istic.assoumou.manivoule.jaxrs.dao;

import fr.istic.assoumou.manivoule.jaxrs.business.Fiche;

import java.util.List;

public class FicheDao extends AbstractJpaDao<Integer, Fiche> {

    public Fiche findById(Integer fiche_id) {
        List<Fiche> fiche = this.entityManager
                .createQuery("select f from Fiche as f where f.id_fiche = :id")
                .setParameter("id", fiche_id)
                .getResultList();
        return fiche.get(0);
    }

    public List<Fiche> findAll() {
        return this.entityManager
                .createQuery("select f from Fiche as f", Fiche.class)
                .getResultList();
    }

    public List<Fiche> findByResponsable(String respEmail) {
        List<Fiche> fiches = this.entityManager
                .createQuery("select f from Fiche as f where f.responsable.email = :email", Fiche.class)
                .setParameter("email", respEmail)
                .getResultList();

        return fiches;
    }

    public List<Fiche> findBySection(int sectionId) {
        return this.entityManager
                .createQuery("select f from Fiche as f where f.section.id_section = :id")
                .setParameter("id", sectionId).getResultList();

    }

    public List<Fiche> findBySectionByRespEmail(int sectionId, String respEmail) {
        return this.entityManager
                .createQuery("select f from Fiche as f where f.section.id_section = :id and f.responsable.email = :email")
                .setParameter("id", sectionId)
                .setParameter("email", respEmail)
                .getResultList();
    }



}
