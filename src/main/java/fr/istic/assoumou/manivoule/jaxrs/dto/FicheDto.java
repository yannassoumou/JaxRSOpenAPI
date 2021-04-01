package fr.istic.assoumou.manivoule.jaxrs.dto;

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
    List<Tag> ficheTag = new ArrayList<>();

    public FicheDto(){}

    public FicheDto(int id_fiche, String libelle, Date dateFin, String timeTodo, String lieu, String url, String note, List<Tag> ficheTag) {
        this.id_fiche = id_fiche;
        this.libelle = libelle;
        this.dateFin = dateFin;
        this.timeTodo = timeTodo;
        this.lieu = lieu;
        this.url = url;
        this.note = note;
        this.ficheTag.addAll(ficheTag);
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

}
