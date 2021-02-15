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
@Table(name = "actitvite")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actitvite.findAll", query = "SELECT a FROM Actitvite a")
    , @NamedQuery(name = "Actitvite.findById", query = "SELECT a FROM Actitvite a WHERE a.id = :id")
    , @NamedQuery(name = "Actitvite.findByApprenant", query = "SELECT a FROM Actitvite a WHERE a.apprenant = :apprenant")
    , @NamedQuery(name = "Actitvite.findByMatere", query = "SELECT a FROM Actitvite a WHERE a.matere = :matere")
    , @NamedQuery(name = "Actitvite.findByProf", query = "SELECT a FROM Actitvite a WHERE a.prof = :prof")
    , @NamedQuery(name = "Actitvite.findByDuree", query = "SELECT a FROM Actitvite a WHERE a.duree = :duree")})
public class Actitvite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "apprenant", nullable = false, length = 45)
    private String apprenant;
    @Basic(optional = false)
    @Column(name = "matere", nullable = false, length = 45)
    private String matere;
    @Basic(optional = false)
    @Column(name = "prof", nullable = false, length = 45)
    private String prof;
    @Basic(optional = false)
    @Column(name = "duree", nullable = false, length = 45)
    private String duree;

    public Actitvite() {
    }

    public Actitvite(Integer id) {
        this.id = id;
    }

    public Actitvite(Integer id, String apprenant, String matere, String prof, String duree) {
        this.id = id;
        this.apprenant = apprenant;
        this.matere = matere;
        this.prof = prof;
        this.duree = duree;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApprenant() {
        return apprenant;
    }

    public void setApprenant(String apprenant) {
        this.apprenant = apprenant;
    }

    public String getMatere() {
        return matere;
    }

    public void setMatere(String matere) {
        this.matere = matere;
    }

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actitvite)) {
            return false;
        }
        Actitvite other = (Actitvite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ESEN.Actitvite[ id=" + id + " ]";
    }
    
}
