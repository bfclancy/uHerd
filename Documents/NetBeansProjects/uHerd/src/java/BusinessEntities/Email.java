/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessEntities;

import IBusinessEntities.IEmail;

/**
 *
 * @author asus
 */
public class Email implements IEmail {

    public Email(String recipient, String sender, String subject, String Message) {
        this.recipient = recipient;
        this.sender = sender;
        this.subject = subject;
        this.Message = Message;
    }
    private String recipient;
    private String sender;
    private String subject;
    private String Message;

    /**
     * @return the recipient
     */
    @Override
    public String getRecipient() {
        return recipient;
    }

    /**
     * @param recipient the recipient to set
     */
    @Override
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    /**
     * @return the sender
     */
    @Override
    public String getSender() {
        return sender;
    }

    /**
     * @param sender the sender to set
     */
    @Override
    public void setSender(String sender) {
        this.sender = sender;
    }

    /**
     * @return the subject
     */
    @Override
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    @Override
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the Message
     */
    @Override
    public String getMessage() {
        return Message;
    }

    /**
     * @param Message the Message to set
     */
    @Override
    public void setMessage(String Message) {
        this.Message = Message;
    }
}
