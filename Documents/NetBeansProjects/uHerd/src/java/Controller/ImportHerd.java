/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import BusinessEntities.Cattle;
import BusinessEntities.Cattleowners;
import BusinessEntities.Users;
import Model.DBCattleOwners;
import Model.DBLivestock;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.fileupload.FileUploadException;
/**
 *
 * @author asus
 */
@WebServlet(name = "ImportHerd", urlPatterns = {"/ImportHerd"})
public class ImportHerd extends HttpServlet {

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
            throws ServletException, IOException, FileUploadException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("currentUser");
        String herdNumber = user.getHerdNumber();
        String url = "";
        boolean isMultiPart = ServletFileUpload.isMultipartContent(request);
        List<Cattle> cattle = new ArrayList<>();
        List<Cattleowners> cattleOwners = new ArrayList<>();
        
        if(isMultiPart){
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            try{
                List fileItems = upload.parseRequest(request);
                Iterator i = fileItems.iterator();
                while ( i.hasNext () ) {
                    FileItem file = (FileItem)i.next();
                    if (!file.isFormField()){
                        File uploadedFile = new File("importHerd.csv");
                        file.write(uploadedFile);
                        cattle = processUploadedFile(uploadedFile,herdNumber);
                    }
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }
        try{
            for(Cattle c: cattle){
                try{
                    Cattleowners co = new Cattleowners(herdNumber, c.getTagNumber());
                    DBLivestock.registerNewAnimal(c);
                    DBCattleOwners.addToUserHerd(co);
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }catch(Exception e){
            System.out.println(e);
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
        try {
            processRequest(request, response);
        } catch (FileUploadException ex) {
            Logger.getLogger(ImportHerd.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (FileUploadException ex) {
            Logger.getLogger(ImportHerd.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    private List<Cattle> processUploadedFile(File file, String herdNumber) throws FileNotFoundException, IOException, ParseException{
        List<Cattle> cattle = new ArrayList<>();
        try (CSVParser parser = new CSVParser(new FileReader("importHerd.csv"), CSVFormat.DEFAULT.withHeader())) {
            for (CSVRecord record : parser) {
                java.util.Date dateOfBirth = dateConvert(record.get("DateOfBirth"));
                java.util.Date dmi = dateConvert(record.get("Date Moved In"));
                java.util.Date dtb = dateConvert(record.get("TB Test Date"));
                try{
                    Cattle c = new Cattle();
                    c.setTagNumber(record.get("TagNumber"));
                    c.setGender(record.get("Sex"));
                    c.setSireBreed(record.get("Breed"));
                    c.setDateOfBirth(dateOfBirth);
                    c.setDateLastTBTest(dtb);
                    c.setDateMovedIn(dmi);
                    cattle.add(c);
                }catch(Exception e){
                    System.out.println("here" + e);
                }
            }
            parser.close();
            return cattle;
        }
    }
    
    public static Date dateConvert(String origFormat) throws ParseException {
        if(origFormat.equals("")){
            origFormat = "0000/00/00";
        }
        SimpleDateFormat origDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat newDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date retrivedDate = origDateFormat.parse(origFormat);
        return retrivedDate;
    }
}
