package servlets;

import beans.monBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "doBeans", urlPatterns = {"/doBeans"})
public class doBeans extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet doBeans</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet doBeans at " + request.getContextPath() + "</h1>");

            HttpSession session = request.getSession();

            beans.monBean beanSession
                    = (beans.monBean) session.getAttribute("beanSession");
            if (beanSession == null) {
                beanSession = new monBean();
                session.setAttribute("beanSession", beanSession);
            }
            out.println("Session : " + beanSession.getDate());
            out.println("<br>");

            ServletContext application = this.getServletContext();
            monBean beanApplication
                    = (monBean) application.getAttribute("beanApplication");
            if (beanApplication == null) {
                beanApplication = new monBean();
                application.setAttribute("beanApplication", beanApplication);
            }
            
            out.println("Application : " + beanApplication.getDate());

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
