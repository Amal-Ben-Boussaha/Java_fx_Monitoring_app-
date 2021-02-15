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
@Table(name = "mecom2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mecom2.findAll", query = "SELECT m FROM Mecom2 m")
    , @NamedQuery(name = "Mecom2.findByIdmecom2", query = "SELECT m FROM Mecom2 m WHERE m.idmecom2 = :idmecom2")
    , @NamedQuery(name = "Mecom2.findByJour", query = "SELECT m FROM Mecom2 m WHERE m.jour = :jour")
    , @NamedQuery(name = "Mecom2.findByDate", query = "SELECT m FROM Mecom2 m WHERE m.date = :date")
    , @NamedQuery(name = "Mecom2.findByMatieres", query = "SELECT m FROM Mecom2 m WHERE m.matieres = :matieres")
    , @NamedQuery(name = "Mecom2.findByHoraire", query = "SELECT m FROM Mecom2 m WHERE m.horaire = :horaire")
    , @NamedQuery(name = "Mecom2.findByDuree", query = "SELECT m FROM Mecom2 m WHERE m.duree = :duree")
    , @NamedQuery(name = "Mecom2.findBySalle", query = "SELECT m FROM Mecom2 m WHERE m.salle = :salle")})
public class Mecom2 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmecom2", nullable = false)
    private Integer idmecom2;
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

    public Mecom2() {
    }

    public Mecom2(Integer idmecom2) {
        this.idmecom2 = idmecom2;
    }

    public Mecom2(Integer idmecom2, String jour, String date, String matieres, String horaire, String duree, String salle) {
        this.idmecom2 = idmecom2;
        this.jour = jour;
        this.date = date;
        this.matieres = matieres;
        this.horaire = horaire;
        this.duree = duree;
        this.salle = salle;
    }

    public Integer getIdmecom2() {
        return idmecom2;
    }

    public void setIdmecom2(Integer idmecom2) {
        this.idmecom2 = idmecom2;
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
        hash += (idmecom2 != null ? idmecom2.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mecom2)) {
            return false;
        }
        Mecom2 other = (Mecom2) object;
        if ((this.idmecom2 == null && other.idmecom2 != null) || (this.idmecom2 != null && !this.idmecom2.equals(other.idmecom2))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Controller.Mecom2[ idmecom2=" + idmecom2 + " ]";
    }
    
}
