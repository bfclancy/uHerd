/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import BusinessEntities.Aibulls;
import BusinessEntities.Cattle;
import BusinessEntities.Users;
import IBusinessEntities.ICattle;
import Model.DBAIBulls;
import Model.DBCattleOwners;
import Model.DBLivestock;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "RecordPregnancyData", urlPatterns = {"/RecordPregnancyData"})
public class RecordPregnancyData extends HttpServlet {

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
        List<Cattle> cows = new ArrayList<>();
        List<Cattle> bulls = new ArrayList<>();
        List<Aibulls> aibulls = new ArrayList<>();
        List<String> tagNumbers = new ArrayList<>();
        String url = "";
        try{
            tagNumbers = DBCattleOwners.getAllTagNumbersForUser(herdNumber);
            url = "Users/recordPregnancy.jsp";
        }catch(Exception e){
            System.out.println(e);
            url = "/error.jsp";
        }
        cows = getAllCows(tagNumbers);
        bulls = getAllBulls(tagNumbers);
        aibulls = getAllAIBulls();
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        request.setAttribute("cows", cows);
        request.setAttribute("bulls", bulls);
        request.setAttribute("aibulls", aibulls);
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

    private List<Cattle> getAllCows(List<String> tagNumbers){
        List<Cattle> cows = new ArrayList<>();
        for(String s : tagNumbers){
            Cattle cow = DBLivestock.getAnimalByTagNumber(s);
            if(cow.getGender().equals("F"))
                cows.add(cow);
        }
        return cows;
    }
    
    private List<Cattle> getAllBulls(List<String> tagNumbers){
        List<Cattle> bulls = new ArrayList<>();
        for(String s : tagNumbers){
            Cattle bull = DBLivestock.getAnimalByTagNumber(s);
            if(bull.getGender().equals("M"))
                bulls.add(bull);
        }
        return bulls;
    }
    
     private List<Aibulls> getAllAIBulls(){
        List<Aibulls> aibulls = new ArrayList<>();
        try{
            aibulls = DBAIBulls.getAllBulls();
        }catch(Exception e){
            System.out.println(e);
        }
        return aibulls;
    }
}
