
package principal;

import clienteconversor.SWConversor_Service;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;


public class respuesta extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/AplicacionSWConversor/SWConversor.wsdl")
    private SWConversor_Service service;

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String angulo = request.getParameter("angulo");
            String op = request.getParameter("operacion");
            double ang = Double.parseDouble(angulo);
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet respuesta</title>");            
            out.println("</head>");
            out.println("<body>");
            if (op.equals("Convertir a radianes"))
                out.println("<h3>" + ang + " grados se corresponde con " + grad2Rad(ang) + " radianes </h3>");
            if (op.equals("Tipo de angulo"))
                out.println("<h3>" + ang + " es " + tipoang(ang) + "</h3>");
            if (op.equals("Angulo suplementario"))
                out.println("<h3>El ángulo suplementario de " + ang + " es " + angsup1(ang) + "</h3>");
            
            
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

    private double angsup1(double ang) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        clienteconversor.SWConversor port = service.getSWConversorPort();
        return port.angsup1(ang);
    }

    private double grad2Rad(double ang) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        clienteconversor.SWConversor port = service.getSWConversorPort();
        return port.grad2Rad(ang);
    }

    private String tipoang(double ang) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        clienteconversor.SWConversor port = service.getSWConversorPort();
        return port.tipoang(ang);
    }

    

}
