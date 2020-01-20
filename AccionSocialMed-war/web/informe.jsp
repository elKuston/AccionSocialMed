<%-- 
    Document   : informe
    Created on : 09-ene-2020, 11:45:51
    Author     : Angela
--%>

<%@page import="entity.Informe"%>
<%@page import="java.util.List"%>
<%@page import="entity.Actividad"%>
<%@page import="entity.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%
    String nombre =(String) request.getAttribute("nombre");
    Actividad act = (Actividad) request.getAttribute("actividad");
    Informe informe = (Informe) request.getAttribute("informe");
 %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informe</title>
    </head>
    <body>
<jsp:include page="navigation.jsp" /> 
    <center>
        <br>
        <% if (informe.getNotaong()==null) { %>
        <fieldset style="width:400px">
            <h2>Informe de <%= nombre %></h2>
            <form action="GuardarInformeServlet" method="post">
                <b>Actividad: </b><%= act.getTitulo() %> <br><br>
                <b>Nº horas: </b><input type="text" name="horas" size="4" required> &emsp;
                <b>Nota (1-5): </b><input type="number" name="nota" min="1" max="5" required><br>
                <br><textarea name="informe" rows="15" cols="60" placeholder="Escriba aquí el informe" required></textarea><br>
                
                <input type="hidden" value="<%= informe.getIdinforme() %>" name="id"/>

        </fieldset><br>

                       <input type="submit" value="Enviar informe">
            </form>
        <% } else { %>
         <fieldset style="width:400px">
            <h2>Informe de <%= nombre %></h2>
                <b>Actividad: </b><%= act.getTitulo() %> <br><br>
                <b>Nº horas: </b><%= informe.getNhoras() %> &emsp;
                <b>Nota (1-5): </b><%= informe.getNotaong() %><br>
                <br><b>Informe: </b><%= informe.getComentarioong() %><br>
        </fieldset><br>
        
         <% } %>
        <input type="button" value="Volver" onclick="history.back()">
    </center>
        
    </body>
</html>
