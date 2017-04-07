<%-- 
    Document   : cadastroUsuario
    Created on : 05/04/2017, 22:36:44
    Author     : vinicius
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--banner-->
<div class="row text-center">
    <div class="bannerInterno">
    </div>
</div>

<!-- barra verde -->
<div class="barraVerde verde">
    <div class="row">
        <div class="col-lg-9 col-md-9 col-sm-6 col-xs-6">
            <h3 class="chamada">São mais de 200 opções para você achar uma oportunidade.</h3>
            <h2>Aproveite, é grátis.</h2>
        </div>
    </div>
</div>

<!-- corpo -->
<div class="warapper">
    <div class="container-fluid">
        <section>
            <div class="row resultadoBusca mTop-50">
                <div class="col-lg-2 col-md-2 col-sm-2 col-xs-12">

                </div>
                <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12 center">
                    <span id="textoDestaque">Cadastra-se agora mesmo, é rápido e grátis. São centenas de vagas e oportunidades de você encontrar um emprego ou estágio.</span>
                </div>
                <div class="col-lg-2 col-md-2 col-sm-2 col-xs-12">
                </div>
            </div>

            <div class="row mTop-50">
                <div class="col-lg-2 col-md-1 col-sm-1 col-xs-12"></div>
                <div class="col-lg-8 col-md-10 col-sm-10 col-xs-12">
                    <div class="corpoCadastro">
                        <h3 class="tituloCadastro">CADASTRO DE USUÁRIO</h3>
                        <span class="subtituloCadastro">Dados de Acesso</span>
                        <form class="form-group mTop-20" action="HomeCentral" method="POST">
                            <input type="hidden" name="op" value="cadastrarUsuario"/>
                            <div class="row">
                                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                    <label class="control-label" for="email">E-mail</label>
                                    <input type="mail" name="email" class="form-control" value="${usuario.email}" required="required">
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
                                    <label class="control-label" for="senha">Senha</label>
                                    <input type="password" name="senha" class="form-control">
                                </div>
                                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
                                    <label class="control-label" for="confirmaSenha">Repita a Senha</label>
                                    <input type="password" name="confirmaSenha" class="form-control">
                                </div>
                                <c:if test="${existeErro == true}">
                                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                        <div id="alertSenha" role="alert">  
                                            Senhas não correspondetes.
                                        </div>
                                    </div>
                                </c:if>
                            </div>

                            <div class="row mTop-50">
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                    <span class="subtituloCadastro">Dados Pessoais</span>
                                </div>
                                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 mTop-20">
                                    <label class="control-label" for="nome">Nome</label>
                                    <input type="mail" name="nome" class="form-control" value="${usuario.nome}" required="required">
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
                                    <label class="control-label" for="dataNascimento">Data Nascimento</label>
                                    <input type="date" name="dataNascimento" class="form-control" value="${usuario.datanascimento}" required="required">
                                </div>
                                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
                                    <label class="control-label" for="cpf">CPF</label>
                                    <input type="text" name="cpf" class="form-control" value="${usuario.cpf}" required="required">
                                </div>
                                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
                                    <label class="control-label" for="telefone">Telefone</label>
                                    <input type="text" name="telefone" class="form-control" value="${usuario.telefone}" required="required">
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                    <label class="control-label" for="addFoto">Adicionar Foto</label>
                                    <input type="file" name="addFoto" class="form-control">
                                </div>
                                <div class="col-lg-3 col-md-3 col-sm-6 col-xs-6">
                                </div>
                                <div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 acoes">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-3 col-md-3 col-sm-6 col-xs-6">
                                </div>
                                <div class="col-lg-3 col-md-3 col-sm-6 col-xs-6">
                                </div>
                                <div class="col-lg-3 col-md-3 col-sm-6 col-xs-6">
                                </div>
                                <div class="col-lg-3 col-md-3 col-sm-6 col-xs-6">
                                    <button type="submit" class="btn btnVerdeAcao verde">Cadastrar</button>
                                    <button id="btnAbrirModal" type="button" onclick="abrirModal()" style="display: none">testes</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-lg-2 col-md-1 col-sm-1 col-xs-12"></div>
            </div>
        </section>
    </div>
</div>


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
                            <a href="template.jsp?page=cadastrarUsuario">
                                <figure><img class="iconTipoCadastro" src="img/user.svg" alt="usuario"></figure>
                                <span class="nomeIconCad">Usuário</span>
                            </a>
                        </div>
                        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 center mTop-40">
                            <a href="template.jsp?page=cadastrarEmpresa">
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

<!-- MODAL CADASTRO USUARIO SUCESSO -->
<div class="modal fade" id="cadastroUsuarioSuc">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- Modal Body -->
            <div class="modal-body">
                <div class="form-group">
                    <div class="row">
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 center">
                            <h4 class="bemVindo">SUCESSO!</h4><br>
                            <span class="textoDestaque">Cadastro realizado com sucesso. Agora é só aproveitar, buscar e se cadastrar às vagas de seu interesse.</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- FIM DA MODAL -->

