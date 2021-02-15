package Controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Vic1fx {
    private SimpleIntegerProperty idvic1;
    private SimpleStringProperty jourVic;
    private SimpleStringProperty dateVic;
    private SimpleStringProperty matieresVic;
    private SimpleStringProperty horaireVic;
    private SimpleStringProperty dureeVic;
    private SimpleStringProperty salleVic;

    public Vic1fx() {
    }

    public Vic1fx(Integer idvic1) {
        this.idvic1 =new SimpleIntegerProperty (idvic1);
    }

    public Vic1fx(Integer idvic1, String jourVic, String dateVic, String matieresVic, String horaireVic, String dureeVic, String salleVic) {
        this.idvic1 =new SimpleIntegerProperty (idvic1);
        this.jourVic =new SimpleStringProperty (jourVic);
        this.dateVic =new SimpleStringProperty (dateVic);
        this.matieresVic =new SimpleStringProperty (matieresVic);
        this.horaireVic =new SimpleStringProperty (horaireVic);
        this.dureeVic =new SimpleStringProperty (dureeVic);
        this.salleVic =new SimpleStringProperty (salleVic);
    }

    public Integer getIdvic1() {
        return idvic1.get();
    }
    public SimpleIntegerProperty getIdvic1Property() {
        return idvic1;
    }
    public void setIdvic1(Integer idvic1) {
        this.idvic1 =new SimpleIntegerProperty (idvic1);
    }

    public String getJourVic() {
        return jourVic.get();
    }
    public SimpleStringProperty getJourVicProperty() {
        return jourVic;
    }
    public void setJourVic(String jourVic) {
        this.jourVic =new SimpleStringProperty (jourVic);
    }

    public String getDateVic() {
        return dateVic.get();
    }
    public SimpleStringProperty getDateVicProperty() {
        return dateVic;
    }
    public void setDateVic(String dateVic) {
        this.dateVic =new SimpleStringProperty (dateVic);
    }

    public String getMatieresVic() {
        return matieresVic.get();
    }
    public SimpleStringProperty getMatieresVicProperty() {
        return matieresVic;
    }
    public void setMatieresVic(String matieresVic) {
        this.matieresVic =new SimpleStringProperty (matieresVic);
    }

    public String getHoraireVic() {
        return horaireVic.get();
    }
    public SimpleStringProperty getHoraireVicProperty() {
        return horaireVic;
    }
    public void setHoraireVic(String horaireVic) {
        this.horaireVic =new SimpleStringProperty (horaireVic);
    }

    public String getDureeVic() {
        return dureeVic.get();
    }
    public SimpleStringProperty getDureeVicProperty() {
        return dureeVic;
    }
    public void setDureeVic(String dureeVic) {
        this.dureeVic =new SimpleStringProperty (dureeVic);
    }

    public String getSalleVic() {
        return salleVic.get();
    }
    public SimpleStringProperty getSalleVicProperty() {
        return salleVic;
    }
    public void setSalleVic(String salleVic) {
        this.salleVic =new SimpleStringProperty (salleVic);
    }

    
}
