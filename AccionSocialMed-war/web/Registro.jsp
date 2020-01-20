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
        <title>Registro</title>
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
        <%
            HttpSession sesion = request.getSession();
            String corr = (String) sesion.getAttribute("correo2");
            String cn = (String) sesion.getAttribute("ocupation");
            String nombre = (String) sesion.getAttribute("name");
            String apellidos = (String) sesion.getAttribute("apellidos");
            %>
        <h1>Registro Usuario</h1>
        <form action="RegistroServlet" method="post">
            Usuario: <%=corr%> <br/><br/>
            Nombre: <%=nombre%> <%=apellidos%><br/><br/>
            <input type="hidden" name="correo" value= "<%=corr%>" size="30" maxlength="30" required="true" />
            <input type="hidden" name="cn" value= "<%=cn%>" size="30" maxlength="30" required="true" />
            <input type="hidden" name="contrasena" value="rellenar" size="30" maxlength="30" required="true" />
            <input type="hidden" name="nombre" value="<%=nombre%>" size="30" maxlength="30" /><br/><br/>
            <input type="hidden" name="apellidos" placeholder="<%=apellidos%>" size="30" maxlength="30" />
            Telefono:<input name="telefono" placeholder="Telefono" size="30" maxlength="30" /><br/><br/>
            Direccion:<input name="direccion" placeholder="Direccion" size="30" maxlength="30" /><br/><br/>
            Localidad:<input name="localidad" placeholder="Localidad" size="30" maxlength="30" /><br/><br/>
            <!Fecha de nacimiento:<input name="fnacimiento" placeholder="dd/mm/aaaa" size="30" maxlength="30" /><br/><br/>
            <input type="submit" value="Registrarse">
        </form>
    </body>
</html>
