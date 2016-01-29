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
public interface IUserrole extends Serializable {

    boolean equals(Object object);

    Integer getId();

    String getRole();

    String getUserName();

    int hashCode();

    void setId(Integer id);

    void setRole(String role);

    void setUserName(String userName);

    String toString();
    
}
