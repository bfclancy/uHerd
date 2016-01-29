/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessEntities;

import IBusinessEntities.ICattle;
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
@Table(name = "cattle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cattle.findAll", query = "SELECT c FROM Cattle c"),
    @NamedQuery(name = "Cattle.findByTagNumber", query = "SELECT c FROM Cattle c WHERE c.tagNumber = :tagNumber"),
    @NamedQuery(name = "Cattle.findByGender", query = "SELECT c FROM Cattle c WHERE c.gender = :gender"),
    @NamedQuery(name = "Cattle.findByDateOfBirth", query = "SELECT c FROM Cattle c WHERE c.dateOfBirth = :dateOfBirth"),
    @NamedQuery(name = "Cattle.findByDamTagNumber", query = "SELECT c FROM Cattle c WHERE c.damTagNumber = :damTagNumber"),
    @NamedQuery(name = "Cattle.findBySireBreed", query = "SELECT c FROM Cattle c WHERE c.sireBreed = :sireBreed"),
    @NamedQuery(name = "Cattle.findBySire", query = "SELECT c FROM Cattle c WHERE c.sire = :sire"),
    @NamedQuery(name = "Cattle.findByDateLastTBTest", query = "SELECT c FROM Cattle c WHERE c.dateLastTBTest = :dateLastTBTest"),
    @NamedQuery(name = "Cattle.findByDateLastBRTest", query = "SELECT c FROM Cattle c WHERE c.dateLastBRTest = :dateLastBRTest"),
    @NamedQuery(name = "Cattle.findByDateMovedIn", query = "SELECT c FROM Cattle c WHERE c.dateMovedIn = :dateMovedIn")})
public class Cattle implements ICattle {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tagNumber")
    private String tagNumber;
    @Basic(optional = false)
    @Column(name = "gender")
    private String gender;
    @Basic(optional = false)
    @Column(name = "dateOfBirth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Column(name = "damTagNumber")
    private String damTagNumber;
    @Basic(optional = false)
    @Column(name = "sireBreed")
    private String sireBreed;
    @Column(name = "sire")
    private String sire;
    @Column(name = "dateLastTBTest")
    @Temporal(TemporalType.DATE)
    private Date dateLastTBTest;
    @Column(name = "dateLastBRTest")
    @Temporal(TemporalType.DATE)
    private Date dateLastBRTest;
    @Column(name = "dateMovedIn")
    @Temporal(TemporalType.DATE)
    private Date dateMovedIn;

    public Cattle() {
    }

    public Cattle(String tagNumber) {
        this.tagNumber = tagNumber;
    }
    
    public Cattle(String tagNumber, Date dateOfBirth, String gender, String breed, Date dateMovedIn, Date tBTest) {
        this.tagNumber = tagNumber;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.sireBreed = breed;
        this.dateMovedIn = dateMovedIn;
        this.dateLastTBTest = tBTest;
    }

    public Cattle(String tagNumber, String gender, Date dateOfBirth, String sireBreed) {
        this.tagNumber = tagNumber;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.sireBreed = sireBreed;
    }

    @Override
    public String getTagNumber() {
        return tagNumber;
    }

    @Override
    public void setTagNumber(String tagNumber) {
        this.tagNumber = tagNumber;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String getDamTagNumber() {
        return damTagNumber;
    }

    @Override
    public void setDamTagNumber(String damTagNumber) {
        this.damTagNumber = damTagNumber;
    }

    @Override
    public String getSireBreed() {
        return sireBreed;
    }

    @Override
    public void setSireBreed(String sireBreed) {
        this.sireBreed = sireBreed;
    }

    @Override
    public String getSire() {
        return sire;
    }

    @Override
    public void setSire(String sire) {
        this.sire = sire;
    }

    @Override
    public Date getDateLastTBTest() {
        return dateLastTBTest;
    }

    @Override
    public void setDateLastTBTest(Date dateLastTBTest) {
        this.dateLastTBTest = dateLastTBTest;
    }

    @Override
    public Date getDateLastBRTest() {
        return dateLastBRTest;
    }

    @Override
    public void setDateLastBRTest(Date dateLastBRTest) {
        this.dateLastBRTest = dateLastBRTest;
    }

    @Override
    public Date getDateMovedIn() {
        return dateMovedIn;
    }

    @Override
    public void setDateMovedIn(Date dateMovedIn) {
        this.dateMovedIn = dateMovedIn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tagNumber != null ? tagNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cattle)) {
            return false;
        }
        Cattle other = (Cattle) object;
        if ((this.tagNumber == null && other.tagNumber != null) || (this.tagNumber != null && !this.tagNumber.equals(other.tagNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BusinessEntities.Cattle[ tagNumber=" + tagNumber + " ]";
    }
    
}
