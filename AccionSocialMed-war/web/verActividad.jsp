<%-- 
    Document   : verActividad
    Created on : 03-dic-2019, 21:36:44
    Author     : jange
--%>

<%@page import="entity.Etiqueta"%>
<%@page import="entity.Actividad"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Actividad act = (Actividad) request.getAttribute("actividad");
    int plazas = act.getNpersonas() - act.getUsuarioList().size();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ver Actividad</title>
    </head>
    <body>
        <h1>Actividad</h1>
        <b>Nombre:</b><%= act.getTitulo()%> &nbsp &nbsp 
        <b>Tipo de Actividad:</b> <%= act.getTipoActividad() %><br/><br/>
        <b>Plazas disponibles:</b> <%= plazas%> &nbsp &nbsp 
        <b>Fecha de inicio:</b> <%=act.getFechaInicio()%> &nbsp &nbsp 
        <b>Fecha de fin:</b> <%=act.getFechaFin()%><br/><br/>
        <b>Descripción:</b> <%=act.getDescripcion()%> <br/> <br/>
        <b>Tags:</b>
        
        <%for (Etiqueta e : act.getEtiquetaList()) {%>
        <%=e.getEtiqueta()%>
        <%}%>

        <form action="UnirseActividadServlet" method="post">
            <input type="hidden" value="<%=act.getNactividad() %>" name="id"/>
            <input type="submit" name="boton" value="Quiero unirme"> &nbsp &nbsp <input type="submit" name="boton" value="Volver">
        </form>
    </body>
</html>
