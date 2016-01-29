/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import BusinessEntities.Email;
import BusinessEntities.SendEmail;
import BusinessEntities.Userrole;
import BusinessEntities.Users;
import IBusinessEntities.IUserrole;
import IBusinessEntities.IUsers;
import Model.DBUsers;
import java.io.IOException;
import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author asus
 */
@WebServlet(name = "RegisterNewUser", urlPatterns = {"/RegisterNewUser"})
public class RegisterNewUser extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = "";
        String firstName= request.getParameter("firstName");
        String surname = request.getParameter("surname");
        String address = request.getParameter("address");
        String county = request.getParameter("county");
        String herdNumber = request.getParameter("herdNumber");
        String PAC = request.getParameter("pac");
        String username = request.getParameter("username");
        String password = hashPassword(request.getParameter("password"));
        String email = request.getParameter("email");
        IUsers user = new Users();
        user.setHerdNumber(herdNumber);
        user.setFirstName(firstName);
        user.setSurname(surname);
        user.setAddress(address);
        user.setCounty(county);
        user.setPac(PAC);
        user.setUserName(username);
        user.setPassword(password);
        user.setEmail(email);
        IUserrole ur = new Userrole(0, username, "user");
        
        try{
            sendEmailConfirmation(email);
            DBUsers.addNewUserRole(ur);
            DBUsers.addNewUser(user);
            url = "/uHerd/Users";
        }catch(Exception ex){
            System.out.println(ex);
            url = "/error.jsp";
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String hashPassword(String unencryptedPassword){
        String encryptedPassword = DigestUtils.sha1Hex(unencryptedPassword);
        return encryptedPassword;
    }
    
    private void sendEmailConfirmation(String emailAddress){
        Email email = new Email(emailAddress, "livestockmanger8@gmail.com", "Registration Confirmation", "Thank you for joining the LivestockManager Community");
        SendEmail newEmail = new SendEmail();
        try {
            newEmail.sendEmailMessage(email);
        } catch (MessagingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}
