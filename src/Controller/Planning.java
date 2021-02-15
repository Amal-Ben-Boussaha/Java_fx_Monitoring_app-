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
@Table(name = "planning")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Planning.findAll", query = "SELECT p FROM Planning p")
    , @NamedQuery(name = "Planning.findByIdP", query = "SELECT p FROM Planning p WHERE p.idP = :idP")
    , @NamedQuery(name = "Planning.findByNomcomplt", query = "SELECT p FROM Planning p WHERE p.nomcomplt = :nomcomplt")
    , @NamedQuery(name = "Planning.findByJ1s1", query = "SELECT p FROM Planning p WHERE p.j1s1 = :j1s1")
    , @NamedQuery(name = "Planning.findByJ1s2", query = "SELECT p FROM Planning p WHERE p.j1s2 = :j1s2")
    , @NamedQuery(name = "Planning.findByJ1s3", query = "SELECT p FROM Planning p WHERE p.j1s3 = :j1s3")
    , @NamedQuery(name = "Planning.findByJ2s1", query = "SELECT p FROM Planning p WHERE p.j2s1 = :j2s1")
    , @NamedQuery(name = "Planning.findByJ2s2", query = "SELECT p FROM Planning p WHERE p.j2s2 = :j2s2")
    , @NamedQuery(name = "Planning.findByJ2s3", query = "SELECT p FROM Planning p WHERE p.j2s3 = :j2s3")
    , @NamedQuery(name = "Planning.findByJ3s1", query = "SELECT p FROM Planning p WHERE p.j3s1 = :j3s1")
    , @NamedQuery(name = "Planning.findByJ3s2", query = "SELECT p FROM Planning p WHERE p.j3s2 = :j3s2")
    , @NamedQuery(name = "Planning.findByJ3s3", query = "SELECT p FROM Planning p WHERE p.j3s3 = :j3s3")
    , @NamedQuery(name = "Planning.findByJ4s1", query = "SELECT p FROM Planning p WHERE p.j4s1 = :j4s1")
    , @NamedQuery(name = "Planning.findByJ4s2", query = "SELECT p FROM Planning p WHERE p.j4s2 = :j4s2")
    , @NamedQuery(name = "Planning.findByJ4s3", query = "SELECT p FROM Planning p WHERE p.j4s3 = :j4s3")
    , @NamedQuery(name = "Planning.findByJ5s1", query = "SELECT p FROM Planning p WHERE p.j5s1 = :j5s1")
    , @NamedQuery(name = "Planning.findByJ5s2", query = "SELECT p FROM Planning p WHERE p.j5s2 = :j5s2")
    , @NamedQuery(name = "Planning.findByJ5s3", query = "SELECT p FROM Planning p WHERE p.j5s3 = :j5s3")
    , @NamedQuery(name = "Planning.findByJ6s1", query = "SELECT p FROM Planning p WHERE p.j6s1 = :j6s1")
    , @NamedQuery(name = "Planning.findByJ6s2", query = "SELECT p FROM Planning p WHERE p.j6s2 = :j6s2")
    , @NamedQuery(name = "Planning.findByJ6s3", query = "SELECT p FROM Planning p WHERE p.j6s3 = :j6s3")
    , @NamedQuery(name = "Planning.findByJ7s1", query = "SELECT p FROM Planning p WHERE p.j7s1 = :j7s1")
    , @NamedQuery(name = "Planning.findByJ7s2", query = "SELECT p FROM Planning p WHERE p.j7s2 = :j7s2")
    , @NamedQuery(name = "Planning.findByJ7s3", query = "SELECT p FROM Planning p WHERE p.j7s3 = :j7s3")
    , @NamedQuery(name = "Planning.findByJ8s1", query = "SELECT p FROM Planning p WHERE p.j8s1 = :j8s1")
    , @NamedQuery(name = "Planning.findByJ8s2", query = "SELECT p FROM Planning p WHERE p.j8s2 = :j8s2")
    , @NamedQuery(name = "Planning.findByJ8s3", query = "SELECT p FROM Planning p WHERE p.j8s3 = :j8s3")
    , @NamedQuery(name = "Planning.findByJ9s1", query = "SELECT p FROM Planning p WHERE p.j9s1 = :j9s1")
    , @NamedQuery(name = "Planning.findByJ9s2", query = "SELECT p FROM Planning p WHERE p.j9s2 = :j9s2")
    , @NamedQuery(name = "Planning.findByJ9s3", query = "SELECT p FROM Planning p WHERE p.j9s3 = :j9s3")
    , @NamedQuery(name = "Planning.findByJ10s1", query = "SELECT p FROM Planning p WHERE p.j10s1 = :j10s1")
    , @NamedQuery(name = "Planning.findByJ10s2", query = "SELECT p FROM Planning p WHERE p.j10s2 = :j10s2")
    , @NamedQuery(name = "Planning.findByJ10s3", query = "SELECT p FROM Planning p WHERE p.j10s3 = :j10s3")
    , @NamedQuery(name = "Planning.findByNbre", query = "SELECT p FROM Planning p WHERE p.nbre = :nbre")})
public class Planning implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idP", nullable = false)
    private Integer idP;
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
    @Column(name = "j2s1", nullable = false, length = 45)
    private String j2s1;
    @Basic(optional = false)
    @Column(name = "j2s2", nullable = false, length = 45)
    private String j2s2;
    @Basic(optional = false)
    @Column(name = "j2s3", nullable = false, length = 45)
    private String j2s3;
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
    @Column(name = "j4s1", nullable = false, length = 45)
    private String j4s1;
    @Basic(optional = false)
    @Column(name = "j4s2", nullable = false, length = 45)
    private String j4s2;
    @Basic(optional = false)
    @Column(name = "j4s3", nullable = false, length = 45)
    private String j4s3;
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
    @Column(name = "j6s1", nullable = false, length = 45)
    private String j6s1;
    @Basic(optional = false)
    @Column(name = "j6s2", nullable = false, length = 45)
    private String j6s2;
    @Basic(optional = false)
    @Column(name = "j6s3", nullable = false, length = 45)
    private String j6s3;
    @Basic(optional = false)
    @Column(name = "j7s1", nullable = false, length = 45)
    private String j7s1;
    @Basic(optional = false)
    @Column(name = "j7s2", nullable = false, length = 45)
    private String j7s2;
    @Basic(optional = false)
    @Column(name = "j7s3", nullable = false, length = 45)
    private String j7s3;
    @Basic(optional = false)
    @Column(name = "j8s1", nullable = false, length = 45)
    private String j8s1;
    @Basic(optional = false)
    @Column(name = "j8s2", nullable = false, length = 45)
    private String j8s2;
    @Basic(optional = false)
    @Column(name = "j8s3", nullable = false, length = 45)
    private String j8s3;
    @Basic(optional = false)
    @Column(name = "j9s1", nullable = false, length = 45)
    private String j9s1;
    @Basic(optional = false)
    @Column(name = "j9s2", nullable = false, length = 45)
    private String j9s2;
    @Basic(optional = false)
    @Column(name = "j9s3", nullable = false, length = 45)
    private String j9s3;
    @Basic(optional = false)
    @Column(name = "j10s1", nullable = false, length = 45)
    private String j10s1;
    @Basic(optional = false)
    @Column(name = "j10s2", nullable = false, length = 45)
    private String j10s2;
    @Basic(optional = false)
    @Column(name = "j10s3", nullable = false, length = 45)
    private String j10s3;
    @Basic(optional = false)
    @Column(name = "nbre", nullable = false, length = 45)
    private String nbre;

    public Planning() {
    }

    public Planning(Integer idP) {
        this.idP = idP;
    }

    public Planning(Integer idP, String nomcomplt, String j1s1, String j1s2, String j1s3, String j2s1, String j2s2, String j2s3, String j3s1, String j3s2, String j3s3, String j4s1, String j4s2, String j4s3, String j5s1, String j5s2, String j5s3, String j6s1, String j6s2, String j6s3, String j7s1, String j7s2, String j7s3, String j8s1, String j8s2, String j8s3, String j9s1, String j9s2, String j9s3, String j10s1, String j10s2, String j10s3, String nbre) {
        this.idP = idP;
        this.nomcomplt = nomcomplt;
        this.j1s1 = j1s1;
        this.j1s2 = j1s2;
        this.j1s3 = j1s3;
        this.j2s1 = j2s1;
        this.j2s2 = j2s2;
        this.j2s3 = j2s3;
        this.j3s1 = j3s1;
        this.j3s2 = j3s2;
        this.j3s3 = j3s3;
        this.j4s1 = j4s1;
        this.j4s2 = j4s2;
        this.j4s3 = j4s3;
        this.j5s1 = j5s1;
        this.j5s2 = j5s2;
        this.j5s3 = j5s3;
        this.j6s1 = j6s1;
        this.j6s2 = j6s2;
        this.j6s3 = j6s3;
        this.j7s1 = j7s1;
        this.j7s2 = j7s2;
        this.j7s3 = j7s3;
        this.j8s1 = j8s1;
        this.j8s2 = j8s2;
        this.j8s3 = j8s3;
        this.j9s1 = j9s1;
        this.j9s2 = j9s2;
        this.j9s3 = j9s3;
        this.j10s1 = j10s1;
        this.j10s2 = j10s2;
        this.j10s3 = j10s3;
        this.nbre = nbre;
    }

    public Integer getIdP() {
        return idP;
    }

    public void setIdP(Integer idP) {
        this.idP = idP;
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

    public String getJ7s1() {
        return j7s1;
    }

    public void setJ7s1(String j7s1) {
        this.j7s1 = j7s1;
    }

    public String getJ7s2() {
        return j7s2;
    }

    public void setJ7s2(String j7s2) {
        this.j7s2 = j7s2;
    }

    public String getJ7s3() {
        return j7s3;
    }

    public void setJ7s3(String j7s3) {
        this.j7s3 = j7s3;
    }

    public String getJ8s1() {
        return j8s1;
    }

    public void setJ8s1(String j8s1) {
        this.j8s1 = j8s1;
    }

    public String getJ8s2() {
        return j8s2;
    }

    public void setJ8s2(String j8s2) {
        this.j8s2 = j8s2;
    }

    public String getJ8s3() {
        return j8s3;
    }

    public void setJ8s3(String j8s3) {
        this.j8s3 = j8s3;
    }

    public String getJ9s1() {
        return j9s1;
    }

    public void setJ9s1(String j9s1) {
        this.j9s1 = j9s1;
    }

    public String getJ9s2() {
        return j9s2;
    }

    public void setJ9s2(String j9s2) {
        this.j9s2 = j9s2;
    }

    public String getJ9s3() {
        return j9s3;
    }

    public void setJ9s3(String j9s3) {
        this.j9s3 = j9s3;
    }

    public String getJ10s1() {
        return j10s1;
    }

    public void setJ10s1(String j10s1) {
        this.j10s1 = j10s1;
    }

    public String getJ10s2() {
        return j10s2;
    }

    public void setJ10s2(String j10s2) {
        this.j10s2 = j10s2;
    }

    public String getJ10s3() {
        return j10s3;
    }

    public void setJ10s3(String j10s3) {
        this.j10s3 = j10s3;
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
        hash += (idP != null ? idP.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Planning)) {
            return false;
        }
        Planning other = (Planning) object;
        if ((this.idP == null && other.idP != null) || (this.idP != null && !this.idP.equals(other.idP))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Controller.Planning[ idP=" + idP + " ]";
    }
    
}
