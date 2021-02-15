package Controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Wi1fx  {

    private SimpleIntegerProperty idwi1;
    private SimpleStringProperty jourWi;
    private SimpleStringProperty dateWi;
    private SimpleStringProperty matieresWi;
    private SimpleStringProperty horaireWi;
    private SimpleStringProperty dureeWi;
    private SimpleStringProperty salleWi;

    public Wi1fx() {
    }

    public Wi1fx(Integer idwi1) {
        this.idwi1 =new SimpleIntegerProperty (idwi1);
    }

    public Wi1fx(Integer idwi1, String jourWi, String dateWi, String matieresWi, String horaireWi, String dureeWi, String salleWi) {
        this.idwi1 =new SimpleIntegerProperty (idwi1);
        this.jourWi =new SimpleStringProperty(jourWi);
        this.dateWi =new SimpleStringProperty(dateWi);
        this.matieresWi =new SimpleStringProperty(matieresWi);
        this.horaireWi =new SimpleStringProperty(horaireWi);
        this.dureeWi =new SimpleStringProperty(dureeWi);
        this.salleWi =new SimpleStringProperty (salleWi);
    }

    public Integer getIdwi1() {
        return idwi1.get();
    }
    public SimpleIntegerProperty getIdwi1Property() {
        return idwi1;
    }
    public void setIdwi1(Integer idwi1) {
        this.idwi1 =new SimpleIntegerProperty (idwi1);
    }

    public String getJourWi() {
        return jourWi.get();
    }
    public SimpleStringProperty getJourWiProperty() {
        return jourWi;
    }

    public void setJourWi(String jourWi) {
        this.jourWi =new SimpleStringProperty(jourWi);
    }

    public String getDateWi() {
        return dateWi.get();
    }
    public SimpleStringProperty getDateWiProperty() {
        return dateWi;
    }
    public void setDateWi(String dateWi) {
        this.dateWi =new SimpleStringProperty (dateWi);
    }

    public String getMatieresWi() {
        return matieresWi.get();
    }
    public SimpleStringProperty getMatieresWiProperty() {
        return matieresWi;
    }

    public void setMatieresWi(String matieresWi) {
        this.matieresWi =new SimpleStringProperty (matieresWi);
    }

    public String getHoraireWi() {
        return horaireWi.get();
    }
    public SimpleStringProperty getHoraireWiProperty() {
        return horaireWi;
    }
    public void setHoraireWi(String horaireWi) {
        this.horaireWi =new SimpleStringProperty (horaireWi);
    }

    public String getDureeWi() {
        return dureeWi.get();
    }
    public SimpleStringProperty getDureeWiProperty() {
        return dureeWi;
    }

    public void setDureeWi(String dureeWi) {
        this.dureeWi =new SimpleStringProperty (dureeWi);
    }

    public String getSalleWi() {
        return salleWi.get();
    }
    public SimpleStringProperty getSalleWiProperty() {
        return salleWi;
    }
    public void setSalleWi(String salleWi) {
        this.salleWi =new SimpleStringProperty (salleWi);
    }

   
    
}
