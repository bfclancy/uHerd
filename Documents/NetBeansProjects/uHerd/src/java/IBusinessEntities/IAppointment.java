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
public interface IAppointment extends Serializable {

    boolean equals(Object object);

    Integer getAppointmentId();

    Date getDate();

    String getHerdNumber();

    Date getTime();

    String getType();

    int hashCode();

    void setAppointmentId(Integer appointmentId);

    void setDate(Date date);

    void setHerdNumber(String herdNumber);

    void setTime(Date time);

    void setType(String type);

    String toString();
    
}
