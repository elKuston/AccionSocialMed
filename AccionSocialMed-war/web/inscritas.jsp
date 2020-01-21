<%-- 
    Document   : inscritas
    Created on : 16-dic-2019, 12:49:54
    Author     : Angela
--%>

<%@page import="entity.Informe"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Iterator"%>
<%@page import="entity.Usuario"%>
<%@page import="entity.Actividad"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
SimpleDateFormat formato = new SimpleDateFormat("dd/MM/YYYY");    
HttpSession sesion = request.getSession();
Usuario user = (Usuario) sesion.getAttribute("usuario");
String correo = user.getCorreo();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actividades inscritas</title>
    </head>
    <body>
<jsp:include page="navigation.jsp" /> 
        
        <% if (user.getActividadList().isEmpty()) {%>
        <h2>No te has inscrito a ninguna actividad </h2>
        <% } else {%>
        <h2>Tus actividades inscritas: <%= user.getActividadList().size() %> </h2>
         <table border="1">
            <tr>
                <th>Nombre</th>
                <th>Tipo</th>
                <th>Fecha Inicio</th>
                <th>Fecha Fin</th>
                <th>Turno</th>
                <th>Certificado</th>
                <th>Detalles</th>
                <th>Evaluación</th>
            </tr>
            
                <% for (Actividad a : user.getActividadList()) { %>  
                <tr>
                    <td><b> <%= a.getTitulo() %> </b></td>
                    <td> <%= a.getTipoActividad() %> </td>
                    <td> <%= formato.format(a.getFechaInicio()) %> </td>
                    <td> <%= formato.format(a.getFechaFin()) %> </td>
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
                <% boolean certificado = false;
                if(!a.getInformeList().isEmpty()) {
                    for(Informe i : a.getInformeList()) {
                        if (i.getParticipante().getCorreo().equals(correo)) {
                            if (i.getNotaprofesor() != null) {
                                certificado = true; 
                            } } } } if (certificado) { %>
                            <form action="VerCertificado" method="post">
                                <input type="hidden" value="<%=a.getNactividad() %>" name="actividad"/>
                                 <input type="submit" value="Descargar" >
                                 </form>
                            <%} else {%>
                                    <input type="submit" value="Descargar" disabled> 
                            <%}%>
  
                <td><form action="VerActividadServlet" method="post">
                        <input type="hidden" value="<%=a.getNactividad() %>" name="actividad"/>
                        <input type="submit" value="Ver actividad" >
                    </form>   </td>
                
                <td><form action ="VerEvaluacionServlet" method="post">
                        <input type="hidden" value="<%=a.getNactividad() %>" name="actividad">
                        <%
                            if(a.getFechaFin().before(new Date())) {%>
                                <input type ="submit" value="Evaluación">
                           <% } else { %>
                           No finalizada
                           <% } %>
                        
                    </form>
                    
                </td>
                </tr>
                <%} }%>

    </body>
</html>