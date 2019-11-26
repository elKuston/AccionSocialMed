<%-- 
    Document   : Register
    Created on : 26-nov-2019, 16:36:57
    Author     : gdiar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
                 <% if(request.getAttribute("mensaje")!=null){
            String mensaje =(String) request.getAttribute("mensaje");
            request.removeAttribute("mensaje");
            %>
            <script>
                alert("<%=mensaje%>");
            </script>
            <%
        }%>
        <h1>Aqui vas y te registras</h1>
        <form action="RegistroServlet" method="post">
            Correo*:<input name="correo" placeholder="Correo" size="30" maxlength="30" /><br/><br/>
            Contraseña*:<input type="password" name="contrasena" placeholder="pass" size="30" maxlength="30" /><br/><br/>
            Telefono:<input name="telefono" placeholder="Telefono" size="30" maxlength="30" /><br/><br/>
            Direccion:<input name="direccion" placeholder="Direccion" size="30" maxlength="30" /><br/><br/>
            Localidad:<input name="localidad" placeholder="Localidad" size="30" maxlength="30" /><br/><br/>
            <!Fecha de nacimiento:<input name="fnacimiento" placeholder="dd/mm/aaaa" size="30" maxlength="30" /><br/><br/>
            <input type="submit" value="Registrarse">
        </form>
    </body>
</html>
