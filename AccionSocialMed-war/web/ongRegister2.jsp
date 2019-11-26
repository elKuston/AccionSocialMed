<%-- 
    Document   : ongRegister2
    Created on : 24-nov-2019, 23:26:15
    Author     : Angela
--%>

<%@page import="entity.Usuario"%>
<%@page import="entity.Ong"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%Usuario user = (Usuario)request.getAttribute("usuario");
request.setAttribute("correo", user.getCorreo());%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ONG Registro 2</title>
    </head>
    <body>
       <center>
            
            <h3> ¡Hola <%= user.getNombre() %>!</h3>
            <h3> Tu correo es : <%= user.getCorreo() %></h3>
            
                <form action="OngRegister2Servlet" method="get">
                    <input type="hidden" name="correo" value=<%= user.getCorreo()%> />
                    <input type="password" name= "passw1" placeholder="Nueva contraseña" size="30" maxlength="30" /><br><br>
                    <input type="password" name = "passw2" placeholder="Repita la contraseña" size="30" maxlength="30" /><br><br>
                    <input name="tlf" placeholder="Teléfono" size="30" maxlength="30" /><br><br>
                    <input name="web" placeholder="Web" size="30" maxlength="30" /><br><br>
                    <input name="direc" placeholder="Dirección" size="30" maxlength="30" /><br><br>
                    <input name="localidad" placeholder="Localidad" size="30" maxlength="30" /><br><br>
                    <input type="submit" value="Validar">
        
        </form>
    </center> 
    </body>
</html>
