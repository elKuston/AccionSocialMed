<%-- 
    Document   : index
    Created on : 21-nov-2019, 16:29:42
    Author     : jange
--%>

<%@page import="entity.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%Usuario user = (Usuario)request.getAttribute("usuario");%>
<%
   
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <h1>HOLA PUTO AMO </h1><br/><br/>
        
        <h1>TU NOMBRE ES: <%= user.getNombre() %></h1><br/>
        <h1>TU CORREO ES: <%= user.getCorreo() %></h1><br/>
        <h1>TU CONTRASEÑA ES: <%= user.getContrasena() %></h1><br/><br/>
        
        <a  href="CerrarSesionServlet">CERRAR SESION </a><br/><br/>
        <% 
            if(!user.getCorreo().contains("uma.es")){//es (PROBABLEMENTE) una ong (hay que refinar bien si esto incluye a alguna no-ong o excluye a alguna ong
                %>
                    <a href ="ProponerActividadServlet">NUEVA ACTIVIDAD</a>
                <%
            }
        %>
    </center>
    </body>
</html>
