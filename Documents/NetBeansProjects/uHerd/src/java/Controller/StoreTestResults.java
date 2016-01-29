/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import BusinessEntities.Testresults;
import Model.DBTestResults;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asus
 */
@WebServlet(name = "StoreTestResults", urlPatterns = {"/StoreTestResults"})
public class StoreTestResults extends HttpServlet {

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
        java.util.Date testDate = java.sql.Date.valueOf(request.getParameter("testDate"));
        String testType = request.getParameter("testType");
        List<String> params = Collections.list(request.getParameterNames());//Get param name
        List<Testresults> testResults = new ArrayList<>();
        
        //Add Test Results to A List
        for (int i = params.size() - 1; i > -1;  i--)
        {
            if(params.get(i).equals("testType")){
                params.remove(params.get(i));
            }
            else if(params.get(i).equals("testDate")){
                params.remove(params.get(i));
            }
            else{
                Testresults result = new Testresults(0 , params.get(i), testType,request.getParameter(params.get(i)), testDate);
                DBTestResults.addTestResult(result);
                testResults.add(result);
            }
        }
        
        for(Testresults t : testResults){
            System.out.println(t.getTestId() + " " + t.getTagNumber() + " " + t.getTestType() + " " + t.getTestDate() + " " + t.getResult());
        }
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
