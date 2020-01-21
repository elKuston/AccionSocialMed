<%-- 
    Document   : iDUMARegistro
    Created on : 02-dic-2019, 8:07:32
    Author     : gdiar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LoginUma</title>
    </head>
    <body style="background-color:#2f3fa3;">
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
        <h2>IDUMA</h2>
        <br/><br/>
        <form action="iDUMARegistroServlet" method="post">
            Correo:  <input name="correo" placeholder="Usuario" size="30" maxlength="30" /> <br/><br/>
            Contraseña: <input type="password" name="contrasena" placeholder="Contraseña" size="30" maxlength="30" /> <br/><br/>
            <input type="submit" value="Acceder">
            </form>
            <br/><br/>
    </center>
</body>
</html>
