package Entities;

import java.util.Date;

public class Reclamation {
    private long id;
    private Date dateReclamation;
    private String objet;
    private String description;
    private Etat etat;


    //Constructor for the Admin to update the Reclamation
    public Reclamation(long id, Date dateReclamation, String objet, String description, Etat etat) {
        this.id = id;
        this.dateReclamation = dateReclamation;
        this.objet = objet;
        this.description = description;
        this.etat = etat;
    }
    //Constructor for the User to add a new Reclamation
    public Reclamation(long id, Date dateReclamation, String objet, String description) {
        this.id = id;
        this.dateReclamation = dateReclamation;
        this.objet = objet;
        this.description = description;
    }

    public Reclamation(Date dateReclamation, String objet, String description, Etat etat) {
        this.dateReclamation = dateReclamation;
        this.objet = objet;
        this.description = description;
        this.etat = etat;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateReclamation() {
        return dateReclamation;
    }

    public void setDateReclamation(Date dateReclamation) {
        this.dateReclamation = dateReclamation;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }


    @Override
    public String toString() {
        return "Reclamation{" +
                "id=" + id +
                ", dateReclamation=" + dateReclamation +
                ", objet='" + objet + '\'' +
                ", description='" + description + '\'' +
                ", etat=" + etat +
                '}';
    }


}
