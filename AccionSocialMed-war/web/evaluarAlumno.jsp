    <%@page import="services.Utils"%>
<%@page import="entity.Usuario"%>
<%@page import="entity.Informe"%>
<%-- 
    Document   : evaluarAlumno
    Created on : 13-ene-2020, 12:13:37
    Author     : romol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Evaluar alumno</title>
    </head>
    <body>
        <jsp:include page="navigation.jsp" /> 
        <%
            Informe informe = (Informe) request.getAttribute("informe");
            Usuario participante = (Usuario) request.getAttribute("participante");
            String apellido = (String) request.getAttribute("apellido");
            String informeInvalido = "El informe solicitado no se encuentra disponible. lamentamos las molestias.";
            boolean informeValido = informe!=null;
        %>
        <table>
            <tr>
                <td>
                    <b>Informe:</b><br/>
                    <p>
                        <% if(!informeValido){%>
                            <%= informeInvalido %>
                        <%}else{%>
                            Puntuación ONG (1-5): <%= informe.getNotaong() %><br/>
                            Número de horas realizadas: <%= informe.getNhoras() %><br/>
                            Comentario de la ONG: <%= informe.getComentarioong() %><br>
                            
                        <%} %>
                        <br/>
                     </p>
                </td>
                <td>
                    <b>Datos del alumno:</b><br/>
                    <p>
                        Nombre: <%= apellido+", "+participante.getNombre() %><br/>
                        Otros datos...
                    </p>
                </td>
            </tr>
        </table>
        <p>Fecha del informe: <%= informeValido?informe.getFechainforme() : "DD/MM/YYYY" %></p>
        <form>
            <input type="hidden" name="act" value="<%= informeValido? informe.getActividad().getNactividad() : "" %>"/>
            <input type="hidden" name="part" value="<%= informeValido? participante.getCorreo() : "" %>"/>
            Calificación: <input type="number" min="0" max="10" name="evaluacion" value="<%= informeValido? (informe.getNotaprofesor()!=null? informe.getNotaprofesor(): "") : "" %>" required/><br/>
            Comentario:<br>
            <textarea name="comentario" cols="50" rows="5" ><%= informeValido? (informe.getComentarioprofesor()!=null? informe.getComentarioprofesor() : "") : "" %></textarea>
            <br/>
            <input type="submit" name ="guardar" value="Gardar Evaluación" />
        </form>
    </body>
</html>
