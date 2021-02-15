package Controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Planningdsfx {

    private SimpleIntegerProperty idPlanningDS;
    private SimpleStringProperty nomcomplt;
    private SimpleStringProperty j1s1;
    private SimpleStringProperty j1s2;
    private SimpleStringProperty j1s3;
    private SimpleStringProperty j1s4;
    private SimpleStringProperty j2s1;
    private SimpleStringProperty j2s2;
    private SimpleStringProperty j2s3;
    private SimpleStringProperty j2s4;
    private SimpleStringProperty j3s1;
    private SimpleStringProperty j3s2;
    private SimpleStringProperty j3s3;
    private SimpleStringProperty j3s4;
    private SimpleStringProperty j4s1;
    private SimpleStringProperty j4s2;
    private SimpleStringProperty j4s3;
    private SimpleStringProperty j4s4;
    private SimpleStringProperty j5s1;
    private SimpleStringProperty j5s2;
    private SimpleStringProperty j5s3;
    private SimpleStringProperty j5s4;
    private SimpleStringProperty j6s1;
    private SimpleStringProperty j6s2;
    private SimpleStringProperty j6s3;
    private SimpleStringProperty j6s4;
    private SimpleStringProperty nbre;

    public Planningdsfx() {
    }

    public Planningdsfx(Integer idPlanningDS) {
        this.idPlanningDS =new SimpleIntegerProperty (idPlanningDS);
    }

    public Planningdsfx(Integer idPlanningDS, String nomcomplt, String j1s1, String j1s2, String j1s3, String j1s4, String j2s1, String j2s2, String j2s3, String j2s4, String j3s1, String j3s2, String j3s3, String j3s4, String j4s1, String j4s2, String j4s3, String j4s4, String j5s1, String j5s2, String j5s3, String j5s4, String j6s1, String j6s2, String j6s3, String j6s4, String nbre) {
        this.idPlanningDS =new SimpleIntegerProperty ( idPlanningDS);
        this.nomcomplt =new SimpleStringProperty ( nomcomplt);
        this.j1s1 =new SimpleStringProperty ( j1s1);
        this.j1s2 =new SimpleStringProperty ( j1s2);
        this.j1s3 =new SimpleStringProperty ( j1s3);
        this.j1s4 =new SimpleStringProperty ( j1s4);
        this.j2s1 =new SimpleStringProperty ( j2s1);
        this.j2s2 =new SimpleStringProperty ( j2s2);
        this.j2s3 =new SimpleStringProperty ( j2s3);
        this.j2s4 =new SimpleStringProperty ( j2s4);
        this.j3s1 =new SimpleStringProperty ( j3s1);
        this.j3s2 =new SimpleStringProperty ( j3s2);
        this.j3s3 =new SimpleStringProperty ( j3s3);
        this.j3s4 =new SimpleStringProperty ( j3s4);
        this.j4s1 =new SimpleStringProperty ( j4s1);
        this.j4s2 =new SimpleStringProperty ( j4s2);
        this.j4s3 =new SimpleStringProperty ( j4s3);
        this.j4s4 =new SimpleStringProperty ( j4s4);
        this.j5s1 = new SimpleStringProperty ( j5s1);
        this.j5s2 =new SimpleStringProperty ( j5s2);
        this.j5s3 =new SimpleStringProperty ( j5s3);
        this.j5s4 =new SimpleStringProperty ( j5s4);
        this.j6s1 =new SimpleStringProperty ( j6s1);
        this.j6s2 =new SimpleStringProperty ( j6s2);
        this.j6s3 =new SimpleStringProperty ( j6s3);
        this.j6s4 =new SimpleStringProperty ( j6s4);
        this.nbre =new SimpleStringProperty ( nbre);
    }

    public Integer getIdPlanningDS() {
        return idPlanningDS.get();
    }

    public void setIdPlanningDS(Integer idPlanningDS) {
        this.idPlanningDS = new SimpleIntegerProperty ( idPlanningDS);
    }
    
    public SimpleIntegerProperty getIdPlanningDSProperty() {
        return idPlanningDS;
    }
    public String getNomcomplt() {
        return nomcomplt.get();
    }
    public SimpleStringProperty getNomcompltProperty() {
        return nomcomplt;
    }
    public void setNomcomplt(String nomcomplt) {
        this.nomcomplt =new SimpleStringProperty ( nomcomplt);
    }

    public String getJ1s1() {
        return j1s1.get();
    }
    public SimpleStringProperty getJ1s1Property() {
        return j1s1;
    }
    public void setJ1s1(String j1s1) {
        this.j1s1 =new SimpleStringProperty ( j1s1);
    }

    public String getJ1s2() {
        return j1s2.get();
    }
    public SimpleStringProperty getJ1s2Proprty() {
        return j1s2;
    }

    public void setJ1s2(String j1s2) {
        this.j1s2 =new SimpleStringProperty ( j1s2);
    }

    public String getJ1s3() {
        return j1s3.get();
    }
    public SimpleStringProperty getJ1s3Property() {
        return j1s3;
    }
    public void setJ1s3(String j1s3) {
        this.j1s3 =new SimpleStringProperty ( j1s3);
    }

    public String getJ1s4() {
        return j1s4.get();
    }

    public void setJ1s4(String j1s4) {
        this.j1s4 =new SimpleStringProperty (j1s4);
    }
    public SimpleStringProperty getJ1s4Property() {
        return j1s4;
    }
    public String getJ2s1() {
        return j2s1.get();
    }
    public SimpleStringProperty getJ2s1Property() {
        return j2s1;
    }
    public void setJ2s1(String j2s1) {
        this.j2s1 =new SimpleStringProperty ( j2s1);
    }

    public String getJ2s2() {
        return j2s2.get();
    }
    public SimpleStringProperty getJ2s2Property() {
        return j2s2;
    }
    public void setJ2s2(String j2s2) {
        this.j2s2 =new SimpleStringProperty ( j2s2);
    }

    public String getJ2s3() {
        return j2s3.get();
    }
    public SimpleStringProperty getJ2s3Property() {
        return j2s3;
    }
    public void setJ2s3(String j2s3) {
        this.j2s3 =new SimpleStringProperty ( j2s3);
    }
    public String getJ2s4() {
        return j2s4.get();
    }

    public void setJ2s4(String j2s4) {
        this.j2s4 =new SimpleStringProperty (j2s4);
    }
    
    public SimpleStringProperty getJ2s4Property() {
        return j2s4;
    }
    public String getJ3s1() {
        return j3s1.get();
    }
    public SimpleStringProperty getJ3s1Property() {
        return j3s1;
    }
    public void setJ3s1(String j3s1) {
        this.j3s1 =new SimpleStringProperty ( j3s1);
    }

    public String getJ3s2() {
        return j3s2.get();
    }
    public SimpleStringProperty getJ3s2Property() {
        return j3s2;
    }
    public void setJ3s2(String j3s2) {
        this.j3s2 =new SimpleStringProperty ( j3s2);
    }

    public String getJ3s3() {
        return j3s3.get();
    }
    public SimpleStringProperty getJ3s3Property() {
        return j3s3;
    }
    public void setJ3s3(String j3s3) {
        this.j3s3 =new SimpleStringProperty ( j3s3);
    }

    public String getJ3s4() {
        return j3s4.get();
    }

    public void setJ3s4(String j3s4) {
        this.j3s4 =new SimpleStringProperty (j3s4);
    }
    public SimpleStringProperty getJ3s4Property() {
        return j3s4;
    }
    public String getJ4s1() {
        return j4s1.get();
    }
    public SimpleStringProperty getJ4s1Property() {
        return j4s1;
    }
    public void setJ4s1(String j4s1) {
        this.j4s1 =new SimpleStringProperty ( j4s1);
    }

    public String getJ4s2() {
        return j4s2.get();
    }
    public SimpleStringProperty getJ4s2Property() {
        return j4s2;
    }
    public void setJ4s2(String j4s2) {
        this.j4s2 =new SimpleStringProperty ( j4s2);
    }

    public String getJ4s3() {
        return j4s3.get();
    }
    public SimpleStringProperty getJ4s3Property() {
        return j4s3;
    }
    public void setJ4s3(String j4s3) {
        this.j4s3 =new SimpleStringProperty ( j4s3);
    }
    public String getJ4s4() {
        return j4s4.get();
    }

    public void setJ4s4(String j4s4) {
        this.j4s4 =new SimpleStringProperty (j4s4);
    }
    public SimpleStringProperty getJ4s4Property() {
        return j4s4;
    }
    public String getJ5s1() {
        return j5s1.get();
    }
    public SimpleStringProperty getJ5s1PRoperty() {
        return j5s1;
    }
    public void setJ5s1(String j5s1) {
        this.j5s1 =new SimpleStringProperty ( j5s1);
    }

    public String getJ5s2() {
        return j5s2.get();
    }
    public SimpleStringProperty getJ5s2Property() {
        return j5s2;
    }
    public void setJ5s2(String j5s2) {
        this.j5s2 =new SimpleStringProperty ( j5s2);
    }

    public String getJ5s3() {
        return j5s3.get();
    }
    public SimpleStringProperty getJ5s3Property() {
        return j5s3;
    }
    public void setJ5s3(String j5s3) {
        this.j5s3 =new SimpleStringProperty ( j5s3);
    }

    public String getJ5s4() {
        return j5s4.get();
    }

    public void setJ5s4(String j5s4) {
        this.j5s4 =new SimpleStringProperty (j5s4);
    }
    public SimpleStringProperty getJ5s4Property() {
        return j5s4;
    }
    public String getJ6s1() {
        return j6s1.get();
    }
     public SimpleStringProperty getJ6s1Property() {
        return j6s1;
    }

    public void setJ6s1(String j6s1) {
        this.j6s1 =new SimpleStringProperty ( j6s1);
    }

    public String getJ6s2() {
        return j6s2.get();
    }
    public SimpleStringProperty getJ6s2Property() {
        return j6s2;
    }
    public void setJ6s2(String j6s2) {
        this.j6s2 =new SimpleStringProperty ( j6s2);
    }

    public String getJ6s3() {
        return j6s3.get();
    }
    public SimpleStringProperty getJ6s3Property() {
        return j6s3;
    }
    public void setJ6s3(String j6s3) {
        this.j6s3 = new SimpleStringProperty (j6s3);
    }

    public String getJ6s4() {
        return j6s4.get();
    }

    public void setJ6s4(String j6s4) {
        this.j6s4 =new SimpleStringProperty (j6s4);
    }
    public SimpleStringProperty getJ6s4Property() {
        return j6s4;
    }
    public String getNbre() {
        return nbre.get();
    }
    public SimpleStringProperty getNbreProperty() {
        return nbre;
    }
    public void setNbre(String nbre) {
        this.nbre = new SimpleStringProperty (nbre);
    }

}
