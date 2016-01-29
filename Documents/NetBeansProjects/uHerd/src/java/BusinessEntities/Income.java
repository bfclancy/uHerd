/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessEntities;

import IBusinessEntities.IIncome;
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
@Table(name = "income")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Income.findAll", query = "SELECT i FROM Income i"),
    @NamedQuery(name = "Income.findByIncomeId", query = "SELECT i FROM Income i WHERE i.incomeId = :incomeId"),
    @NamedQuery(name = "Income.findByIncomeDate", query = "SELECT i FROM Income i WHERE i.incomeDate = :incomeDate"),
    @NamedQuery(name = "Income.findByIncomeAmount", query = "SELECT i FROM Income i WHERE i.incomeAmount = :incomeAmount"),
    @NamedQuery(name = "Income.findByIncomeDescription", query = "SELECT i FROM Income i WHERE i.incomeDescription = :incomeDescription"),
    @NamedQuery(name = "Income.findByHerdNumber", query = "SELECT i FROM Income i WHERE i.herdNumber = :herdNumber")})
public class Income implements IIncome {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "incomeId")
    private Integer incomeId;
    @Basic(optional = false)
    @Column(name = "incomeDate")
    @Temporal(TemporalType.DATE)
    private Date incomeDate;
    @Basic(optional = false)
    @Column(name = "incomeAmount")
    private double incomeAmount;
    @Basic(optional = false)
    @Column(name = "incomeDescription")
    private String incomeDescription;
    @Basic(optional = false)
    @Column(name = "herdNumber")
    private String herdNumber;

    public Income() {
    }

    public Income(Integer incomeId) {
        this.incomeId = incomeId;
    }

    public Income(Integer incomeId, Date incomeDate, double incomeAmount, String incomeDescription, String herdNumber) {
        this.incomeId = incomeId;
        this.incomeDate = incomeDate;
        this.incomeAmount = incomeAmount;
        this.incomeDescription = incomeDescription;
        this.herdNumber = herdNumber;
    }

    @Override
    public Integer getIncomeId() {
        return incomeId;
    }

    @Override
    public void setIncomeId(Integer incomeId) {
        this.incomeId = incomeId;
    }

    @Override
    public Date getIncomeDate() {
        return incomeDate;
    }

    @Override
    public void setIncomeDate(Date incomeDate) {
        this.incomeDate = incomeDate;
    }

    @Override
    public double getIncomeAmount() {
        return incomeAmount;
    }

    @Override
    public void setIncomeAmount(double incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

    @Override
    public String getIncomeDescription() {
        return incomeDescription;
    }

    @Override
    public void setIncomeDescription(String incomeDescription) {
        this.incomeDescription = incomeDescription;
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
        hash += (incomeId != null ? incomeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Income)) {
            return false;
        }
        Income other = (Income) object;
        if ((this.incomeId == null && other.incomeId != null) || (this.incomeId != null && !this.incomeId.equals(other.incomeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BusinessEntities.Income[ incomeId=" + incomeId + " ]";
    }
    
}
