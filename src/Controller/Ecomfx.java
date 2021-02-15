package Controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Ecomfx{

    private SimpleIntegerProperty idecom;
    private SimpleStringProperty jourEcom;
    private SimpleStringProperty dateEcom;
    private SimpleStringProperty matiereEcom;
    private SimpleStringProperty horaireEcom;
    private SimpleStringProperty dureeEcom;
    private SimpleStringProperty g1Ecom;
    private SimpleStringProperty g2Ecom;
    private SimpleStringProperty salleG1;
    private SimpleStringProperty lleG2;

    public Ecomfx() {
    }

    public Ecomfx(Integer idecom) {
        this.idecom =new SimpleIntegerProperty (idecom);
    }

    public Ecomfx(Integer idecom,String jourEcom, String dateEcom, String matiereEcom, String horaireEcom, String dureeEcom, String g1Ecom, String g2Ecom, String salleG1, String lleG2) {
        this.idecom =new SimpleIntegerProperty ( idecom);
        this.jourEcom =new SimpleStringProperty (jourEcom);
        this.dateEcom =new SimpleStringProperty (dateEcom);
        this.matiereEcom =new SimpleStringProperty ( matiereEcom);
        this.horaireEcom =new SimpleStringProperty ( horaireEcom);
        this.dureeEcom =new SimpleStringProperty ( dureeEcom);
        this.g1Ecom =new SimpleStringProperty ( g1Ecom);
        this.g2Ecom =new SimpleStringProperty ( g2Ecom);
        this.salleG1 =new SimpleStringProperty ( salleG1);
        this.lleG2 =new SimpleStringProperty ( lleG2);
    }

    
    public Integer getIdecom() {
        return idecom.get();
    }
    public SimpleIntegerProperty getIdecomProperty() {
        return idecom;
    }
    public void setIdecom(Integer idecom) {
        this.idecom =new SimpleIntegerProperty ( idecom);
    }
    public String getJourEcom() {
        return jourEcom.get();
    }
    public SimpleStringProperty getJourEcomProperty() {
        return jourEcom;
    }
    public void setJourEcom(String jourEcom) {
        this.jourEcom =new SimpleStringProperty (jourEcom);
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

    public String getMatiereEcom() {
        return matiereEcom.get();
    }
     public SimpleStringProperty getMatiereEcomProperty() {
        return matiereEcom;
    }
    public void setMatiereEcom(String matiereEcom) {
        this.matiereEcom =new SimpleStringProperty (matiereEcom);
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

    public String getG1Ecom() {
        return g1Ecom.get();
    }
    public SimpleStringProperty getG1EcomProperty() {
        return g1Ecom;
    }
    public void setG1Ecom(String g1Ecom) {
        this.g1Ecom =new SimpleStringProperty (g1Ecom);
    }

    public String getG2Ecom() {
        return g2Ecom.get();
    }
    public SimpleStringProperty getG2EcomProperty() {
        return g2Ecom;
    }
    public void setG2Ecom(String g2Ecom) {
        this.g2Ecom =new SimpleStringProperty (g2Ecom);
    }

    public String getSalleG1() {
        return salleG1.get();
    }
    public SimpleStringProperty getSalleG1Property() {
        return salleG1;
    }
    public void setSalleG1(String salleG1) {
        this.salleG1 =new SimpleStringProperty (salleG1);
    }

    public String getLleG2() {
        return lleG2.get();
    }
    public SimpleStringProperty getLleG2Property() {
        return lleG2;
    }
    public void setLleG2(String lleG2) {
        this.lleG2 =new SimpleStringProperty (lleG2);
    }

     
}
