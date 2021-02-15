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
@Table(name = "salle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salle.findAll", query = "SELECT s FROM Salle s")
    , @NamedQuery(name = "Salle.findByIdsalle", query = "SELECT s FROM Salle s WHERE s.idsalle = :idsalle")
    , @NamedQuery(name = "Salle.findByNomSalle", query = "SELECT s FROM Salle s WHERE s.nomSalle = :nomSalle")
    , @NamedQuery(name = "Salle.findByCapacite", query = "SELECT s FROM Salle s WHERE s.capacite = :capacite")
    , @NamedQuery(name = "Salle.findByNomfac", query = "SELECT s FROM Salle s WHERE s.nomfac = :nomfac")})
public class Salle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsalle", nullable = false)
    private Integer idsalle;
    @Basic(optional = false)
    @Column(name = "nom_salle", nullable = false, length = 45)
    private String nomSalle;
    @Basic(optional = false)
    @Column(name = "capacite", nullable = false, length = 20)
    private String capacite;
    @Basic(optional = false)
    @Column(name = "nomfac", nullable = false, length = 45)
    private String nomfac;

    public Salle() {
    }

    public Salle(Integer idsalle) {
        this.idsalle = idsalle;
    }

    public Salle(Integer idsalle, String nomSalle, String capacite, String nomfac) {
        this.idsalle = idsalle;
        this.nomSalle = nomSalle;
        this.capacite = capacite;
        this.nomfac = nomfac;
    }

    public Integer getIdsalle() {
        return idsalle;
    }

    public void setIdsalle(Integer idsalle) {
        this.idsalle = idsalle;
    }

    public String getNomSalle() {
        return nomSalle;
    }

    public void setNomSalle(String nomSalle) {
        this.nomSalle = nomSalle;
    }

    public String getCapacite() {
        return capacite;
    }

    public void setCapacite(String capacite) {
        this.capacite = capacite;
    }

    public String getNomfac() {
        return nomfac;
    }

    public void setNomfac(String nomfac) {
        this.nomfac = nomfac;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsalle != null ? idsalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salle)) {
            return false;
        }
        Salle other = (Salle) object;
        if ((this.idsalle == null && other.idsalle != null) || (this.idsalle != null && !this.idsalle.equals(other.idsalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Controller.Salle[ idsalle=" + idsalle + " ]";
    }
    
}
