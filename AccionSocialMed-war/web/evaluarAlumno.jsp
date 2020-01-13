    <%-- 
    Document   : evaluarAlumno
    Created on : 13-ene-2020, 12:13:37
    Author     : romol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <tr>
                <td>
                    <b>Informe:</b><br/>
                    <p>
                        Lorem ipsum es el texto que se usa habitualmente en diseño gráfico en demostraciones de ... Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua.
                    </p>
                </td>
                <td>
                    <b>Datos del alumno:</b><br/>
                    <p>
                        Lorem ipsum es el texto que se usa habitualmente en diseño gráfico en demostraciones de ... Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua.
                    </p>
                </td>
            </tr>
        </table>
        <p>Fecha del informe: dd/mm/yyyy</p>
        <form>
            Evaluación: <input type="number" min="0" max="10" id="evaluacion"/><br/>
            Comentario:<br>
            <textarea name="comentario"></textarea>
            <br/>
            <input type="submit" value="Gardar Evaluación" />
        </form>
    </body>
</html>
