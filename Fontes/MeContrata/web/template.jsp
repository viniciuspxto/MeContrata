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
        <c:if test="${usuario == null && empresa == null}">
            <header class="header">
                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                    <figure>
                        <a href="HomeCentral"><img src="img/logo.svg" alt="Me Contrata"></a>
                    </figure>
                </div>
                <div class="users col-lg-6 col-md-6 col-sm-6 col-xs-6">
                    <ul class="logins">
                        <li id="LoginEmpresa"><a href="#"><img src="img/empresa.svg"> Login Empresa</a></li>
                        <li id="LoginUsuario"><a href="#"><img src="img/user.svg"> Login Usuário</a></li>
                    </ul>
                </div>
            </header>
        </c:if>


        <c:if test="${usuario != null}">
            <header class="header-logado">
                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                    <figure>
                        <a href="HomeCentral"><img src="img/logo.svg" alt="Me Contrata"></a>
                    </figure>
                </div>
                <div id="usuario" class="ol-lg-6 col-md-6 col-sm-6 col-xs-6">
                    <ul class="list-inline">
                        <li id="perfilUsuario" class="listaMenu">Olá, ${usuario.nome}<span class="iconeNome glyphicon glyphicon-chevron-down"></span></li>
                    </ul>
                </div>
            </header>
        </c:if>

        <c:if test="${empresa != null}">
            <header class="header-logado">
                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                    <figure>
                        <a href="HomeCentral"><img src="img/logo.svg" alt="Me Contrata"></a>
                    </figure>
                </div>
                <div id="usuario" class="ol-lg-6 col-md-6 col-sm-6 col-xs-6">
                    <ul class="list-inline">
                        <li id="perfilEmpresa" class="listaMenu">Olá, ${empresa.nomefantasia}<span class="iconeNome glyphicon glyphicon-chevron-down"></span></li>
                    </ul>
                </div>
            </header>
        </c:if>

        <!-- ABA PERFIL -->
        <div id="abaPerfil">
            <ul class="listaUser">
                <li><a href="template.jsp?page=editarPerfil"><img src="img/user.svg"> Editar Perfil</a></li>
                <li><a href="template.jsp?page=cadastroCurriculo"><img src="img/curriculo.svg"> Meu Currículo</a></li>
                <li><a href="HomeCentral?op=notificacoes"><img src="img/notificacoes.svg"> Notificações <span class="badge verde">${notificacoesNaoLidas}</span></a></li>
                <li><a href="HomeCentral?op=vagasCandidatadas"><img src="img/vaga.svg"> Vagas Candidatadas</a></li>
                <li class="logout"><a href="HomeCentral?op=logoutUsuario"><img src="img/logout.svg"> Sair</a></li>
            </ul>
        </div>
        
        <!-- ABA PERFIL EMPRESA -->
        <div id="abaPerfilEmpresa">
            <ul class="listaUser">
                <li><a href="template.jsp?page=cadastroEmpresa"><img src="img/empresa.svg"> Editar Perfil</a></li>
                <li><a href="HomeCentral?op=minhasVagas"><img src="img/vaga.svg"> Minhas Vagas</a></li>
                <li><a href="template.jsp?page=cadastrarVaga"><img src="img/vaga.svg"> Cadastrar Vaga</a></li>
                <li class="logout"><a href="HomeCentral?op=logoutUsuario"><img src="img/logout.svg"> Sair</a></li>
            </ul>
        </div>

        <div id="abaLoginUsuario">
            <p class="textoLogin">Faça login para acessar sua conta.</p>
            <form id="formLogin" name="formLoginUsuario" action="HomeCentral" method="POST">
                <input type="hidden" name="op" value="loginUsuario">
                <input type="text" name="loginUsuario" class="form-control-login" placeholder="E-mail">
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
            <form action="HomeCentral" method="POST">
                <input type="hidden" name="op" value="loginEmpresa">
                <input type="text" name="loginEmpresa" class="form-control-login" placeholder="E-mail">
                <input type="password" name="senha" class="form-control-login" placeholder="senha">
                <c:if test="${loginEmpresaInvalida == true}">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <div id="alertLogin" role="alert">
                            Login ou senha inválidos.
                        </div>
                    </div>
                </c:if>
                <button type="submit" class="btn btnVerdeLogin verde">Entrar</button>
            </form>
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
            function abrirModal() {
                $("#cadastroUsuarioSuc").modal();
            }
        </script>

    </body>
</html>

<!-- MODAL TIPO CADASTRO -->
<div class="modal fade" id="tipoCadastro">
	<div class="modal-dialog">
		<div class="modal-content">
			<!-- Modal Body -->
			<div class="modal-body">
				<div class="form-group">

					<div class="row">
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 center">
							<h4 class="bemVindo">Bem-vindo ao Me Contrata!</h4><br>
							<span class="textoDestaque">Escolha qual tipo de cadastro você deseja criar:</span>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 center mTop-40">
							<a href="template.jsp?page=cadastroUsuario">
								<figure><img class="iconTipoCadastro" src="img/user.svg" alt="usuario"></figure>
								<span class="nomeIconCad">Usuário</span>
							</a>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 center mTop-40">
							<a href="template.jsp?page=cadastroEmpresa">
								<figure><img class="iconTipoCadastro" src="img/empresa.svg" alt="usuario"></figure>
								<span class="nomeIconCad">Empresa</span>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- FIM DA MODAL -->

<!-- MODAL CONFIRMAR CANDIDATURA -->
<div class="modal fade" id="confirmacaoCandidatar">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- Modal Body -->
            <div class="modal-body">
                <div class="form-group">
                    <div class="row">
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 center">
                            <h4 class="bemVindo">CANDIDATAR A VAGA</h4><br>
                            <span class="textoDestaque">Você confirma que quer se candidatar a essa vaga?</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <div class="row">
                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 direita">
                        <button class="btn btnVoltar verde" data-dismiss="modal">Cancelar</button>
                    </div>
                    <form action="HomeCentral" method="POST">
                        <input type="hidden" name="op" value="candidatarVaga">
                        <input id="pegarIdVaga" type="hidden" name="idVaga">
                        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 esquerda">
                            <button type="submit" class="btn btnCandidatar amarelo">Confirmar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- FIM DA MODAL -->

<!-- MODAL CONFIRMAR CONTRATAÇÃO -->
<div class="modal fade" id="confirmacaoContratar">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- Modal Body -->
            <div class="modal-body">
                <div class="form-group">
                    <div class="row">
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 center">
                            <h4 class="bemVindo">CONTRATAR CANDIDATO</h4><br>
                            <span class="textoDestaque">Você confirma o preenchimento da vaga com o candidato selecionado?</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <div class="row">
                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 direita">
                        <button class="btn btnVoltar verde" data-dismiss="modal">Cancelar</button>
                    </div>
                    <form action="HomeCentral" method="POST">
                        <input type="hidden" name="op" value="contratar">
                        <input id="pegarIdCandidatoVaga" type="hidden" name="idCandidatoVaga">
                        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 esquerda">
                            <button type="submit" class="btn btnContratarAmarelo amarelo">Confirmar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- FIM DA MODAL -->