package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "session02", urlPatterns = {"/session02"})
public class session02 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet session02</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet session02 at " + request.getContextPath() + "</h1>");

            HttpSession session = request.getSession();

            out.println(session.getId());
            out.println("<br>");
            out.println("N° CLient : "
                    + session.getAttribute("NOCLIENT"));
            out.println("<br>");
            out.println("Derniere visite : "
                    + session.getAttribute("LASTVISIT"));
            out.println("<br>");

            int i=0;
            if (session.getAttribute("COMPTEUR") != null) {
                i = (Integer) session.getAttribute("COMPTEUR");
            }
            session.setAttribute("COMPTEUR", ++i);
            out.println("Compteur : " + i);

            out.println( "<a href='"+
                    response.encodeURL("session02")
                    +"'>Suite</a>");

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

}
