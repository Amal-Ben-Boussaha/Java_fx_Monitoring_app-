package Controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Planningscfx{

    private SimpleIntegerProperty idPlanningSC;
    private SimpleStringProperty nomcomplt;
    private SimpleStringProperty j1s1;
    private SimpleStringProperty j1s2;
    private SimpleStringProperty j2s1;
    private SimpleStringProperty j2s2;
    private SimpleStringProperty j3s1;
    private SimpleStringProperty j3s2;
    private SimpleStringProperty j4s1;
    private SimpleStringProperty j4s2;
    private SimpleStringProperty j5s1;
    private SimpleStringProperty j5s2;
    private SimpleStringProperty j6s1;
    private SimpleStringProperty j6s2;
    private SimpleStringProperty j7s1;
    private SimpleStringProperty j7s2;
    private SimpleStringProperty j8s1;
    private SimpleStringProperty j8s2;
    private SimpleStringProperty j9s1;
    private SimpleStringProperty j9s2;
    private SimpleStringProperty j10s1;
    private SimpleStringProperty j10s2;
    private SimpleStringProperty j11s1;
    private SimpleStringProperty j11s2;
    private SimpleStringProperty j12s1;
    private SimpleStringProperty j12s2;
    private SimpleStringProperty j13s1;
    private SimpleStringProperty j13s2;
    private SimpleStringProperty j14s1;
    private SimpleStringProperty j14s2;
    private SimpleStringProperty j15s1;
    private SimpleStringProperty j15s2;
    private SimpleStringProperty nbre;


    public Planningscfx() {
    }

    public Planningscfx(Integer idPlanningSC) {
        
    }

    public Planningscfx(Integer idPlanningSC, String nomcomplt, String j1s1, String j1s2, String j2s1, String j2s2, String j3s1, String j3s2, String j4s1, String j4s2, String j5s1, String j5s2, String j6s1, String j6s2, String j7s1, String j7s2, String j8s1, String j8s2, String j9s1, String j9s2, String j10s1, String j10s2, String j11s1, String j11s2, String j12s1, String j12s2, String j13s1, String j13s2, String j14s1, String j14s2, String j15s1, String j15s2, String nbre) {
        this.idPlanningSC =new SimpleIntegerProperty (idPlanningSC);
        this.nomcomplt =new SimpleStringProperty (nomcomplt);
        this.j1s1 =new SimpleStringProperty ( j1s1);
        this.j1s2 =new SimpleStringProperty ( j1s2);
        this.j2s1 =new SimpleStringProperty ( j2s1);
        this.j2s2 =new SimpleStringProperty ( j2s2);
        this.j3s1 =new SimpleStringProperty ( j3s1);
        this.j3s2 =new SimpleStringProperty ( j3s2);
        this.j3s1 =new SimpleStringProperty ( j3s1);
        this.j3s2 =new SimpleStringProperty ( j3s2);
        this.j4s1 =new SimpleStringProperty ( j4s1);
        this.j4s2 =new SimpleStringProperty ( j4s2);
        this.j5s1 =new SimpleStringProperty (j5s1);
        this.j5s2 =new SimpleStringProperty ( j5s2);
        this.j6s1 =new SimpleStringProperty ( j6s1);
        this.j6s2 =new SimpleStringProperty ( j6s2);
        this.j7s1 =new SimpleStringProperty ( j7s1);
        this.j7s2 =new SimpleStringProperty ( j7s2);
        this.j8s1 =new SimpleStringProperty ( j8s1);
        this.j8s2 =new SimpleStringProperty ( j8s2);
        this.j9s1 =new SimpleStringProperty (j9s1);
        this.j9s2 =new SimpleStringProperty ( j9s2);
        this.j10s1 =new SimpleStringProperty ( j10s1);
        this.j10s2 =new SimpleStringProperty ( j10s2);
        this.j11s1 =new SimpleStringProperty ( j11s1);
        this.j11s2 =new SimpleStringProperty ( j11s2);
        this.j12s1 =new SimpleStringProperty ( j12s1);
        this.j12s2 =new SimpleStringProperty ( j12s2);
        this.j13s1 =new SimpleStringProperty ( j13s1);
        this.j13s2 =new SimpleStringProperty ( j13s2);
        this.j14s1 =new SimpleStringProperty ( j14s1);
        this.j14s2 =new SimpleStringProperty ( j14s2);
        this.j15s1 =new SimpleStringProperty ( j15s1);
        this.j15s2 =new SimpleStringProperty ( j15s2);
        this.nbre =new SimpleStringProperty ( nbre);
    }

    public Integer getIdPlanningSC() {
        return idPlanningSC.get();
    }

    public void setIdPlanningSC(Integer idPlanningSC) {
        this.idPlanningSC =new SimpleIntegerProperty ( idPlanningSC);
    }
    
    public SimpleIntegerProperty getIdPlanningSCProperty() {
        return idPlanningSC;
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

    
    public String getJ11s1() {
        return j11s1.get();
    }

    public void setJ11s1(String j11s1) {
        this.j11s1 =new SimpleStringProperty (j11s1);
    }

    public SimpleStringProperty getJ11s1Property() {
        return j11s1;
    }
    
    public String getJ11s2() {
        return j11s2.get();
    }

    public void setJ11s2(String j11s2) {
        this.j11s2 =new SimpleStringProperty (j11s2);
    }
    
    public SimpleStringProperty getJ11s2Property() {
        return j11s2;
    }
    
    public String getJ12s1() {
        return j12s1.get();
    }

    public void setJ12s1(String j12s1) {
        this.j12s1 =new SimpleStringProperty (j12s1);
    }
    
    public SimpleStringProperty getJ12s1Property() {
        return j12s1;
    }
    public String getJ12s2() {
        return j12s2.get();
    }

    public void setJ12s2(String j12s2) {
        this.j12s2 =new SimpleStringProperty (j12s2);
    }
    
    public SimpleStringProperty getJ12s2Property() {
        return j12s2;
    }
    
    public String getJ13s1() {
        return j13s1.get();
    }

    public void setJ13s1(String j13s1) {
        this.j13s1 =new SimpleStringProperty (j13s1);
    }

    public SimpleStringProperty getJ13s1Property() {
        return j13s1;
    }
    public String getJ13s2() {
        return j13s2.get();
    }

    public void setJ13s2(String j13s2) {
        this.j13s2 =new SimpleStringProperty (j13s2);
    }
    
    public SimpleStringProperty getJ13s2Property() {
        return j13s2;
    }
    
    public String getJ14s1() {
        return j14s1.get();
    }

    public void setJ14s1(String j14s1) {
        this.j14s1 =new SimpleStringProperty (j14s1);
    }
    
    public SimpleStringProperty getJ14s1Property() {
        return j14s1;
    }
    
    public String getJ14s2() {
        return j14s2.get();
    }

    public void setJ14s2(String j14s2) {
        this.j14s2 =new SimpleStringProperty (j14s2);
    }

    public SimpleStringProperty getJ14s2Property() {
        return j14s2;
    }
    
    
    public String getJ15s1() {
        return j15s1.get();
    }

    public void setJ15s1(String j15s1) {
        this.j15s1 =new SimpleStringProperty (j15s1);
    }

    public SimpleStringProperty getJ15s1Property() {
        return j15s1;
    }
    public String getJ15s2() {
        return j15s2.get();
    }

    public void setJ15s2(String j15s2) {
        this.j15s2 =new SimpleStringProperty (j15s2);
    }

    public SimpleStringProperty getJ15s2Property() {
        return j15s2;
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
