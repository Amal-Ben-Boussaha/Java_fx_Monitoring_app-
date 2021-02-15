package Controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Lfigfx {
private SimpleIntegerProperty idLf;
private SimpleStringProperty jour;
private SimpleStringProperty date;
private SimpleStringProperty matiere;
private SimpleStringProperty duree;
private SimpleStringProperty grp1;
private SimpleStringProperty grp2;
private SimpleStringProperty grp3;
private SimpleStringProperty g4;
private SimpleStringProperty salleg1;
private SimpleStringProperty salleg2;
private SimpleStringProperty salleg3;
private SimpleStringProperty salleg4;
private SimpleStringProperty horaire;

    public Lfigfx() {
    }

    public Lfigfx(Integer idLf) {
        this.idLf = new SimpleIntegerProperty (idLf);
    }

    public Lfigfx(Integer idLf,String jour, String date, String matiere, String duree, String grp1, String grp2, String grp3, String g4, String salleg1, String salleg2, String salleg3, String salleg4, String horaire) {
        this.idLf =new SimpleIntegerProperty (idLf);
        this.jour =new SimpleStringProperty (jour);
        this.date =new SimpleStringProperty (date);
        this.matiere =new SimpleStringProperty (matiere);
        this.duree =new SimpleStringProperty (duree);
        this.grp1 =new SimpleStringProperty (grp1);
        this.grp2 =new SimpleStringProperty ( grp2);
        this.grp3 =new SimpleStringProperty ( grp3);
        this.g4 =new SimpleStringProperty ( g4);
        this.salleg1 =new SimpleStringProperty ( salleg1);
        this.salleg2 =new SimpleStringProperty ( salleg2);
        this.salleg3 =new SimpleStringProperty (salleg3);
        this.salleg4 =new SimpleStringProperty (salleg4);
        this.horaire =new SimpleStringProperty ( horaire);
    }
public Integer getIdLf() {
        return idLf.get();
    }
    public SimpleIntegerProperty getIdLfProperty() {
        return idLf;
    }

    public void setIdLf(Integer idLf) {
        this.idLf = new SimpleIntegerProperty(idLf);
    }

    public String getDate() {
        return date.get();
    }
    public SimpleStringProperty getDateProperty() {
        return date;
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
    public void setDate(String date) {
        this.date =new SimpleStringProperty ( date);
    }

    public String getMatiere() {
        return matiere.get();
    }
    
    public SimpleStringProperty getMatiereProperty() {
        return matiere;
    }
    public void setMatiere(String matiere) {
        this.matiere =new SimpleStringProperty (  matiere);
    }

    public String getDuree() {
        return duree.get();
    }
    public SimpleStringProperty getDureeProperty() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree =new SimpleStringProperty (  duree);
    }

    public String getGrp1() {
        return grp1.get();
    }
    public SimpleStringProperty getGrp1Property() {
        return grp1;
    }
    public void setGrp1(String grp1) {
        this.grp1 =new SimpleStringProperty (  grp1);
    }

    public String getGrp2() {
        return grp2.get();
    }
    public SimpleStringProperty getGrp2Property() {
        return grp2;
    }
    public void setGrp2(String grp2) {
        this.grp2 =new SimpleStringProperty (  grp2);
    }

    public String getGrp3() {
        return grp3.get();
    }
    public SimpleStringProperty getGrp3Property() {
        return grp3;
    }

    public void setGrp3(String grp3) {
        this.grp3 =new SimpleStringProperty (  grp3);
    }

    public String getG4() {
        return g4.get();
    }
    public SimpleStringProperty getG4Property() {
        return g4;
    }
    public void setG4(String g4) {
        this.g4 =new SimpleStringProperty (  g4);
    }

    public String getSalleg1() {
        return salleg1.get();
    }
    public SimpleStringProperty getSalleg1Property() {
        return salleg1;
    }
    public void setSalleg1(String salleg1) {
        this.salleg1 =new SimpleStringProperty (  salleg1);
    }

    public String getSalleg2() {
        return salleg2.get();
    }
    public SimpleStringProperty getSalleg2Property() {
        return salleg2;
    }
    public void setSalleg2(String salleg2) {
        this.salleg2 =new SimpleStringProperty (  salleg2);
    }

    public String getSalleg3() {
        return salleg3.get();
    }
    public SimpleStringProperty getSalleg3Property() {
        return salleg3;
    }
    public void setSalleg3(String salleg3) {
        this.salleg3 =new SimpleStringProperty (  salleg3);
    }

    public String getSalleg4() {
        return salleg4.get();
    }
    public SimpleStringProperty getSalleg4Property() {
        return salleg4;
    }
    public void setSalleg4(String salleg4) {
        this.salleg4 =new SimpleStringProperty (  salleg4);
    }


    public String getHoraire() {
        return horaire.get();
    }
    public SimpleStringProperty getHoraireProperty() {
        return horaire;
    }
    public void setHoraire(String horaire) {
        this.horaire =new SimpleStringProperty ( horaire);
    }

}
