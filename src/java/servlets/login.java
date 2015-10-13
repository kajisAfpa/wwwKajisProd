package servlets;

import beans.beanLogin;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

    private Cookie getCookie(Cookie[] cookies, String name) {
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals(name)) {
                    return c;
                }
            }
        }
        return null;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet login</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet login at " + request.getContextPath() + "</h1>");

            ServletContext application = this.getServletContext();

            String msg = null;
            String welcome = null;
            String user = "";
            String fatalError = null;

            if (request.getParameter("doIt") == null) {
                msg = "";
            } else {
                beanLogin login = (beanLogin) application.getAttribute("login");
                if (login == null) {
                    login = new beanLogin();
                    application.setAttribute("login", login);
                }
                if (login.check(request.getParameter("user"),
                        request.getParameter("password"))) {
                    welcome = request.getParameter("user");
                    Cookie c = new Cookie("nom", welcome);
                    response.addCookie(c);
                    c= new Cookie("try", "");
                    c.setMaxAge(0);
                    response.addCookie(c);
                } else {
                    msg = "Utilisateur/Mot de passe invalide !!!";
                    user = request.getParameter("user");

                    Cookie c = getCookie(request.getCookies(), "try");
                    if (c == null) {
                        c = new Cookie("try", "");
                    }
                    c.setValue(c.getValue() + "*");
                    if (c.getValue().length() > 3) {
                        fatalError = "Nombre de tentatives maximum";
                        c.setMaxAge(60 * 2);
                        msg = welcome = null;
                    }
                    response.addCookie(c);
                }
            }

            Cookie cc = getCookie(request.getCookies(), "nom");
            if (cc != null) {
                welcome = cc.getValue();
                msg = null;
            }

            if (request.getParameter("deconnect") != null) {
                Cookie c = new Cookie("nom", welcome);
                c.setMaxAge(0);
                response.addCookie(c);
                if (cc != null) {
                    user = cc.getValue();
                }
                welcome = null;
                msg = "";
            }

            Cookie c = getCookie(request.getCookies(), "try");
            if (c != null) {
                if (c.getValue().length() > 3) {
                    fatalError = "Nombre de tentatives maximum";
                    msg = welcome = null;
                }
            }
///////////////////////////////////////////////////////////////////            
            if (msg != null) {
                out.println("<FORM METHOD='POST' ACTION='login'>"
                        + "Utilisateur : "
                        + "<INPUT TYPE='TEXT' NAME='user' "
                        + "VALUE='" + user + "'"
                        + "><br>"
                        + "Mot de passe : "
                        + "<INPUT TYPE='PASSWORD' NAME='password'><br>"
                        + "<INPUT TYPE='SUBMIT' NAME='doIt' VALUE='Ok'>"
                        + "</FORM>"
                        + "<FONT COLOR='RED'>"
                        + msg
                        + "</FONT>");
            }
            if (welcome != null) {
                out.println("Bienvenue " + welcome);
                out.println("<br><a HREF='login?deconnect'>Déconnexion</a>");
            }
            if (fatalError != null) {
                out.println(fatalError);
            }

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
