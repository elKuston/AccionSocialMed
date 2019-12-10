<%-- 
    Document   : revisionProfesor
    Created on : 10-dic-2019, 13:45:50
    Author     : jange
--%>

<%@page import="entity.Actividad"%>
<%@page import="entity.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%Usuario solicitante= (Usuario)request.getAttribute("solicitante"); %>
<%Actividad act= (Actividad)request.getAttribute("acti"); %>
<%String rolSolicitante= (String)request.getAttribute("rolSolicitante"); %>
<%String tipo= (String)request.getAttribute("actual"); %>
<%String notificacion= (String)request.getAttribute("notificacion"); %>
<%String direccion= "RevisionProfesorServlet";%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmacion1</title>
    </head>
    <body>
        <b>Nombre de la ONG:</b> <%=act.getOng().getUsuario().getNombre() %><br/>
        <b>Nombre de la actividad:</b><%=act.getTitulo() %><br/>
        <b>Descripcion de la actividad:</b> <%=act.getDescripcion() %><br/>
        <b>Tipo de la actividad:</b> <%=act.getTipoActividad() %><br/>
        <b>Etiquetas asociadas</b> <%=act.getEtiquetaList() %><br/><br/><br/><br/>
        
        <%if(tipo.equals("profesor")){%>
        <b>Nombre del solicitante</b> <%=solicitante.getNombre() %><br/>
        <%}%>
        <b>Tipo del solicitante</b> <%=rolSolicitante %><br/>
        <b>Lista de actividades activas</b> <%=solicitante.getActividadList().toString() %><br/>
        <b>Asignaturas asociadas</b> <%=solicitante.getEstudiante().getAsignaturaList() %><br/>
        <b>Etiquetas asociadas</b> <%=solicitante.getEtiquetaList().toString() %><br/><br/><br/>
        

        
        <%if(tipo.equals("ong")){%>
        <%direccion="RevisionOngServlet";}%>
        <form action="<%=direccion%>" method="post">
            <input type="hidden" value="<%=act.getNactividad() %>" name="act">
            <input type="hidden" value="<%=solicitante.getCorreo() %>" name="solicitante">
            <input type="hidden" value="<%=notificacion %>" name="notificacion">
            <input type="submit" value="Aceptar solicitante" name="boton">
            <input type="submit" value="Rechazar solicitante" name="boton">
            <input type="submit" value="Volver" name="boton">
        </form>
        
        
        
        
            
        
    </body>
</html>
