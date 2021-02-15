package Controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Tsifx{

    private SimpleIntegerProperty idTSI;
    private SimpleStringProperty jour;
    private SimpleStringProperty date;
    private SimpleStringProperty matiereTsi;
    private SimpleStringProperty horaireTsi;
    private SimpleStringProperty dureeTsi;
    private SimpleStringProperty g1Tsi;
    private SimpleStringProperty g2Tsi;
    private SimpleStringProperty salleG1;
    private SimpleStringProperty salleG2;

    public Tsifx() {
    }

    public Tsifx(Integer idTSI) {
        this.idTSI =new SimpleIntegerProperty(idTSI);
    }

    public Tsifx(Integer idTSI, String jour, String date, String matiereTsi, String horaireTsi, String dureeTsi, String g1Tsi, String g2Tsi, String salleG1, String salleG2) {
        this.idTSI =new SimpleIntegerProperty( idTSI);
        this.jour =new SimpleStringProperty( jour);
        this.date =new SimpleStringProperty(date) ;
        this.matiereTsi =new SimpleStringProperty( matiereTsi);
        this.horaireTsi =new SimpleStringProperty( horaireTsi);
        this.dureeTsi = new SimpleStringProperty(dureeTsi);
        this.g1Tsi = new SimpleStringProperty(g1Tsi);
        this.g2Tsi = new SimpleStringProperty(g2Tsi);
        this.salleG1 = new SimpleStringProperty(salleG1);
        this.salleG2 = new SimpleStringProperty(salleG2);
    }

    public Integer getIdTSI() {
        return idTSI.get();
    }
    public SimpleIntegerProperty getIdTSIProperty() {
        return idTSI;
    }

    public void setIdTSI(Integer idTSI) {
        this.idTSI = new SimpleIntegerProperty( idTSI);
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
        this.date =new SimpleStringProperty( date);
    }

    public String getMatiereTsi() {
        return matiereTsi.get();
    }
    public SimpleStringProperty getMatiereTsiProperty() {
        return matiereTsi;
    }
    public void setMatiereTsi(String matiereTsi) {
        this.matiereTsi =new SimpleStringProperty( matiereTsi);
    }

    public String getHoraireTsi() {
        return horaireTsi.get();
    }
    public SimpleStringProperty getHoraireTsiProperty() {
        return horaireTsi;
    }
    public void setHoraireTsi(String horaireTsi) {
        this.horaireTsi =new SimpleStringProperty( horaireTsi);
    }

    public String getDureeTsi() {
        return dureeTsi.get();
    }
    public SimpleStringProperty getDureeTsiProperty() {
        return dureeTsi;
    }
    public void setDureeTsi(String dureeTsi) {
        this.dureeTsi =new SimpleStringProperty( dureeTsi);
    }

    public String getG1Tsi() {
        return g1Tsi.get();
    }
    public SimpleStringProperty getG1TsiProperty() {
        return g1Tsi;
    }
    public void setG1Tsi(String g1Tsi) {
        this.g1Tsi =new SimpleStringProperty( g1Tsi);
    }

    public String getG2Tsi() {
        return g2Tsi.get();
    }
    public SimpleStringProperty getG2TsiProperty() {
        return g2Tsi;
    }
    public void setG2Tsi(String g2Tsi) {
        this.g2Tsi =new SimpleStringProperty( g2Tsi);
    }

    public String getSalleG1() {
        return salleG1.get();
    }
    public SimpleStringProperty getSalleG1Property() {
        return salleG1;
    }
    public void setSalleG1(String salleG1) {
        this.salleG1 = new SimpleStringProperty(salleG1);
    }

    public String getSalleG2() {
        return salleG2.get();
    }
    public SimpleStringProperty getSalleG2Property() {
        return salleG2;
    }
    public void setSalleG2(String salleG2) {
        this.salleG2 =new SimpleStringProperty( salleG2);
    }

}
