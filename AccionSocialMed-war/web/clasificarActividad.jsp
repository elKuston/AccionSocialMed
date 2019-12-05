<%-- 
    Document   : clasificarActividad
    Created on : 05-dic-2019, 17:43:29
    Author     : romol
--%>

<%@page import="entity.Actividad"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Actividad a = (Actividad) request.getAttribute("actividad");
            %>
        <h1><%=a.getTitulo()%></h1>
    </body>
</html>
