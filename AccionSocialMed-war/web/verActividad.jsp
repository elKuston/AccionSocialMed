<%-- 
    Document   : verActividad
    Created on : 03-dic-2019, 21:36:44
    Author     : jange
--%>

<%@page import="entity.Informe"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="entity.Usuario"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="entity.Etiqueta"%>
<%@page import="entity.Actividad"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HttpSession sesion = request.getSession();
    Actividad act = (Actividad) request.getAttribute("actividad");
    int plazas = act.getNpersonas() - act.getUsuarioList().size();
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    String fechaInicio = format.format(act.getFechaInicio());
    String fechaFin = act.getFechaFin() != null ? format.format(act.getFechaFin()) : "No definida";
    Usuario user = (Usuario) sesion.getAttribute("usuario");
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ver Actividad</title>
        
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.checked {
  color: orange;
}

</style>
    </head>
    <body>
<jsp:include page="navigation.jsp" /> 
        
        <h1>Actividad</h1>
        <b>ONG: </b> <%=act.getOng().getUsuario().getNombre() %><br/><br/>
        <b>Nombre:</b><%= act.getTitulo()%> &nbsp &nbsp 
        <b>Tipo de Actividad:</b> <%= act.getTipoActividad()%><br/><br/>
        <b>Plazas disponibles:</b> <%= plazas%> &nbsp &nbsp 
        <b>Fecha de inicio:</b> <%=fechaInicio%> &nbsp &nbsp 
        <b>Fecha de fin:</b> <%=fechaFin%><br/><br/>
        <b>Descripción:</b> <%=act.getDescripcion()%> <br/> <br/>
       <b>Etiquetas asociadas de ambito: </b> 
        <%for (Etiqueta et : act.getEtiquetaList()) {%>
            <%if (et.getTipo() == 1) {%>
                <%=et.getEtiqueta() + ", "%> 
            <%}%>
            <%}%><br/><br/>
        <b>Etiquetas asociadas de tipo: </b> 
        <%for (Etiqueta et : act.getEtiquetaList()) {%>
            <%if (et.getTipo() == 2) {%>
                <%=et.getEtiqueta() + ", "%>
            <%}%>
        <%}%>
        <br/>
        <br/>
        
         <%  boolean finalizada = false;
         if(act.getFechaFin().before(new Date())) {
             finalizada = true;
         }
            if(!sesion.getAttribute("tipo").equals("ong")){
             if (user.getActividadList().contains(act)) {
                if (!finalizada){%>
                <form action="CancelarParticipacionServlet" method="post">
                <input type="submit" name="btnCanc" value="Cancelar participación">
                <input type="hidden" value="<%=act.getNactividad()%>" name="id"/>
                </form><br>

             <%}  } else {
            if(plazas != 0) { %>
            <form action="ConfirmacionUnionProfesorServlet" method="post">
            <input type="hidden" value="<%=act.getNactividad()%>" name="id"/>
            <input type="submit" name="boton" value="Quiero unirme">
            </form>
            <br> 
            <%} else { %>
            Todas las plazas ocupadas, no puedes unirte.
            <%}}}
            if(finalizada) { %>
            <h3><u>Actividad finalizada</u></h3>
            <% }
                if(act.getInformeList().isEmpty()) { %>
                Todavía no se ha comentado la actividad.
            <% } else { %>
    <a style="font-weight: 100; font-size: 20px;">Comentarios</a><div style="border-bottom: 1px solid #dddddd"></div><br/>
    <% for (Informe i : act.getInformeList()) {
        %>
        <b> <%= i.getParticipante().getNombre() %> el <%= formato.format(i.getFechaopinion()) %> :
        <%  if(i.getNotaparticipante() == 0) {%>
            <span class="fa fa-star"></span><span class="fa fa-star"></span><span class="fa fa-star"></span><span class="fa fa-star"></span><span class="fa fa-star"></span>
         <%  } else if(i.getNotaparticipante() == 1) {%>
                    <span class="fa fa-star checked"></span><span class="fa fa-star"></span><span class="fa fa-star"></span><span class="fa fa-star"></span><span class="fa fa-star"></span>
        <%} else if (i.getNotaparticipante() == 2) { %>
                    <span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star"></span><span class="fa fa-star"></span><span class="fa fa-star"></span>
        <% } else if (i.getNotaparticipante() == 3) { %>
         <span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star"></span><span class="fa fa-star"></span>
        <% } else if (i.getNotaparticipante() == 4) { %>
             <span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star"></span>
        <%} else { %>
              <span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star checked"></span>
        <% } %>
              
              <br> <%= i.getParticipante().getCorreo() %> :</b>
              <p><%= i.getComentarioparticipante() %> </p>
             
               <div style="border-bottom: 1px solid #dddddd"></div>
<% } }
 %>
            
    </body>
</html>
