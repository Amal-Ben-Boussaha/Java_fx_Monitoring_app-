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
@Table(name = "lfig3")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lfig3.findAll", query = "SELECT l FROM Lfig3 l")
    , @NamedQuery(name = "Lfig3.findByIdlfig3", query = "SELECT l FROM Lfig3 l WHERE l.idlfig3 = :idlfig3")
    , @NamedQuery(name = "Lfig3.findByJour", query = "SELECT l FROM Lfig3 l WHERE l.jour = :jour")
    , @NamedQuery(name = "Lfig3.findByDate", query = "SELECT l FROM Lfig3 l WHERE l.date = :date")
    , @NamedQuery(name = "Lfig3.findByMatieres", query = "SELECT l FROM Lfig3 l WHERE l.matieres = :matieres")
    , @NamedQuery(name = "Lfig3.findByHoraire", query = "SELECT l FROM Lfig3 l WHERE l.horaire = :horaire")
    , @NamedQuery(name = "Lfig3.findByDuree", query = "SELECT l FROM Lfig3 l WHERE l.duree = :duree")
    , @NamedQuery(name = "Lfig3.findByGroupe1", query = "SELECT l FROM Lfig3 l WHERE l.groupe1 = :groupe1")
    , @NamedQuery(name = "Lfig3.findBySalleG1", query = "SELECT l FROM Lfig3 l WHERE l.salleG1 = :salleG1")
    , @NamedQuery(name = "Lfig3.findByGroupe2", query = "SELECT l FROM Lfig3 l WHERE l.groupe2 = :groupe2")
    , @NamedQuery(name = "Lfig3.findBySalleG2", query = "SELECT l FROM Lfig3 l WHERE l.salleG2 = :salleG2")})
public class Lfig3 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlfig3", nullable = false)
    private Integer idlfig3;
    @Basic(optional = false)
    @Column(name = "jour", nullable = false, length = 45)
    private String jour;
    @Basic(optional = false)
    @Column(name = "date", nullable = false, length = 45)
    private String date;
    @Basic(optional = false)
    @Column(name = "matieres", nullable = false, length = 45)
    private String matieres;
    @Basic(optional = false)
    @Column(name = "horaire", nullable = false, length = 45)
    private String horaire;
    @Basic(optional = false)
    @Column(name = "duree", nullable = false, length = 45)
    private String duree;
    @Basic(optional = false)
    @Column(name = "groupe1", nullable = false, length = 45)
    private String groupe1;
    @Basic(optional = false)
    @Column(name = "salle_g1", nullable = false, length = 45)
    private String salleG1;
    @Basic(optional = false)
    @Column(name = "groupe2", nullable = false, length = 45)
    private String groupe2;
    @Basic(optional = false)
    @Column(name = "salle_g2", nullable = false, length = 45)
    private String salleG2;

    public Lfig3() {
    }

    public Lfig3(Integer idlfig3) {
        this.idlfig3 = idlfig3;
    }

    public Lfig3(Integer idlfig3, String jour, String date, String matieres, String horaire, String duree, String groupe1, String salleG1, String groupe2, String salleG2) {
        this.idlfig3 = idlfig3;
        this.jour = jour;
        this.date = date;
        this.matieres = matieres;
        this.horaire = horaire;
        this.duree = duree;
        this.groupe1 = groupe1;
        this.salleG1 = salleG1;
        this.groupe2 = groupe2;
        this.salleG2 = salleG2;
    }

    public Integer getIdlfig3() {
        return idlfig3;
    }

    public void setIdlfig3(Integer idlfig3) {
        this.idlfig3 = idlfig3;
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

    public String getMatieres() {
        return matieres;
    }

    public void setMatieres(String matieres) {
        this.matieres = matieres;
    }

    public String getHoraire() {
        return horaire;
    }

    public void setHoraire(String horaire) {
        this.horaire = horaire;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getGroupe1() {
        return groupe1;
    }

    public void setGroupe1(String groupe1) {
        this.groupe1 = groupe1;
    }

    public String getSalleG1() {
        return salleG1;
    }

    public void setSalleG1(String salleG1) {
        this.salleG1 = salleG1;
    }

    public String getGroupe2() {
        return groupe2;
    }

    public void setGroupe2(String groupe2) {
        this.groupe2 = groupe2;
    }

    public String getSalleG2() {
        return salleG2;
    }

    public void setSalleG2(String salleG2) {
        this.salleG2 = salleG2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlfig3 != null ? idlfig3.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lfig3)) {
            return false;
        }
        Lfig3 other = (Lfig3) object;
        if ((this.idlfig3 == null && other.idlfig3 != null) || (this.idlfig3 != null && !this.idlfig3.equals(other.idlfig3))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Controller.Lfig3[ idlfig3=" + idlfig3 + " ]";
    }
    
}
