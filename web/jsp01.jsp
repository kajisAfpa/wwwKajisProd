<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%=new Date()%><hr>
        <%
            for (int i = 1; i <= 6; i++) {%>
    <h<%=i%>><%=i%></h<%=i%>>
        <%  }%>

    <%@include file="inc.jsp" %>

</body>
</html>

<%!
    private Cookie getCookie(Cookie[] cookies, String name) {
        return null;
    }

    private boolean isEmpty(String s) {
        return true;
    }
%>    


