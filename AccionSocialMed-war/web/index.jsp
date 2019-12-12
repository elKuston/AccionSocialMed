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
        
    <center>
        <h1>HOLA SEÑOR </h1><br/><br/>
        
        <h1>TU NOMBRE ES: <%= user.getNombre() %></h1><br/>
        <h1>TU CORREO ES: <%= user.getCorreo() %></h1><br/>
        <h1>TU TIPO ES: <%= request.getSession().getAttribute("tipo") %></h1><br/><br/>
        <h1>El link del iduma es: <%= request.getSession().getAttribute("json") %></h1><br/><br/>
        
        <a  href="CerrarSesionServlet">CERRAR SESION </a><br/><br/>
        <% 
            if(request.getSession().getAttribute("tipo").equals("ong")){//es (PROBABLEMENTE) una ong (hay que refinar bien si esto incluye a alguna no-ong o excluye a alguna ong
                %>
                    <a href ="ProponerActividadServlet">NUEVA ACTIVIDAD</a>
                <%
            }
        %>
        
                <% 
            if(request.getSession().getAttribute("tipo").equals("profesor")){//es (PROBABLEMENTE) una ong (hay que refinar bien si esto incluye a alguna no-ong o excluye a alguna ong
                %>
                    <a href ="IngresarONGServlet">Ingresar ONG</a>
                <%
            }
        %>
        
        <form action="VerActividadServlet" method="post">
            <input type="hidden" value="<%=actividad.getNactividad() %>" name="actividad"/>
            <input type="submit" value="Acceder a actividad" >
        </form>
    </center>
    </body>
</html>
