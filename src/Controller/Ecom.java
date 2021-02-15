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
@Table(name = "ecom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ecom.findAll", query = "SELECT e FROM Ecom e")
    , @NamedQuery(name = "Ecom.findByIdecom", query = "SELECT e FROM Ecom e WHERE e.idecom = :idecom")
    , @NamedQuery(name = "Ecom.findByJourEcom", query = "SELECT e FROM Ecom e WHERE e.jourEcom = :jourEcom")
    , @NamedQuery(name = "Ecom.findByDateEcom", query = "SELECT e FROM Ecom e WHERE e.dateEcom = :dateEcom")
    , @NamedQuery(name = "Ecom.findByMatiereEcom", query = "SELECT e FROM Ecom e WHERE e.matiereEcom = :matiereEcom")
    , @NamedQuery(name = "Ecom.findByHoraireEcom", query = "SELECT e FROM Ecom e WHERE e.horaireEcom = :horaireEcom")
    , @NamedQuery(name = "Ecom.findByDureeEcom", query = "SELECT e FROM Ecom e WHERE e.dureeEcom = :dureeEcom")
    , @NamedQuery(name = "Ecom.findByG1Ecom", query = "SELECT e FROM Ecom e WHERE e.g1Ecom = :g1Ecom")
    , @NamedQuery(name = "Ecom.findByG2Ecom", query = "SELECT e FROM Ecom e WHERE e.g2Ecom = :g2Ecom")
    , @NamedQuery(name = "Ecom.findBySalleG1", query = "SELECT e FROM Ecom e WHERE e.salleG1 = :salleG1")
    , @NamedQuery(name = "Ecom.findByLleG2", query = "SELECT e FROM Ecom e WHERE e.lleG2 = :lleG2")})
public class Ecom implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idecom", nullable = false)
    private Integer idecom;
    @Basic(optional = false)
    @Column(name = "jour_ecom", nullable = false, length = 45)
    private String jourEcom;
    @Basic(optional = false)
    @Column(name = "date_ecom", nullable = false, length = 45)
    private String dateEcom;
    @Basic(optional = false)
    @Column(name = "matiere_ecom", nullable = false, length = 100)
    private String matiereEcom;
    @Basic(optional = false)
    @Column(name = "horaire_ecom", nullable = false, length = 45)
    private String horaireEcom;
    @Basic(optional = false)
    @Column(name = "duree_ecom", nullable = false, length = 45)
    private String dureeEcom;
    @Basic(optional = false)
    @Column(name = "g1_ecom", nullable = false, length = 45)
    private String g1Ecom;
    @Basic(optional = false)
    @Column(name = "g2_ecom", nullable = false, length = 45)
    private String g2Ecom;
    @Basic(optional = false)
    @Column(name = "salle_g1", nullable = false, length = 45)
    private String salleG1;
    @Basic(optional = false)
    @Column(name = "lle_g2", nullable = false, length = 45)
    private String lleG2;

    public Ecom() {
    }

    public Ecom(Integer idecom) {
        this.idecom = idecom;
    }

    public Ecom(Integer idecom, String jourEcom, String dateEcom, String matiereEcom, String horaireEcom, String dureeEcom, String g1Ecom, String g2Ecom, String salleG1, String lleG2) {
        this.idecom = idecom;
        this.jourEcom = jourEcom;
        this.dateEcom = dateEcom;
        this.matiereEcom = matiereEcom;
        this.horaireEcom = horaireEcom;
        this.dureeEcom = dureeEcom;
        this.g1Ecom = g1Ecom;
        this.g2Ecom = g2Ecom;
        this.salleG1 = salleG1;
        this.lleG2 = lleG2;
    }

    public Integer getIdecom() {
        return idecom;
    }

    public void setIdecom(Integer idecom) {
        this.idecom = idecom;
    }

    public String getJourEcom() {
        return jourEcom;
    }

    public void setJourEcom(String jourEcom) {
        this.jourEcom = jourEcom;
    }

    public String getDateEcom() {
        return dateEcom;
    }

    public void setDateEcom(String dateEcom) {
        this.dateEcom = dateEcom;
    }

    public String getMatiereEcom() {
        return matiereEcom;
    }

    public void setMatiereEcom(String matiereEcom) {
        this.matiereEcom = matiereEcom;
    }

    public String getHoraireEcom() {
        return horaireEcom;
    }

    public void setHoraireEcom(String horaireEcom) {
        this.horaireEcom = horaireEcom;
    }

    public String getDureeEcom() {
        return dureeEcom;
    }

    public void setDureeEcom(String dureeEcom) {
        this.dureeEcom = dureeEcom;
    }

    public String getG1Ecom() {
        return g1Ecom;
    }

    public void setG1Ecom(String g1Ecom) {
        this.g1Ecom = g1Ecom;
    }

    public String getG2Ecom() {
        return g2Ecom;
    }

    public void setG2Ecom(String g2Ecom) {
        this.g2Ecom = g2Ecom;
    }

    public String getSalleG1() {
        return salleG1;
    }

    public void setSalleG1(String salleG1) {
        this.salleG1 = salleG1;
    }

    public String getLleG2() {
        return lleG2;
    }

    public void setLleG2(String lleG2) {
        this.lleG2 = lleG2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idecom != null ? idecom.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ecom)) {
            return false;
        }
        Ecom other = (Ecom) object;
        if ((this.idecom == null && other.idecom != null) || (this.idecom != null && !this.idecom.equals(other.idecom))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Controller.Ecom[ idecom=" + idecom + " ]";
    }
    
}
