package Controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class SeancExamenfx {

    private SimpleIntegerProperty idseance;
    private SimpleStringProperty nomseance;
    private SimpleStringProperty horaireseance;

    public SeancExamenfx() {
    }

    public SeancExamenfx(Integer idseance) {
        this.idseance =new SimpleIntegerProperty (idseance);
    }

    public SeancExamenfx(Integer idseance, String nomseance, String horaireseance) {
        this.idseance =new SimpleIntegerProperty (idseance);
        this.nomseance =new SimpleStringProperty (nomseance);
        this.horaireseance =new SimpleStringProperty(horaireseance);
    }

    public Integer getIdseance() {
        return idseance.get();
    }
    public SimpleIntegerProperty getIdseanceProperty() {
        return idseance;
    }
    public void setIdseance(Integer idseance) {
        this.idseance = new SimpleIntegerProperty (idseance);
    }

    public String getNomseance() {
        return nomseance.get();
    }
    public SimpleStringProperty getNomseanceProperty() {
        return nomseance;
    }
    public void setNomseance(String nomseance) {
        this.nomseance = new SimpleStringProperty (nomseance);
    }

    public String getHoraireseance() {
        return horaireseance.get();
    }
    public SimpleStringProperty getHoraireseanceProperty() {
        return horaireseance;
    }
    public void setHoraireseance(String horaireseance) {
        this.horaireseance =new SimpleStringProperty(horaireseance);
    }
}
