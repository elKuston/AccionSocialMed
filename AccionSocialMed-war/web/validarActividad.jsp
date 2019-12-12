<%-- 
    Document   : validarActividad
    Created on : 12-dic-2019, 8:33:29
    Author     : romol
--%>

<%@page import="entity.Asignatura"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="entity.Actividad"%>
<%@page import="entity.Profesor"%>
<%@page import="java.util.List"%>
<%@page import="java.util.StringJoiner"%>
<%@page import="entity.Etiqueta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
            Actividad a = (Actividad) request.getAttribute("actividad");
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            String fechaInicio = format.format( a.getFechaInicio());
            String fechaFin = a.getFechaFin()!=null? format.format( a.getFechaFin()) : "No definida";
            StringJoiner ambitos = new StringJoiner(", ");
            StringJoiner tipos = new StringJoiner(", ");
            
            for(Etiqueta e : a.getEtiquetaList() ){
                if(e.getTipo()==1){//Tipo 1
                    ambitos.add(e.getEtiqueta());
                }else{//Tipo 2
                    tipos.add(e.getEtiqueta());
                }
            }
            String asignaturaAsociada = a.getTipoActividad().equals("Aprendizaje-Servicio")? "<p>Asignatura asociada: "+a.getAsignaturaAsociada().getNombreAsignatura() : "";
            %>
            <p>Nombre actividad: <%=a.getTitulo()%></p>
            <p>Plazas disponibles: <%=a.getNpersonas()%></p>
            <p>Fecha Inicio: <%=fechaInicio%></p>
            <p>Fecha Fin: <%=fechaFin%></p>
            <p>Descripción: <%= a.getDescripcion() %></p>
            <p>Ámbito(s) actividad: <%= ambitos %> </p>
            <p>Tipo(s) actividad: <%= tipos %> </p>
            <p>Actividad clasificada como: <%= a.getTipoActividad()%></p>
            <%= asignaturaAsociada%>
            
            
            <form>
                <input type="hidden" name ="nActividad" value="<%= a.getNactividad() %>"/>
                <input type="submit" name="accion" value="Aceptar actividad"/>
                <input type="submit" name="accion" value="Rechazar actividad"/>
            </form>
    </body>
</html>
