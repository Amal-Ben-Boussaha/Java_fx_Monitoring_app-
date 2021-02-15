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
@Table(name = "planningsc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Planningsc.findAll", query = "SELECT p FROM Planningsc p")
    , @NamedQuery(name = "Planningsc.findByIdPlanningSC", query = "SELECT p FROM Planningsc p WHERE p.idPlanningSC = :idPlanningSC")
    , @NamedQuery(name = "Planningsc.findByNomcomplt", query = "SELECT p FROM Planningsc p WHERE p.nomcomplt = :nomcomplt")
    , @NamedQuery(name = "Planningsc.findByJ1s1", query = "SELECT p FROM Planningsc p WHERE p.j1s1 = :j1s1")
    , @NamedQuery(name = "Planningsc.findByJ1s2", query = "SELECT p FROM Planningsc p WHERE p.j1s2 = :j1s2")
    , @NamedQuery(name = "Planningsc.findByJ2s1", query = "SELECT p FROM Planningsc p WHERE p.j2s1 = :j2s1")
    , @NamedQuery(name = "Planningsc.findByJ2s2", query = "SELECT p FROM Planningsc p WHERE p.j2s2 = :j2s2")
    , @NamedQuery(name = "Planningsc.findByJ3s1", query = "SELECT p FROM Planningsc p WHERE p.j3s1 = :j3s1")
    , @NamedQuery(name = "Planningsc.findByJ3s2", query = "SELECT p FROM Planningsc p WHERE p.j3s2 = :j3s2")
    , @NamedQuery(name = "Planningsc.findByJ4s1", query = "SELECT p FROM Planningsc p WHERE p.j4s1 = :j4s1")
    , @NamedQuery(name = "Planningsc.findByJ4s2", query = "SELECT p FROM Planningsc p WHERE p.j4s2 = :j4s2")
    , @NamedQuery(name = "Planningsc.findByJ5s1", query = "SELECT p FROM Planningsc p WHERE p.j5s1 = :j5s1")
    , @NamedQuery(name = "Planningsc.findByJ5s2", query = "SELECT p FROM Planningsc p WHERE p.j5s2 = :j5s2")
    , @NamedQuery(name = "Planningsc.findByJ6s1", query = "SELECT p FROM Planningsc p WHERE p.j6s1 = :j6s1")
    , @NamedQuery(name = "Planningsc.findByJ6s2", query = "SELECT p FROM Planningsc p WHERE p.j6s2 = :j6s2")
    , @NamedQuery(name = "Planningsc.findByJ7s1", query = "SELECT p FROM Planningsc p WHERE p.j7s1 = :j7s1")
    , @NamedQuery(name = "Planningsc.findByJ7s2", query = "SELECT p FROM Planningsc p WHERE p.j7s2 = :j7s2")
    , @NamedQuery(name = "Planningsc.findByJ8s1", query = "SELECT p FROM Planningsc p WHERE p.j8s1 = :j8s1")
    , @NamedQuery(name = "Planningsc.findByJ8s2", query = "SELECT p FROM Planningsc p WHERE p.j8s2 = :j8s2")
    , @NamedQuery(name = "Planningsc.findByJ9s1", query = "SELECT p FROM Planningsc p WHERE p.j9s1 = :j9s1")
    , @NamedQuery(name = "Planningsc.findByJ9s2", query = "SELECT p FROM Planningsc p WHERE p.j9s2 = :j9s2")
    , @NamedQuery(name = "Planningsc.findByJ10s1", query = "SELECT p FROM Planningsc p WHERE p.j10s1 = :j10s1")
    , @NamedQuery(name = "Planningsc.findByJ10s2", query = "SELECT p FROM Planningsc p WHERE p.j10s2 = :j10s2")
    , @NamedQuery(name = "Planningsc.findByJ11s1", query = "SELECT p FROM Planningsc p WHERE p.j11s1 = :j11s1")
    , @NamedQuery(name = "Planningsc.findByJ11s2", query = "SELECT p FROM Planningsc p WHERE p.j11s2 = :j11s2")
    , @NamedQuery(name = "Planningsc.findByJ12s1", query = "SELECT p FROM Planningsc p WHERE p.j12s1 = :j12s1")
    , @NamedQuery(name = "Planningsc.findByJ12s2", query = "SELECT p FROM Planningsc p WHERE p.j12s2 = :j12s2")
    , @NamedQuery(name = "Planningsc.findByJ13s1", query = "SELECT p FROM Planningsc p WHERE p.j13s1 = :j13s1")
    , @NamedQuery(name = "Planningsc.findByJ13s2", query = "SELECT p FROM Planningsc p WHERE p.j13s2 = :j13s2")
    , @NamedQuery(name = "Planningsc.findByJ14s1", query = "SELECT p FROM Planningsc p WHERE p.j14s1 = :j14s1")
    , @NamedQuery(name = "Planningsc.findByJ14s2", query = "SELECT p FROM Planningsc p WHERE p.j14s2 = :j14s2")
    , @NamedQuery(name = "Planningsc.findByJ15s1", query = "SELECT p FROM Planningsc p WHERE p.j15s1 = :j15s1")
    , @NamedQuery(name = "Planningsc.findByJ15s2", query = "SELECT p FROM Planningsc p WHERE p.j15s2 = :j15s2")
    , @NamedQuery(name = "Planningsc.findByNbre", query = "SELECT p FROM Planningsc p WHERE p.nbre = :nbre")})
public class Planningsc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPlanningSC", nullable = false)
    private Integer idPlanningSC;
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
    @Column(name = "j2s1", nullable = false, length = 45)
    private String j2s1;
    @Basic(optional = false)
    @Column(name = "j2s2", nullable = false, length = 45)
    private String j2s2;
    @Basic(optional = false)
    @Column(name = "j3s1", nullable = false, length = 45)
    private String j3s1;
    @Basic(optional = false)
    @Column(name = "j3s2", nullable = false, length = 45)
    private String j3s2;
    @Basic(optional = false)
    @Column(name = "j4s1", nullable = false, length = 45)
    private String j4s1;
    @Basic(optional = false)
    @Column(name = "j4s2", nullable = false, length = 45)
    private String j4s2;
    @Basic(optional = false)
    @Column(name = "j5s1", nullable = false, length = 45)
    private String j5s1;
    @Basic(optional = false)
    @Column(name = "j5s2", nullable = false, length = 45)
    private String j5s2;
    @Basic(optional = false)
    @Column(name = "j6s1", nullable = false, length = 45)
    private String j6s1;
    @Basic(optional = false)
    @Column(name = "j6s2", nullable = false, length = 45)
    private String j6s2;
    @Basic(optional = false)
    @Column(name = "j7s1", nullable = false, length = 45)
    private String j7s1;
    @Basic(optional = false)
    @Column(name = "j7s2", nullable = false, length = 45)
    private String j7s2;
    @Basic(optional = false)
    @Column(name = "j8s1", nullable = false, length = 45)
    private String j8s1;
    @Basic(optional = false)
    @Column(name = "j8s2", nullable = false, length = 45)
    private String j8s2;
    @Basic(optional = false)
    @Column(name = "j9s1", nullable = false, length = 45)
    private String j9s1;
    @Basic(optional = false)
    @Column(name = "j9s2", nullable = false, length = 45)
    private String j9s2;
    @Basic(optional = false)
    @Column(name = "j10s1", nullable = false, length = 45)
    private String j10s1;
    @Basic(optional = false)
    @Column(name = "j10s2", nullable = false, length = 45)
    private String j10s2;
    @Basic(optional = false)
    @Column(name = "j11s1", nullable = false, length = 45)
    private String j11s1;
    @Basic(optional = false)
    @Column(name = "j11s2", nullable = false, length = 45)
    private String j11s2;
    @Basic(optional = false)
    @Column(name = "j12s1", nullable = false, length = 45)
    private String j12s1;
    @Basic(optional = false)
    @Column(name = "j12s2", nullable = false, length = 45)
    private String j12s2;
    @Basic(optional = false)
    @Column(name = "j13s1", nullable = false, length = 45)
    private String j13s1;
    @Basic(optional = false)
    @Column(name = "j13s2", nullable = false, length = 45)
    private String j13s2;
    @Basic(optional = false)
    @Column(name = "j14s1", nullable = false, length = 45)
    private String j14s1;
    @Basic(optional = false)
    @Column(name = "j14s2", nullable = false, length = 45)
    private String j14s2;
    @Basic(optional = false)
    @Column(name = "j15s1", nullable = false, length = 45)
    private String j15s1;
    @Basic(optional = false)
    @Column(name = "j15s2", nullable = false, length = 45)
    private String j15s2;
    @Basic(optional = false)
    @Column(name = "nbre", nullable = false, length = 45)
    private String nbre;

    public Planningsc() {
    }

    public Planningsc(Integer idPlanningSC) {
        this.idPlanningSC = idPlanningSC;
    }

    public Planningsc(Integer idPlanningSC, String nomcomplt, String j1s1, String j1s2, String j2s1, String j2s2, String j3s1, String j3s2, String j4s1, String j4s2, String j5s1, String j5s2, String j6s1, String j6s2, String j7s1, String j7s2, String j8s1, String j8s2, String j9s1, String j9s2, String j10s1, String j10s2, String j11s1, String j11s2, String j12s1, String j12s2, String j13s1, String j13s2, String j14s1, String j14s2, String j15s1, String j15s2, String nbre) {
        this.idPlanningSC = idPlanningSC;
        this.nomcomplt = nomcomplt;
        this.j1s1 = j1s1;
        this.j1s2 = j1s2;
        this.j2s1 = j2s1;
        this.j2s2 = j2s2;
        this.j3s1 = j3s1;
        this.j3s2 = j3s2;
        this.j4s1 = j4s1;
        this.j4s2 = j4s2;
        this.j5s1 = j5s1;
        this.j5s2 = j5s2;
        this.j6s1 = j6s1;
        this.j6s2 = j6s2;
        this.j7s1 = j7s1;
        this.j7s2 = j7s2;
        this.j8s1 = j8s1;
        this.j8s2 = j8s2;
        this.j9s1 = j9s1;
        this.j9s2 = j9s2;
        this.j10s1 = j10s1;
        this.j10s2 = j10s2;
        this.j11s1 = j11s1;
        this.j11s2 = j11s2;
        this.j12s1 = j12s1;
        this.j12s2 = j12s2;
        this.j13s1 = j13s1;
        this.j13s2 = j13s2;
        this.j14s1 = j14s1;
        this.j14s2 = j14s2;
        this.j15s1 = j15s1;
        this.j15s2 = j15s2;
        this.nbre = nbre;
    }

    public Integer getIdPlanningSC() {
        return idPlanningSC;
    }

    public void setIdPlanningSC(Integer idPlanningSC) {
        this.idPlanningSC = idPlanningSC;
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

    public String getJ11s1() {
        return j11s1;
    }

    public void setJ11s1(String j11s1) {
        this.j11s1 = j11s1;
    }

    public String getJ11s2() {
        return j11s2;
    }

    public void setJ11s2(String j11s2) {
        this.j11s2 = j11s2;
    }

    public String getJ12s1() {
        return j12s1;
    }

    public void setJ12s1(String j12s1) {
        this.j12s1 = j12s1;
    }

    public String getJ12s2() {
        return j12s2;
    }

    public void setJ12s2(String j12s2) {
        this.j12s2 = j12s2;
    }

    public String getJ13s1() {
        return j13s1;
    }

    public void setJ13s1(String j13s1) {
        this.j13s1 = j13s1;
    }

    public String getJ13s2() {
        return j13s2;
    }

    public void setJ13s2(String j13s2) {
        this.j13s2 = j13s2;
    }

    public String getJ14s1() {
        return j14s1;
    }

    public void setJ14s1(String j14s1) {
        this.j14s1 = j14s1;
    }

    public String getJ14s2() {
        return j14s2;
    }

    public void setJ14s2(String j14s2) {
        this.j14s2 = j14s2;
    }

    public String getJ15s1() {
        return j15s1;
    }

    public void setJ15s1(String j15s1) {
        this.j15s1 = j15s1;
    }

    public String getJ15s2() {
        return j15s2;
    }

    public void setJ15s2(String j15s2) {
        this.j15s2 = j15s2;
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
        hash += (idPlanningSC != null ? idPlanningSC.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Planningsc)) {
            return false;
        }
        Planningsc other = (Planningsc) object;
        if ((this.idPlanningSC == null && other.idPlanningSC != null) || (this.idPlanningSC != null && !this.idPlanningSC.equals(other.idPlanningSC))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Controller.Planningsc[ idPlanningSC=" + idPlanningSC + " ]";
    }
    
}
