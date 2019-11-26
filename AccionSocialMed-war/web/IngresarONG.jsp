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
        
        <h1>Ingreso de ONGs</h1>
        
        <%
            List<Ong> ongs = (List<Ong>)request.getAttribute("ongs");
                
                %>
                
                <table border="1">
                    <tr>
                        <th>Correo</th>
                        <th>Clave Registro</th>
                        
                    </tr>
                    <%
                        for(int i = 0; i < ongs.size();i++) {
                            %>
                             <tr>
                                 <td><%=ongs.get(i).getCorreo()%></td>
                        <td><%=ongs.get(i).getClaveRegistro()%></td>
                            </tr>
                            <%
                        }
                                %>
                    
                                
                                        <tr>
                       <form action="IngresarONGServlet2" method="post">
                           <td colspan="2"><input name="CorreoONG" placeholder="Correo de la ONG" size="30" maxlength="30" /> <input type="submit" value="Ingresar ONG"></td>
                          
      
        <form/>
                        
                    </tr>
                </table>
    </body>
</html>
