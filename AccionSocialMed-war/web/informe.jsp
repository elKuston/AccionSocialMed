<%-- 
    Document   : informe
    Created on : 09-ene-2020, 11:45:51
    Author     : Angela
--%>

<%@page import="entity.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Usuario user =(Usuario) request.getAttribute("user");
 %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informe</title>
    </head>
    <body>
        <fieldset style="width:400px">
                   <legend>Informe de <%= user.getNombre() %></legend>
        </fieldset>
        <br><input type="button" onclick="history.back()" name="Volver" value="Volver">
    </body>
</html>
