/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessEntities;

import IBusinessEntities.IExpenditure;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "expenditure")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Expenditure.findAll", query = "SELECT e FROM Expenditure e"),
    @NamedQuery(name = "Expenditure.findByExpenditureId", query = "SELECT e FROM Expenditure e WHERE e.expenditureId = :expenditureId"),
    @NamedQuery(name = "Expenditure.findByExpenditureDate", query = "SELECT e FROM Expenditure e WHERE e.expenditureDate = :expenditureDate"),
    @NamedQuery(name = "Expenditure.findByExpenditureAmount", query = "SELECT e FROM Expenditure e WHERE e.expenditureAmount = :expenditureAmount"),
    @NamedQuery(name = "Expenditure.findByExpenditureDescription", query = "SELECT e FROM Expenditure e WHERE e.expenditureDescription = :expenditureDescription"),
    @NamedQuery(name = "Expenditure.findByHerdNumber", query = "SELECT e FROM Expenditure e WHERE e.herdNumber = :herdNumber")})
public class Expenditure implements IExpenditure {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "expenditureId")
    private Integer expenditureId;
    @Basic(optional = false)
    @Column(name = "expenditureDate")
    @Temporal(TemporalType.DATE)
    private Date expenditureDate;
    @Basic(optional = false)
    @Column(name = "expenditureAmount")
    private double expenditureAmount;
    @Basic(optional = false)
    @Column(name = "expenditureDescription")
    private String expenditureDescription;
    @Basic(optional = false)
    @Column(name = "herdNumber")
    private String herdNumber;

    public Expenditure() {
    }

    public Expenditure(Integer expenditureId) {
        this.expenditureId = expenditureId;
    }

    public Expenditure(Integer expenditureId, Date expenditureDate, double expenditureAmount, String expenditureDescription, String herdNumber) {
        this.expenditureId = expenditureId;
        this.expenditureDate = expenditureDate;
        this.expenditureAmount = expenditureAmount;
        this.expenditureDescription = expenditureDescription;
        this.herdNumber = herdNumber;
    }

    @Override
    public Integer getExpenditureId() {
        return expenditureId;
    }

    @Override
    public void setExpenditureId(Integer expenditureId) {
        this.expenditureId = expenditureId;
    }

    @Override
    public Date getExpenditureDate() {
        return expenditureDate;
    }

    @Override
    public void setExpenditureDate(Date expenditureDate) {
        this.expenditureDate = expenditureDate;
    }

    @Override
    public double getExpenditureAmount() {
        return expenditureAmount;
    }

    @Override
    public void setExpenditureAmount(double expenditureAmount) {
        this.expenditureAmount = expenditureAmount;
    }

    @Override
    public String getExpenditureDescription() {
        return expenditureDescription;
    }

    @Override
    public void setExpenditureDescription(String expenditureDescription) {
        this.expenditureDescription = expenditureDescription;
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
    public int hashCode() {
        int hash = 0;
        hash += (expenditureId != null ? expenditureId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Expenditure)) {
            return false;
        }
        Expenditure other = (Expenditure) object;
        if ((this.expenditureId == null && other.expenditureId != null) || (this.expenditureId != null && !this.expenditureId.equals(other.expenditureId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BusinessEntities.Expenditure[ expenditureId=" + expenditureId + " ]";
    }
    
}
