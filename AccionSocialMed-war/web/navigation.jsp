<%-- 
    Document   : navigation
    Created on : 07-ene-2020, 13:22:18
    Author     : romol









    PARA USARLO, COPIAR EL SIGUIENTE CÓDIGO AL *PRINCIPIO* DEL BODY DE LA PÁGINA:
    
    <jsp:include page="navigation.jsp" />
--%>

<%@page import="entity.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <%Usuario user = (Usuario)request.getSession().getAttribute("usuario"); %>
    <div style="float:right">
            <%
            boolean invitado = (Boolean) request.getSession().getAttribute("invitado");
                if(invitado){
                    %>
                    Invitado, <a href="iDUMARegistro.jsp">¡regístrate ya!</a>&nbsp;&nbsp;&nbsp;
                    <%
                }else{
                    %>
                     <a href="IndexServlet">Inicio</a>&nbsp;&nbsp;&nbsp;
                     <a href="PerfilServlet">Mi perfil</a>&nbsp;&nbsp;&nbsp;
                    <%
                }
                %>
                    <a  href="CerrarSesionServlet">Cerrar sesión </a>
        </div>
        
        
        
            <%
            boolean tipo = (Boolean) request.getSession().getAttribute("tipo").equals("ong");
                if(tipo && !invitado){
                    %>
                    <a href ="ProponerActividadServlet">Nueva actividad</a>&nbsp;&nbsp;&nbsp;
                    <a href="PropuestasServlet">Actividades propuestas</a>&nbsp;&nbsp;&nbsp;
                    <a href="MensajeriaServlet">Mensajería</a>
                    
                    
                    <%
                }
                %>   
                
            <%
            tipo = (Boolean) request.getSession().getAttribute("tipo").equals("estudiante") || (Boolean) request.getSession().getAttribute("tipo").equals("pas");
                if(tipo && !invitado){
                    %>
                    <a href="MensajeriaServlet">Mensajería</a>&nbsp;&nbsp;&nbsp;
                    <a href ="InscritasServlet">Actividades inscritas</a>
                    
                    <%
                }
                %>   
        
            <%
            tipo = (Boolean) request.getSession().getAttribute("tipo").equals("profesor");
                if(tipo && !invitado){
                    %>
                    <a href="MensajeriaServlet">Mensajería</a>&nbsp;&nbsp;&nbsp;
                    <a href ="InscritasServlet">Actividades inscritas</a>&nbsp;&nbsp;&nbsp;
                    
                    <%
                }
                %> 
                
            <%
            tipo = (Boolean) request.getSession().getAttribute("tipo").equals("profesor")&&user.getProfesor().getGestor();
                if(tipo && !invitado){
                    %>
                                    <a href="ActividadesPendientesServlet">Actividades pendientes</a>&nbsp;&nbsp;&nbsp;
                                    <a href ="IngresarONGServlet">Gestión ONGs</a>&nbsp;&nbsp;&nbsp;
                <a  href="GestionEtiquetasServlet">Gestión etiquetas </a>
                    <%
                }
                %> 
                
                <br/><br/><br/>
    
</html>
