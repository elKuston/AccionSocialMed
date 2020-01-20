<%-- 
    Document   : IngresarONG
    Created on : 26-nov-2019, 13:58:12
    Author     : gdiar
--%>

<%@page import="java.util.List"%>
<%@page import="entity.Ong"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestion ONG</title>
    </head>
    <body>
        <jsp:include page="navigation.jsp" /> 
                 <% if(request.getAttribute("mensaje")!=null){
            String mensaje =(String) request.getAttribute("mensaje");
            request.removeAttribute("mensaje");
            %>
            <script>
                alert("<%=mensaje%>");
            </script>
            <%
        }%>
        
        <h1>Ingreso de ONGs</h1>
        
        <%
            List<Ong> ongs = (List<Ong>)request.getAttribute("ongs");
                
                %>
                
                <table border="1">
                    <tr>
                        <th>Correo</th>
                        <th>Clave Registro</th>
                        <th>Estado</th>
                        
                    </tr>
                    <%
                        for(int i = 0; i < ongs.size();i++) {
                            if(!ongs.get(i).getClaveRegistro().equals(ongs.get(i).hashCode()+"")) {
                            %>
                             <tr>
                                 <td><%=ongs.get(i).getCorreo()%></td>
                        <td><%=ongs.get(i).getClaveRegistro()%></td>
                        <form action="DarDeBajaServlet" method="post">
                            <td colspan="1"><input name = "bajar" type = "hidden" value="<%=ongs.get(i).getCorreo()%>"><input type="submit" value="Dar de Baja"></td>
                          
      
        </form>
                            </tr>
                            
                            <%
                                }
                        }
                                %>
                    
                                
                                        <tr>
                       <form action="IngresarONGServlet2" method="post">
                           <td colspan="3"><input name="CorreoONG" placeholder="Correo de la ONG" size="30" maxlength="30" /> <input type="submit" value="Ingresar ONG"></td>
                          
      
        </form>
                        
                    </tr>
                </table>
    </body>
</html>
