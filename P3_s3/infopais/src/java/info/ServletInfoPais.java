/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import org.oorsprong.websamples.CountryInfoService;
import org.oorsprong.websamples.TCountryInfo;

/**
 *
 * @author Aula
 */
public class ServletInfoPais extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso.wsdl")
    private CountryInfoService service;

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            String iso = request.getParameter("ISOcode");
            TCountryInfo info = fullCountryInfo(iso);
            
            String name = info.getSName();
            String capitalCity = info.getSCapitalCity();
            String coin = info.getSCurrencyISOCode();
            String flagURI = info.getSCountryFlag();
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<script src=\"https://cdn.tailwindcss.com\"></script>\n");
            out.println("<title>Servlet ServletInfoPais</title>");            
            out.println("</head>");
            out.println("<body class='p-4'>");
            out.println("<h1 class='text-2xl font-semibold'>Informacion pais: " + name + "</h1>");
            out.println("<h4 class='text-lg'>Capital: " + capitalCity + "</h4>");
            out.println("<h4 class='text-lg'>Moneda: " + coin + "</h4>");
            out.println("<img src="  + flagURI + ">");
            out.println("</body>");
            out.println("</html>");
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

    private TCountryInfo fullCountryInfo(java.lang.String sCountryISOCode) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        org.oorsprong.websamples.CountryInfoServiceSoapType port = service.getCountryInfoServiceSoap();
        return port.fullCountryInfo(sCountryISOCode);
    }

}
