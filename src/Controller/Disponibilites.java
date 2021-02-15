/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Amal Ben Boussaha
 */
@Entity
@Table(name = "disponibilites")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Disponibilites.findAll", query = "SELECT d FROM Disponibilites d")
    , @NamedQuery(name = "Disponibilites.findByIddisponibilites", query = "SELECT d FROM Disponibilites d WHERE d.iddisponibilites = :iddisponibilites")
    , @NamedQuery(name = "Disponibilites.findByIdactivites", query = "SELECT d FROM Disponibilites d WHERE d.idactivites = :idactivites")
    , @NamedQuery(name = "Disponibilites.findByDay", query = "SELECT d FROM Disponibilites d WHERE d.day = :day")
    , @NamedQuery(name = "Disponibilites.findByHour", query = "SELECT d FROM Disponibilites d WHERE d.hour = :hour")
    , @NamedQuery(name = "Disponibilites.findByClasse", query = "SELECT d FROM Disponibilites d WHERE d.classe = :classe")
    , @NamedQuery(name = "Disponibilites.findBySubject", query = "SELECT d FROM Disponibilites d WHERE d.subject = :subject")
    , @NamedQuery(name = "Disponibilites.findByTeachers", query = "SELECT d FROM Disponibilites d WHERE d.teachers = :teachers")
    , @NamedQuery(name = "Disponibilites.findByActivitestages", query = "SELECT d FROM Disponibilites d WHERE d.activitestages = :activitestages")
    , @NamedQuery(name = "Disponibilites.findByRom", query = "SELECT d FROM Disponibilites d WHERE d.rom = :rom")
    , @NamedQuery(name = "Disponibilites.findByCommentaire", query = "SELECT d FROM Disponibilites d WHERE d.commentaire = :commentaire")})
public class Disponibilites implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddisponibilites", nullable = false)
    private Integer iddisponibilites;
    @Basic(optional = false)
    @Column(name = "idactivites", nullable = false, length = 45)
    private String idactivites;
    @Basic(optional = false)
    @Column(name = "day", nullable = false, length = 10)
    private String day;
    @Basic(optional = false)
    @Column(name = "hour", nullable = false, length = 10)
    private String hour;
    @Basic(optional = false)
    @Column(name = "classe", nullable = false, length = 45)
    private String classe;
    @Basic(optional = false)
    @Column(name = "subject", nullable = false, length = 100)
    private String subject;
    @Basic(optional = false)
    @Column(name = "teachers", nullable = false, length = 45)
    private String teachers;
    @Basic(optional = false)
    @Column(name = "activitestages", nullable = false, length = 45)
    private String activitestages;
    @Basic(optional = false)
    @Column(name = "rom", nullable = false, length = 10)
    private String rom;
    @Column(name = "commentaire", length = 10)
    private String commentaire;

    public Disponibilites() {
    }

    public Disponibilites(Integer iddisponibilites) {
        this.iddisponibilites = iddisponibilites;
    }

    public Disponibilites(Integer iddisponibilites, String idactivites, String day, String hour, String classe, String subject, String teachers, String activitestages, String rom) {
        this.iddisponibilites = iddisponibilites;
        this.idactivites = idactivites;
        this.day = day;
        this.hour = hour;
        this.classe = classe;
        this.subject = subject;
        this.teachers = teachers;
        this.activitestages = activitestages;
        this.rom = rom;
    }

    public Integer getIddisponibilites() {
        return iddisponibilites;
    }

    public void setIddisponibilites(Integer iddisponibilites) {
        this.iddisponibilites = iddisponibilites;
    }

    public String getIdactivites() {
        return idactivites;
    }

    public void setIdactivites(String idactivites) {
        this.idactivites = idactivites;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTeachers() {
        return teachers;
    }

    public void setTeachers(String teachers) {
        this.teachers = teachers;
    }

    public String getActivitestages() {
        return activitestages;
    }

    public void setActivitestages(String activitestages) {
        this.activitestages = activitestages;
    }

    public String getRom() {
        return rom;
    }

    public void setRom(String rom) {
        this.rom = rom;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddisponibilites != null ? iddisponibilites.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Disponibilites)) {
            return false;
        }
        Disponibilites other = (Disponibilites) object;
        if ((this.iddisponibilites == null && other.iddisponibilites != null) || (this.iddisponibilites != null && !this.iddisponibilites.equals(other.iddisponibilites))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Controller.Disponibilites[ iddisponibilites=" + iddisponibilites + " ]";
    }
    
}
