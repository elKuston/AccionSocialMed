<%-- 
    Document   : proponerActividad
    Created on : 23-nov-2019, 12:28:19
    Author     : romol
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.List"%>
<%@page import="entity.Etiqueta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date date = new Date();    
        %>
    </head>
    <body>
        <form action="ProponerActividadServlet" method="post">
            <input type="hidden" value="true" name="validar"/>
            <input name="titulo" placeholder="Título" required="true"/>
            <input name="plazas" placeholder="Plazas disponibles" type="number" required="true"/><br/><br/>
            <textarea name="descripcion" placeholder="Dedscripción de la actividad" rows="10" cols="80" required="true"></textarea><br/>
            <input name="lugar" placeholder="Lugar" required="true"/><br/><br/>
            
            <div>
                <p>Fecha inicio (*)</p>
                <input id = "fechaInicio" name="fechaInicio" type="date" min="<%= dateFormat.format(date) %>" onchange="updateMinFin()" required="true"/>
            </div>
            <div>
                <p>Fecha fin</p>
                <input id ="fechaFin" name="fechaFin" type="date"/>
            </div>
            <p>Seleccione el ámbito de la actividad (al menos una opción):</p>
            
            <%
                //etiquetas
                List<Etiqueta> ambitos = (List<Etiqueta>) request.getAttribute("ambitos");
                List<Etiqueta> tipos = (List<Etiqueta>) request.getAttribute("tipos");
                for(Etiqueta e : ambitos){
                    %>
                    <input type="checkbox" name="<%=e.getEtiqueta()%>"/><%=e.getEtiqueta()%> <br/>
                    <%
                }
            %>
            <p>Seleccione el tipo de la actividad (al menos una opción):</p>
            
            <%
                for(Etiqueta e : tipos){
                    %>
                    <input type="checkbox" name="<%=e.getEtiqueta()%>"/><%=e.getEtiqueta()%> <br/>
                    <%
                }
            %>
            <p>Seleccione el turno para la actividad:</p>
            <input type="radio" name="turno" value="mañana" required/>Mañana<br/>
            <input type="radio" name="turno" value="tarde"/>Tarde<br/>
            <br/><input type="submit"/>
            
        </form>
            
            <script>
                function updateMinFin(){
                    var fecha = document.getElementById("fechaInicio").value;
                    document.getElementById("fechaFin").min = fecha;
                }
            </script>
    </body>
</html>
