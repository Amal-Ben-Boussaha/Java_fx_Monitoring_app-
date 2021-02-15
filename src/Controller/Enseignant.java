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
@Table(name = "enseignant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enseignant.findAll", query = "SELECT e FROM Enseignant e")
    , @NamedQuery(name = "Enseignant.findById", query = "SELECT e FROM Enseignant e WHERE e.id = :id")
    , @NamedQuery(name = "Enseignant.findByNomcomplt", query = "SELECT e FROM Enseignant e WHERE e.nomcomplt = :nomcomplt")
    , @NamedQuery(name = "Enseignant.findByGrade", query = "SELECT e FROM Enseignant e WHERE e.grade = :grade")})
public class Enseignant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nomcomplt", nullable = false, length = 45)
    private String nomcomplt;
    @Basic(optional = false)
    @Column(name = "grade", nullable = false, length = 45)
    private String grade;

    public Enseignant() {
    }

    public Enseignant(Integer id) {
        this.id = id;
    }

    public Enseignant(Integer id, String nomcomplt, String grade) {
        this.id = id;
        this.nomcomplt = nomcomplt;
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomcomplt() {
        return nomcomplt;
    }

    public void setNomcomplt(String nomcomplt) {
        this.nomcomplt = nomcomplt;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
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
        if (!(object instanceof Enseignant)) {
            return false;
        }
        Enseignant other = (Enseignant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Controller.Enseignant[ id=" + id + " ]";
    }
    
}
