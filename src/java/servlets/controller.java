package servlets;

import beans.beanLogin;
import beans.beanPanier;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "controller", urlPatterns = {"/controller"})
public class controller extends HttpServlet {

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

        System.out.println("+++++"+ request.getParameter("section"));
        
        String url = "/WEB-INF/jspForm.jsp";
        ServletContext application = this.getServletContext();
        HttpSession session = request.getSession();

        if (request.getParameter("section") == null) {
            Cookie cc = getCookie(request.getCookies(), "nom");
            if (cc != null) {
                url = "/WEB-INF/jspWelcome.jsp";
                request.setAttribute("welcome", cc.getValue());
            }
        }

        if ("commande".equals(request.getParameter("section"))) {
            url = "/WEB-INF/jspCommande.jsp";
        }
        if ("catalog".equals(request.getParameter("section"))) {
            url = "/WEB-INF/jspCatalog.jsp";
        }
        if ("panier".equals(request.getParameter("section"))) {
            url = "/WEB-INF/jspPanier.jsp";
            beanPanier panier = (beanPanier) session.getAttribute("panier");
            if (panier == null) {
                panier = new beanPanier();
                session.setAttribute("panier", panier);
            }
            request.setAttribute("panierVide", panier.isEmpty());
            request.setAttribute("items", panier.liste());
        }
        if ("calculPanier".equals(request.getParameter("section"))) {
            url = "/WEB-INF/jspCommande.jsp";
            beanPanier panier = (beanPanier) session.getAttribute("panier");
            if (panier == null) {
                panier = new beanPanier();
                session.setAttribute("panier", panier);
            }
            if (request.getParameter("add") != null) {
                panier.add(request.getParameter("add"));
            }
            if (request.getParameter("dec") != null) {
                panier.dec(request.getParameter("dec"));
            }
            if (request.getParameter("del") != null) {
                panier.del(request.getParameter("del"));
            }
            if (request.getParameter("vider") != null) {
                panier.vider();
            }
        }

        if ("login".equals(request.getParameter("section"))) {
            if (request.getParameter("doIt") != null) {
                beanLogin login = (beanLogin) application.getAttribute("login");
                if (login == null) {
                    login = new beanLogin();
                    application.setAttribute("login", login);
                }
                if (login.check(request.getParameter("user"),
                        request.getParameter("password"))) {
                    url = "/WEB-INF/jspWelcome.jsp";
                    request.setAttribute("welcome", request.getParameter("user"));
                    Cookie c = new Cookie("nom", request.getParameter("user"));
                    response.addCookie(c);
                    c = new Cookie("try", "");
                    c.setMaxAge(0);
                    response.addCookie(c);
                } else {
                    url = "/WEB-INF/jspForm.jsp";
                    request.setAttribute("msg", "Utilisateur/Mot de passe invalide !!!");
                    request.setAttribute("user", request.getParameter("user"));

                    Cookie c = getCookie(request.getCookies(), "try");
                    if (c == null) {
                        c = new Cookie("try", "");
                    }
                    c.setValue(c.getValue() + "*");
                    if (c.getValue().length() > 3) {
                        url = "/WEB-INF/jspFatalError.jsp";
                        request.setAttribute("msg", "Nombre de tentatives maximum");
                        c.setMaxAge(60 * 2);
                    }
                    response.addCookie(c);
                }
            }

            Cookie ccc = getCookie(request.getCookies(), "nom");
            if (ccc != null) {
                url = "/WEB-INF/jspWelcome.jsp";
                request.setAttribute("welcome", ccc.getValue());
            }

            if (request.getParameter("deconnect") != null) {
                url = "/WEB-INF/jspForm.jsp";
                Cookie c = new Cookie("nom", "");
                c.setMaxAge(0);
                response.addCookie(c);
                if (ccc != null) {
                    request.setAttribute("user", ccc.getValue());
                }
            }

            Cookie c = getCookie(request.getCookies(), "try");
            if (c != null) {
                if (c.getValue().length() > 3) {
                    url = "/WEB-INF/jspFatalError.jsp";
                    request.setAttribute("msg", "Nombre de tentatives maximum");
                }
            }
        }
        System.out.println(">>>>>" + url);
        request.getRequestDispatcher(url).include(request, response);
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
