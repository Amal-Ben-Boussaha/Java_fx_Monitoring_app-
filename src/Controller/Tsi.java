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
@Table(name = "tsi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tsi.findAll", query = "SELECT t FROM Tsi t")
    , @NamedQuery(name = "Tsi.findByIdTSI", query = "SELECT t FROM Tsi t WHERE t.idTSI = :idTSI")
    , @NamedQuery(name = "Tsi.findByJour", query = "SELECT t FROM Tsi t WHERE t.jour = :jour")
    , @NamedQuery(name = "Tsi.findByDate", query = "SELECT t FROM Tsi t WHERE t.date = :date")
    , @NamedQuery(name = "Tsi.findByMatiereTsi", query = "SELECT t FROM Tsi t WHERE t.matiereTsi = :matiereTsi")
    , @NamedQuery(name = "Tsi.findByHoraireTsi", query = "SELECT t FROM Tsi t WHERE t.horaireTsi = :horaireTsi")
    , @NamedQuery(name = "Tsi.findByDureeTsi", query = "SELECT t FROM Tsi t WHERE t.dureeTsi = :dureeTsi")
    , @NamedQuery(name = "Tsi.findByG1Tsi", query = "SELECT t FROM Tsi t WHERE t.g1Tsi = :g1Tsi")
    , @NamedQuery(name = "Tsi.findByG2Tsi", query = "SELECT t FROM Tsi t WHERE t.g2Tsi = :g2Tsi")
    , @NamedQuery(name = "Tsi.findBySalleG1", query = "SELECT t FROM Tsi t WHERE t.salleG1 = :salleG1")
    , @NamedQuery(name = "Tsi.findBySalleG2", query = "SELECT t FROM Tsi t WHERE t.salleG2 = :salleG2")})
public class Tsi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTSI", nullable = false)
    private Integer idTSI;
    @Basic(optional = false)
    @Column(name = "jour", nullable = false, length = 45)
    private String jour;
    @Basic(optional = false)
    @Column(name = "date", nullable = false, length = 45)
    private String date;
    @Basic(optional = false)
    @Column(name = "matiere_tsi", nullable = false, length = 100)
    private String matiereTsi;
    @Basic(optional = false)
    @Column(name = "horaire_tsi", nullable = false, length = 45)
    private String horaireTsi;
    @Basic(optional = false)
    @Column(name = "duree_tsi", nullable = false, length = 45)
    private String dureeTsi;
    @Basic(optional = false)
    @Column(name = "g1_tsi", nullable = false, length = 45)
    private String g1Tsi;
    @Basic(optional = false)
    @Column(name = "g2_tsi", nullable = false, length = 45)
    private String g2Tsi;
    @Basic(optional = false)
    @Column(name = "salle_g1", nullable = false, length = 45)
    private String salleG1;
    @Basic(optional = false)
    @Column(name = "salle_g2", nullable = false, length = 45)
    private String salleG2;

    public Tsi() {
    }

    public Tsi(Integer idTSI) {
        this.idTSI = idTSI;
    }

    public Tsi(Integer idTSI, String jour, String date, String matiereTsi, String horaireTsi, String dureeTsi, String g1Tsi, String g2Tsi, String salleG1, String salleG2) {
        this.idTSI = idTSI;
        this.jour = jour;
        this.date = date;
        this.matiereTsi = matiereTsi;
        this.horaireTsi = horaireTsi;
        this.dureeTsi = dureeTsi;
        this.g1Tsi = g1Tsi;
        this.g2Tsi = g2Tsi;
        this.salleG1 = salleG1;
        this.salleG2 = salleG2;
    }

    public Integer getIdTSI() {
        return idTSI;
    }

    public void setIdTSI(Integer idTSI) {
        this.idTSI = idTSI;
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

    public String getMatiereTsi() {
        return matiereTsi;
    }

    public void setMatiereTsi(String matiereTsi) {
        this.matiereTsi = matiereTsi;
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

    public String getG1Tsi() {
        return g1Tsi;
    }

    public void setG1Tsi(String g1Tsi) {
        this.g1Tsi = g1Tsi;
    }

    public String getG2Tsi() {
        return g2Tsi;
    }

    public void setG2Tsi(String g2Tsi) {
        this.g2Tsi = g2Tsi;
    }

    public String getSalleG1() {
        return salleG1;
    }

    public void setSalleG1(String salleG1) {
        this.salleG1 = salleG1;
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
        hash += (idTSI != null ? idTSI.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tsi)) {
            return false;
        }
        Tsi other = (Tsi) object;
        if ((this.idTSI == null && other.idTSI != null) || (this.idTSI != null && !this.idTSI.equals(other.idTSI))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Controller.Tsi[ idTSI=" + idTSI + " ]";
    }
    
}
