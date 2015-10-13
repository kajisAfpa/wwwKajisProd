<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Form!</h1>
        
        <jsp:useBean class="beans.beanForm" scope="request" id="requestForm" />
        <jsp:setProperty name="requestForm" property="*" />
        
        Nom : <jsp:getProperty name="requestForm" property="nom" /><br>
        Prenom : <jsp:getProperty name="requestForm" property="prenom" /><br>
        Prenom Nom : <jsp:getProperty name="requestForm" property="prenomNom" /><br>
        
    </body>
</html>
