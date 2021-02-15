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
@Table(name = "mecom1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mecom1.findAll", query = "SELECT m FROM Mecom1 m")
    , @NamedQuery(name = "Mecom1.findByIdMecom1", query = "SELECT m FROM Mecom1 m WHERE m.idMecom1 = :idMecom1")
    , @NamedQuery(name = "Mecom1.findByJour", query = "SELECT m FROM Mecom1 m WHERE m.jour = :jour")
    , @NamedQuery(name = "Mecom1.findByDate", query = "SELECT m FROM Mecom1 m WHERE m.date = :date")
    , @NamedQuery(name = "Mecom1.findByMatieres", query = "SELECT m FROM Mecom1 m WHERE m.matieres = :matieres")
    , @NamedQuery(name = "Mecom1.findByHoraire", query = "SELECT m FROM Mecom1 m WHERE m.horaire = :horaire")
    , @NamedQuery(name = "Mecom1.findByDuree", query = "SELECT m FROM Mecom1 m WHERE m.duree = :duree")
    , @NamedQuery(name = "Mecom1.findBySalle", query = "SELECT m FROM Mecom1 m WHERE m.salle = :salle")})
public class Mecom1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMecom1", nullable = false)
    private Integer idMecom1;
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
    @Column(name = "salle", nullable = false, length = 45)
    private String salle;

    public Mecom1() {
    }

    public Mecom1(Integer idMecom1) {
        this.idMecom1 = idMecom1;
    }

    public Mecom1(Integer idMecom1, String jour, String date, String matieres, String horaire, String duree, String salle) {
        this.idMecom1 = idMecom1;
        this.jour = jour;
        this.date = date;
        this.matieres = matieres;
        this.horaire = horaire;
        this.duree = duree;
        this.salle = salle;
    }

    public Integer getIdMecom1() {
        return idMecom1;
    }

    public void setIdMecom1(Integer idMecom1) {
        this.idMecom1 = idMecom1;
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

    public String getSalle() {
        return salle;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMecom1 != null ? idMecom1.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mecom1)) {
            return false;
        }
        Mecom1 other = (Mecom1) object;
        if ((this.idMecom1 == null && other.idMecom1 != null) || (this.idMecom1 != null && !this.idMecom1.equals(other.idMecom1))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Controller.Mecom1[ idMecom1=" + idMecom1 + " ]";
    }
    
}
