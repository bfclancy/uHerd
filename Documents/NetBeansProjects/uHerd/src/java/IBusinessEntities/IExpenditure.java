/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IBusinessEntities;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author asus
 */
public interface IExpenditure extends Serializable {

    boolean equals(Object object);

    double getExpenditureAmount();

    Date getExpenditureDate();

    String getExpenditureDescription();

    Integer getExpenditureId();

    String getHerdNumber();

    int hashCode();

    void setExpenditureAmount(double expenditureAmount);

    void setExpenditureDate(Date expenditureDate);

    void setExpenditureDescription(String expenditureDescription);

    void setExpenditureId(Integer expenditureId);

    void setHerdNumber(String herdNumber);

    String toString();
    
}
