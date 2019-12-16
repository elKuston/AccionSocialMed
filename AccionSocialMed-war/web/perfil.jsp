<%-- 
    Document   : perfil
    Created on : 15-dic-2019, 22:54:27
    Author     : Angela
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="entity.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Usuario user = (Usuario) request.getAttribute("usuario");
    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
    
   %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil</title>
    </head>
    <body>
        <div style="float:right">
            <a href="IndexServlet">Inicio</a>
        </div>
        <h1>Perfil de <%= user.getNombre() %></h1>
        <form action="PerfilServlet" method="post">
             <fieldset style="width:400px">
                 <input type="hidden" value="true" name="datos"/>
                   <legend>Datos personales</legend>
                   <br>
                    Nombre: <input type="text" name="nombre" value="<%= user.getNombre()%>" size="40"/> <br><br>
                    <% 
                        if(request.getSession().getAttribute("tipo").equals("ong")){
                    %>
                    Correo: <input type="text" name="correo" value=<%= user.getCorreo()%> size="41" disabled/> <br><br>
                    Contraseña actual: <input type="password" name= "passw" value="<%= user.getOng().getContrasena()%>" size="30" maxlength="30" disabled/><br><br>
                    Nueva contraseña: <input type="password" name = "passw1" placeholder="Introduzca nueva contraseña" size="30" maxlength="30" /><br><br>
                    Repita contraseña: <input type="password" name = "passw2" placeholder="Repita la contraseña" size="30" maxlength="30" /><br><br>
                    
                    <% 
                        } else if (request.getSession().getAttribute("tipo").equals("estudiante")){

                    %>
                    Apellidos: <input type="text" name="app" value="<%=user.getEstudiante().getApellidos() != null ? user.getEstudiante().getApellidos():""%>" size="38"/> <br><br>
                    Correo: <input type="text" name="correo" value=<%= user.getCorreo()%> size="41" disabled/> <br><br>
                    Fecha de nacimiento: <input type="date" name="fnac" <% if (user.getEstudiante().getFechaNacimiento() != null) { %> 
                      value="<%= formato.format(user.getEstudiante().getFechaNacimiento()) %>" <%} %> /> 
                    <% 
                        } else if (request.getSession().getAttribute("tipo").equals("profesor")) {

                    %>
                     Apellidos: <input type="text" name="app" value="<%=user.getProfesor().getApellidos() != null ? user.getProfesor().getApellidos():""%>" size="38"/> <br><br>
                     Correo: <input type="text" name="correo" value=<%= user.getCorreo()%> size="41" disabled/> <br><br>
                     Fecha de nacimiento: <input type="date" name="fnac" 
                                                 <% if (user.getProfesor().getFechaNacimiento() != null) { %> 
                      value="<%= formato.format(user.getProfesor().getFechaNacimiento()) %>" <%} %> />
                    
                      <% } else { 
                    %>
                    
                    Apellidos: <input type="text" name="app" value="<%=user.getPas().getApellidos() != null ? user.getPas().getApellidos():""%>" size="38"/> <br><br>
                    Correo: <input type="text" name="correo" value=<%= user.getCorreo()%> size="41" disabled/> <br><br>
                    Fecha de nacimiento: <input type="date" name="fnac" <% if (user.getProfesor().getFechaNacimiento() != null) { %> 
                      value="<%= formato.format(user.getPas().getFechaNacimiento()) %>" <%} %> />
                    <% 
                        }
                    %>
                    
             </fieldset>
             <br>
             <fieldset style="width:400px">
                   <legend>Información de contacto</legend>
                   <br>
                    Teléfono: <input type="number" name="tlf" value= "<%= user.getTelefono() != null ? user.getTelefono(): ""%>" size="50" maxlength="30" /><br><br>
                    Dirección: <input name="direc" value="<%= user.getDireccion() != null ? user.getDireccion():""%>" size="39" maxlength="30" /><br><br>
                    Localidad: <input name="localidad" value="<%= user.getLocalidad() != null ? user.getLocalidad():""%>" size="39" maxlength="30" /><br><br>
                    
                    <% 
                        if(request.getSession().getAttribute("tipo").equals("ong")){
                    %>
                    Página web: <input name="web" value="<%= user.getOng().getWeb() != null ? user.getOng().getWeb():""%>" size="37" maxlength="30" /><br><br>
                    <% 
                        }
                    %>
             </fieldset>
             
             <br><input type="submit" value="Guardar cambios" name="bt" style="margin-left: 10%">
        </form>            
    </body>
</html>
