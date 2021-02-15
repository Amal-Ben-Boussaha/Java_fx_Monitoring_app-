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
@Table(name = "tsi3")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tsi3.findAll", query = "SELECT t FROM Tsi3 t")
    , @NamedQuery(name = "Tsi3.findByIdtsi3", query = "SELECT t FROM Tsi3 t WHERE t.idtsi3 = :idtsi3")
    , @NamedQuery(name = "Tsi3.findByJourTsi", query = "SELECT t FROM Tsi3 t WHERE t.jourTsi = :jourTsi")
    , @NamedQuery(name = "Tsi3.findByDateTsi", query = "SELECT t FROM Tsi3 t WHERE t.dateTsi = :dateTsi")
    , @NamedQuery(name = "Tsi3.findByMatiersTsi", query = "SELECT t FROM Tsi3 t WHERE t.matiersTsi = :matiersTsi")
    , @NamedQuery(name = "Tsi3.findByHoraireTsi", query = "SELECT t FROM Tsi3 t WHERE t.horaireTsi = :horaireTsi")
    , @NamedQuery(name = "Tsi3.findByDureeTsi", query = "SELECT t FROM Tsi3 t WHERE t.dureeTsi = :dureeTsi")
    , @NamedQuery(name = "Tsi3.findByGroupe1Tsi", query = "SELECT t FROM Tsi3 t WHERE t.groupe1Tsi = :groupe1Tsi")
    , @NamedQuery(name = "Tsi3.findBySalleG1Tsi", query = "SELECT t FROM Tsi3 t WHERE t.salleG1Tsi = :salleG1Tsi")
    , @NamedQuery(name = "Tsi3.findByGroupe2Tsi", query = "SELECT t FROM Tsi3 t WHERE t.groupe2Tsi = :groupe2Tsi")
    , @NamedQuery(name = "Tsi3.findBySalleG2Tsi", query = "SELECT t FROM Tsi3 t WHERE t.salleG2Tsi = :salleG2Tsi")})
public class Tsi3 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtsi3", nullable = false)
    private Integer idtsi3;
    @Basic(optional = false)
    @Column(name = "jour_tsi", nullable = false, length = 45)
    private String jourTsi;
    @Basic(optional = false)
    @Column(name = "date_tsi", nullable = false, length = 45)
    private String dateTsi;
    @Basic(optional = false)
    @Column(name = "matiers_tsi", nullable = false, length = 45)
    private String matiersTsi;
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

    public Tsi3() {
    }

    public Tsi3(Integer idtsi3) {
        this.idtsi3 = idtsi3;
    }

    public Tsi3(Integer idtsi3, String jourTsi, String dateTsi, String matiersTsi, String horaireTsi, String dureeTsi, String groupe1Tsi, String salleG1Tsi, String groupe2Tsi, String salleG2Tsi) {
        this.idtsi3 = idtsi3;
        this.jourTsi = jourTsi;
        this.dateTsi = dateTsi;
        this.matiersTsi = matiersTsi;
        this.horaireTsi = horaireTsi;
        this.dureeTsi = dureeTsi;
        this.groupe1Tsi = groupe1Tsi;
        this.salleG1Tsi = salleG1Tsi;
        this.groupe2Tsi = groupe2Tsi;
        this.salleG2Tsi = salleG2Tsi;
    }

    public Integer getIdtsi3() {
        return idtsi3;
    }

    public void setIdtsi3(Integer idtsi3) {
        this.idtsi3 = idtsi3;
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

    public String getMatiersTsi() {
        return matiersTsi;
    }

    public void setMatiersTsi(String matiersTsi) {
        this.matiersTsi = matiersTsi;
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
        hash += (idtsi3 != null ? idtsi3.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tsi3)) {
            return false;
        }
        Tsi3 other = (Tsi3) object;
        if ((this.idtsi3 == null && other.idtsi3 != null) || (this.idtsi3 != null && !this.idtsi3.equals(other.idtsi3))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Controller.Tsi3[ idtsi3=" + idtsi3 + " ]";
    }
    
}
