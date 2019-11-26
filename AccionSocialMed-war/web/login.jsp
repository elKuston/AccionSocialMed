<%-- 
    Document   : login
    Created on : 21-nov-2019, 16:09:23
    Author     : jange
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
         <% if(request.getAttribute("mensaje")!=null){
            String mensaje =(String) request.getAttribute("mensaje");
            request.removeAttribute("mensaje");
            %>
            <script>
                alert("<%=mensaje%>");
            </script>
            <%
        }%>
        <h1>AccionSocialMed</h1>
        <br/><br/>
        <h2>LOGIN</h2>
        <br/><br/>
        <form action="LoginServlet" method="post">
        <input name="correo" placeholder="Usuario" size="30" maxlength="30" /> <br/><br/>
        <input type="password" name="contrasena" placeholder="Contraseña" size="30" maxlength="30" /> <br/><br/>
        <input type="submit" value="Logearse">
        <form/>
        
        </center>
    </body>
</html>
