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
public interface ITestresults extends Serializable {

    boolean equals(Object object);

    String getResult();

    String getTagNumber();

    Date getTestDate();

    Integer getTestId();

    String getTestType();

    int hashCode();

    void setResult(String result);

    void setTagNumber(String tagNumber);

    void setTestDate(Date testDate);

    void setTestId(Integer testId);

    void setTestType(String testType);

    String toString();
    
}
