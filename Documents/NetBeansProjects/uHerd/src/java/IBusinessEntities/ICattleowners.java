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
public interface ICattleowners extends Serializable {

    boolean equals(Object object);

    String getHerdNumber();

    String getTagNumber();

    int hashCode();

    void setHerdNumber(String herdNumber);

    void setTagNumber(String tagNumber);

    String toString();
    
}
