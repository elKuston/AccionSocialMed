<%-- 
    Document   : loginOng
    Created on : 01-dic-2019, 21:25:30
    Author     : jange
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login ONG</title>
    </head>
    <body style="background-color:#a83232;">
    <center>
        <% if (request.getAttribute("mensaje") != null) {
                String mensaje = (String) request.getAttribute("mensaje");
                request.removeAttribute("mensaje");
        %>
        <script>
                alert("<%=mensaje%>");
        </script>
        <%
                }%>
        <h1>AccionSocialMed</h1>
        <br/><br/>
        <h2>Login ONG</h2>
        <br/><br/>
        <form action="LoginOngServlet" method="post">
            Correo:  <input name="correo" placeholder="Usuario" size="30" maxlength="30" required> <br/><br/>
            Contraseña: <input type="password" name="contrasena" placeholder="Contraseña" size="30" maxlength="30" required> <br/><br/>
            <input type="submit" value="Acceder">
            </form>
            <br/><br/>
    </center>
</body>
</html>
