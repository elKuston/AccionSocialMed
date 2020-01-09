<%-- 
    Document   : inscritas
    Created on : 16-dic-2019, 12:49:54
    Author     : Angela
--%>

<%@page import="java.util.Iterator"%>
<%@page import="entity.Usuario"%>
<%@page import="entity.Actividad"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

    
List<Actividad> ins= (List<Actividad>) request.getAttribute("al");

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actividades inscritas</title>
    </head>
    <body>
        <h3><div style="float:right">
            <a href="IndexServlet">Inicio</a>
        </div></h3>
        <% if (ins.size()==0) {%>
        <h1>No te has inscrito a ninguna actividad </h1>
        <% } else {%>
        <h1>Tus actividades inscritas: <%= ins.size()%> </h1>
                <% for (Actividad a : ins) { %>  
                
                <form action="VerInscritaServlet" method="post">
                    <h2>- <%= a.getTitulo() %> 
                        <input type="hidden" value="<%=a.getNactividad() %>" name="actividad"/>
                        <input type="submit" value="Ver actividad" >
                    </form>  </h2>
                <form action="VerCertificado" method="post">
                    <input type="hidden" value="<%=a.getNactividad() %>" name="actividad"/>
                    <input type="submit" value="Ver Certificado" >
                </form>  </h2>
                
                <%} }%>

    </body>
</html>