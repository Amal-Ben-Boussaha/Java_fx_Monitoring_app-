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
@Table(name = "mati")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mati.findAll", query = "SELECT m FROM Mati m")
    , @NamedQuery(name = "Mati.findByIdM", query = "SELECT m FROM Mati m WHERE m.idM = :idM")
    , @NamedQuery(name = "Mati.findByClasse", query = "SELECT m FROM Mati m WHERE m.classe = :classe")
    , @NamedQuery(name = "Mati.findByExamen", query = "SELECT m FROM Mati m WHERE m.examen = :examen")})
public class Mati implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idM", nullable = false)
    private Integer idM;
    @Basic(optional = false)
    @Column(name = "classe", nullable = false, length = 45)
    private String classe;
    @Basic(optional = false)
    @Column(name = "examen", nullable = false, length = 100)
    private String examen;

    public Mati() {
    }

    public Mati(Integer idM) {
        this.idM = idM;
    }

    public Mati(Integer idM, String classe, String examen) {
        this.idM = idM;
        this.classe = classe;
        this.examen = examen;
    }

    public Integer getIdM() {
        return idM;
    }

    public void setIdM(Integer idM) {
        this.idM = idM;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getExamen() {
        return examen;
    }

    public void setExamen(String examen) {
        this.examen = examen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idM != null ? idM.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mati)) {
            return false;
        }
        Mati other = (Mati) object;
        if ((this.idM == null && other.idM != null) || (this.idM != null && !this.idM.equals(other.idM))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Controller.Mati[ idM=" + idM + " ]";
    }
    
}
