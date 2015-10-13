<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello ${welcome}!</h1>
        <a href="controller?section=login&deconnect">Deconnexion</a><br>
        <a href="controller?section=commande">Catalogue</a> 
    </body>
</html>
