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
@Table(name = "lfig")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lfig.findAll", query = "SELECT l FROM Lfig l")
    , @NamedQuery(name = "Lfig.findByIdLf", query = "SELECT l FROM Lfig l WHERE l.idLf = :idLf")
    , @NamedQuery(name = "Lfig.findByJour", query = "SELECT l FROM Lfig l WHERE l.jour = :jour")
    , @NamedQuery(name = "Lfig.findByDate", query = "SELECT l FROM Lfig l WHERE l.date = :date")
    , @NamedQuery(name = "Lfig.findByMatiere", query = "SELECT l FROM Lfig l WHERE l.matiere = :matiere")
    , @NamedQuery(name = "Lfig.findByDuree", query = "SELECT l FROM Lfig l WHERE l.duree = :duree")
    , @NamedQuery(name = "Lfig.findByGrp1", query = "SELECT l FROM Lfig l WHERE l.grp1 = :grp1")
    , @NamedQuery(name = "Lfig.findByGrp2", query = "SELECT l FROM Lfig l WHERE l.grp2 = :grp2")
    , @NamedQuery(name = "Lfig.findByGrp3", query = "SELECT l FROM Lfig l WHERE l.grp3 = :grp3")
    , @NamedQuery(name = "Lfig.findByG4", query = "SELECT l FROM Lfig l WHERE l.g4 = :g4")
    , @NamedQuery(name = "Lfig.findBySalleg1", query = "SELECT l FROM Lfig l WHERE l.salleg1 = :salleg1")
    , @NamedQuery(name = "Lfig.findBySalleg2", query = "SELECT l FROM Lfig l WHERE l.salleg2 = :salleg2")
    , @NamedQuery(name = "Lfig.findBySalleg3", query = "SELECT l FROM Lfig l WHERE l.salleg3 = :salleg3")
    , @NamedQuery(name = "Lfig.findBySalleg4", query = "SELECT l FROM Lfig l WHERE l.salleg4 = :salleg4")
    , @NamedQuery(name = "Lfig.findByHoraire", query = "SELECT l FROM Lfig l WHERE l.horaire = :horaire")})
public class Lfig implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idLf", nullable = false)
    private Integer idLf;
    @Basic(optional = false)
    @Column(name = "jour", nullable = false, length = 45)
    private String jour;
    @Basic(optional = false)
    @Column(name = "date", nullable = false, length = 45)
    private String date;
    @Basic(optional = false)
    @Column(name = "matiere", nullable = false, length = 45)
    private String matiere;
    @Basic(optional = false)
    @Column(name = "duree", nullable = false, length = 45)
    private String duree;
    @Basic(optional = false)
    @Column(name = "grp1", nullable = false, length = 45)
    private String grp1;
    @Basic(optional = false)
    @Column(name = "grp2", nullable = false, length = 45)
    private String grp2;
    @Basic(optional = false)
    @Column(name = "grp3", nullable = false, length = 45)
    private String grp3;
    @Basic(optional = false)
    @Column(name = "g4", nullable = false, length = 45)
    private String g4;
    @Basic(optional = false)
    @Column(name = "salleg1", nullable = false, length = 45)
    private String salleg1;
    @Basic(optional = false)
    @Column(name = "salleg2", nullable = false, length = 45)
    private String salleg2;
    @Basic(optional = false)
    @Column(name = "salleg3", nullable = false, length = 45)
    private String salleg3;
    @Basic(optional = false)
    @Column(name = "salleg4", nullable = false, length = 45)
    private String salleg4;
    @Basic(optional = false)
    @Column(name = "horaire", nullable = false, length = 45)
    private String horaire;

    public Lfig() {
    }

    public Lfig(Integer idLf) {
        this.idLf = idLf;
    }

    public Lfig(Integer idLf, String jour, String date, String matiere, String duree, String grp1, String grp2, String grp3, String g4, String salleg1, String salleg2, String salleg3, String salleg4, String horaire) {
        this.idLf = idLf;
        this.jour = jour;
        this.date = date;
        this.matiere = matiere;
        this.duree = duree;
        this.grp1 = grp1;
        this.grp2 = grp2;
        this.grp3 = grp3;
        this.g4 = g4;
        this.salleg1 = salleg1;
        this.salleg2 = salleg2;
        this.salleg3 = salleg3;
        this.salleg4 = salleg4;
        this.horaire = horaire;
    }

    public Integer getIdLf() {
        return idLf;
    }

    public void setIdLf(Integer idLf) {
        this.idLf = idLf;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getGrp1() {
        return grp1;
    }

    public void setGrp1(String grp1) {
        this.grp1 = grp1;
    }

    public String getGrp2() {
        return grp2;
    }

    public void setGrp2(String grp2) {
        this.grp2 = grp2;
    }

    public String getGrp3() {
        return grp3;
    }

    public void setGrp3(String grp3) {
        this.grp3 = grp3;
    }

    public String getG4() {
        return g4;
    }

    public void setG4(String g4) {
        this.g4 = g4;
    }

    public String getSalleg1() {
        return salleg1;
    }

    public void setSalleg1(String salleg1) {
        this.salleg1 = salleg1;
    }

    public String getSalleg2() {
        return salleg2;
    }

    public void setSalleg2(String salleg2) {
        this.salleg2 = salleg2;
    }

    public String getSalleg3() {
        return salleg3;
    }

    public void setSalleg3(String salleg3) {
        this.salleg3 = salleg3;
    }

    public String getSalleg4() {
        return salleg4;
    }

    public void setSalleg4(String salleg4) {
        this.salleg4 = salleg4;
    }

    public String getHoraire() {
        return horaire;
    }

    public void setHoraire(String horaire) {
        this.horaire = horaire;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLf != null ? idLf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lfig)) {
            return false;
        }
        Lfig other = (Lfig) object;
        if ((this.idLf == null && other.idLf != null) || (this.idLf != null && !this.idLf.equals(other.idLf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Controller.Lfig[ idLf=" + idLf + " ]";
    }
    
}
