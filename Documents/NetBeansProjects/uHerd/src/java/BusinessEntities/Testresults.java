/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessEntities;

import IBusinessEntities.ITestresults;
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
@Table(name = "testresults")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Testresults.findAll", query = "SELECT t FROM Testresults t"),
    @NamedQuery(name = "Testresults.findByTestId", query = "SELECT t FROM Testresults t WHERE t.testId = :testId"),
    @NamedQuery(name = "Testresults.findByTagNumber", query = "SELECT t FROM Testresults t WHERE t.tagNumber = :tagNumber"),
    @NamedQuery(name = "Testresults.findByTestType", query = "SELECT t FROM Testresults t WHERE t.testType = :testType"),
    @NamedQuery(name = "Testresults.findByResult", query = "SELECT t FROM Testresults t WHERE t.result = :result"),
    @NamedQuery(name = "Testresults.findByTestDate", query = "SELECT t FROM Testresults t WHERE t.testDate = :testDate")})
public class Testresults implements ITestresults {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "testId")
    private Integer testId;
    @Basic(optional = false)
    @Column(name = "tagNumber")
    private String tagNumber;
    @Basic(optional = false)
    @Column(name = "testType")
    private String testType;
    @Basic(optional = false)
    @Column(name = "result")
    private String result;
    @Basic(optional = false)
    @Column(name = "testDate")
    @Temporal(TemporalType.DATE)
    private Date testDate;

    public Testresults() {
    }

    public Testresults(Integer testId) {
        this.testId = testId;
    }

    public Testresults(Integer testId, String tagNumber, String testType, String result, Date testDate) {
        this.testId = testId;
        this.tagNumber = tagNumber;
        this.testType = testType;
        this.result = result;
        this.testDate = testDate;
    }

    @Override
    public Integer getTestId() {
        return testId;
    }

    @Override
    public void setTestId(Integer testId) {
        this.testId = testId;
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
    public String getTestType() {
        return testType;
    }

    @Override
    public void setTestType(String testType) {
        this.testType = testType;
    }

    @Override
    public String getResult() {
        return result;
    }

    @Override
    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public Date getTestDate() {
        return testDate;
    }

    @Override
    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (testId != null ? testId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Testresults)) {
            return false;
        }
        Testresults other = (Testresults) object;
        if ((this.testId == null && other.testId != null) || (this.testId != null && !this.testId.equals(other.testId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BusinessEntities.Testresults[ testId=" + testId + " ]";
    }
    
}
