package fr.istic.assoumou.manivoule.jaxrs.dto;

public class MoveFicherequest {
    int id_fiche;
    int section_from_id;
    int section_to_id;

    public MoveFicherequest(int id_fiche, int section_from_id, int section_to_i) {
        this.id_fiche = id_fiche;
        this.section_from_id = section_from_id;
        this.section_to_id = section_to_i;
    }

    public MoveFicherequest() {
    }

    public int getId_fiche() {
        return id_fiche;
    }

    public void setId_fiche(int id_fiche) {
        this.id_fiche = id_fiche;
    }

    public int getSection_from_id() {
        return section_from_id;
    }

    public void setSection_from_id(int section_from_id) {
        this.section_from_id = section_from_id;
    }

    public int getSection_to_id() {
        return section_to_id;
    }

    public void setSection_to_id(int section_to_i) {
        this.section_to_id = section_to_i;
    }
}
