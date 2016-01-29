/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessEntities;

import IBusinessEntities.ICounties;
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
@Table(name = "counties")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Counties.findAll", query = "SELECT c FROM Counties c"),
    @NamedQuery(name = "Counties.findByCounty", query = "SELECT c FROM Counties c WHERE c.county = :county")})
public class Counties implements ICounties {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "county")
    private String county;

    public Counties() {
    }

    public Counties(String county) {
        this.county = county;
    }

    @Override
    public String getCounty() {
        return county;
    }

    @Override
    public void setCounty(String county) {
        this.county = county;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (county != null ? county.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Counties)) {
            return false;
        }
        Counties other = (Counties) object;
        if ((this.county == null && other.county != null) || (this.county != null && !this.county.equals(other.county))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BusinessEntities.Counties[ county=" + county + " ]";
    }
    
}
