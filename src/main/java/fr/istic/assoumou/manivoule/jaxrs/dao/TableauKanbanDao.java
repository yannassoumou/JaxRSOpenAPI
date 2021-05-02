package fr.istic.assoumou.manivoule.jaxrs.dao;

import fr.istic.assoumou.manivoule.jaxrs.business.Collaborateur;
import fr.istic.assoumou.manivoule.jaxrs.business.TableauKanban;
import fr.istic.assoumou.manivoule.jaxrs.dao.AbstractJpaDao;

import java.util.ArrayList;
import java.util.List;

public class TableauKanbanDao extends AbstractJpaDao<Long, TableauKanban> {

    public List<TableauKanban> findById(int id) {
        List<TableauKanban> tk = new ArrayList<>();
        tk = EntityManagerHelper.getEntityManager()
                .createQuery("select tk from TableauKanban as tk where tk.id_tableau = :id")
                .setParameter("id", id)
                .getResultList();
        return tk;
    }

    @Override
    public List<TableauKanban> findAll() {
        List<TableauKanban> listTbk = EntityManagerHelper.getEntityManager()
                .createQuery("select tbk from TableauKanban as tbk")
                .getResultList();
        return listTbk;
    }
}
