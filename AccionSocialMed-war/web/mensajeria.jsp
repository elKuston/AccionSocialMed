<%-- 
    Document   : mensajeria
    Created on : 04-ene-2020, 21:23:27
    Author     : jange
--%>

<%@page import="entity.Mensaje"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    List<Mensaje> lista = (List<Mensaje>) request.getAttribute("lista");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mensajeria</title>
    </head>
    <body>
        <h1>Mensajeria</h1>
        <% if(request.getAttribute("mensaje")!=null){
            String mensaje =(String) request.getAttribute("mensaje");
            request.removeAttribute("mensaje");
            %>
            <script>
                alert("<%=mensaje%>");
            </script>
            <%
        }%>
       
        <%if(lista.isEmpty()){%>
        ¡No tienes mensajes! <br/> <br/>
        <%}%>
        
        <form action="EnviarMensajeServlet" method="post">
        <%for(Mensaje mensaje: lista){%>
        <fieldset>
        <b>De: </b> <%=mensaje.getEmisor().getNombre()%><br/>  
        <b>Titulo: </b> <%=mensaje.getTitulo() %> <br/><br/>
        <%=mensaje.getContenido() %><br/>
        <input type="hidden" name="mensaje" value="<%=mensaje.getIdmensajenotificacion() %>" />
        <input type="submit" name="boton" value="Borrar"/><br/>
        </fieldset>
        <%}%>
        </form>
        
        
        <br/><br/>
        <form action="EnviarMensajeServlet" method="post">
        <b>Enviar mensaje:</b><br/><br/>
        <b>Destinatario: </b><input name="destinatario"required="true"/><br/>
        <b>Titulo: </b><input name="titulo" required="true"/><br/>
        <b>Contenido: </b><textarea name="contenido" required="true"></textarea><br/><br/>
        <input type="submit" name="boton" value="Enviar">
        </form>
        <br/>
        <form action="IndexServlet" method="post">
            <input type="submit" value="Volver"><tab/>
        </form>
    </body>
</html>
