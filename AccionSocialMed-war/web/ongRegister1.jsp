<%-- 
    Document   : ongRegister1
    Created on : 24-nov-2019, 23:23:05
    Author     : Angela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <title>ONG Registro 1</title>
        <script src="js/main.js"></script> 
        
    </head>
    <body style="background-color:#9370DB;">
        <div style="float:right">
            <a href="prettyLogin.jsp">Volver</a>
        </div>    
        <br> 
        <center>
            <% if (request.getAttribute("mensaje") != null) {
                String mensaje = (String) request.getAttribute("mensaje");
                request.removeAttribute("mensaje");
        %>
        <script>
                alert("<%=mensaje%>");
        </script>
        <%
                }%>
                
        <h1>Registro de ONG</h1> 
  
         <form action="OngRegister1Servlet" id="form1"> 
             <p> <input name="clave" placeholder=" Introduzca la clave"  id="txtclave" size="30" maxlength="30"><br><br>
            <input name="correo" placeholder=" Introduzca correo ONG (*)" id="txtcorreo" size="30" maxlength="30"><br><br>
            <input type="button" value=" Validar " id="btn1"></p>
        </form>
        </center>     
    
    </body>
</html>