package Controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Disponibilitesfx{

    private SimpleIntegerProperty iddisponibilites;
    private SimpleStringProperty idactivites;
    private SimpleStringProperty day;
    private SimpleStringProperty hour;
    private SimpleStringProperty classe;
    private SimpleStringProperty subject;
    private SimpleStringProperty teachers;
    private SimpleStringProperty activitestages;
    private SimpleStringProperty rom;
    private SimpleStringProperty commentaire;

    public Disponibilitesfx() {
    }

    public Disponibilitesfx(Integer iddisponibilites) {
     this.iddisponibilites =new SimpleIntegerProperty(iddisponibilites);
    }

    public Disponibilitesfx(Integer iddisponibilites, String idactivites, String day, String hour, String classe, String subject, String teachers, String activitestages, String rom) {
        this.iddisponibilites = new SimpleIntegerProperty(iddisponibilites);
        this.idactivites =new  SimpleStringProperty(idactivites);
        this.day = new  SimpleStringProperty(day);
        this.hour = new  SimpleStringProperty(hour);
        this.classe =new  SimpleStringProperty(classe);
        this.subject =new  SimpleStringProperty(subject);
        this.teachers =new  SimpleStringProperty(teachers);
        this.activitestages = new  SimpleStringProperty(activitestages);
        this.rom =new  SimpleStringProperty(rom);
        
    }

    Disponibilitesfx(Integer iddisponibilites, String idactivites, String day, String hour, String classe, String subject, String teachers, String activitestages, String rom, String commentaire) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
public Integer getIddisponibilites() {
        return iddisponibilites.get();
    }
    public SimpleIntegerProperty getIddisponibilitesProperty() {
        return iddisponibilites;
    }

    public void setIddisponibilites(Integer iddisponibilites) {
        this.iddisponibilites =new  SimpleIntegerProperty( iddisponibilites);
    }

    public String getIdactivites() {
        return idactivites.get();
    }
    public SimpleStringProperty getIdactivitesProperty() {
        return idactivites;
    }

    public void setIdactivites(String idactivites) {
        this.idactivites =new  SimpleStringProperty( idactivites);
    }

    public String getDay() {
        return day.get();
    }
    public SimpleStringProperty getDayProperty() {
        return day;
    }
    public void setDay(String day) {
        this.day = new  SimpleStringProperty(day);
    }

    public String getHour() {
        return hour.get();
    }
public SimpleStringProperty getHourProperty() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour =new  SimpleStringProperty( hour);
    }

    public String getClasse() {
        return classe.get();
    }
public SimpleStringProperty getClasseProperty() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = new  SimpleStringProperty(classe);
    }

    public String getSubject() {
        return subject.get();
    }
    public SimpleStringProperty getSubjectProperty() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject =new  SimpleStringProperty( subject);
    }

    public String getTeachers() {
        return teachers.get();
    }
    
    public SimpleStringProperty getTeachersProperty() {
        return teachers;
    }
    public void setTeachers(String teachers) {
        this.teachers =new  SimpleStringProperty( teachers);
    }

    public String getActivitestages() {
        return activitestages.get();
    }
    public SimpleStringProperty getActivitestagesProperty() {
        return activitestages;
    }
    public void setActivitestages(String activitestages) {
        this.activitestages = new  SimpleStringProperty(activitestages);
    }

    public String getRom() {
        return rom.get();
    }
    public SimpleStringProperty getRomProperty() {
        return rom;
    }

    public void setRom(String rom) {
        this.rom = new  SimpleStringProperty(rom);
    }

    public String getCommentaire() {
        return commentaire.get();
    }
    public SimpleStringProperty getCommentaireProperty() {
        return commentaire;
    }
    public void setCommentaire(String commentaire) {
        this.commentaire =new SimpleStringProperty (commentaire);
   }
}
