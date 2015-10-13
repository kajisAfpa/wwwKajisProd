<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Login!</h1>
        <FORM METHOD='POST' ACTION='controller'>
            <input type="hidden" name="section" value="login" />
            Utilisateur : <INPUT TYPE='TEXT' NAME='user' VALUE='${user}'><br>
            Mot de passe : <INPUT TYPE='PASSWORD' NAME='password'><br>
            <INPUT TYPE='SUBMIT' NAME='doIt' VALUE='Ok'>
        </FORM>
        <FONT COLOR='RED'>${msg}</FONT>
    </body>
</html>







