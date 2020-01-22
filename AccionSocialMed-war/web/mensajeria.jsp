<%-- 
    Document   : mensajeria
    Created on : 04-ene-2020, 21:23:27
    Author     : jange
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="entity.Mensaje"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    List<Mensaje> lista = (List<Mensaje>) request.getAttribute("lista");
    Boolean entrante = (Boolean) request.getAttribute("entrante");
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy ---- HH:mm:ss");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mensajeria</title>
    </head>
    <body>
 <jsp:include page="navigation.jsp" /> 
        <h1>Mensajería</h1>
        
        <form action="MensajeriaServlet" method="post">
            <input type="submit" value="Entrantes" name="boton">
            <input type="submit" value="Salientes" name="boton">
        </form>
        
        <br/><br/>
       
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
        <%if(entrante==true){%>
             <b>De: </b> <%=mensaje.getEmisor().getNombre()%><br/>
        <%} else{%>
        
             <b>Para: </b> <%=mensaje.getReceptor().getNombre() %><br/>
        <%}%>
        <b>Fecha: </b> 
        <%if(mensaje.getFecha()!=null){%><%=formato.format(mensaje.getFecha()) %> <%}%><br/>
        <b>Titulo: </b> <%=mensaje.getTitulo() %> <br/><br/>
        <%=mensaje.getContenido() %><br/><br/>
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
            <input type="submit" value="Volver">
        </form>
    </body>
</html>
