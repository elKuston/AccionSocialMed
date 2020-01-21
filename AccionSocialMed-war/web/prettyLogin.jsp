<!DOCTYPE html>
<html lang="en" id="cuerpo">
    <head>
        <title>AccionSocialMed</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <!--===============================================================================================-->
    </head>
    <body>
        <script>
            </script>
        <%
             request.getSession().setAttribute("invitado", Boolean.FALSE);
            
            
            
            
            
            if (request.getAttribute("mensaje") != null) {
                String mensaje = (String) request.getAttribute("mensaje");
                request.removeAttribute("mensaje");
        %>
        <script>
                alert("<%=mensaje%>");
        </script>
        <%
                }%>

        <div class="limiter">
            
            <div class="container-login100">
                
                <div class="wrap-login100">
                    <img src="images/Imagen1.png" alt="IMG">
                    <div class="login100-pic js-tilt" data-tilt>
                        
                    </div>
                    
                        <div class="text-center p-t-10">
                            
                            <a class="txt2" href="LoginUmaServlet?guest=1">
                                Iniciar sesi�n como invitado
                                <i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
                            </a><br>
                            <a class="txt2" href="loginUma.jsp">
                                Inicio sesi�n iDUMA
                                <i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
                            </a><br>
                            <a class="txt2" href="loginOng.jsp">
                                Inicio sesi�n ONG
                                <i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
                            </a><br>
                            <a class="txt2" href="iDUMARegistro.jsp">
                                Registro nuevo usuario UMA
                                <i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
                            </a><br>
                            <a class="txt2" href="ongRegister1.jsp">
                                Registro nueva ONG
                                <i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
                            </a><br><br>
                        </div>
                    </form>
                </div>
            </div>
        </div>




        <!--===============================================================================================-->	
        <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/bootstrap/js/popper.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/select2/select2.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/tilt/tilt.jquery.min.js"></script>
        <script >
                $('.js-tilt').tilt({
                    scale: 1.1
                })
        </script>
        <!--===============================================================================================-->
        <script src="js/main.js"></script>
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

    </body>
</html>