/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessEntities;

import IBusinessEntities.ISendEmail;
import java.util.ArrayList;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author asus
 */
public class SendEmail implements ISendEmail {
    private class SMTPAuthenticator extends Authenticator
    {
        public PasswordAuthentication getPasswordAuthentication()
        {
            return new PasswordAuthentication("livestockmanager8@gmail.com", "roxypoxy");
        }
    }



    @Override
   public void sendEmailMessage(Email email) throws MessagingException {

          // Get system properties
        Properties props = System.getProperties();
        props = new Properties();
            props.put("mail.smtp.user", "livestockmanager8@gmail.com.com");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.starttls.enable","true");
            props.put("mail.smtp.debug", "true");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.socketFactory.port", "587");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.socketFactory.fallback", "false");


            SMTPAuthenticator auth = new SMTPAuthenticator();
            Session session = Session.getInstance(props, auth);
            session.setDebug(false);

            MimeMessage msg = new MimeMessage(session);
            msg.setText(email.getMessage());
            msg.setSubject(email.getSubject());
            msg.setFrom(new InternetAddress(email.getSender()));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getRecipient()));

            Transport transport = session.getTransport("smtps");
            transport.connect("smtp.gmail.com", 465, "livestockmanager8@gmail.com", "roxypoxy");
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();  

   }
}
