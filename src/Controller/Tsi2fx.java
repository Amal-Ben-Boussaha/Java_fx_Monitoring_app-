package Controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Tsi2fx {

    private SimpleIntegerProperty idtsi2;
    private SimpleStringProperty jourTsi;
    private SimpleStringProperty dateTsi;
    private SimpleStringProperty matieresTsi;
    private SimpleStringProperty horaireTsi;
    private SimpleStringProperty dureeTsi;
    private SimpleStringProperty groupe1Tsi;
    private SimpleStringProperty salleG1Tsi;
    private SimpleStringProperty groupe2Tsi;
    private SimpleStringProperty salleG2Tsi;

    public Tsi2fx() {
    }

    public Tsi2fx(Integer idtsi2) {
        this.idtsi2 = new SimpleIntegerProperty (idtsi2);
    }

    public Tsi2fx(Integer idtsi2, String jourTsi, String dateTsi, String matieresTsi, String horaireTsi, String dureeTsi, String groupe1Tsi, String salleG1Tsi, String groupe2Tsi, String salleG2Tsi) {
        this.idtsi2 = new SimpleIntegerProperty ( idtsi2);
        this.jourTsi =new SimpleStringProperty ( jourTsi);
        this.dateTsi =new SimpleStringProperty (  dateTsi);
        this.matieresTsi =new SimpleStringProperty (  matieresTsi);
        this.horaireTsi =new SimpleStringProperty (  horaireTsi);
        this.dureeTsi =new SimpleStringProperty (  dureeTsi);
        this.groupe1Tsi =new SimpleStringProperty (  groupe1Tsi);
        this.salleG1Tsi =new SimpleStringProperty (  salleG1Tsi);
        this.groupe2Tsi =new SimpleStringProperty (  groupe2Tsi);
        this.salleG2Tsi =new SimpleStringProperty (  salleG2Tsi);
    }

    public Integer getIdtsi2() {
        return idtsi2.get();
    }
    public SimpleIntegerProperty getIdtsi2Property() {
        return idtsi2;
    }

    public void setIdtsi2(Integer idtsi2) {
        this.idtsi2 =new SimpleIntegerProperty (idtsi2);
    }

    public String getJourTsi() {
        return jourTsi.get();
    }
    public SimpleStringProperty getJourTsiProperty() {
        return jourTsi;
    }
    public void setJourTsi(String jourTsi) {
        this.jourTsi =new SimpleStringProperty (jourTsi);
    }

    public String getDateTsi() {
        return dateTsi.get();
    }
    public SimpleStringProperty getDateTsiProperty() {
        return dateTsi;
    }
    public void setDateTsi(String dateTsi) {
        this.dateTsi =new SimpleStringProperty (dateTsi);
    }

    public String getMatieresTsi() {
        return matieresTsi.get();
    }
    public SimpleStringProperty getMatieresTsiProperty() {
        return matieresTsi;
    }
    public void setMatieresTsi(String matieresTsi) {
        this.matieresTsi =new SimpleStringProperty (matieresTsi);
    }

    public String getHoraireTsi() {
        return horaireTsi.get();
    }
    public SimpleStringProperty getHoraireTsiProperty() {
        return horaireTsi;
    }
    public void setHoraireTsi(String horaireTsi) {
        this.horaireTsi =new SimpleStringProperty (horaireTsi);
    }

    public String getDureeTsi() {
        return dureeTsi.get();
    }
    
    public SimpleStringProperty getDureeTsiProperty() {
        return dureeTsi;
    }
    public void setDureeTsi(String dureeTsi) {
        this.dureeTsi =new SimpleStringProperty (dureeTsi);
    }

    public String getGroupe1Tsi() {
        return groupe1Tsi.get();
    }
    public SimpleStringProperty getGroupe1TsiProperty() {
        return groupe1Tsi;
    }
    public void setGroupe1Tsi(String groupe1Tsi) {
        this.groupe1Tsi =new SimpleStringProperty (groupe1Tsi);
    }

    public String getSalleG1Tsi() {
        return salleG1Tsi.get();
    }
    public SimpleStringProperty getSalleG1TsiProperty() {
        return salleG1Tsi;
    }
    public void setSalleG1Tsi(String salleG1Tsi) {
        this.salleG1Tsi =new SimpleStringProperty (salleG1Tsi);
    }

    public String getGroupe2Tsi() {
        return groupe2Tsi.get();
    }
    public SimpleStringProperty getGroupe2TsiProperty() {
        return groupe2Tsi;
    }
    public void setGroupe2Tsi(String groupe2Tsi) {
        this.groupe2Tsi =new SimpleStringProperty (groupe2Tsi);
    }

    public String getSalleG2Tsi() {
        return salleG2Tsi.get();
    }
    public SimpleStringProperty getSalleG2TsiProperty() {
        return salleG2Tsi;
    }
    public void setSalleG2Tsi(String salleG2Tsi) {
        this.salleG2Tsi =new SimpleStringProperty (salleG2Tsi);
    }

}
