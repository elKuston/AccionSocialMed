<%-- 
    Document   : misActividades
    Created on : 07-ene-2020, 20:52:03
    Author     : Angela
--%>

<%@page import="entity.Actividad"%>
<%@page import="java.util.List"%>
<%@page import="entity.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Usuario user = (Usuario) request.getAttribute("usuario");
    List<Actividad> mis= (List<Actividad>) request.getAttribute("mis");
    %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div style="float:right">
            <a href="IndexServlet">Inicio</a>
        </div>
        <h1>Actividades de <%= user.getNombre() %></h1>
        
        <%
            if(mis.isEmpty()) { %>
            
            No tienes actividades
        <% } else { %>
        Tienes <%= mis.size() %> actividades <br><br>
         <table border="1">
            <tr>
                <th>Nombre</th>
                <th>Tipo</th>
                <th>Fecha Inicio</th>
                <th>Fecha Fin</th>
                <th>Turno</th>
                <th>Plazas</th>
                <th>Participantes</th>
            </tr>
                
           
                <%
                for(Actividad a: mis)
                {
                %>
            <tr>
                <td><%=a.getTitulo()%></td>
                <td><%=a.getTipoActividad()%></td>
                <td><%=a.getFechaInicio()%></td>
                <td><%=a.getFechaFin() %></td>
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
                <td><%=a.getNpersonas()%></td>
                <td> <%=a.getUsuarioList().size()%></td>
                <td>
                    <form action="ParticipantesServlet" method="post">
                        <input type="hidden" value="<%=a.getNactividad() %>" name="actividad"/>
                        <%
                            if (a.getUsuarioList().size() > 0){%>
                         <input type="submit" value="Ver participantes" >       
                         <% } else {   %>
                        <input type="submit" value="Ver participantes" disabled>
                          <% } %>  
              
                    </form>              
                    
                </td>
                <td>
                    <form action="VerActividadServlet" method="post">
                        <input type="hidden" value="<%=a.getNactividad() %>" name="actividad"/>
                        <input type="submit" value="Acceder a actividad" >
                    </form>              
                    
                </td>
            <tr>
        <%
            }}
            %>
        
    </body>
</html>
