<%-- 
    Document   : informe
    Created on : 09-ene-2020, 11:45:51
    Author     : Angela
--%>

<%@page import="entity.Actividad"%>
<%@page import="entity.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String nombre =(String) request.getAttribute("nombre");
    String correo =(String) request.getAttribute("correo");
    String tipo =(String) request.getAttribute("tipo");
    Actividad act = (Actividad) request.getAttribute("actividad");

 %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informe</title>
    </head>
    <body>
        <div style="float:right">
            <a href="IndexServlet">Inicio</a>
        </div>
    <center>
        <br>
        <fieldset style="width:400px">
            <h2>Informe de <%= nombre %></h2>
            
            <form action="GuardarInformeServlet" method="post">
                <b>Actividad: </b><%= act.getTitulo() %> <br><br>
                <b>Nº horas: </b><input type="text" name="horas" size="4"> &emsp;
                <b>Nota (1-5): </b><input type="number" name="nota" min="1" max="5"><br>
                <br><textarea name="informe" rows="15" cols="60" placeholder="Escriba aquí el informe"></textarea><br>
                <input type="hidden" value="<%=act.getNactividad() %>" name="actividad"/>
                <input type="hidden" value="<%= correo %>" name="correo"/>
                <input type="hidden" value="<%= tipo %>" name="tipo"/>
        </fieldset><br>
        

                       <input type="submit" value="Enviar informe">
            </form>
        <input type="button" value="Volver" onclick="history.back()">
    </center>
        
    </body>
</html>
