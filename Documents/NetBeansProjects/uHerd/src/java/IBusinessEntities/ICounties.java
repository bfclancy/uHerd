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
public interface ICounties extends Serializable {

    boolean equals(Object object);

    String getCounty();

    int hashCode();

    void setCounty(String county);

    String toString();
    
}
