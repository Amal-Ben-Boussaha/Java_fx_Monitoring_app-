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
@Table(name = "mbds1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mbds1.findAll", query = "SELECT m FROM Mbds1 m")
    , @NamedQuery(name = "Mbds1.findByIdmbds1", query = "SELECT m FROM Mbds1 m WHERE m.idmbds1 = :idmbds1")
    , @NamedQuery(name = "Mbds1.findByJourMbds", query = "SELECT m FROM Mbds1 m WHERE m.jourMbds = :jourMbds")
    , @NamedQuery(name = "Mbds1.findByDateMbds", query = "SELECT m FROM Mbds1 m WHERE m.dateMbds = :dateMbds")
    , @NamedQuery(name = "Mbds1.findByMatieresMbds", query = "SELECT m FROM Mbds1 m WHERE m.matieresMbds = :matieresMbds")
    , @NamedQuery(name = "Mbds1.findByHoraireMbds", query = "SELECT m FROM Mbds1 m WHERE m.horaireMbds = :horaireMbds")
    , @NamedQuery(name = "Mbds1.findByDureeMbds", query = "SELECT m FROM Mbds1 m WHERE m.dureeMbds = :dureeMbds")
    , @NamedQuery(name = "Mbds1.findBySalleMbds", query = "SELECT m FROM Mbds1 m WHERE m.salleMbds = :salleMbds")})
public class Mbds1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmbds1", nullable = false)
    private Integer idmbds1;
    @Basic(optional = false)
    @Column(name = "jour_mbds", nullable = false, length = 45)
    private String jourMbds;
    @Basic(optional = false)
    @Column(name = "date_mbds", nullable = false, length = 45)
    private String dateMbds;
    @Basic(optional = false)
    @Column(name = "matieres_mbds", nullable = false, length = 45)
    private String matieresMbds;
    @Basic(optional = false)
    @Column(name = "horaire_mbds", nullable = false, length = 45)
    private String horaireMbds;
    @Basic(optional = false)
    @Column(name = "duree_mbds", nullable = false, length = 45)
    private String dureeMbds;
    @Basic(optional = false)
    @Column(name = "salle_mbds", nullable = false, length = 45)
    private String salleMbds;

    public Mbds1() {
    }

    public Mbds1(Integer idmbds1) {
        this.idmbds1 = idmbds1;
    }

    public Mbds1(Integer idmbds1, String jourMbds, String dateMbds, String matieresMbds, String horaireMbds, String dureeMbds, String salleMbds) {
        this.idmbds1 = idmbds1;
        this.jourMbds = jourMbds;
        this.dateMbds = dateMbds;
        this.matieresMbds = matieresMbds;
        this.horaireMbds = horaireMbds;
        this.dureeMbds = dureeMbds;
        this.salleMbds = salleMbds;
    }

    public Integer getIdmbds1() {
        return idmbds1;
    }

    public void setIdmbds1(Integer idmbds1) {
        this.idmbds1 = idmbds1;
    }

    public String getJourMbds() {
        return jourMbds;
    }

    public void setJourMbds(String jourMbds) {
        this.jourMbds = jourMbds;
    }

    public String getDateMbds() {
        return dateMbds;
    }

    public void setDateMbds(String dateMbds) {
        this.dateMbds = dateMbds;
    }

    public String getMatieresMbds() {
        return matieresMbds;
    }

    public void setMatieresMbds(String matieresMbds) {
        this.matieresMbds = matieresMbds;
    }

    public String getHoraireMbds() {
        return horaireMbds;
    }

    public void setHoraireMbds(String horaireMbds) {
        this.horaireMbds = horaireMbds;
    }

    public String getDureeMbds() {
        return dureeMbds;
    }

    public void setDureeMbds(String dureeMbds) {
        this.dureeMbds = dureeMbds;
    }

    public String getSalleMbds() {
        return salleMbds;
    }

    public void setSalleMbds(String salleMbds) {
        this.salleMbds = salleMbds;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmbds1 != null ? idmbds1.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mbds1)) {
            return false;
        }
        Mbds1 other = (Mbds1) object;
        if ((this.idmbds1 == null && other.idmbds1 != null) || (this.idmbds1 != null && !this.idmbds1.equals(other.idmbds1))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Controller.Mbds1[ idmbds1=" + idmbds1 + " ]";
    }
    
}
