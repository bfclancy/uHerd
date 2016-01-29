/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IBusinessEntities;

/**
 *
 * @author asus
 */
public interface IEmail {

    /**
     * @return the Message
     */
    String getMessage();

    /**
     * @return the recipient
     */
    String getRecipient();

    /**
     * @return the sender
     */
    String getSender();

    /**
     * @return the subject
     */
    String getSubject();

    /**
     * @param Message the Message to set
     */
    void setMessage(String Message);

    /**
     * @param recipient the recipient to set
     */
    void setRecipient(String recipient);

    /**
     * @param sender the sender to set
     */
    void setSender(String sender);

    /**
     * @param subject the subject to set
     */
    void setSubject(String subject);
    
}
