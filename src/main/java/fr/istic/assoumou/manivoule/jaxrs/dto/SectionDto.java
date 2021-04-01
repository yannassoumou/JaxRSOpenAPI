package fr.istic.assoumou.manivoule.jaxrs.dto;

import fr.istic.assoumou.manivoule.jaxrs.business.Fiche;
import fr.istic.assoumou.manivoule.jaxrs.business.TableauKanban;

import java.util.ArrayList;
import java.util.Collection;

public class SectionDto {
    private int id_section;
    private String name_section;
    private Boolean state;
    private TableauKanban tbk;
    private Collection<Fiche> parentFiche = new ArrayList<Fiche>();

    public SectionDto(int id_section, String name_section, Boolean state, TableauKanban tbk, Collection<Fiche> parentFiche) {
        this.id_section = id_section;
        this.name_section = name_section;
        this.state = state;
        this.tbk = tbk;
        this.parentFiche = parentFiche;
    }

    public int getId_section() {
        return id_section;
    }

    public void setId_section(int id_section) {
        this.id_section = id_section;
    }

    public String getName_section() {
        return name_section;
    }

    public void setName_section(String name_section) {
        this.name_section = name_section;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public TableauKanban getTbk() {
        return tbk;
    }

    public void setTbk(TableauKanban tbk) {
        this.tbk = tbk;
    }

    public Collection<Fiche> getParentFiche() {
        return parentFiche;
    }

    public void setParentFiche(Collection<Fiche> parentFiche) {
        this.parentFiche = parentFiche;
    }
}
