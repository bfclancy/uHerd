/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessEntities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "pregnancy")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pregnancy.findAll", query = "SELECT p FROM Pregnancy p"),
    @NamedQuery(name = "Pregnancy.findById", query = "SELECT p FROM Pregnancy p WHERE p.id = :id"),
    @NamedQuery(name = "Pregnancy.findBySireTagNumber", query = "SELECT p FROM Pregnancy p WHERE p.sireTagNumber = :sireTagNumber"),
    @NamedQuery(name = "Pregnancy.findBySireBreed", query = "SELECT p FROM Pregnancy p WHERE p.sireBreed = :sireBreed"),
    @NamedQuery(name = "Pregnancy.findByDamTagNumber", query = "SELECT p FROM Pregnancy p WHERE p.damTagNumber = :damTagNumber"),
    @NamedQuery(name = "Pregnancy.findByDate", query = "SELECT p FROM Pregnancy p WHERE p.date = :date"),
    @NamedQuery(name = "Pregnancy.findByDueDate", query = "SELECT p FROM Pregnancy p WHERE p.dueDate = :dueDate")})
public class Pregnancy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "sireTagNumber")
    private String sireTagNumber;
    @Basic(optional = false)
    @Column(name = "sireBreed")
    private String sireBreed;
    @Basic(optional = false)
    @Column(name = "damTagNumber")
    private String damTagNumber;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "dueDate")
    @Temporal(TemporalType.DATE)
    private Date dueDate;

    public Pregnancy() {
    }

    public Pregnancy(Integer id) {
        this.id = id;
    }

    public Pregnancy(Integer id, String sireTagNumber, String sireBreed, String damTagNumber, Date date, Date dueDate) {
        this.id = id;
        this.sireTagNumber = sireTagNumber;
        this.sireBreed = sireBreed;
        this.damTagNumber = damTagNumber;
        this.date = date;
        this.dueDate = dueDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSireTagNumber() {
        return sireTagNumber;
    }

    public void setSireTagNumber(String sireTagNumber) {
        this.sireTagNumber = sireTagNumber;
    }

    public String getSireBreed() {
        return sireBreed;
    }

    public void setSireBreed(String sireBreed) {
        this.sireBreed = sireBreed;
    }

    public String getDamTagNumber() {
        return damTagNumber;
    }

    public void setDamTagNumber(String damTagNumber) {
        this.damTagNumber = damTagNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
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
        if (!(object instanceof Pregnancy)) {
            return false;
        }
        Pregnancy other = (Pregnancy) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BusinessEntities.Pregnancy[ id=" + id + " ]";
    }
    
}
