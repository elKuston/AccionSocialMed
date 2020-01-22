<%-- 
    Document   : GestionEtiquetas
    Created on : 15-ene-2020, 8:46:21
    Author     : gdiar
--%>

<%@page import="entity.Etiqueta"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestión etiquetas</title>
    </head>
    <%
        List<Etiqueta> e = (List<Etiqueta>)request.getAttribute("et");
        %>
    <body>
        
        <jsp:include page="navigation.jsp" /> 
        
        <h1>Panel de gestión de etiquetas</h1>
        
        <table border="1">
            <tr>
                <th>Etiqueta</th>
                <th>Tipo</th>
                <th>Borrar</th>
            </tr>
            <%for(int i = 0; i < e.size();i++)
            {
                %>
                <tr>
                    <td><%=e.get(i).getEtiqueta()%></td>
                    <%if(e.get(i).getTipo() == 1)
                    {
                        %>
                        <td>Ámbito</td>
                        <%
                    }
                    else
                    {
                        %>
                        <td>Tipo</td>
                        <%
                    }
                    %>
                    
                          <td>
                        <form action="GestionEtiquetas2Servlet" method="post">
                          <input type="hidden" value="<%=e.get(i).getEtiqueta()%>" name="bEt"><input type="submit" name ="option" value="Borrar Etiqueta">
                        </form>
                        </td>
                        
                </tr>
                <%
            }
            %>
            <tr>
                <td colspan="2">
                <form action="GestionEtiquetas2Servlet" method="post">
                    <input required name="nEt" placeholder="Nombre de la Etiqueta" size="30" maxlength="30"><input type="radio" name="tipo" value="1" checked>Ámbito<input type="radio" name="tipo" value="2">Tipo <input type="submit" name="option" value="Nueva Etiqueta">
                </form>
                    </td>
            </tr>
        </table>
    </body>
</html>
