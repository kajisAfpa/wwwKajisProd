<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- @page import="classes.Item"%>
<%@page import="java.util.Collection" --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello JSP!</h1>
        No client : <%=request.getAttribute("NOCLIENT")%><br>                
        Derniere visite : <%=request.getAttribute("LASTVISIT")%><br>
        <%--
            Collection<Item> items = (Collection) request.getAttribute("items");
            for (Item i : items) {
                out.println(i.getRef() + "/" + i.getQty() + "<br>");
            }
        --%>
        <hr>        
        No client : ${NOCLIENT}<br>
        Derniere visite : ${LASTVISIT}<br>

    <c:forEach var="i" items="${items}">
        ${i.ref}/${i.qty}<br>
    </c:forEach>


</body>
</html>




