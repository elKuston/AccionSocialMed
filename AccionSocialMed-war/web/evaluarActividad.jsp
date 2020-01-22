<%-- 
    Document   : evaluarActividad
    Created on : 12-ene-2020, 11:59:18
    Author     : romol
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="entity.Informe"%>
<%@page import="java.util.List"%>
<%@page import="entity.Usuario"%>
<%@page import="entity.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Evaluar actividad</title>
    </head>
    <body>
        <jsp:include page="navigation.jsp" /> 
        <%@include file="messageService.jsp" %>
        <table>
            <tr>
                <th>Nombre del participante</th>
                <th>Evaluado</th>
                <!--<th>Informe</th>-->
                <th>Evaluación</th>
            </tr>
            <%
                List<Usuario> participantes = (List<Usuario>) request.getAttribute("participantes");
                List<String> apellidos = (List<String>) request.getAttribute("apellidos");
                List<Informe> informes = (List<Informe>) request.getAttribute("informes");
                int actividad = Integer.parseInt(request.getParameter("actividad"));
                for(int i=0;i<participantes.size();i++){
                    Usuario p = participantes.get(i);
                    String apellido = apellidos.get(i);
                    Informe inf = informes.get(i);
                    boolean evaluado = inf !=null && inf.getNotaprofesor()!=null;
                    String evaluacion = "";
                    if(evaluado){
                        evaluacion = inf.getNotaprofesor()+"   ";
                    }
                    String urlEvaluar = "\"EvaluarAlumnoServlet?part="+p.getCorreo()+"&act="+actividad+"\"";
                    evaluacion+="<a href="+urlEvaluar+">";
                    evaluacion+=evaluado? "modificar" : "evaluar";
                    evaluacion+="</a>";
                    %>
                    <tr>
                        <td><%= apellido+", "+p.getNombre() %></td>
                        <td><%= evaluado? "Sí" : "No" %></td>
                        <!--<td><a href="verInformeServlet?informe=<%= evaluado? inf.getIdinforme() : "err" %>">Ver informe</a></td>-->
                        <td><%= evaluacion %></td>
                    </tr>
                    <%
                }
                %>
        </table>
    </body>
</html>
