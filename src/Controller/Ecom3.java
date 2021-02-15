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
@Table(name = "ecom3")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ecom3.findAll", query = "SELECT e FROM Ecom3 e")
    , @NamedQuery(name = "Ecom3.findByIdecom3", query = "SELECT e FROM Ecom3 e WHERE e.idecom3 = :idecom3")
    , @NamedQuery(name = "Ecom3.findByJourEcom", query = "SELECT e FROM Ecom3 e WHERE e.jourEcom = :jourEcom")
    , @NamedQuery(name = "Ecom3.findByDateEcom", query = "SELECT e FROM Ecom3 e WHERE e.dateEcom = :dateEcom")
    , @NamedQuery(name = "Ecom3.findByMatieresEcom", query = "SELECT e FROM Ecom3 e WHERE e.matieresEcom = :matieresEcom")
    , @NamedQuery(name = "Ecom3.findByHoraireEcom", query = "SELECT e FROM Ecom3 e WHERE e.horaireEcom = :horaireEcom")
    , @NamedQuery(name = "Ecom3.findByDureeEcom", query = "SELECT e FROM Ecom3 e WHERE e.dureeEcom = :dureeEcom")
    , @NamedQuery(name = "Ecom3.findByGroupe1Ecom", query = "SELECT e FROM Ecom3 e WHERE e.groupe1Ecom = :groupe1Ecom")
    , @NamedQuery(name = "Ecom3.findBySalleG1Ecom", query = "SELECT e FROM Ecom3 e WHERE e.salleG1Ecom = :salleG1Ecom")
    , @NamedQuery(name = "Ecom3.findByGroupe2", query = "SELECT e FROM Ecom3 e WHERE e.groupe2 = :groupe2")
    , @NamedQuery(name = "Ecom3.findBySalleG2Ecom", query = "SELECT e FROM Ecom3 e WHERE e.salleG2Ecom = :salleG2Ecom")})
public class Ecom3 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idecom3", nullable = false)
    private Integer idecom3;
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
    @Column(name = "groupe2", nullable = false, length = 45)
    private String groupe2;
    @Basic(optional = false)
    @Column(name = "salle_g2_ecom", nullable = false, length = 45)
    private String salleG2Ecom;

    public Ecom3() {
    }

    public Ecom3(Integer idecom3) {
        this.idecom3 = idecom3;
    }

    public Ecom3(Integer idecom3, String jourEcom, String dateEcom, String matieresEcom, String horaireEcom, String dureeEcom, String groupe1Ecom, String salleG1Ecom, String groupe2, String salleG2Ecom) {
        this.idecom3 = idecom3;
        this.jourEcom = jourEcom;
        this.dateEcom = dateEcom;
        this.matieresEcom = matieresEcom;
        this.horaireEcom = horaireEcom;
        this.dureeEcom = dureeEcom;
        this.groupe1Ecom = groupe1Ecom;
        this.salleG1Ecom = salleG1Ecom;
        this.groupe2 = groupe2;
        this.salleG2Ecom = salleG2Ecom;
    }

    public Integer getIdecom3() {
        return idecom3;
    }

    public void setIdecom3(Integer idecom3) {
        this.idecom3 = idecom3;
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

    public String getGroupe2() {
        return groupe2;
    }

    public void setGroupe2(String groupe2) {
        this.groupe2 = groupe2;
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
        hash += (idecom3 != null ? idecom3.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ecom3)) {
            return false;
        }
        Ecom3 other = (Ecom3) object;
        if ((this.idecom3 == null && other.idecom3 != null) || (this.idecom3 != null && !this.idecom3.equals(other.idecom3))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Controller.Ecom3[ idecom3=" + idecom3 + " ]";
    }
    
}
