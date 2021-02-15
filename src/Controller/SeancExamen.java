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
@Table(name = "seanc_examen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeancExamen.findAll", query = "SELECT s FROM SeancExamen s")
    , @NamedQuery(name = "SeancExamen.findByIdseance", query = "SELECT s FROM SeancExamen s WHERE s.idseance = :idseance")
    , @NamedQuery(name = "SeancExamen.findByNomseance", query = "SELECT s FROM SeancExamen s WHERE s.nomseance = :nomseance")
    , @NamedQuery(name = "SeancExamen.findByHoraireseance", query = "SELECT s FROM SeancExamen s WHERE s.horaireseance = :horaireseance")})
public class SeancExamen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idseance", nullable = false)
    private Integer idseance;
    @Basic(optional = false)
    @Column(name = "nomseance", nullable = false, length = 45)
    private String nomseance;
    @Basic(optional = false)
    @Column(name = "horaireseance", nullable = false, length = 45)
    private String horaireseance;

    public SeancExamen() {
    }

    public SeancExamen(Integer idseance) {
        this.idseance = idseance;
    }

    public SeancExamen(Integer idseance, String nomseance, String horaireseance) {
        this.idseance = idseance;
        this.nomseance = nomseance;
        this.horaireseance = horaireseance;
    }

    public Integer getIdseance() {
        return idseance;
    }

    public void setIdseance(Integer idseance) {
        this.idseance = idseance;
    }

    public String getNomseance() {
        return nomseance;
    }

    public void setNomseance(String nomseance) {
        this.nomseance = nomseance;
    }

    public String getHoraireseance() {
        return horaireseance;
    }

    public void setHoraireseance(String horaireseance) {
        this.horaireseance = horaireseance;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idseance != null ? idseance.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeancExamen)) {
            return false;
        }
        SeancExamen other = (SeancExamen) object;
        if ((this.idseance == null && other.idseance != null) || (this.idseance != null && !this.idseance.equals(other.idseance))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Controller.SeancExamen[ idseance=" + idseance + " ]";
    }
    
}
