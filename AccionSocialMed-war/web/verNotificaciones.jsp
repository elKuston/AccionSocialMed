<%-- 
    Document   : verNotificaciones
    Created on : 01-dic-2019, 17:11:58
    Author     : romol
--%>

<%@page import="entity.Notificacion"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
        <%
            List<Notificacion> notificaciones = (List<Notificacion>) request.getAttribute("notificaciones");
            for(Notificacion n : notificaciones){
                if(!n.getLeido()){
                    %>
                    <b>
                    <%
                }
                %>
                <h2><%=n.getContenido()%></h2>
                <%

                if(!n.getLeido()){
                    %>
                    </b>
                    <%
                }
            }
        %>
        <form>
            su
        </form>
    </body>
</html>
