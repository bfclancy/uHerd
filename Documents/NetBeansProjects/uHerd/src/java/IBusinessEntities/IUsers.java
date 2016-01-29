/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IBusinessEntities;

import java.io.Serializable;

/**
 *
 * @author asus
 */
public interface IUsers extends Serializable {

    boolean equals(Object object);

    String getAddress();

    String getCounty();

    String getEmail();

    String getFirstName();

    String getHerdNumber();

    String getPac();

    String getPassword();

    String getSurname();

    String getUserName();

    int hashCode();

    void setAddress(String address);

    void setCounty(String county);

    void setEmail(String email);

    void setFirstName(String firstName);

    void setHerdNumber(String herdNumber);

    void setPac(String pac);

    void setPassword(String password);

    void setSurname(String surname);

    void setUserName(String userName);

    String toString();
    
}
