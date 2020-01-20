<%-- 
    Document   : index
    Created on : 21-nov-2019, 16:29:42
    Author     : jange
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="entity.Profesor"%>
<%@page import="entity.Actividad"%>
<%@page import="entity.Notificacion"%>
<%@page import="java.util.List"%>
<%@page import="entity.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%Usuario user = (Usuario)request.getAttribute("usuario"); %>
 <%SimpleDateFormat formato= new SimpleDateFormat("dd/MM/yyyy");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
        
    </head>
    <body>
        
        <jsp:include page="navigation.jsp" />  
        
     
        
        <% if(request.getAttribute("mensaje")!=null){
            String mensaje =(String) request.getAttribute("mensaje");
            request.removeAttribute("mensaje");
            %>
            <script>
                alert("<%=mensaje%>");
            </script>
            <%
        }%>
        
        
        
        <%
            boolean invitado = (Boolean) request.getSession().getAttribute("invitado");
            if(!invitado){
                List<Notificacion> notificaciones = (List<Notificacion>) request.getAttribute("pendientes");
                if(notificaciones.size()>0){
                    %>
                    <h2><a href="VerNotificacionesServlet"><%=notificaciones.size()%> notificaciones pendientes</a></h2>
                    <%
                }else{
                    %>
                    <h2><a href="VerNotificacionesServlet">Mis notificaciones</a></h2>
                    <%
                }
            }
        %>
        
        <%
            if(!invitado && !request.getSession().getAttribute("tipo").equals("ong")){
                if(request.getSession().getAttribute("screen").equals("match"))
                {
                    %>
                            <form action="IndexServlet" method="post">
                <input type="submit" value="Ver todas las Actividades">
                <input type="hidden" name="all" value="1">
            </form>
                    <%
                }
                else
                {
                    %>
                            <form action="IndexServlet" method="post">
                <input type="submit" value="Matching">
                <input type="hidden" name="match" value="1">
            </form>
                    <%
                }
            }
            %>
            
        <%
            List<Actividad> act = (List<Actividad>) request.getAttribute("actividades");
        %>

        <br/><br/><br/><br/>
    <center>

        
        <%
            if(act.size()>0 && !request.getSession().getAttribute("tipo").equals("ong"))
            {
                %>
                          <table border="1">
            <tr>
                <th>ONG</th>
                <th>Nombre</th>
                <th>Tipo</th>
                <th>Plazas</th>
                <th>Fecha Inicio</th>
                <th>Turno</th>
            </tr>
                
           
                <%
                for(Actividad a: act)
                {
                %>
            <tr>
                <td><%=a.getOng().getUsuario().getNombre()  %></td>
                <td><%=a.getTitulo()%></td>
                <td><%=a.getTipoActividad()%></td>
                <td><%=a.getNpersonas()%></td>
                <td><%=formato.format(a.getFechaInicio())%></td>
                <td>
                <%
                    if(a.getTurnotarde())
                    {
                        %>
                        Tarde
                        <%
                    }
                    else
                    {
                        %>
                        Mañana
                        <%
                    }
                %>
                </td>
                <td>
                    <form action="VerActividadServlet" method="post">
                        <input type="hidden" value="<%=a.getNactividad() %>" name="actividad"/>
                        <input type="submit" value="Acceder a actividad" >
                    </form>              
                    
                </td>
            <tr>
                <%
                } 
                %>
                
                
                
            
        </table>
                
                <%
            }
            else if(!request.getSession().getAttribute("tipo").equals("ong"))
            {
                    if(request.getSession().getAttribute("screen").equals("match"))
                    {
                        %>
                        No hay matches. Quizas, tu perfil esta incompleto, o no hay actividades suficientes en el sistema.<br/><br/>
                        <%
                    }
                    else
                    {
                        %>
                        No hay actividades en el sistema.<br/><br/>
                        <%
                    }
                %>
            <%
            }
            %>

    </center>

    </body>
</html>