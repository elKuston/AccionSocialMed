<%-- 
    Document   : ongRegister1
    Created on : 24-nov-2019, 23:23:05
    Author     : Angela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ONG Registro 1</title>
    </head>
    <body>
    <center>
        <% if(request.getAttribute("mensaje") != null){
            String mensaje =(String) request.getAttribute("mensaje");
            request.removeAttribute("mensaje");
            %>
            <script>
                alert("<%=mensaje%>");
            </script>
            <%
        }%>
        <h1>Registro de ONG</h1>
        <form action="OngRegister1Servlet" method="get"> 
        <input name="clave" placeholder="Introduzca la clave" size="30" maxlength="30" /><br><br>
        <input name="correo" placeholder="Introduzca correo ONG" size="30" maxlength="30" /><br><br>
        <input type="submit" value="Validar">
        </form>
    </center>    
    </body>
</html>