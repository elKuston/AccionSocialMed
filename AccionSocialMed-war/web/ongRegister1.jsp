<%-- 
    Document   : ongRegister1
    Created on : 24-nov-2019, 23:23:05
    Author     : Angela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <title>Registro ONG</title>
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
  
         <form action="OngRegister1Servlet"> 
             <input type="email" name="correo" placeholder=" Introduzca correo ONG"  size="30"  required><br><br>
             <input type="text" name="clave" placeholder=" Introduzca la clave" size="30" required><br><br>
            <input type="submit" value=" Validar " id="btn1">
        </form>
        </center>     
    
    </body>
</html>