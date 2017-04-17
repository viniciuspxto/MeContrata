<%-- 
    Document   : detalheVaga
    Created on : 06/04/2017, 00:27:27
    Author     : vinicius
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
        <div class="col-lg-3 col-md-3 col-sm-6 col-xs-6">
            
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
                    <span id="textoDestaque">Encontre a vaga ideal que você procura:</span>
                    <div class="campoBuscaInterna">
                        <form aciton="HomeCentral" method="POST">
                            <input type="hidden" value="pesquisarVaga" name="op">
                            <input type="text" name="search" class="form-control-search-pricnipal-Interno" placeholder="Digite um cargo...">
                            <button type="submit" class="btn botaoBuscaInterna">Encontrar Vaga</button>
                        </form>
                    </div>
                </div>
                <div class="col-lg-2 col-md-2 col-sm-2 col-xs-12">
                </div>
            </div>

            <div class="row">
                <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1"></div>
                <div class="tituloSub col-lg-10 col-md-10 col-sm-10 col-xs-10 center">
                    <h4 class="submenu"><img src="img/linhaAmarela.svg">DETALHES DA VAGA<img src="img/linhaAmarela.svg"></h4>
                </div>
                <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1"></div>
            </div>

            <div class="row mTop-50">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="flex-container">
                        <div class="flex-item-detalhe">
                            <div class="row">
                                <div class="col-lg-6 col-md-6 col-sm-6 colxs-6">
                                    <h4 class="card-title-detalhe">${vaga.nome}</h4>
                                    <p class="card-text">${vaga.idEmpresa.cidade} - ${vaga.idEmpresa.estado}</p>
                                    <p>${vaga.idEmpresa.nomefantasia}</p>
                                </div>
                                <div class="col-lg-6 col-md-6 col-sm-6 colxs-6 direita">
                                    <span class="glyphicon glyphicon-heart-empty"></span>
                                    <span class="glyphicon glyphicon-thumbs-up"></span>
                                    <span class="glyphicon glyphicon-share"></span>
                                </div>
                            </div>
                            <div class="descVaga">
                                <span class="card-label-detalhe">Descrição</span>
                                <p class="card-descricao">${vaga.descricao}</p>
                            </div>
                            <div class="desVaga">
                                <span class="card-label-detalhe">Pré-requisitos</span>
                                <p class="card-descricao">${vaga.preRequisito}</p>
                            </div>
                            <div class="descVaga">
                                <span class="card-label-detalhe">Benefícios</span>
                                <p class="card-descricao">${vaga.beneficios}</p>
                            </div>

                            <div class="row mTop-30">
                                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 direita">
                                    <button class="btn btnVoltar verde"><a href="HomeCentral?op=pesquisarVaga">Voltar</a></button>
                                </div>
                                <c:if test="${usuario != null}">
                                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 esquerda">
                                        <button class="btn btnCandidatar amarelo">Cadastrar a esta vaga</button>
                                    </div>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </div>
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
                            <a href="cadastro.html">
                                <figure><img class="iconTipoCadastro" src="img/user.svg" alt="usuario"></figure>
                                <span class="nomeIconCad">Usuário</span>
                            </a>
                        </div>
                        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 center mTop-40">
                            <a href="cadastro-empresa.html">
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