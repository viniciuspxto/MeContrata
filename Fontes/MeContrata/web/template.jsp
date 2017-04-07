<%-- 
    Document   : template
    Created on : 05/04/2017, 18:11:04
    Author     : vinicius
--%>

<%@page import="java.io.File"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="UTF-8">
	<title>Me Contrata</title>

	<meta name="viewport" content="width=device-width, shrink-to-fit=no, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="description" content="Portal de Vagas Me Contrata">
    <meta name="author" content="Vinícius Peixoto">
    <!-- Bootstrap Core CSS -->
    <link href="plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <!-- Custom CSS -->
	<link href="css/style.css" rel="stylesheet" type="text/css"/>
	<!-- Forms Style CSS -->
    <link rel="stylesheet" href="plugins/forms-style/dist/css/bootstrap-select.css">
    <!-- Datepicker CSS -->
    <link rel="stylesheet" href="plugins/datepicker/css/bootstrap-datepicker.standalone.min.css">
    <!-- Slick Slider -->
	<link rel="stylesheet" type="text/css" href="js/slick/slick.css"/>
    <link rel="stylesheet" type="text/css" href="js/slick/slick-theme.css"/>

</head>
<body>

<header class="header">
	<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
		<figure>
			<a href="template.jsp?page=home"><img src="img/logo.svg" alt="Me Contrata"></a>
		</figure>
	</div>
	<div class="users col-lg-6 col-md-6 col-sm-6 col-xs-6">
		<ul class="logins">
			<li id="LoginEmpresa"><a href="#"><img src="img/empresa.svg"> Login Empresa</a></li>
		  	<li id="LoginUsuario"><a href="#"><img src="img/user.svg"> Login Usuário</a></li>
		</ul>
	</div>
</header>

<div id="abaLoginUsuario">
	<p class="textoLogin">Faça login para acessar sua conta.</p>
        <form action="HomeCentral" method="POST">
            <input type="hidden" name="op" value="loginUsuario">
            <input type="text" name="loginUsuario" class="form-control-login" placeholder="Login">
            <input type="password" name="senha" class="form-control-login" placeholder="Senha">
            <c:if test="${loginUsuarioInvalido == true}">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div id="alertLogin" role="alert">  
                        Login ou senha inválidos.
                    </div>
                </div>
            </c:if>
            <button type="submit" class="btn btnVerdeLogin verde">Entrar</button>
        </form>
	<span>ou <a href="template.jsp?page=cadastroUsuario">Cadastre-se</a></span>
</div>

<div id="abaLoginEmpresa">
	<p class="textoLogin">Faça login para acessar sua conta.</p>
	<input type="text" name="loginEmpresa" class="form-control-login" placeholder="Login">
	<input type="password" name="senha" class="form-control-login" placeholder="Senha">
	<button class="btn btnVerdeLogin verde">Entrar</button>
	<span>ou <a href="template.jsp?page=cadastroEmpresa">Cadastre-se</a></span>
</div>
    
<!-- corpo -->

<c:if test="${param.page == null}">
    <jsp:include page="pages/home.jsp" /> 
</c:if>
<c:if test="${param.page != null}">
    <c:set var="pg" value="pages/${param.page}.jsp" /> 

    <%
        //out.print(request.getServletContext().getRealPath("/")+"\\pages\\"+request.getParameter("page")+".jsp");
        File f = new File(request.getServletContext().getRealPath("/") + "/pages/" + request.getParameter("page") + ".jsp");
        if (f.exists()) {
    %>
    <jsp:include page="${pg}" />
    <%} else {%>
    <jsp:include page="pages/404.jsp" />
    <%}%>
</c:if>

<!-- fim do corpo -->

<!-- footer -->
<footer>
	<div class="footerPrincipal verde">

	</div>
	<div class="footerSecundario verdeEscuro">
		<p>Copyright © 2017 - Me Contrata - Todos os direitos reservados.</p>
	</div>
</footer>


<!-- jQuery -->
<script src="js/jquery-3.2.0.min.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="plugins/bootstrap/js/bootstrap.min.js"></script>
<!-- slick slice imagens -->
<script type="text/javascript" src="js/slick/slick.min.js"></script>
<!-- scripts -->
<script src="js/scripts.js"></script>
<!-- Forms Style -->
<script src="plugins/forms-style/dist/js/bootstrap-select.js"></script>
<script src="plugins/forms-style/dist/js/i18n/defaults-pt_BR.min.js"></script>

<!-- Datepicker -->
<script src="plugins/datepicker/js/bootstrap-datepicker.js"></script>
<script src="plugins/datepicker/js/bootstrap-datepicker.pt-BR.min.js" charset="utf-8"></script>

<script>
	function abrirModal(){
		$("#cadastroUsuarioSuc").modal();
	}
</script>

</body>
</html>