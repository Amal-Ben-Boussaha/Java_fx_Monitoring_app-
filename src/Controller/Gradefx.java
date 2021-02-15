package Controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Gradefx {

    private SimpleIntegerProperty idgrade;
    private SimpleStringProperty nomgrade;
    private SimpleStringProperty nbseancemax;
    private SimpleStringProperty nbseancemin;

    public Gradefx() {
    }

    public Gradefx(Integer idgrade) {
        this.idgrade =new SimpleIntegerProperty (idgrade);
    }

    public Gradefx(Integer idgrade, String nomgrade, String nbseancemax, String nbseancemin) {
        this.idgrade =new SimpleIntegerProperty (idgrade);
        this.nomgrade =new SimpleStringProperty (nomgrade);
        this.nbseancemax =new SimpleStringProperty (nbseancemax);
        this.nbseancemin =new SimpleStringProperty(nbseancemin);
    }

    public Integer getIdgrade() {
        return idgrade.get();
    }
    public SimpleIntegerProperty getIdgradeProperty() {
        return idgrade;
    }

    public void setIdgrade(Integer idgrade) {
        this.idgrade =new SimpleIntegerProperty (idgrade);
    }

    public String getNomgrade() {
        return nomgrade.get();
    }
    public SimpleStringProperty getNomgradeProperty() {
        return nomgrade;
    }
    public void setNomgrade(String nomgrade) {
        this.nomgrade =new SimpleStringProperty (nomgrade);
    }

    public String getNbseancemax() {
        return nbseancemax.get();
    }
    public SimpleStringProperty getNbseancemaxProperty() {
        return nbseancemax;
    }
    public void setNbseancemax(String nbseancemax) {
        this.nbseancemax =new SimpleStringProperty (nbseancemax);
    }

    public String getNbseancemin() {
        return nbseancemin.get();
    }
    public SimpleStringProperty getNbseanceminProperty() {
        return nbseancemin;
    }

    public void setNbseancemin(String nbseancemin) {
        this.nbseancemin =new SimpleStringProperty (nbseancemin);
    }

}
