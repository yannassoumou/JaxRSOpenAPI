package fr.istic.assoumou.manivoule.jaxrs.business;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class TableauKanban {

    int id_tableau;
    String name;
    Collection<Section> section = new ArrayList<Section>();

    public TableauKanban(String name) {
        this.name = name;
    }

    public TableauKanban() {

    }

    @OneToMany(mappedBy = "tbk")
    public Collection<Section> getSection() {
        return section;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId_tableau() {
        return id_tableau;
    }

    public void setId_tableau(int id_tableau) {
        this.id_tableau = id_tableau;
    }
    public void setSection(Collection<Section> section) {
        this.section = section;
    }

    public void setElementSection(Section section) {
        if (section != null && !this.section.contains(section))
            this.section.add(section);
    }

}



