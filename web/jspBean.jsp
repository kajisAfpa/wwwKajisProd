<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Beans!</h1>
        
        <jsp:useBean class="beans.monBean" scope="page" id="beanPage" />
        <jsp:useBean class="beans.monBean" scope="request" id="beanRequest" />
        <jsp:useBean class="beans.monBean" scope="session" id="beanSession" />
        <jsp:useBean class="beans.monBean" scope="application" id="beanApplication" />
        
        
        Page : <%=beanPage.getDate()%><br>
        Request : <%=beanRequest.getDate()%><br>
        Session : <%=beanSession.getDate()%><br>
        Application : <%=beanApplication.getDate()%><br>
        <hr>
        Page : <jsp:getProperty name="beanPage" property="date" /><br>
        Request : <jsp:getProperty name="beanRequest" property="date" /><br>
        Session : <jsp:getProperty name="beanSession" property="date" /><br>
        Application : <jsp:getProperty name="beanApplication" property="date" /><br>
        
        
        
    </body>
</html>











