<%-- 
    Document   : verEvaluacion
    Created on : 21-ene-2020, 0:03:34
    Author     : Angela
--%>

<%@page import="entity.Informe"%>
<%@page import="entity.Actividad"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Actividad actividad =(Actividad) request.getAttribute("actividad");
    Informe inf = (Informe) request.getAttribute("informe");
    %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informe</title>
    </head>
    <body>
        <jsp:include page="navigation.jsp" /> 
        <h2>Informe de la actividad <%=actividad.getTitulo() %></h2>
        <fieldset style="width:600px">
            <legend> Valoración del participante sobre la actividad</legend>
            <form action="ValoracionServlet" method ="post">
                <b>Nota (1-5): </b><input type="number" min="1" max="5" name="nota" value="<%= inf.getNotaparticipante() != null ? inf.getNotaparticipante() : "" %>" required><br><br>
                <textarea name="informe" rows="10" cols="80" required><% if(inf.getComentarioparticipante() != null) {%><%= inf.getComentarioparticipante() %><%}else{%>Escriba aquí su valoración...<%}%> </textarea>
                <input type="hidden" value="<%= inf.getIdinforme() %>" name="id"/>
                <br><center><input type="submit" value="Guardar cambios"></center>
            </form>
        </fieldset><br>
                <% if(actividad.getTipoActividad().equals("Aprendizaje-Servicio")) { %>
                <fieldset style="width:600px">
                    <legend> Valoración del profesor sobre el participante </legend>
                    <b>Nota (1-10): </b><%= inf.getNotaprofesor() != null ? inf.getNotaprofesor() : "Sin calificar" %><br><br>
                    <b>Comentario: </b><%= inf.getComentarioprofesor() != null ? inf.getComentarioprofesor() : "Sin calificar" %>
                </fieldset><br>
             <%   } %>

                <fieldset style="width:600px">
                    <legend> Valoración de la ONG sobre el participante </legend>
                    <b>Nota (1-5): </b><%= inf.getNotaong() != null ? inf.getNotaong() : "Sin calificar" %><br><br>
                    <b>Comentario: </b><%= inf.getComentarioong() != null ? inf.getComentarioong() : "Sin calificar" %>
                </fieldset>
    
    </body>
</html>
