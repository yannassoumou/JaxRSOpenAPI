package fr.istic.assoumou.manivoule.jaxrs.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Fiche implements Serializable {

    int id_fiche;
    String libelle;
    Date dateFin;
    String timeTodo;
    List<Tag> ficheTag = new ArrayList<>();
    String lieu;
    String url;
    String note;

    Collaborateur responsable;
    Section section;

    public Fiche(String libelle, Date dateFin, String timeTodo, String lieu, String url, String note, Collaborateur responsable, Section section, List<Tag> tags) {
        this.libelle = libelle;
        this.dateFin = dateFin;
        this.timeTodo = timeTodo;
        this.lieu = lieu;
        this.url = url;
        this.note = note;
        this.responsable = responsable;
        this.section = getSection();
        this.ficheTag = tags;
        this.section = section;
    }

    public Fiche(String libelle, Section section) {
        this.libelle = libelle;
        this.section = section;
    }

    public Fiche(String libelle) {
        this.libelle = libelle;

    }

    public Fiche() {

    }


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "fiche_tag",
            joinColumns = @JoinColumn(name = "id_fiche"),
            inverseJoinColumns = @JoinColumn(name = "id_tag")
    )

    public List<Tag> getFicheTag() {
        return ficheTag;
    }

    public void setFicheTag(List<Tag> ficheTag) {
        this.ficheTag.addAll(ficheTag);
    }

    @JsonIgnore
    @ManyToOne
    public Collaborateur getResponsable() {
        return responsable;
    }

    public void setResponsable(Collaborateur responsable) {
        this.responsable = responsable;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId_fiche() {
        return id_fiche;
    }

    public void setId_fiche(int id_fiche) {
        this.id_fiche = id_fiche;
    }

    @JsonIgnore
    @ManyToOne
    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }


    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }


    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getTimeTodo() {
        return timeTodo;
    }

    public void setTimeTodo(String timeTodo) {
        this.timeTodo = timeTodo;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


}
