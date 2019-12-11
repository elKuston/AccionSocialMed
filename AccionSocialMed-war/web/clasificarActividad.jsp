<%-- 
    Document   : clasificarActividad
    Created on : 05-dic-2019, 17:43:29
    Author     : romol
--%>
<%@page import="entity.Asignatura"%>
<%@page import="entity.Profesor"%>
<%@page import="java.util.List"%>
<%@page import="entity.Etiqueta"%>
<%@page import="java.util.StringJoiner"%>
<%@page import="java.sql.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="entity.Actividad"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clasificar actividad</title>
    </head>
    <body>
        <%
            Actividad a = (Actividad) request.getAttribute("actividad");
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            String fechaInicio = format.format( a.getFechaInicio());
            String fechaFin = a.getFechaFin()!=null? format.format( a.getFechaFin()) : "No definida";
            StringJoiner ambitos = new StringJoiner(", ");
            StringJoiner tipos = new StringJoiner(", ");
            
            StringJoiner asignaturas = new StringJoiner("\n");
            List<Asignatura> asigs = (List<Asignatura>) request.getAttribute("asignaturas");
            for(Asignatura as : asigs){
                StringBuilder opt = new StringBuilder("<option value=\""+as.getCodAsignatura() +"\">");
                opt.append(as.getNombreAsignatura());
                
                opt.append("</option>");
                asignaturas.add(opt.toString());
            }
            
            StringJoiner profesores = new StringJoiner("\n");
            List<Profesor> profs = (List<Profesor>) request.getAttribute("profesores");
            for(Profesor p : profs){
                StringBuilder opt = new StringBuilder("<option value=\""+p.getCorreo() +"\">");
                opt.append(p.getApellidos()+", "+p.getUsuario().getNombre());
                
                opt.append("</option>");
                profesores.add(opt.toString());
            }
            
            for(Etiqueta e : a.getEtiquetaList() ){
                if(e.getTipo()==1){//Tipo 1
                    ambitos.add(e.getEtiqueta());
                }else{//Tipo 2
                    tipos.add(e.getEtiqueta());
                }
            }
            %>
            <p>Nombre actividad: <%=a.getTitulo()%></p>
            <p>Plazas disponibles: <%=a.getNpersonas()%></p>
            <p>Fecha Inicio: <%=fechaInicio%></p>
            <p>Fecha Fin; <%=fechaFin%></p>
            <p>Descripción: <%= a.getDescripcion() %></p>
            <p>Ámbito(s) actividad: <%= ambitos %> </p>
            <p>Tipo(s) actividad: <%= tipos %> </p>
            
            <form action="ClasificarActividadServlet" method="post">
                <input type="hidden" name ="nActividad" value="<%= a.getNactividad() %>"/>
                Clasificación actividad:
                <select id="tipo" name="tipo" onchange="enableSelects()">
                    <option disabled selected value> -- Selecciona una opción -- </option>
                    <option value="Aprendizaje-Servicio">Aprendizaje-Servicio</option>
                    <option value="Investigación">Investigación</option>
                    <option value="Voluntariado">Voluntariado</option>
                </select>
                <br/>
                <br/>

                Asignatura asociada a la actividad:
                <select id="asignatura" name="asignatura" disabled="true">
                    <option disabled selected value> -- Selecciona una opción -- </option>
                    <%= asignaturas %>
                </select>
                <br/>
                <br/>
                
                Profesor de la actividad:
                <select id="profesor" name="profesor" disabled="true">
                    <option disabled selected value> -- Selecciona una opción -- </option>  
                    <%=profesores%>
                </select>
                <br/>
                <br/>
                <br/>
                <input type="submit" name="accion" value="Clasificar actividad"/>
                <input type="submit" name="accion" value="Descartar actividad"/>
            
            </form>
            
            
            
            
            <script>
                function enableSelects(){
                    var value = document.getElementById("tipo").value;
                    if(value==="Aprendizaje-Servicio"){
                        document.getElementById("asignatura").disabled = false;
                        document.getElementById("profesor").disabled = true;
                    }else if(value==="Investigación"){
                        document.getElementById("profesor").disabled = false;
                        document.getElementById("asignatura").disabled = true;
                    }else{
                        document.getElementById("profesor").disabled = true;
                        document.getElementById("asignatura").disabled = true;
                    }
                }
            </script>
        
    </body>
</html>
