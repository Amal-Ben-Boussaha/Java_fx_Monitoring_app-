package Controller;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class Actitvitefx  {
    private static final long serialVersionUID = 1L;
    private SimpleIntegerProperty id;
    private SimpleStringProperty apprenant;
    private SimpleStringProperty matere;
    private SimpleStringProperty prof;
    private SimpleStringProperty code;
    private SimpleStringProperty duree;

    public Actitvitefx() {
    }

    public Actitvitefx(Integer id) {
        this.id =new SimpleIntegerProperty(id);
    }

    public Actitvitefx(Integer id, String apprenant, String matere, String prof, String code) {
        this.id = new SimpleIntegerProperty(id);
        this.apprenant =new SimpleStringProperty( apprenant);
        this.matere =new SimpleStringProperty(matere);
        this.prof =new SimpleStringProperty(prof);
        this.code =new SimpleStringProperty(code);
    }

    Actitvitefx(Integer id, String apprenant, String matere, String prof, String code, String duree) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getId() {
        return id.get();
    }
    public SimpleIntegerProperty getIdProperty() {
        return id;
    }
    public void setId(Integer id) {
        this.id = new SimpleIntegerProperty(id);
    }

    
    public String getApprenant() {
        return apprenant.get();
    }
    public SimpleStringProperty getApprenantProperty() {
        return apprenant;
    }

    public void setApprenant(String apprenant) {
        this.apprenant =new SimpleStringProperty (apprenant);
    }
    
    public String getMatere() {
        return matere.get();
    }
    public SimpleStringProperty getMatereProperty() {
        return matere;
    }

    public void setMatere(String matere) {
        this.matere =new SimpleStringProperty( matere);
    }

    public String getProf() {
        return prof.get();
    }
    public SimpleStringProperty getProfProperty() {
        return prof;
    }
    
    public void setProf(String prof) {
        this.prof =new SimpleStringProperty( prof);
    }

    public String getCode() {
        return code.get();
    }
    public SimpleStringProperty getCodeProperty() {
        return code;
    }

    public void setCode(String code) {
        this.code =new SimpleStringProperty( code);
    }

    public String getDuree() {
        return duree.get();
    }
    public SimpleStringProperty getDureeProperty() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree =new SimpleStringProperty( duree);
    }

    
    
}
