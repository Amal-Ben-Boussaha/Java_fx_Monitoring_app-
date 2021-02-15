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
@Table(name = "planningds")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Planningds.findAll", query = "SELECT p FROM Planningds p")
    , @NamedQuery(name = "Planningds.findByIdPlanningDS", query = "SELECT p FROM Planningds p WHERE p.idPlanningDS = :idPlanningDS")
    , @NamedQuery(name = "Planningds.findByNomcomplt", query = "SELECT p FROM Planningds p WHERE p.nomcomplt = :nomcomplt")
    , @NamedQuery(name = "Planningds.findByJ1s1", query = "SELECT p FROM Planningds p WHERE p.j1s1 = :j1s1")
    , @NamedQuery(name = "Planningds.findByJ1s2", query = "SELECT p FROM Planningds p WHERE p.j1s2 = :j1s2")
    , @NamedQuery(name = "Planningds.findByJ1s3", query = "SELECT p FROM Planningds p WHERE p.j1s3 = :j1s3")
    , @NamedQuery(name = "Planningds.findByJ1s4", query = "SELECT p FROM Planningds p WHERE p.j1s4 = :j1s4")
    , @NamedQuery(name = "Planningds.findByJ2s1", query = "SELECT p FROM Planningds p WHERE p.j2s1 = :j2s1")
    , @NamedQuery(name = "Planningds.findByJ2s2", query = "SELECT p FROM Planningds p WHERE p.j2s2 = :j2s2")
    , @NamedQuery(name = "Planningds.findByJ2s3", query = "SELECT p FROM Planningds p WHERE p.j2s3 = :j2s3")
    , @NamedQuery(name = "Planningds.findByJ2s4", query = "SELECT p FROM Planningds p WHERE p.j2s4 = :j2s4")
    , @NamedQuery(name = "Planningds.findByJ3s1", query = "SELECT p FROM Planningds p WHERE p.j3s1 = :j3s1")
    , @NamedQuery(name = "Planningds.findByJ3s2", query = "SELECT p FROM Planningds p WHERE p.j3s2 = :j3s2")
    , @NamedQuery(name = "Planningds.findByJ3s3", query = "SELECT p FROM Planningds p WHERE p.j3s3 = :j3s3")
    , @NamedQuery(name = "Planningds.findByJ3s4", query = "SELECT p FROM Planningds p WHERE p.j3s4 = :j3s4")
    , @NamedQuery(name = "Planningds.findByJ4s1", query = "SELECT p FROM Planningds p WHERE p.j4s1 = :j4s1")
    , @NamedQuery(name = "Planningds.findByJ4s2", query = "SELECT p FROM Planningds p WHERE p.j4s2 = :j4s2")
    , @NamedQuery(name = "Planningds.findByJ4s3", query = "SELECT p FROM Planningds p WHERE p.j4s3 = :j4s3")
    , @NamedQuery(name = "Planningds.findByJ4s4", query = "SELECT p FROM Planningds p WHERE p.j4s4 = :j4s4")
    , @NamedQuery(name = "Planningds.findByJ5s1", query = "SELECT p FROM Planningds p WHERE p.j5s1 = :j5s1")
    , @NamedQuery(name = "Planningds.findByJ5s2", query = "SELECT p FROM Planningds p WHERE p.j5s2 = :j5s2")
    , @NamedQuery(name = "Planningds.findByJ5s3", query = "SELECT p FROM Planningds p WHERE p.j5s3 = :j5s3")
    , @NamedQuery(name = "Planningds.findByJ5s4", query = "SELECT p FROM Planningds p WHERE p.j5s4 = :j5s4")
    , @NamedQuery(name = "Planningds.findByJ6s1", query = "SELECT p FROM Planningds p WHERE p.j6s1 = :j6s1")
    , @NamedQuery(name = "Planningds.findByJ6s2", query = "SELECT p FROM Planningds p WHERE p.j6s2 = :j6s2")
    , @NamedQuery(name = "Planningds.findByJ6s3", query = "SELECT p FROM Planningds p WHERE p.j6s3 = :j6s3")
    , @NamedQuery(name = "Planningds.findByJ6s4", query = "SELECT p FROM Planningds p WHERE p.j6s4 = :j6s4")
    , @NamedQuery(name = "Planningds.findByNbre", query = "SELECT p FROM Planningds p WHERE p.nbre = :nbre")})
public class Planningds implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPlanningDS", nullable = false)
    private Integer idPlanningDS;
    @Basic(optional = false)
    @Column(name = "nomcomplt", nullable = false, length = 45)
    private String nomcomplt;
    @Basic(optional = false)
    @Column(name = "j1s1", nullable = false, length = 45)
    private String j1s1;
    @Basic(optional = false)
    @Column(name = "j1s2", nullable = false, length = 45)
    private String j1s2;
    @Basic(optional = false)
    @Column(name = "j1s3", nullable = false, length = 45)
    private String j1s3;
    @Basic(optional = false)
    @Column(name = "j1s4", nullable = false, length = 45)
    private String j1s4;
    @Basic(optional = false)
    @Column(name = "j2s1", nullable = false, length = 45)
    private String j2s1;
    @Basic(optional = false)
    @Column(name = "j2s2", nullable = false, length = 45)
    private String j2s2;
    @Basic(optional = false)
    @Column(name = "j2s3", nullable = false, length = 45)
    private String j2s3;
    @Basic(optional = false)
    @Column(name = "j2s4", nullable = false, length = 45)
    private String j2s4;
    @Basic(optional = false)
    @Column(name = "j3s1", nullable = false, length = 45)
    private String j3s1;
    @Basic(optional = false)
    @Column(name = "j3s2", nullable = false, length = 45)
    private String j3s2;
    @Basic(optional = false)
    @Column(name = "j3s3", nullable = false, length = 45)
    private String j3s3;
    @Basic(optional = false)
    @Column(name = "j3s4", nullable = false, length = 45)
    private String j3s4;
    @Basic(optional = false)
    @Column(name = "j4s1", nullable = false, length = 45)
    private String j4s1;
    @Basic(optional = false)
    @Column(name = "j4s2", nullable = false, length = 45)
    private String j4s2;
    @Basic(optional = false)
    @Column(name = "j4s3", nullable = false, length = 45)
    private String j4s3;
    @Basic(optional = false)
    @Column(name = "j4s4", nullable = false, length = 45)
    private String j4s4;
    @Basic(optional = false)
    @Column(name = "j5s1", nullable = false, length = 45)
    private String j5s1;
    @Basic(optional = false)
    @Column(name = "j5s2", nullable = false, length = 45)
    private String j5s2;
    @Basic(optional = false)
    @Column(name = "j5s3", nullable = false, length = 45)
    private String j5s3;
    @Basic(optional = false)
    @Column(name = "j5s4", nullable = false, length = 45)
    private String j5s4;
    @Basic(optional = false)
    @Column(name = "j6s1", nullable = false, length = 45)
    private String j6s1;
    @Basic(optional = false)
    @Column(name = "j6s2", nullable = false, length = 45)
    private String j6s2;
    @Basic(optional = false)
    @Column(name = "j6s3", nullable = false, length = 45)
    private String j6s3;
    @Basic(optional = false)
    @Column(name = "j6s4", nullable = false, length = 45)
    private String j6s4;
    @Basic(optional = false)
    @Column(name = "nbre", nullable = false, length = 45)
    private String nbre;

    public Planningds() {
    }

    public Planningds(Integer idPlanningDS) {
        this.idPlanningDS = idPlanningDS;
    }

    public Planningds(Integer idPlanningDS, String nomcomplt, String j1s1, String j1s2, String j1s3, String j1s4, String j2s1, String j2s2, String j2s3, String j2s4, String j3s1, String j3s2, String j3s3, String j3s4, String j4s1, String j4s2, String j4s3, String j4s4, String j5s1, String j5s2, String j5s3, String j5s4, String j6s1, String j6s2, String j6s3, String j6s4, String nbre) {
        this.idPlanningDS = idPlanningDS;
        this.nomcomplt = nomcomplt;
        this.j1s1 = j1s1;
        this.j1s2 = j1s2;
        this.j1s3 = j1s3;
        this.j1s4 = j1s4;
        this.j2s1 = j2s1;
        this.j2s2 = j2s2;
        this.j2s3 = j2s3;
        this.j2s4 = j2s4;
        this.j3s1 = j3s1;
        this.j3s2 = j3s2;
        this.j3s3 = j3s3;
        this.j3s4 = j3s4;
        this.j4s1 = j4s1;
        this.j4s2 = j4s2;
        this.j4s3 = j4s3;
        this.j4s4 = j4s4;
        this.j5s1 = j5s1;
        this.j5s2 = j5s2;
        this.j5s3 = j5s3;
        this.j5s4 = j5s4;
        this.j6s1 = j6s1;
        this.j6s2 = j6s2;
        this.j6s3 = j6s3;
        this.j6s4 = j6s4;
        this.nbre = nbre;
    }

    public Integer getIdPlanningDS() {
        return idPlanningDS;
    }

    public void setIdPlanningDS(Integer idPlanningDS) {
        this.idPlanningDS = idPlanningDS;
    }

    public String getNomcomplt() {
        return nomcomplt;
    }

    public void setNomcomplt(String nomcomplt) {
        this.nomcomplt = nomcomplt;
    }

    public String getJ1s1() {
        return j1s1;
    }

    public void setJ1s1(String j1s1) {
        this.j1s1 = j1s1;
    }

    public String getJ1s2() {
        return j1s2;
    }

    public void setJ1s2(String j1s2) {
        this.j1s2 = j1s2;
    }

    public String getJ1s3() {
        return j1s3;
    }

    public void setJ1s3(String j1s3) {
        this.j1s3 = j1s3;
    }

    public String getJ1s4() {
        return j1s4;
    }

    public void setJ1s4(String j1s4) {
        this.j1s4 = j1s4;
    }

    public String getJ2s1() {
        return j2s1;
    }

    public void setJ2s1(String j2s1) {
        this.j2s1 = j2s1;
    }

    public String getJ2s2() {
        return j2s2;
    }

    public void setJ2s2(String j2s2) {
        this.j2s2 = j2s2;
    }

    public String getJ2s3() {
        return j2s3;
    }

    public void setJ2s3(String j2s3) {
        this.j2s3 = j2s3;
    }

    public String getJ2s4() {
        return j2s4;
    }

    public void setJ2s4(String j2s4) {
        this.j2s4 = j2s4;
    }

    public String getJ3s1() {
        return j3s1;
    }

    public void setJ3s1(String j3s1) {
        this.j3s1 = j3s1;
    }

    public String getJ3s2() {
        return j3s2;
    }

    public void setJ3s2(String j3s2) {
        this.j3s2 = j3s2;
    }

    public String getJ3s3() {
        return j3s3;
    }

    public void setJ3s3(String j3s3) {
        this.j3s3 = j3s3;
    }

    public String getJ3s4() {
        return j3s4;
    }

    public void setJ3s4(String j3s4) {
        this.j3s4 = j3s4;
    }

    public String getJ4s1() {
        return j4s1;
    }

    public void setJ4s1(String j4s1) {
        this.j4s1 = j4s1;
    }

    public String getJ4s2() {
        return j4s2;
    }

    public void setJ4s2(String j4s2) {
        this.j4s2 = j4s2;
    }

    public String getJ4s3() {
        return j4s3;
    }

    public void setJ4s3(String j4s3) {
        this.j4s3 = j4s3;
    }

    public String getJ4s4() {
        return j4s4;
    }

    public void setJ4s4(String j4s4) {
        this.j4s4 = j4s4;
    }

    public String getJ5s1() {
        return j5s1;
    }

    public void setJ5s1(String j5s1) {
        this.j5s1 = j5s1;
    }

    public String getJ5s2() {
        return j5s2;
    }

    public void setJ5s2(String j5s2) {
        this.j5s2 = j5s2;
    }

    public String getJ5s3() {
        return j5s3;
    }

    public void setJ5s3(String j5s3) {
        this.j5s3 = j5s3;
    }

    public String getJ5s4() {
        return j5s4;
    }

    public void setJ5s4(String j5s4) {
        this.j5s4 = j5s4;
    }

    public String getJ6s1() {
        return j6s1;
    }

    public void setJ6s1(String j6s1) {
        this.j6s1 = j6s1;
    }

    public String getJ6s2() {
        return j6s2;
    }

    public void setJ6s2(String j6s2) {
        this.j6s2 = j6s2;
    }

    public String getJ6s3() {
        return j6s3;
    }

    public void setJ6s3(String j6s3) {
        this.j6s3 = j6s3;
    }

    public String getJ6s4() {
        return j6s4;
    }

    public void setJ6s4(String j6s4) {
        this.j6s4 = j6s4;
    }

    public String getNbre() {
        return nbre;
    }

    public void setNbre(String nbre) {
        this.nbre = nbre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlanningDS != null ? idPlanningDS.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Planningds)) {
            return false;
        }
        Planningds other = (Planningds) object;
        if ((this.idPlanningDS == null && other.idPlanningDS != null) || (this.idPlanningDS != null && !this.idPlanningDS.equals(other.idPlanningDS))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Controller.Planningds[ idPlanningDS=" + idPlanningDS + " ]";
    }
    
}
