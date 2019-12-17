<%-- 
    Document   : verActividad
    Created on : 03-dic-2019, 21:36:44
    Author     : jange
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="entity.Etiqueta"%>
<%@page import="entity.Actividad"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Actividad act = (Actividad) request.getAttribute("actividad");
    int plazas = act.getNpersonas() - act.getUsuarioList().size();
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    String fechaInicio = format.format(act.getFechaInicio());
    String fechaFin = act.getFechaFin() != null ? format.format(act.getFechaFin()) : "No definida";
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ver Actividad</title>
    </head>
    <body>
        <h1>Actividad</h1>
        <b>ONG: </b> <%=act.getOng().getUsuario().getNombre() %><br/><br/>
        <b>Nombre:</b><%= act.getTitulo()%> &nbsp &nbsp 
        <b>Tipo de Actividad:</b> <%= act.getTipoActividad()%><br/><br/>
        <b>Plazas disponibles:</b> <%= plazas%> &nbsp &nbsp 
        <b>Fecha de inicio:</b> <%=fechaInicio%> &nbsp &nbsp 
        <b>Fecha de fin:</b> <%=fechaFin%><br/><br/>
        <b>Descripción:</b> <%=act.getDescripcion()%> <br/> <br/>
       <b>Etiquetas asociadas de ambito: </b> 
        <%for (Etiqueta et : act.getEtiquetaList()) {%>
            <%if (et.getTipo() == 1) {%>
                <%=et.getEtiqueta() + ", "%> 
            <%}%>
            <%}%><br/><br/>
        <b>Etiquetas asociadas de tipo: </b> 
        <%for (Etiqueta et : act.getEtiquetaList()) {%>
            <%if (et.getTipo() == 2) {%>
                <%=et.getEtiqueta() + ", "%>
            <%}%>
        <%}%>
        <br/>
        <br/>

        <form action="ConfirmacionUnionProfesorServlet" method="post">
            <input type="hidden" value="<%=act.getNactividad()%>" name="id"/>
            <input type="submit" name="boton" value="Quiero unirme"> &nbsp &nbsp <input type="submit" name="boton" value="Volver">
        </form>
    </body>
</html>
