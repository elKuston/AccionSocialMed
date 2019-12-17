<%-- 
    Document   : index
    Created on : 21-nov-2019, 16:29:42
    Author     : jange
--%>

<%@page import="entity.Actividad"%>
<%@page import="entity.Notificacion"%>
<%@page import="java.util.List"%>
<%@page import="entity.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%Usuario user = (Usuario)request.getAttribute("usuario");%>
<%Actividad actividad = (Actividad)request.getAttribute("actividad"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
        <div style="float:right">
            <a href="PerfilServlet">Mi perfil</a>
        </div>
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
        %>
        
        <%
            if(request.getSession().getAttribute("tipo").equals("profesor")&&user.getProfesor().getGestor()){
                %>
                <a href="ActividadesPendientesServlet">Actividades pendientes</a>
                <%
            }
        %>
        
        <%
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
            %>
            
        <%
            List<Actividad> act = (List<Actividad>) request.getAttribute("actividades");
        %>

    <center>

        
        <%
            if(act.size()>0)
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
                <td><%=a.getFechaInicio().toString()%></td>
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
            else
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
           
        
        
        

        
        
        
        
        
        
        
        
        
        
        
        <a  href="CerrarSesionServlet">CERRAR SESION </a><br/><br/>
        <% 
            if(request.getSession().getAttribute("tipo").equals("ong")){//es (PROBABLEMENTE) una ong (hay que refinar bien si esto incluye a alguna no-ong o excluye a alguna ong
                %>
                    <a href ="ProponerActividadServlet">NUEVA ACTIVIDAD</a>
                <%
            }
        %>
        
                <% 
            if(request.getSession().getAttribute("tipo").equals("profesor")&&user.getProfesor().getGestor()){//es (PROBABLEMENTE) una ong (hay que refinar bien si esto incluye a alguna no-ong o excluye a alguna ong
                %>
                    <a href ="IngresarONGServlet">Ingresar ONG</a>
                <%
            }
        %>
        
        <% 
            if(!request.getSession().getAttribute("tipo").equals("ong")){
                %>
                <h1> <a href ="InscritasServlet">Actividades inscritas</a></h1><br/>
                <%
            }
        %>
    </center>

    </body>
</html>
