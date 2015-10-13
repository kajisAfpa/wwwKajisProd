<%@page import="classes.Item"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Panier !</h1>
        <jsp:include page="jspCatalog.jsp" flush="false" />
        <hr>
        <jsp:useBean class="beans.beanPanier" id="beanPanier" scope="session" />
        <%
            if (request.getParameter("add") != null) {
                beanPanier.add(request.getParameter("add"));
            }
            if (request.getParameter("dec") != null) {
                beanPanier.dec(request.getParameter("dec"));
            }
            if (request.getParameter("del") != null) {
                beanPanier.del(request.getParameter("del"));
            }
            if (request.getParameter("vider") != null) {
                beanPanier.vider();
            }
        %>
        <%
            if (beanPanier.isEmpty()) { %>
        Panier vide.              
        <%} else {
              for (Item i : beanPanier.liste()) {%>
        <%=i.getRef()%>/<%=i.getQty()%>
        <a href="jspPanier.jsp?add=<%=i.getRef()%>">+</a>
        <a href="jspPanier.jsp?dec=<%=i.getRef()%>">-</a>
        <a href="jspPanier.jsp?del=<%=i.getRef()%>">X</a>
        <br>
        <%}%>
        <a href="jspPanier.jsp?vider">Vider le panier.</a>
        <%}%>


    </body>
</html>



