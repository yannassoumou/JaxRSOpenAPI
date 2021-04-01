package fr.istic.assoumou.manivoule.jaxrs.dao;

import fr.istic.assoumou.manivoule.jaxrs.business.Collaborateur;
import fr.istic.assoumou.manivoule.jaxrs.business.TableauKanban;
import fr.istic.assoumou.manivoule.jaxrs.dao.AbstractJpaDao;

import java.util.ArrayList;
import java.util.List;

public class TableauKanbanDao extends AbstractJpaDao<Long, TableauKanban> {
    public TableauKanban findById(int id) {
        List<TableauKanban> tk = new ArrayList<>();
        tk = this.entityManager.createQuery("select tk from tableaukanban as tk where tk.id_tableau = :id")
                .setParameter("id", id).getResultList();
        if (! tk.isEmpty())
            return tk.get(0);
        else
            return null;
    }
}
