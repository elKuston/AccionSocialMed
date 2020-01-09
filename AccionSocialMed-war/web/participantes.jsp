<%-- 
    Document   : participantes
    Created on : 09-ene-2020, 0:47:11
    Author     : Angela
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="entity.Usuario"%>
<%@page import="entity.Actividad"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Actividad act = (Actividad) request.getAttribute("act");
    ArrayList<String> participantesN = (ArrayList<String>) request.getAttribute("participantesN");
    List<Usuario> participantes = (List<Usuario>) request.getAttribute("participantes");
    
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Participantes</title>
    </head>
    <body>
        <div style="float:right">
            <a href="IndexServlet">Inicio</a>
        </div>
        <h1>Participantes en <%= act.getTitulo() %></h1>
        
       <table border="1">
            <tr>
                <th>Participante</th>
                <th>Correo</th>
                <th>Informe</th> 
            </tr>
            
               
                <%
                for(int i = 0; i < participantesN.size(); i++){ %>
                 <form action="InformeServlet" method="post">
                <tr>
                    <td><input type="text" name="nombre" value="<%= participantesN.get(i)%>" readonly></td>
                    <td><input type="text" name="correo" value="<%= participantes.get(i).getCorreo()%>" readonly></td>
                    <td><input type="submit" value="Informe"></td>
                </tr>
                    <% }
                %>
                </form>
            
            
       
       </table>
            <br><input type="button" onclick="history.back()" name="Volver" value="Volver">

    </body>
    
</html>
