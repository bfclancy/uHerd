/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import BusinessEntities.BeefPrice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author asus
 */
@WebServlet(name = "BeefPriceData", urlPatterns = {"/BeefPriceData"})
public class BeefPriceData extends HttpServlet {

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
        Document doc = Jsoup.connect("http://www.bordbia.ie/industry/farmers/pricetracking/cattle/pages/default.aspx").get();
        List<BeefPrice> prices = new ArrayList<>();

        for (Element table : doc.select("table.CommodityListTable")) {
            int i = 0;
            String cattleType = "";
            for (Element row : table.select("tr")) {
                Elements tds = row.select("td");
                
                if (tds.size() > 6) {
                    if(i < 5) {
                        cattleType = "Steer";
                    }
                    else if(i < 8){
                        cattleType = "Young Bull";
                    }
                    else if(i < 12){
                        cattleType = "Heifer";
                    }
                    else
                        cattleType = "Cow";
                    BeefPrice price = new BeefPrice(cattleType, tds.get(1).text(), tds.get(2).text(), tds.get(3).text(), 
                                                    tds.get(5).text(), tds.get(6).text(), tds.get(7).text(), 
                                                    tds.get(8).text());
                    prices.add(price);
                    i++;
                }
            }
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Users/beefPriceTracker.jsp");
        request.setAttribute("prices", prices);
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
