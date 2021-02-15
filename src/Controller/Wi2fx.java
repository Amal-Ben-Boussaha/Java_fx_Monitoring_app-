package Controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Wi2fx  {
    private SimpleIntegerProperty idwi2;
    private SimpleStringProperty jourWi;
    private SimpleStringProperty dateWi;
    private SimpleStringProperty matieresWi;
    private SimpleStringProperty horaireWi;
    private SimpleStringProperty dureeWi;
    private SimpleStringProperty salleWi;

    public Wi2fx() {
    }

    public Wi2fx(Integer idwi2) {
        this.idwi2 =new SimpleIntegerProperty (idwi2);
    }

    public Wi2fx(Integer idwi2, String jourWi, String dateWi, String matieresWi, String horaireWi, String dureeWi, String salleWi) {
        this.idwi2 =new SimpleIntegerProperty (idwi2);
        this.jourWi =new SimpleStringProperty(jourWi);
        this.dateWi =new SimpleStringProperty(dateWi);
        this.matieresWi =new SimpleStringProperty(matieresWi);
        this.horaireWi =new SimpleStringProperty(horaireWi);
        this.dureeWi =new SimpleStringProperty(dureeWi);
        this.salleWi =new SimpleStringProperty (salleWi);
    }

    public Integer getIdwi2() {
        return idwi2.get();
    }
    public SimpleIntegerProperty getIdwi2Property() {
        return idwi2;
    }
    public void setIdwi2(Integer idwi2) {
        this.idwi2 = new SimpleIntegerProperty (idwi2);
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
