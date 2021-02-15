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
@Table(name = "wi2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wi2.findAll", query = "SELECT w FROM Wi2 w")
    , @NamedQuery(name = "Wi2.findByIdwi2", query = "SELECT w FROM Wi2 w WHERE w.idwi2 = :idwi2")
    , @NamedQuery(name = "Wi2.findByJourWi", query = "SELECT w FROM Wi2 w WHERE w.jourWi = :jourWi")
    , @NamedQuery(name = "Wi2.findByDateWi", query = "SELECT w FROM Wi2 w WHERE w.dateWi = :dateWi")
    , @NamedQuery(name = "Wi2.findByMatieresWi", query = "SELECT w FROM Wi2 w WHERE w.matieresWi = :matieresWi")
    , @NamedQuery(name = "Wi2.findByHoraireWi", query = "SELECT w FROM Wi2 w WHERE w.horaireWi = :horaireWi")
    , @NamedQuery(name = "Wi2.findByDureeWi", query = "SELECT w FROM Wi2 w WHERE w.dureeWi = :dureeWi")
    , @NamedQuery(name = "Wi2.findBySalleWi", query = "SELECT w FROM Wi2 w WHERE w.salleWi = :salleWi")})
public class Wi2 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idwi2", nullable = false)
    private Integer idwi2;
    @Basic(optional = false)
    @Column(name = "jour_wi", nullable = false, length = 45)
    private String jourWi;
    @Basic(optional = false)
    @Column(name = "date_wi", nullable = false, length = 45)
    private String dateWi;
    @Basic(optional = false)
    @Column(name = "matieres_wi", nullable = false, length = 45)
    private String matieresWi;
    @Basic(optional = false)
    @Column(name = "horaire_wi", nullable = false, length = 45)
    private String horaireWi;
    @Basic(optional = false)
    @Column(name = "duree_wi", nullable = false, length = 45)
    private String dureeWi;
    @Basic(optional = false)
    @Column(name = "salle_wi", nullable = false, length = 45)
    private String salleWi;

    public Wi2() {
    }

    public Wi2(Integer idwi2) {
        this.idwi2 = idwi2;
    }

    public Wi2(Integer idwi2, String jourWi, String dateWi, String matieresWi, String horaireWi, String dureeWi, String salleWi) {
        this.idwi2 = idwi2;
        this.jourWi = jourWi;
        this.dateWi = dateWi;
        this.matieresWi = matieresWi;
        this.horaireWi = horaireWi;
        this.dureeWi = dureeWi;
        this.salleWi = salleWi;
    }

    public Integer getIdwi2() {
        return idwi2;
    }

    public void setIdwi2(Integer idwi2) {
        this.idwi2 = idwi2;
    }

    public String getJourWi() {
        return jourWi;
    }

    public void setJourWi(String jourWi) {
        this.jourWi = jourWi;
    }

    public String getDateWi() {
        return dateWi;
    }

    public void setDateWi(String dateWi) {
        this.dateWi = dateWi;
    }

    public String getMatieresWi() {
        return matieresWi;
    }

    public void setMatieresWi(String matieresWi) {
        this.matieresWi = matieresWi;
    }

    public String getHoraireWi() {
        return horaireWi;
    }

    public void setHoraireWi(String horaireWi) {
        this.horaireWi = horaireWi;
    }

    public String getDureeWi() {
        return dureeWi;
    }

    public void setDureeWi(String dureeWi) {
        this.dureeWi = dureeWi;
    }

    public String getSalleWi() {
        return salleWi;
    }

    public void setSalleWi(String salleWi) {
        this.salleWi = salleWi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idwi2 != null ? idwi2.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wi2)) {
            return false;
        }
        Wi2 other = (Wi2) object;
        if ((this.idwi2 == null && other.idwi2 != null) || (this.idwi2 != null && !this.idwi2.equals(other.idwi2))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Controller.Wi2[ idwi2=" + idwi2 + " ]";
    }
    
}
