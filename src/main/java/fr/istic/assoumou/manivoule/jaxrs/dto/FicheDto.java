package fr.istic.assoumou.manivoule.jaxrs.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.istic.assoumou.manivoule.jaxrs.business.Collaborateur;
import fr.istic.assoumou.manivoule.jaxrs.business.Section;
import fr.istic.assoumou.manivoule.jaxrs.business.Tag;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class FicheDto {

    int id_fiche;
    String libelle;
    Date dateFin;
    String timeTodo;
    String lieu;
    String url;
    String note;
    int sectionId;
    String sectionName;
    String emailResp;
    List<Tag> ficheTag = new ArrayList<>();

    Collaborateur responsable;
    Section section;

    public FicheDto(){}

    public FicheDto(int id_fiche, String libelle, Date dateFin, String timeTodo, String lieu, String url, String note, Section section, List<Tag> tags) {
        this.id_fiche = id_fiche;
        this.libelle = libelle;
        this.dateFin = dateFin;
        this.timeTodo = timeTodo;
        this.lieu = lieu;
        this.url = url;
        this.note = note;
        this.section = section;
        this.sectionId = section.getId_section();
        this.sectionName = section.getName_section();
        //this.ficheTag.addAll(tags);
        //tags.forEach(t -> ficheTag.add(new Tag(t.getName())));
    }

    public int getId_fiche() {
        return id_fiche;
    }

    public void setId_fiche(int id_fiche) {
        this.id_fiche = id_fiche;
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

    public List<Tag> getFicheTag() {
        return ficheTag;
    }

    public void setOneFicheTag(Tag ficheTag) {
        this.ficheTag.add(ficheTag);
    }

    public void setListFicheTag(List<Tag> ficheTag) {
        this.ficheTag.addAll(ficheTag);
    }

    @JsonIgnore
    public Collaborateur getResponsable() {
        return responsable;
    }

    public void setResponsable(Collaborateur responsable) {
        this.responsable = responsable;
        this.emailResp = responsable.getEmail();
    }

    @JsonIgnore
    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public String getEmailResp() {
        return emailResp;
    }

    public void setEmailResp(String emailResp) {
        this.emailResp = emailResp;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }
}
