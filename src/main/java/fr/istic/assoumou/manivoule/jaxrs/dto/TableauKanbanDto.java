package fr.istic.assoumou.manivoule.jaxrs.dto;

import fr.istic.assoumou.manivoule.jaxrs.business.Section;

import java.util.ArrayList;
import java.util.Collection;


public class TableauKanbanDto {
    int id_tableau;
    String name;
    Collection<Section> section = new ArrayList<Section>();

    public int getId_tableau() {
        return id_tableau;
    }

    public void setId_tableau(int id_tableau) {
        this.id_tableau = id_tableau;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Section> getSection() {
        return section;
    }

    public void setSection(Collection<Section> section) {
        this.section = section;
    }
}
