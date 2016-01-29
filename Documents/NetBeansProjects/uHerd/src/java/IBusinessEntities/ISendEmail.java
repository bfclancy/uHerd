/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IBusinessEntities;

import BusinessEntities.Email;
import javax.mail.MessagingException;

/**
 *
 * @author asus
 */
public interface ISendEmail {

    void sendEmailMessage(Email email) throws MessagingException;
    
}
