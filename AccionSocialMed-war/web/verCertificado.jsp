<%-- 
    Document   : verCertificado
    Created on : 09-ene-2020, 10:48:13
    Author     : jange
--%>


<%@page import="java.text.SimpleDateFormat"%>
<%@page import="entity.Usuario"%>
<%@page import="entity.Actividad"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Actividad act = (Actividad) request.getAttribute("actividad");
    Usuario us = (Usuario) request.getAttribute("usuario");
    String tipo = (String)request.getSession().getAttribute("tipo");
    SimpleDateFormat formato= new SimpleDateFormat("dd/MM/yyyy");
    String apellidos = (String) request.getAttribute("apellido");
    int nota= (Integer)request.getAttribute("nota");
%>
<html>
    <body id="cuerpo"> 
        <center>
        <style>
        .signature, .title { 
        float:left;
          border-top: 1px solid #000;
          width: 200px; 
          text-align: center;
        }
        </style>
        <div style="width:800px; height:600px; padding:20px; text-align:center; border: 10px solid #787878">
        <div style="width:750px; height:550px; padding:20px; text-align:center; border: 5px solid #787878">
               <span style="font-size:50px; font-weight:bold">Certificado de completitud</span>
               <br><br>
               <span style="font-size:25px"><i>Esto certifica que</i></span>
               <br><br>
               <span style="font-size:30px"><b><%=us.getNombre()%> <%=apellidos %></b></span><br/><br/>
               <span style="font-size:25px"><i>ha completado el voluntariado</i></span> <br/><br/>
               <span style="font-size:30px"><%=act.getTitulo() %></span> <br/><br/>
               <span style="font-size:20px">con la puntuacion de  <b><%=nota%></b></span> <br/><br/><br/><br/>
               <span style="font-size:25px"><i>Completado el dia</i></span><br>
               <span style="font-size:25px"><i><%=formato.format(act.getFechaFin())%> </i></span><br>
        <table style="margin-top:40px;float:left">
        <tr>
        <td><span><b><%=us.getNombre()%> <%=apellidos %></b></td>
        </tr>
        <tr>
        <td style="width:200px;float:left;border:0;border-bottom:1px solid #000;"></td>
        </tr>
        <tr>
        <td style="text-align:center"><span><b>Firmado</b></td>
        </tr>
        </table>
        <table style="margin-top:40px;float:right">
        <tr>
        <td><span><b><%=act.getCorreoProfesor().getUsuario().getNombre()%> <%=act.getCorreoProfesor().getApellidos() %></b></td>
        </tr>
        <tr>
        <td style="width:200px;float:right;border:0;border-bottom:1px solid #000;"></td>
        </tr>
        <tr>
        <td style="text-align:center"><span><b>Firmado</b></td>
        </tr>
        </table>
        </div>
        </div>
        </center>
    
    
    
    
        <script src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.4.1/html2canvas.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.0.272/jspdf.debug.js"></script>
        <script type="text/javascript">
            genPDF();
        function genPDF(){
            console.log("hey");
            html2canvas(document.getElementById("cuerpo"),{
                scale:1,
                onrendered:function(canvas){
                    
                    var img=canvas.toDataURL("image/png");
                    var doc = new jsPDF();
                    doc.addImage(img,'PNG', 0,0,211,9*211/16);
                    doc.save('certificado.pdf');
                }
            });

        }
        
        </script>
    </body>
    
    
    
</html>