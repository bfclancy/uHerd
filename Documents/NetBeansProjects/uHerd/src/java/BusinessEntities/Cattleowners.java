/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessEntities;

import IBusinessEntities.ICattleowners;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "cattleowners")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cattleowners.findAll", query = "SELECT c FROM Cattleowners c"),
    @NamedQuery(name = "Cattleowners.findByHerdNumber", query = "SELECT c FROM Cattleowners c WHERE c.herdNumber = :herdNumber"),
    @NamedQuery(name = "Cattleowners.findByTagNumber", query = "SELECT c FROM Cattleowners c WHERE c.tagNumber = :tagNumber")})
public class Cattleowners implements ICattleowners {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "herdNumber")
    private String herdNumber;
    @Basic(optional = false)
    @Column(name = "tagNumber")
    private String tagNumber;

    public Cattleowners() {
    }

    public Cattleowners(String herdNumber) {
        this.herdNumber = herdNumber;
    }

    public Cattleowners(String herdNumber, String tagNumber) {
        this.herdNumber = herdNumber;
        this.tagNumber = tagNumber;
    }

    @Override
    public String getHerdNumber() {
        return herdNumber;
    }

    @Override
    public void setHerdNumber(String herdNumber) {
        this.herdNumber = herdNumber;
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
    public int hashCode() {
        int hash = 0;
        hash += (herdNumber != null ? herdNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cattleowners)) {
            return false;
        }
        Cattleowners other = (Cattleowners) object;
        if ((this.herdNumber == null && other.herdNumber != null) || (this.herdNumber != null && !this.herdNumber.equals(other.herdNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BusinessEntities.Cattleowners[ herdNumber=" + herdNumber + " ]";
    }
    
}
