package Controller;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
public class Matifx {

    private SimpleIntegerProperty idM;
    private SimpleStringProperty classe;
    private SimpleStringProperty examen;

    public Matifx() {
    }

    public Matifx(Integer idM) {
        this.idM =new SimpleIntegerProperty (idM);
    }

    public Matifx(Integer idM, String classe, String examen) {
        this.idM =new SimpleIntegerProperty ( idM);
        this.classe =new SimpleStringProperty (classe);
        this.examen =new SimpleStringProperty ( examen);
       
    }



    public Integer getIdM() {
        return idM.get();
    }
    public SimpleIntegerProperty getIdMProperty() {
        return idM;
    }
    public void setIdM(Integer idM) {
        this.idM = new SimpleIntegerProperty(idM);
    }


    public String getClasse() {
        return classe.get();
    }
    public SimpleStringProperty getClasseProperty()
    {
        return classe ;
    
    }
    public void setClasse(String classe) {
        this.classe  = new SimpleStringProperty(classe);
    }

    public String getExamen() {
        return examen.get();
    }
public SimpleStringProperty getExamenProperty()
    {
        return examen ;
    
    }
    
    public void setExamen(String examen) {
        this.examen =new SimpleStringProperty( examen);
    }

}
