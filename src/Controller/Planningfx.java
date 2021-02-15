package Controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Planningfx  {

    private SimpleIntegerProperty idP;
    private SimpleStringProperty nomcomplt;
    private SimpleStringProperty j1s1;
    private SimpleStringProperty j1s2;
    private SimpleStringProperty j1s3;
    private SimpleStringProperty j2s1;
    private SimpleStringProperty j2s2;
    private SimpleStringProperty j2s3;
    private SimpleStringProperty j3s1;
    private SimpleStringProperty j3s2;
    private SimpleStringProperty j3s3;
    private SimpleStringProperty j4s1;
    private SimpleStringProperty j4s2;
    private SimpleStringProperty j4s3;
    private SimpleStringProperty j5s1;
    private SimpleStringProperty j5s2;
    private SimpleStringProperty j5s3;
    private SimpleStringProperty j6s1;
    private SimpleStringProperty j6s2;
    private SimpleStringProperty j6s3;
    private SimpleStringProperty j7s1;
    private SimpleStringProperty j7s2;
    private SimpleStringProperty j7s3;
    private SimpleStringProperty j8s1;
    private SimpleStringProperty j8s2;
    private SimpleStringProperty j8s3;
    private SimpleStringProperty j9s1;
    private SimpleStringProperty j9s2;
    private SimpleStringProperty j9s3;
    private SimpleStringProperty j10s1;
    private SimpleStringProperty j10s2;
    private SimpleStringProperty j10s3;
    private SimpleStringProperty nbre;

    public Planningfx() {
    }

    public Planningfx(Integer idP) {
        this.idP =new SimpleIntegerProperty (idP);
    }

    public Planningfx(Integer idP, String nomcomplt, String j1s1, String j1s2, String j1s3, String j2s1, String j2s2, String j2s3, String j3s1, String j3s2, String j3s3, String j4s1, String j4s2, String j4s3, String j5s1, String j5s2, String j5s3, String j6s1, String j6s2, String j6s3, String j7s1, String j7s2, String j7s3, String j8s1, String j8s2, String j8s3, String j9s1, String j9s2, String j9s3, String j10s1, String j10s2, String j10s3, String nbre) {
        this.idP = new SimpleIntegerProperty (idP);
        this.nomcomplt =new SimpleStringProperty (nomcomplt);
        this.j1s1 =new SimpleStringProperty ( j1s1);
        this.j1s2 =new SimpleStringProperty ( j1s2);
        this.j1s3 =new SimpleStringProperty ( j1s3);
        this.j2s1 =new SimpleStringProperty ( j2s1);
        this.j2s2 =new SimpleStringProperty ( j2s2);
        this.j2s3 =new SimpleStringProperty ( j2s3);
        this.j3s1 =new SimpleStringProperty ( j3s1);
        this.j3s2 =new SimpleStringProperty ( j3s2);
        this.j3s3 =new SimpleStringProperty ( j3s3);
        this.j4s1 =new SimpleStringProperty ( j4s1);
        this.j4s2 =new SimpleStringProperty ( j4s2);
        this.j4s3 =new SimpleStringProperty ( j4s3);
        this.j5s1 = new SimpleStringProperty (j5s1);
        this.j5s2 =new SimpleStringProperty ( j5s2);
        this.j5s3 =new SimpleStringProperty ( j5s3);
        this.j6s1 =new SimpleStringProperty ( j6s1);
        this.j6s2 =new SimpleStringProperty ( j6s2);
        this.j6s3 =new SimpleStringProperty ( j6s3);
        this.j7s1 =new SimpleStringProperty ( j7s1);
        this.j7s2 =new SimpleStringProperty ( j7s2);
        this.j7s3 =new SimpleStringProperty ( j7s3);
        this.j8s1 =new SimpleStringProperty ( j8s1);
        this.j8s2 =new SimpleStringProperty ( j8s2);
        this.j8s3 =new SimpleStringProperty ( j8s3);
        this.j9s1 = new SimpleStringProperty (j9s1);
        this.j9s2 =new SimpleStringProperty ( j9s2);
        this.j9s3 =new SimpleStringProperty ( j9s3);
        this.j10s1 =new SimpleStringProperty ( j10s1);
        this.j10s2 =new SimpleStringProperty ( j10s2);
        this.j10s3 =new SimpleStringProperty ( j10s3);
        this.nbre =new SimpleStringProperty ( nbre);
    }

    public Integer getIdP() {
        return idP.get();
    }
    public SimpleIntegerProperty getIdPProperty() {
        return idP;
    }
    public void setIdP(Integer idP) {
        this.idP =new SimpleIntegerProperty (idP);
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

    public String getJ7s1() {
        return j7s1.get();
    }
    public SimpleStringProperty getJ7s1Property() {
        return j7s1;
    }
    public void setJ7s1(String j7s1) {
        this.j7s1 =new SimpleStringProperty ( j7s1);
    }

    public String getJ7s2() {
        return j7s2.get();
    }
    public SimpleStringProperty getJ7s2Property() {
        return j7s2;
    }
    public void setJ7s2(String j7s2) {
        this.j7s2 =new SimpleStringProperty ( j7s2);
    }

    public String getJ7s3() {
        return j7s3.get();
    }
    public SimpleStringProperty getJ7s3Property() {
        return j7s3;
    }
    public void setJ7s3(String j7s3) {
        this.j7s3 = new SimpleStringProperty (j7s3);
    }

    public String getJ8s1() {
        return j8s1.get();
    }
    public SimpleStringProperty getJ8s1Property() {
        return j8s1;
    }
    public void setJ8s1(String j8s1) {
        this.j8s1 = new SimpleStringProperty (j8s1);
    }

    public String getJ8s2() {
        return j8s2.get();
    }
    public SimpleStringProperty getJ8s2Property() {
        return j8s2;
    }
    public void setJ8s2(String j8s2) {
        this.j8s2 = new SimpleStringProperty (j8s2);
    }

    public String getJ8s3() {
        return j8s3.get();
    }
    public SimpleStringProperty getJ8s3Property() {
        return j8s3;
    }
    public void setJ8s3(String j8s3) {
        this.j8s3 = new SimpleStringProperty (j8s3);
    }

    public String getJ9s1() {
        return j9s1.get();
    }
    public SimpleStringProperty getJ9s1Property() {
        return j9s1;
    }
    public void setJ9s1(String j9s1) {
        this.j9s1 = new SimpleStringProperty (j9s1);
    }

    public String getJ9s2() {
        return j9s2.get();
    }
    public SimpleStringProperty getJ9s2Property() {
        return j9s2;
    }
    public void setJ9s2(String j9s2) {
        this.j9s2 = new SimpleStringProperty (j9s2);
    }

    public String getJ9s3() {
        return j9s3.get();
    }
    public SimpleStringProperty getJ9s3Property() {
        return j9s3;
    }
    public void setJ9s3(String j9s3) {
        this.j9s3 = new SimpleStringProperty (j9s3);
    }

    public String getJ10s1() {
        return j10s1.get();
    }
    public SimpleStringProperty getJ10s1Property() {
        return j10s1;
    }
    public void setJ10s1(String j10s1) {
        this.j10s1 = new SimpleStringProperty (j10s1);
    }

    public String getJ10s2() {
        return j10s2.get();
    }
    public SimpleStringProperty getJ10s2Property() {
        return j10s2;
    }
    public void setJ10s2(String j10s2) {
        this.j10s2 = new SimpleStringProperty (j10s2);
    }

    public String getJ10s3() {
        return j10s3.get();
    }
    public SimpleStringProperty getJ10s3Property() {
        return j10s3;
    }
    public void setJ10s3(String j10s3) {
        this.j10s3 =new SimpleStringProperty ( j10s3);
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
