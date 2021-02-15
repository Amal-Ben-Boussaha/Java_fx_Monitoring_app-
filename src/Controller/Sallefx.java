package Controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Sallefx{

    private SimpleIntegerProperty idsalle;
    private SimpleStringProperty nomSalle;
    private SimpleStringProperty capacite;
    private SimpleStringProperty nomfac;

    public Sallefx() {
    }

    public Sallefx(Integer idsalle) {
        this.idsalle =new SimpleIntegerProperty( idsalle);
    }

    public Sallefx(Integer idsalle, String nomSalle, String capacite, String nomfac) {
        this.idsalle =new SimpleIntegerProperty(idsalle);
        this.nomSalle =new SimpleStringProperty(nomSalle);
        this.capacite = new SimpleStringProperty(capacite);
        this.nomfac = new SimpleStringProperty(nomfac);
    }

    public Integer getIdsalle() {
        return idsalle.get();
    }

    public SimpleIntegerProperty getIdsalleProperty() {
        return idsalle;
    }
    public void setIdsalle(Integer idsalle) {
        this.idsalle = new SimpleIntegerProperty(idsalle);
    }

    public String getNomSalle() {
        return nomSalle.get();
    }

    public SimpleStringProperty getNomSalleProperty() {
        return nomSalle;
    }
    public void setNomSalle(String nomSalle) {
        this.nomSalle = new SimpleStringProperty(nomSalle);
    }

    public String getCapacite() {
        return capacite.get();
    }

    public SimpleStringProperty getCapaciteProperty() {
        return capacite;
    }

    public void setCapacite(String capacite) {
        this.capacite =new SimpleStringProperty( capacite);
    }
    public String getNomfac() {
        return nomfac.get();
    }
    public SimpleStringProperty getNomfacProperty() {
        return nomfac;
    }
    
    public void setNomfac(String nomfac) {
        this.nomfac =new SimpleStringProperty (nomfac);
    }


}
