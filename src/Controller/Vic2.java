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
@Table(name = "vic2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vic2.findAll", query = "SELECT v FROM Vic2 v")
    , @NamedQuery(name = "Vic2.findByIdvic2", query = "SELECT v FROM Vic2 v WHERE v.idvic2 = :idvic2")
    , @NamedQuery(name = "Vic2.findByJourVic", query = "SELECT v FROM Vic2 v WHERE v.jourVic = :jourVic")
    , @NamedQuery(name = "Vic2.findByDateVic", query = "SELECT v FROM Vic2 v WHERE v.dateVic = :dateVic")
    , @NamedQuery(name = "Vic2.findByMatieresVic", query = "SELECT v FROM Vic2 v WHERE v.matieresVic = :matieresVic")
    , @NamedQuery(name = "Vic2.findByHoraireVic", query = "SELECT v FROM Vic2 v WHERE v.horaireVic = :horaireVic")
    , @NamedQuery(name = "Vic2.findByDureeVic", query = "SELECT v FROM Vic2 v WHERE v.dureeVic = :dureeVic")
    , @NamedQuery(name = "Vic2.findBySalleVic", query = "SELECT v FROM Vic2 v WHERE v.salleVic = :salleVic")})
public class Vic2 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idvic2", nullable = false)
    private Integer idvic2;
    @Basic(optional = false)
    @Column(name = "jour_vic", nullable = false, length = 45)
    private String jourVic;
    @Basic(optional = false)
    @Column(name = "date_vic", nullable = false, length = 45)
    private String dateVic;
    @Basic(optional = false)
    @Column(name = "matieres_vic", nullable = false, length = 45)
    private String matieresVic;
    @Basic(optional = false)
    @Column(name = "horaire_vic", nullable = false, length = 45)
    private String horaireVic;
    @Basic(optional = false)
    @Column(name = "duree_vic", nullable = false, length = 45)
    private String dureeVic;
    @Basic(optional = false)
    @Column(name = "salle_vic", nullable = false, length = 45)
    private String salleVic;

    public Vic2() {
    }

    public Vic2(Integer idvic2) {
        this.idvic2 = idvic2;
    }

    public Vic2(Integer idvic2, String jourVic, String dateVic, String matieresVic, String horaireVic, String dureeVic, String salleVic) {
        this.idvic2 = idvic2;
        this.jourVic = jourVic;
        this.dateVic = dateVic;
        this.matieresVic = matieresVic;
        this.horaireVic = horaireVic;
        this.dureeVic = dureeVic;
        this.salleVic = salleVic;
    }

    public Integer getIdvic2() {
        return idvic2;
    }

    public void setIdvic2(Integer idvic2) {
        this.idvic2 = idvic2;
    }

    public String getJourVic() {
        return jourVic;
    }

    public void setJourVic(String jourVic) {
        this.jourVic = jourVic;
    }

    public String getDateVic() {
        return dateVic;
    }

    public void setDateVic(String dateVic) {
        this.dateVic = dateVic;
    }

    public String getMatieresVic() {
        return matieresVic;
    }

    public void setMatieresVic(String matieresVic) {
        this.matieresVic = matieresVic;
    }

    public String getHoraireVic() {
        return horaireVic;
    }

    public void setHoraireVic(String horaireVic) {
        this.horaireVic = horaireVic;
    }

    public String getDureeVic() {
        return dureeVic;
    }

    public void setDureeVic(String dureeVic) {
        this.dureeVic = dureeVic;
    }

    public String getSalleVic() {
        return salleVic;
    }

    public void setSalleVic(String salleVic) {
        this.salleVic = salleVic;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvic2 != null ? idvic2.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vic2)) {
            return false;
        }
        Vic2 other = (Vic2) object;
        if ((this.idvic2 == null && other.idvic2 != null) || (this.idvic2 != null && !this.idvic2.equals(other.idvic2))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Controller.Vic2[ idvic2=" + idvic2 + " ]";
    }
    
}
