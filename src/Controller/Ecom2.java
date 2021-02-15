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
@Table(name = "ecom2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ecom2.findAll", query = "SELECT e FROM Ecom2 e")
    , @NamedQuery(name = "Ecom2.findByIdecom2", query = "SELECT e FROM Ecom2 e WHERE e.idecom2 = :idecom2")
    , @NamedQuery(name = "Ecom2.findByJourEcom", query = "SELECT e FROM Ecom2 e WHERE e.jourEcom = :jourEcom")
    , @NamedQuery(name = "Ecom2.findByDateEcom", query = "SELECT e FROM Ecom2 e WHERE e.dateEcom = :dateEcom")
    , @NamedQuery(name = "Ecom2.findByMatieresEcom", query = "SELECT e FROM Ecom2 e WHERE e.matieresEcom = :matieresEcom")
    , @NamedQuery(name = "Ecom2.findByHoraireEcom", query = "SELECT e FROM Ecom2 e WHERE e.horaireEcom = :horaireEcom")
    , @NamedQuery(name = "Ecom2.findByDureeEcom", query = "SELECT e FROM Ecom2 e WHERE e.dureeEcom = :dureeEcom")
    , @NamedQuery(name = "Ecom2.findByGroupe1Ecom", query = "SELECT e FROM Ecom2 e WHERE e.groupe1Ecom = :groupe1Ecom")
    , @NamedQuery(name = "Ecom2.findBySalleG1Ecom", query = "SELECT e FROM Ecom2 e WHERE e.salleG1Ecom = :salleG1Ecom")
    , @NamedQuery(name = "Ecom2.findByGroupe2Ecom", query = "SELECT e FROM Ecom2 e WHERE e.groupe2Ecom = :groupe2Ecom")
    , @NamedQuery(name = "Ecom2.findBySalleG2Ecom", query = "SELECT e FROM Ecom2 e WHERE e.salleG2Ecom = :salleG2Ecom")})
public class Ecom2 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idecom2", nullable = false)
    private Integer idecom2;
    @Basic(optional = false)
    @Column(name = "jour_ecom", nullable = false, length = 45)
    private String jourEcom;
    @Basic(optional = false)
    @Column(name = "date_ecom", nullable = false, length = 45)
    private String dateEcom;
    @Basic(optional = false)
    @Column(name = "matieres_ecom", nullable = false, length = 45)
    private String matieresEcom;
    @Basic(optional = false)
    @Column(name = "horaire_ecom", nullable = false, length = 45)
    private String horaireEcom;
    @Basic(optional = false)
    @Column(name = "duree_ecom", nullable = false, length = 45)
    private String dureeEcom;
    @Basic(optional = false)
    @Column(name = "groupe1_ecom", nullable = false, length = 45)
    private String groupe1Ecom;
    @Basic(optional = false)
    @Column(name = "salle_g1_ecom", nullable = false, length = 45)
    private String salleG1Ecom;
    @Basic(optional = false)
    @Column(name = "groupe2_ecom", nullable = false, length = 45)
    private String groupe2Ecom;
    @Basic(optional = false)
    @Column(name = "salle_g2_ecom", nullable = false, length = 45)
    private String salleG2Ecom;

    public Ecom2() {
    }

    public Ecom2(Integer idecom2) {
        this.idecom2 = idecom2;
    }

    public Ecom2(Integer idecom2, String jourEcom, String dateEcom, String matieresEcom, String horaireEcom, String dureeEcom, String groupe1Ecom, String salleG1Ecom, String groupe2Ecom, String salleG2Ecom) {
        this.idecom2 = idecom2;
        this.jourEcom = jourEcom;
        this.dateEcom = dateEcom;
        this.matieresEcom = matieresEcom;
        this.horaireEcom = horaireEcom;
        this.dureeEcom = dureeEcom;
        this.groupe1Ecom = groupe1Ecom;
        this.salleG1Ecom = salleG1Ecom;
        this.groupe2Ecom = groupe2Ecom;
        this.salleG2Ecom = salleG2Ecom;
    }

    public Integer getIdecom2() {
        return idecom2;
    }

    public void setIdecom2(Integer idecom2) {
        this.idecom2 = idecom2;
    }

    public String getJourEcom() {
        return jourEcom;
    }

    public void setJourEcom(String jourEcom) {
        this.jourEcom = jourEcom;
    }

    public String getDateEcom() {
        return dateEcom;
    }

    public void setDateEcom(String dateEcom) {
        this.dateEcom = dateEcom;
    }

    public String getMatieresEcom() {
        return matieresEcom;
    }

    public void setMatieresEcom(String matieresEcom) {
        this.matieresEcom = matieresEcom;
    }

    public String getHoraireEcom() {
        return horaireEcom;
    }

    public void setHoraireEcom(String horaireEcom) {
        this.horaireEcom = horaireEcom;
    }

    public String getDureeEcom() {
        return dureeEcom;
    }

    public void setDureeEcom(String dureeEcom) {
        this.dureeEcom = dureeEcom;
    }

    public String getGroupe1Ecom() {
        return groupe1Ecom;
    }

    public void setGroupe1Ecom(String groupe1Ecom) {
        this.groupe1Ecom = groupe1Ecom;
    }

    public String getSalleG1Ecom() {
        return salleG1Ecom;
    }

    public void setSalleG1Ecom(String salleG1Ecom) {
        this.salleG1Ecom = salleG1Ecom;
    }

    public String getGroupe2Ecom() {
        return groupe2Ecom;
    }

    public void setGroupe2Ecom(String groupe2Ecom) {
        this.groupe2Ecom = groupe2Ecom;
    }

    public String getSalleG2Ecom() {
        return salleG2Ecom;
    }

    public void setSalleG2Ecom(String salleG2Ecom) {
        this.salleG2Ecom = salleG2Ecom;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idecom2 != null ? idecom2.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ecom2)) {
            return false;
        }
        Ecom2 other = (Ecom2) object;
        if ((this.idecom2 == null && other.idecom2 != null) || (this.idecom2 != null && !this.idecom2.equals(other.idecom2))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Controller.Ecom2[ idecom2=" + idecom2 + " ]";
    }
    
}
