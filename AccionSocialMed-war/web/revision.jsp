<%-- 
    Document   : revisionProfesor
    Created on : 10-dic-2019, 13:45:50
    Author     : jange
--%>

<%@page import="entity.Asignatura"%>
<%@page import="entity.Etiqueta"%>
<%@page import="entity.Actividad"%>
<%@page import="entity.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%Usuario solicitante = (Usuario) request.getAttribute("solicitante"); %>
<%Actividad act = (Actividad) request.getAttribute("acti"); %>
<%String rolSolicitante = (String) request.getAttribute("rolSolicitante"); %>
<%String tipo = (String) request.getAttribute("actual"); %>
<%String notificacion = (String) request.getAttribute("notificacion"); %>
<%String direccion = "RevisionProfesorServlet";%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmacion1</title>
    </head>
    <body>
        <fieldset style="width: 400px;">
            <legend>Datos de la actividad</legend> 
        <b>Nombre de la ONG:</b> <%=act.getOng().getUsuario().getNombre()%><br/>
        <b>Nombre de la actividad:</b><%=act.getTitulo()%><br/>
        <b>Descripcion de la actividad:</b> <%=act.getDescripcion()%><br/>
        <b>Tipo de la actividad:</b> <%=act.getTipoActividad()%><br/>
        <b>Etiquetas asociadas de ambito: </b> <br/>
        <%for (Etiqueta et : act.getEtiquetaList()) {%>
        <%if (et.getTipo() == 1) {%>
        <%=et.getEtiqueta() + ", "%> 
        <%}%>
        <%}%>
        <b>Etiquetas asociadas de tipo: </b> 
        <%for (Etiqueta et : act.getEtiquetaList()) {%>
        <%if (et.getTipo() == 1) {%>
        <%=et.getEtiqueta() + ", "%>
        <%}%>
        <%}%>
        </fieldset>

        <br/><br/><br/><br/>

        <fieldset style="width: 400px;">
            <legend>Datos del solicitante</legend> 
        <%if (tipo.equals("profesor")) {%>
        <b>Nombre del solicitante</b> <%=solicitante.getNombre()%><br/>
        <%}%>
        <b>Tipo del solicitante</b> <%=rolSolicitante%><br/>
        <b>Lista de actividades activas</b> 
        <%for(Actividad ac: solicitante.getActividadList()){%>
            <%=ac.getTitulo()+", " %>
        <%}%><br/>
        
        <%if (rolSolicitante.equals("Estudiante")) { %>
        <b>Asignaturas asociadas</b> 
        <%for (Asignatura as : solicitante.getEstudiante().getAsignaturaList()) {%>
        <%=as.getNombreAsignatura() + ", "%> 
        <%}%><br/>
        <%}%>

        <b>Etiquetas asociadas de ambito: </b> 
        <%for (Etiqueta et : solicitante.getEtiquetaList()) {%>
        <%if (et.getTipo() == 1) {%>
        <%=et.getEtiqueta() + ", "%> 
        <%}%>
        <%}%><br/>
        <b>Etiquetas asociadas de tipo: </b> 
        <%for (Etiqueta et : solicitante.getEtiquetaList()) {%>
        <%if (et.getTipo() == 1) {%>
        <%=et.getEtiqueta() + ", "%>
        <%}%>
        <%}%>
        </fieldset>
        <br/><br/><br/>



        <%if (tipo.equals("ong")) {%>
        <%direccion = "RevisionOngServlet";
            }%>
        <form action="<%=direccion%>" method="post">
            <input type="hidden" value="<%=act.getNactividad()%>" name="act">
            <input type="hidden" value="<%=solicitante.getCorreo()%>" name="solicitante">
            <input type="hidden" value="<%=notificacion%>" name="notificacion">
            <input type="submit" value="Aceptar solicitante" name="boton">
            <input type="submit" value="Rechazar solicitante" name="boton">
            <input type="submit" value="Volver" name="boton">
        </form>






    </body>
</html>
