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
@Table(name = "grade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grade.findAll", query = "SELECT g FROM Grade g")
    , @NamedQuery(name = "Grade.findByIdgrade", query = "SELECT g FROM Grade g WHERE g.idgrade = :idgrade")
    , @NamedQuery(name = "Grade.findByNomgrade", query = "SELECT g FROM Grade g WHERE g.nomgrade = :nomgrade")
    , @NamedQuery(name = "Grade.findByNbseancemax", query = "SELECT g FROM Grade g WHERE g.nbseancemax = :nbseancemax")
    , @NamedQuery(name = "Grade.findByNbseancemin", query = "SELECT g FROM Grade g WHERE g.nbseancemin = :nbseancemin")})
public class Grade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idgrade", nullable = false)
    private Integer idgrade;
    @Basic(optional = false)
    @Column(name = "nomgrade", nullable = false, length = 45)
    private String nomgrade;
    @Basic(optional = false)
    @Column(name = "nbseancemax", nullable = false, length = 45)
    private String nbseancemax;
    @Basic(optional = false)
    @Column(name = "nbseancemin", nullable = false, length = 45)
    private String nbseancemin;

    public Grade() {
    }

    public Grade(Integer idgrade) {
        this.idgrade = idgrade;
    }

    public Grade(Integer idgrade, String nomgrade, String nbseancemax, String nbseancemin) {
        this.idgrade = idgrade;
        this.nomgrade = nomgrade;
        this.nbseancemax = nbseancemax;
        this.nbseancemin = nbseancemin;
    }

    public Integer getIdgrade() {
        return idgrade;
    }

    public void setIdgrade(Integer idgrade) {
        this.idgrade = idgrade;
    }

    public String getNomgrade() {
        return nomgrade;
    }

    public void setNomgrade(String nomgrade) {
        this.nomgrade = nomgrade;
    }

    public String getNbseancemax() {
        return nbseancemax;
    }

    public void setNbseancemax(String nbseancemax) {
        this.nbseancemax = nbseancemax;
    }

    public String getNbseancemin() {
        return nbseancemin;
    }

    public void setNbseancemin(String nbseancemin) {
        this.nbseancemin = nbseancemin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgrade != null ? idgrade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grade)) {
            return false;
        }
        Grade other = (Grade) object;
        if ((this.idgrade == null && other.idgrade != null) || (this.idgrade != null && !this.idgrade.equals(other.idgrade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Controller.Grade[ idgrade=" + idgrade + " ]";
    }
    
}
