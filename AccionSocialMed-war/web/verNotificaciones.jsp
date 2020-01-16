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
        <title>Notificaciones</title>
        
        <jsp:include page="messageService.jsp" />
    </head>
    <body>
        <div style="float:right">
            <a href="IndexServlet">Inicio</a>
        </div>
        <table>
        <%
            List<Notificacion> notificaciones = (List<Notificacion>) request.getAttribute("notificaciones");
            for(int i = notificaciones.size()-1;i>=0;i--){
                Notificacion n = notificaciones.get(i);
                /*%>
                <tr>
                    <td><p><%=(!n.getLeido()? "<b>" : "") +n.getContenido()+ (!n.getLeido()? "</b>" : "" )%></p><td>
                    <td><p><%=(!n.getLeido()? n.getContenido() : ""%></p><td>

                <%

                if(!n.getLeido()){
                    %>
                <td><button style="display: inline-block" onclick="window.location='VerNotificacionesServlet?mar=<%=n.getIdnotificacion()%>'">Marcar como leído</button><td>
                    
                    <%
                }
                %>
                <tr>
                <% */
                if(!n.getLeido()){
                    %>
                    <tr>
                        <td><p><%=n.getContenido()%></p><td>
                    <td><button style="display: inline-block" onclick="window.location='VerNotificacionesServlet?mar=<%=n.getIdnotificacion()%>'">Marcar como leído</button><td>

                    <tr>
                    <%
                }
                        
            }
        %>
        </table>
    </body>
</html>
