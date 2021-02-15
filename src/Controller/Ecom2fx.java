package Controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Ecom2fx {

    private SimpleIntegerProperty idecom2;
    private SimpleStringProperty jourEcom;
    private SimpleStringProperty dateEcom;
    private SimpleStringProperty matieresEcom;
    private SimpleStringProperty horaireEcom;
    private SimpleStringProperty dureeEcom;
    private SimpleStringProperty groupe1Ecom;
    private SimpleStringProperty salleG1Ecom;
    private SimpleStringProperty groupe2Ecom;
    private SimpleStringProperty salleG2Ecom;

    public Ecom2fx() {
    }

    public Ecom2fx(Integer idecom2) {
        this.idecom2 =new SimpleIntegerProperty (idecom2);
    }

    public Ecom2fx(Integer idecom2, String jourEcom, String dateEcom, String matieresEcom, String horaireEcom, String dureeEcom,String groupe1Ecom, String salleG1Ecom, String groupe2Ecom, String salleG2Ecom) {
        this.idecom2 = new SimpleIntegerProperty (idecom2);
        this.jourEcom =new SimpleStringProperty (jourEcom);
        this.dateEcom =new SimpleStringProperty ( dateEcom);
        this.matieresEcom =new SimpleStringProperty ( matieresEcom);
        this.horaireEcom = new SimpleStringProperty (horaireEcom);
        this.dureeEcom =new SimpleStringProperty ( dureeEcom);
        this.groupe1Ecom = new SimpleStringProperty(groupe1Ecom);
        this.salleG1Ecom =new SimpleStringProperty ( salleG1Ecom);
        this.groupe2Ecom =new SimpleStringProperty ( groupe2Ecom);
        this.salleG2Ecom =new SimpleStringProperty ( salleG2Ecom);
    }

    public Integer getIdecom2() {
        return idecom2.get();
    }
    public SimpleIntegerProperty getIdecom2Property() {
        return idecom2;
    }
    public void setIdecom2(Integer idecom2) {
        this.idecom2 =new SimpleIntegerProperty ( idecom2);
    }

    public String getJourEcom() {
        return jourEcom.get();
    }
    public SimpleStringProperty getJourEcomProperty() {
        return jourEcom;
    }
    public void setJourEcom(String jourEcom) {
        this.jourEcom =new SimpleStringProperty ( jourEcom);
    }

    public String getDateEcom() {
        return dateEcom.get();
    }
    public SimpleStringProperty getDateEcomProperty() {
        return dateEcom;
    }
    public void setDateEcom(String dateEcom) {
        this.dateEcom =new SimpleStringProperty (dateEcom);
    }

    public String getMatieresEcom() {
        return matieresEcom.get();
    }
    public SimpleStringProperty getMatieresEcomProperty() {
        return matieresEcom;
    }
    public void setMatieresEcom(String matieresEcom) {
        this.matieresEcom =new SimpleStringProperty (matieresEcom);
    }

    public String getHoraireEcom() {
        return horaireEcom.get();
    }
    public SimpleStringProperty getHoraireEcomProperty() {
        return horaireEcom;
    }

    public void setHoraireEcom(String horaireEcom) {
        this.horaireEcom =new SimpleStringProperty (horaireEcom);
    }

    public String getDureeEcom() {
        return dureeEcom.get();
    }
    public SimpleStringProperty getDureeEcomProperty() {
        return dureeEcom;
    }
    public void setDureeEcom(String dureeEcom) {
        this.dureeEcom =new SimpleStringProperty (dureeEcom);
    }
    public String getGroupe1Ecom() {
        return groupe1Ecom.get();
    }
    public SimpleStringProperty getGroupe1EcomProperty() {
        return groupe1Ecom;
    }
    public void setGroupe1Ecom(String groupe1Ecom) {
        this.groupe1Ecom =new SimpleStringProperty (groupe1Ecom);
    }
    public String getSalleG1Ecom() {
        return salleG1Ecom.get();
    }
    public SimpleStringProperty getSalleG1EcomProperty() {
        return salleG1Ecom;
    }
    public void setSalleG1Ecom(String salleG1Ecom) {
        this.salleG1Ecom = new SimpleStringProperty(salleG1Ecom);
    }

    public String getGroupe2Ecom() {
        return groupe2Ecom.get();
    }
    public SimpleStringProperty getGroupe2EcomProperty() {
        return groupe2Ecom;
    }
    public void setGroupe2Ecom(String groupe2Ecom) {
        this.groupe2Ecom =new SimpleStringProperty (groupe2Ecom);
    }

    public String getSalleG2Ecom() {
        return salleG2Ecom.get();
    }
    public SimpleStringProperty getSalleG2EcomProperty() {
        return salleG2Ecom;
    }
    public void setSalleG2Ecom(String salleG2Ecom) {
        this.salleG2Ecom =new SimpleStringProperty (salleG2Ecom);
    }

}