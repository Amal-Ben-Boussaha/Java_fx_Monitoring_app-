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
@Table(name = "tsi2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tsi2.findAll", query = "SELECT t FROM Tsi2 t")
    , @NamedQuery(name = "Tsi2.findByIdtsi2", query = "SELECT t FROM Tsi2 t WHERE t.idtsi2 = :idtsi2")
    , @NamedQuery(name = "Tsi2.findByJourTsi", query = "SELECT t FROM Tsi2 t WHERE t.jourTsi = :jourTsi")
    , @NamedQuery(name = "Tsi2.findByDateTsi", query = "SELECT t FROM Tsi2 t WHERE t.dateTsi = :dateTsi")
    , @NamedQuery(name = "Tsi2.findByMatieresTsi", query = "SELECT t FROM Tsi2 t WHERE t.matieresTsi = :matieresTsi")
    , @NamedQuery(name = "Tsi2.findByHoraireTsi", query = "SELECT t FROM Tsi2 t WHERE t.horaireTsi = :horaireTsi")
    , @NamedQuery(name = "Tsi2.findByDureeTsi", query = "SELECT t FROM Tsi2 t WHERE t.dureeTsi = :dureeTsi")
    , @NamedQuery(name = "Tsi2.findByGroupe1Tsi", query = "SELECT t FROM Tsi2 t WHERE t.groupe1Tsi = :groupe1Tsi")
    , @NamedQuery(name = "Tsi2.findBySalleG1Tsi", query = "SELECT t FROM Tsi2 t WHERE t.salleG1Tsi = :salleG1Tsi")
    , @NamedQuery(name = "Tsi2.findByGroupe2Tsi", query = "SELECT t FROM Tsi2 t WHERE t.groupe2Tsi = :groupe2Tsi")
    , @NamedQuery(name = "Tsi2.findBySalleG2Tsi", query = "SELECT t FROM Tsi2 t WHERE t.salleG2Tsi = :salleG2Tsi")})
public class Tsi2 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtsi2", nullable = false)
    private Integer idtsi2;
    @Basic(optional = false)
    @Column(name = "jour_tsi", nullable = false, length = 45)
    private String jourTsi;
    @Basic(optional = false)
    @Column(name = "date_tsi", nullable = false, length = 45)
    private String dateTsi;
    @Basic(optional = false)
    @Column(name = "matieres_tsi", nullable = false, length = 100)
    private String matieresTsi;
    @Basic(optional = false)
    @Column(name = "horaire_tsi", nullable = false, length = 45)
    private String horaireTsi;
    @Basic(optional = false)
    @Column(name = "duree_tsi", nullable = false, length = 45)
    private String dureeTsi;
    @Basic(optional = false)
    @Column(name = "groupe1_tsi", nullable = false, length = 45)
    private String groupe1Tsi;
    @Basic(optional = false)
    @Column(name = "salle_g1_tsi", nullable = false, length = 45)
    private String salleG1Tsi;
    @Basic(optional = false)
    @Column(name = "groupe2_tsi", nullable = false, length = 45)
    private String groupe2Tsi;
    @Basic(optional = false)
    @Column(name = "salle_g2_tsi", nullable = false, length = 45)
    private String salleG2Tsi;

    public Tsi2() {
    }

    public Tsi2(Integer idtsi2) {
        this.idtsi2 = idtsi2;
    }

    public Tsi2(Integer idtsi2, String jourTsi, String dateTsi, String matieresTsi, String horaireTsi, String dureeTsi, String groupe1Tsi, String salleG1Tsi, String groupe2Tsi, String salleG2Tsi) {
        this.idtsi2 = idtsi2;
        this.jourTsi = jourTsi;
        this.dateTsi = dateTsi;
        this.matieresTsi = matieresTsi;
        this.horaireTsi = horaireTsi;
        this.dureeTsi = dureeTsi;
        this.groupe1Tsi = groupe1Tsi;
        this.salleG1Tsi = salleG1Tsi;
        this.groupe2Tsi = groupe2Tsi;
        this.salleG2Tsi = salleG2Tsi;
    }

    public Integer getIdtsi2() {
        return idtsi2;
    }

    public void setIdtsi2(Integer idtsi2) {
        this.idtsi2 = idtsi2;
    }

    public String getJourTsi() {
        return jourTsi;
    }

    public void setJourTsi(String jourTsi) {
        this.jourTsi = jourTsi;
    }

    public String getDateTsi() {
        return dateTsi;
    }

    public void setDateTsi(String dateTsi) {
        this.dateTsi = dateTsi;
    }

    public String getMatieresTsi() {
        return matieresTsi;
    }

    public void setMatieresTsi(String matieresTsi) {
        this.matieresTsi = matieresTsi;
    }

    public String getHoraireTsi() {
        return horaireTsi;
    }

    public void setHoraireTsi(String horaireTsi) {
        this.horaireTsi = horaireTsi;
    }

    public String getDureeTsi() {
        return dureeTsi;
    }

    public void setDureeTsi(String dureeTsi) {
        this.dureeTsi = dureeTsi;
    }

    public String getGroupe1Tsi() {
        return groupe1Tsi;
    }

    public void setGroupe1Tsi(String groupe1Tsi) {
        this.groupe1Tsi = groupe1Tsi;
    }

    public String getSalleG1Tsi() {
        return salleG1Tsi;
    }

    public void setSalleG1Tsi(String salleG1Tsi) {
        this.salleG1Tsi = salleG1Tsi;
    }

    public String getGroupe2Tsi() {
        return groupe2Tsi;
    }

    public void setGroupe2Tsi(String groupe2Tsi) {
        this.groupe2Tsi = groupe2Tsi;
    }

    public String getSalleG2Tsi() {
        return salleG2Tsi;
    }

    public void setSalleG2Tsi(String salleG2Tsi) {
        this.salleG2Tsi = salleG2Tsi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtsi2 != null ? idtsi2.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tsi2)) {
            return false;
        }
        Tsi2 other = (Tsi2) object;
        if ((this.idtsi2 == null && other.idtsi2 != null) || (this.idtsi2 != null && !this.idtsi2.equals(other.idtsi2))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Controller.Tsi2[ idtsi2=" + idtsi2 + " ]";
    }
    
}
