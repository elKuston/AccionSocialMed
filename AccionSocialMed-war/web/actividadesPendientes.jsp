<%-- 
    Document   : actividadesPendientes
    Created on : 12-dic-2019, 12:09:37
    Author     : romol
--%>

<%@page import="entity.Actividad"%>
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
            List<Actividad> actividades = (List<Actividad>) request.getAttribute("todas");
        
        %>
        
        <table border="3px" >
            <tr>
                <th>Nombre actividad</th>
                <th>Estado</th>
                <th>ONG</th>
                <th>Acciones</th>
            </tr>
            <%
                for(Actividad a : actividades){
                    String estado;
                    String acciones = "<center>---</center>";
                    if(a.getValidada()==null){
                        estado = "Pendiente de clasificación";
                        if(a.getCorreoProfesor()==null&&a.getAsignaturaAsociada()==null){//No ha sido aceptada ni por el profesor ni por el gestor
                            acciones = "<a href=\"ClasificarActividadServlet?act="+a.getNactividad()+"\">Clasificar </a>";
                        }
                    }else{
                        estado = a.getValidada()? "Aceptada" : "Rechazada";
                        if(a.getValidada()){
                            acciones = "<a href=\"VerActividadServlet?actividad="+a.getNactividad()+"\">Ver</a>";
                        }
                    }
                    
                    %>
                    <tr>
                        <td><center><%=a.getTitulo()%></center></td>
                        <td><center><%=estado%></center></td>
                        <td><center><%= a.getOng().getUsuario().getNombre() %></center></td>
                        <td><center><%=acciones%></center></td>
                    </tr>
                    <%
                }
            %>
                
        </table>
    </body>
</html>
