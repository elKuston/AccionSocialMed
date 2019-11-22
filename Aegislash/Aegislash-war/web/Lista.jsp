<%-- 
    Document   : Lista
    Created on : 22-nov-2019, 10:52:27
    Author     : jange
--%>

<%@page import="java.util.List"%>
<%@page import="entity.Usuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <h1>Am cute</h1>

        <table class="egt" border="1">
            <tr> 
                <th> Correo</th>
                <th> Nombre</th> 
                <th> Contrasena</th> 
                <th> Clave</th> 
            </tr>
            <%
                List<Usuarios> us = (List<Usuarios>) request.getAttribute("lista");
                for (int i = 0; i < us.size(); i++) {
            %>


            <tr> 
                <td> <%= us.get(i).getCorreo()%></td>
                <td> <%= us.get(i).getNombre()%></td> 
                <td> <%= us.get(i).getContrasena()%></td> 
                <td> 1235</td> 
            </tr>



            <%
                }
            %>
        </table>

        Ingresar la siguiente ONG

        <table class="egt" border="1">
            <tr> 
                <th> Correo</th>
                <th> Nombre</th> 
                <th> Contrasena</th> 
            </tr>
            <tr> 
            <form action="IngresarUsuarioServlet">
                <td> <input name = "correo"></td>
                <td> <input name = "nombre"></td>
                <td> <input name = "contrasena"></td>
                <td><input type="button" value="Ingresar ONG"</td>
            </form>
            </tr>
        </table>    


        
    </center>
</body>
</html>
