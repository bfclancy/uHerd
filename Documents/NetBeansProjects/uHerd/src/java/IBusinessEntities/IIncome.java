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
public interface IIncome extends Serializable {

    boolean equals(Object object);

    String getHerdNumber();

    double getIncomeAmount();

    Date getIncomeDate();

    String getIncomeDescription();

    Integer getIncomeId();

    int hashCode();

    void setHerdNumber(String herdNumber);

    void setIncomeAmount(double incomeAmount);

    void setIncomeDate(Date incomeDate);

    void setIncomeDescription(String incomeDescription);

    void setIncomeId(Integer incomeId);

    String toString();
    
}
