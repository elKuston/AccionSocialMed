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
    request.setAttribute("actividad", act);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ver Actividad</title>
    </head>
    <body>
        <h1>Actividad</h1>
        Nombre:<%= act.getTitulo()%> &nbsp &nbsp Tipo de Actividad: <%= act.getNactividad()%><br/><br/>
        Plazas disponibles: <%= plazas%> &nbsp &nbsp Fecha de inicio: <%=act.getFechaInicio()%> &nbsp &nbsp Fecha de fin: <%=act.getFechaFin()%><br/><br/>
        Descripción: <%=act.getDescripcion()%> <br/> <br/>
        Tags: 
        <%for (Etiqueta e : act.getEtiquetaList()) {%>
        <%=e.getEtiqueta()%>
        <%}%>

        <form action="UnirseActividadServlet" method="post">
            <input type="submit" name="boton" value="Quiero unirme"> &nbsp &nbsp <input type="submit" name="boton" value="Volver">
        </form>
    </body>
</html>
