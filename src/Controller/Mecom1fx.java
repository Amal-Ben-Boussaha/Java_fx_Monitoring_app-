package Controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Mecom1fx {
    private SimpleIntegerProperty idMecom1;
    private SimpleStringProperty jour;
    private SimpleStringProperty date;
    private SimpleStringProperty matieres;
    private SimpleStringProperty horaire;
    private SimpleStringProperty duree;
    private SimpleStringProperty salle;

    public Mecom1fx() {
    }

    public Mecom1fx(Integer idMecom1) {
        this.idMecom1 = new SimpleIntegerProperty (idMecom1);
    }

    public Mecom1fx(Integer idMecom1, String jour, String date, String matieres, String horaire, String duree, String salle) {
        this.idMecom1 =new SimpleIntegerProperty ( idMecom1);
        this.jour =new SimpleStringProperty (jour);
        this.date =new SimpleStringProperty (date);
        this.matieres =new SimpleStringProperty (matieres);
        this.horaire =new SimpleStringProperty (horaire);
        this.duree =new SimpleStringProperty (duree);
        this.salle =new SimpleStringProperty (salle);
    }

    public Integer getIdMecom1() {
        return idMecom1.get();
    }
    public SimpleIntegerProperty getIdMecom1Property() {
        return idMecom1;
    }
    public void setIdMecom1(Integer idMecom1) {
        this.idMecom1 =new SimpleIntegerProperty ( idMecom1);
    }

    public String getJour() {
        return jour.get();
    }
    public SimpleStringProperty getJourProperty() {
        return jour;
    }
    public void setJour(String jour) {
        this.jour =new SimpleStringProperty (jour);
    }

    public String getDate() {
        return date.get();
    }
    public SimpleStringProperty getDateProperty() {
        return date;
    }
    public void setDate(String date) {
        this.date =new SimpleStringProperty (date);
    }

    public String getMatieres() {
        return matieres.get();
    }
    public SimpleStringProperty getMatieresProperty() {
        return matieres;
    }

    public void setMatieres(String matieres) {
        this.matieres =new SimpleStringProperty (matieres);
    }

    public String getHoraire() {
        return horaire.get();
    }
    public SimpleStringProperty getHoraireProperty() {
        return horaire;
    }

    public void setHoraire(String horaire) {
        this.horaire =new SimpleStringProperty (horaire);
    }

    public String getDuree() {
        return duree.get();
    }
    public SimpleStringProperty getDureeProperty() {
        return duree;
    }
    public void setDuree(String duree) {
        this.duree =new SimpleStringProperty (duree);
    }

    public String getSalle() {
        return salle.get();
    }
    public SimpleStringProperty getSalleProperty() {
        return salle;
    }
    public void setSalle(String salle) {
        this.salle =new SimpleStringProperty (salle);
    }

}
