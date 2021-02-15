package Controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Mbds2fx {

    private SimpleIntegerProperty idmbds2;
    private SimpleStringProperty jourMbds;
    private SimpleStringProperty dateMbds;
    private SimpleStringProperty matieresMbds;
    private SimpleStringProperty horaireMbds;
    private SimpleStringProperty dureeMbds;
    private SimpleStringProperty salleMbds;

    public Mbds2fx() {
    }

    public Mbds2fx(Integer idmbds2) {
        this.idmbds2 =new SimpleIntegerProperty (idmbds2);
    }

    public Mbds2fx(Integer idmbds2, String jourMbds, String dateMbds, String matieresMbds, String horaireMbds, String dureeMbds, String salleMbds) {
        this.idmbds2 =new SimpleIntegerProperty (idmbds2);
        this.jourMbds =new SimpleStringProperty (jourMbds);
        this.dateMbds =new SimpleStringProperty (dateMbds);
        this.matieresMbds =new SimpleStringProperty (matieresMbds);
        this.horaireMbds =new SimpleStringProperty (horaireMbds);
        this.dureeMbds =new SimpleStringProperty (dureeMbds);
        this.salleMbds =new SimpleStringProperty (salleMbds);
   }

    public Integer getIdmbds2() {
        return idmbds2.get();
    }
    public SimpleIntegerProperty getIdmbds2Property() {
        return idmbds2;
    }
    public void setIdmbds2(Integer idmbds2) {
        this.idmbds2 = new SimpleIntegerProperty (idmbds2);
    }

    public String getJourMbds() {
        return jourMbds.get();
    }
    public SimpleStringProperty getJourMbdsProperty() {
        return jourMbds;
    }
    public void setJourMbds(String jourMbds) {
        this.jourMbds = new SimpleStringProperty (jourMbds);
    }

    public String getDateMbds() {
        return dateMbds.get();
    }
    public SimpleStringProperty getDateMbdsProperty() {
        return dateMbds;
    }
    public void setDateMbds(String dateMbds) {
        this.dateMbds =new SimpleStringProperty (dateMbds);
    }

    public String getMatieresMbds() {
        return matieresMbds.get();
    }
    public SimpleStringProperty getMatieresMbdsProperty() {
        return matieresMbds;
    }
    public void setMatieresMbds(String matieresMbds) {
        this.matieresMbds =new SimpleStringProperty (matieresMbds);
    }

    public String getHoraireMbds() {
        return horaireMbds.get();
    }
    public SimpleStringProperty getHoraireMbdsProperty() {
        return horaireMbds;
    }

    public void setHoraireMbds(String horaireMbds) {
        this.horaireMbds =new SimpleStringProperty (horaireMbds);
    }

    public String getDureeMbds() {
        return dureeMbds.get();
    }
    public SimpleStringProperty getDureeMbdsProperty() {
        return dureeMbds;
    }
    public void setDureeMbds(String dureeMbds) {
        this.dureeMbds =new SimpleStringProperty (dureeMbds);
    }

    public String getSalleMbds() {
        return salleMbds.get();
    }
    public SimpleStringProperty getSalleMbdsProperty() {
        return salleMbds;
    }
    public void setSalleMbds(String salleMbds) {
        this.salleMbds =new SimpleStringProperty (salleMbds);
    }
 
}
