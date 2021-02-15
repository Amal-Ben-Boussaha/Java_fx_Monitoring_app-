package Controller;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
public class Enseignantfx  {
    private SimpleIntegerProperty id;
    private SimpleStringProperty nomcomplt;
    private SimpleStringProperty grade;
    public Enseignantfx() {
    }
    public Enseignantfx(Integer id) {
        this.id = new SimpleIntegerProperty(id);
    }

    public Enseignantfx(Integer id, String nomcomplt, String grade) {
        this.id = new SimpleIntegerProperty(id);
        this.nomcomplt =new SimpleStringProperty( nomcomplt);
        this.grade = new SimpleStringProperty(grade);
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

    public String getNomcomplt() {
        return nomcomplt.get();
    }

    public  SimpleStringProperty getNomcompltProperty() {
        return nomcomplt;
    }
    
    public void setNomcomplt(String nomcomplt) {
        this.nomcomplt = new SimpleStringProperty(nomcomplt);
    }

    public String getGrade() {
        return grade.get();
    }
    public SimpleStringProperty getGradeProperty() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = new SimpleStringProperty(grade);
    }
}
