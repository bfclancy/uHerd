/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import BusinessEntities.Cattle;
import BusinessEntities.Cattleowners;
import BusinessEntities.Expenditure;
import BusinessEntities.Users;
import Model.DBCattleOwners;
import Model.DBExpenditure;
import Model.DBLivestock;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author asus
 */
@WebServlet(name = "RecordAnimalPurchase", urlPatterns = {"/RecordAnimalPurchase"})
public class RecordAnimalPurchase extends HttpServlet {

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
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("currentUser");
        String herdNumber = user.getHerdNumber();
        String url = "";
        Cattle cattle= new Cattle();
        String tagNumber = request.getParameter("tagNumber");
        Date dateOfBirth = Date.valueOf(request.getParameter("dateOfBirth"));
        String gender = request.getParameter("gender");
        String damTagNumber = request.getParameter("damTagNumber");
        String sireBreed = request.getParameter("sireBreed");
        String sireAICode = request.getParameter("sireAICode");
        
        Cattleowners owner = new Cattleowners(herdNumber, tagNumber);
        int id = 0;
        Date expenditureDate = Date.valueOf(request.getParameter("purchaseDate"));
        double expenditureAmount = Double.parseDouble(request.getParameter("purchasePrice"));
        String description = "Animal Purchase";
        Expenditure expenditure = new Expenditure(id, expenditureDate, expenditureAmount, description, herdNumber);
        
        if(sireAICode.equals(null)){
            String sireTagNumber = request.getParameter("sireTagNumber");
            cattle.setTagNumber(tagNumber);
            cattle.setGender(gender);
            cattle.setDateOfBirth(dateOfBirth);
            cattle.setDamTagNumber(damTagNumber);
            cattle.setSireBreed(sireBreed);
            cattle.setSire(sireTagNumber);
            cattle.setDateMovedIn(expenditureDate);
        }
        else{
            cattle.setTagNumber(tagNumber);
            cattle.setGender(gender);
            cattle.setDateOfBirth(dateOfBirth);
            cattle.setDamTagNumber(damTagNumber);
            cattle.setSireBreed(sireBreed);
            cattle.setSire(sireAICode);
            cattle.setDateMovedIn(expenditureDate);
        }
        try{
            DBLivestock.registerNewAnimal(cattle);
            DBExpenditure.addNewExpenditure(expenditure);
            DBCattleOwners.addToUserHerd(owner);
            url = "/Users/index1.jsp";
        } catch(Exception ex){
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

}
