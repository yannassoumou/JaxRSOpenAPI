package fr.istic.assoumou.manivoule.jaxrs.dao;

import fr.istic.assoumou.manivoule.jaxrs.business.Collaborateur;
import fr.istic.assoumou.manivoule.jaxrs.business.Section;
import fr.istic.assoumou.manivoule.jaxrs.business.TableauKanban;

import java.util.ArrayList;
import java.util.List;

public class SectionDao extends AbstractJpaDao<String, Section> {

    public Section findById(int id_section) {
        List<Section> s = new ArrayList<>();
        s = EntityManagerHelper.getEntityManager()
                .createQuery("select s from Section as s where s.id_section = :id")
                .setParameter("id", id_section)
                .getResultList();
        if (!s.isEmpty())
            return s.get(0);
        else
            return null;
    }

    @Override
    public List<Section> findAll() {
        List<Section> sectionList = EntityManagerHelper.getEntityManager()
                .createQuery("select s from Section as s")
                .getResultList();
        return sectionList;
    }
}
