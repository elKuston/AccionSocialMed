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
        <title>Registro ONG</title>
    </head>
    <body style="background-color:#9370DB;">
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
            
            <h3> Registro</h3>
            
            
                <form action="OngRegister2Servlet" method="get">
                    <fieldset style="width:400px"><br>
                    Correo: <input type="text" name="correo" value=<%= user.getCorreo()%> readonly size="35"> <br><br>
                    * Nombre: <input type="text" name="nombre" placeholder="Nombre de la ONG" size="31"><br><br>
                    * Contraseña:<input type="password" name= "passw1" placeholder="Nueva contraseña" size="29"  required><br><br>
                    * Repita contraseña: <input type="password" name = "passw2" placeholder="Repita la contraseña" size="22"  required><br><br>
                    Teléfono: <input name="tlf" placeholder="Teléfono" size="33" maxlength="12" ><br><br>
                    Página web: <input name="web" placeholder="Web" size="30"><br><br>
                    Dirección: <input name="direc" placeholder="Dirección" size="31"><br><br>
                    Localidad: <input name="localidad" placeholder="Localidad" size="31" ><br><br>
                    </fieldset><br>
                    <input type="submit" value="Registrar">
        
             </form>
         
    </center> 
    </body>
</html>
