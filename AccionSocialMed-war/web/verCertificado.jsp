<%-- 
    Document   : verCertificado
    Created on : 09-ene-2020, 10:48:13
    Author     : jange
--%>


<%@page import="java.text.SimpleDateFormat"%>
<%@page import="entity.Usuario"%>
<%@page import="entity.Actividad"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Actividad act = (Actividad) request.getAttribute("actividad");
    Usuario us = (Usuario) request.getAttribute("usuario");
    String tipo = (String)request.getSession().getAttribute("tipo");
    SimpleDateFormat formato= new SimpleDateFormat("dd/MM/yyyy");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Certificado</title>
    </head>
    <body>
    <center>
        <h1>Certificado de voluntariado</h1>
        
        El voluntario <%=us.getNombre() %>
        en caracter de  <%=tipo %>,
        ha cumplimentado con exito su periodo de voluntariado en la actividad
        <%=act.getTitulo() %> <br/> organizado por la ONG
        <%=act.getOng().getUsuario().getNombre() %>.<br/><br/>
        La actividad empezó el <%=formato.format(act.getFechaInicio()) %>
        y terminó el <%=formato.format(act.getFechaFin())%> 
        y el profesor tutor de la actividad fue <%=act.getCorreoProfesor().getUsuario().getNombre()%>
        <%=act.getCorreoProfesor().getApellidos() %>.<br>
        La actividad se realizo en caracter de <%=act.getTipoActividad()%>.<br/><br/>
        <h1>Enhorabuena y sigue así</h1>
        <b>Firmado: </b> La UMA.<br/><br/>
        
        <image />
        
     
        
    </center>
    </body>
</html>
