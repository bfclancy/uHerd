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
public interface ICattle extends Serializable {

    boolean equals(Object object);

    String getDamTagNumber();

    Date getDateLastBRTest();

    Date getDateLastTBTest();

    Date getDateMovedIn();

    Date getDateOfBirth();

    String getGender();

    String getSire();

    String getSireBreed();

    String getTagNumber();

    int hashCode();

    void setDamTagNumber(String damTagNumber);

    void setDateLastBRTest(Date dateLastBRTest);

    void setDateLastTBTest(Date dateLastTBTest);

    void setDateMovedIn(Date dateMovedIn);

    void setDateOfBirth(Date dateOfBirth);

    void setGender(String gender);

    void setSire(String sire);

    void setSireBreed(String sireBreed);

    void setTagNumber(String tagNumber);

    String toString();
    
}
