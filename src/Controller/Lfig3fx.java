package Controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Lfig3fx {

    private SimpleIntegerProperty idlfig3;
    private SimpleStringProperty jour;
    private SimpleStringProperty date;
    private SimpleStringProperty matieres;
    private SimpleStringProperty horaire;
    private SimpleStringProperty duree;
    private SimpleStringProperty groupe1;
    private SimpleStringProperty salleG1;
    private SimpleStringProperty groupe2;
    private SimpleStringProperty salleG2;


    public Lfig3fx() {
    }

    public Lfig3fx(Integer idlfig3) {
        this.idlfig3 =new SimpleIntegerProperty (idlfig3);
    }

    public Lfig3fx(Integer idlfig3, String jour, String date, String matieres, String horaire, String duree, String groupe1, String salleG1, String groupe2, String salleG2) {
        this.idlfig3 =new SimpleIntegerProperty ( idlfig3);
        this.jour =new SimpleStringProperty (jour);
        this.date =new SimpleStringProperty ( date);
        this.matieres =new SimpleStringProperty ( matieres);
        this.horaire =new SimpleStringProperty ( horaire);
        this.duree = new SimpleStringProperty (duree);
        this.groupe1 =new SimpleStringProperty ( groupe1);
        this.salleG1 =new SimpleStringProperty ( salleG1);
        this.groupe2 =new SimpleStringProperty ( groupe2);
        this.salleG2 =new SimpleStringProperty ( salleG2);
    
    }
public Integer getIdlfig3() {
        return idlfig3.get();
    }
    
    public SimpleIntegerProperty getIdlfig3Property() {
        return idlfig3;
    }
    public void setIdlfig3(Integer idlfig3) {
        this.idlfig3 = new SimpleIntegerProperty (idlfig3);
    }

    public String getJour() {
        return jour.get();
    }
    public SimpleStringProperty getJourProperty() {
        return jour;
    }
    public void setJour(String jour) {
        this.jour =new SimpleStringProperty ( jour);
    }

    public String getDate() {
        return date.get();
    }
    public SimpleStringProperty getDateProperty() {
        return date;
    }
    public void setDate(String date) {
        this.date =new SimpleStringProperty ( date);
    }

    public String getMatieres() {
        return matieres.get();
    }
    public SimpleStringProperty getMatieresProperty() {
        return matieres;
    }
    public void setMatieres(String matieres) {
        this.matieres =new SimpleStringProperty ( matieres);
    }

    public String getHoraire() {
        return horaire.get();
    }
    public SimpleStringProperty getHoraireProperty() {
        return horaire;
    }
    public void setHoraire(String horaire) {
        this.horaire =new SimpleStringProperty ( horaire);
    }

    public String getDuree() {
        return duree.get();
    }
    public SimpleStringProperty getDureeProperty() {
        return duree;
    }
    public void setDuree(String duree) {
        this.duree = new SimpleStringProperty (duree);
    }

    public String getGroupe1() {
        return groupe1.get();
    }
    public SimpleStringProperty getGroupe1Property() {
        return groupe1;
    }
    public void setGroupe1(String groupe1) {
        this.groupe1 =new SimpleStringProperty ( groupe1);
    }

    public String getSalleG1() {
        return salleG1.get();
    }
    public SimpleStringProperty getSalleG1Property() {
        return salleG1;
    }
    public void setSalleG1(String salleG1) {
        this.salleG1 = new SimpleStringProperty (salleG1);
    }

    public String getGroupe2() {
        return groupe2.get();
    }
    public SimpleStringProperty getGroupe2Property() {
        return groupe2;
    }
    public void setGroupe2(String groupe2) {
        this.groupe2 =new SimpleStringProperty ( groupe2);
    }

    public String getSalleG2() {
        return salleG2.get();
    }
    public SimpleStringProperty getSalleG2Property() {
        return salleG2;
    }
    public void setSalleG2(String salleG2) {
        this.salleG2 =new SimpleStringProperty ( salleG2);
    }

}
