<%-- 
    Document   : home
    Created on : 05/04/2017, 23:05:25
    Author     : vinicius
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--banner-->
<div class="row text-center">
    <div class="banner">
        <div class="campoBusca">
            <form action="HomeCentral?op=pesquisarVaga" method="POST">
                <input type="text" name="search" class="form-control-search-pricnipal" placeholder="Digite um cargo...">
                <button type="submit" class="btn botaoBusca">Encontrar Vaga</button>
            </form>
        </div>
        <div class="single-item">
            <div>
                <img src="img/banner1.png" alt="banner1">
            </div>
            <div>
                <img src="img/banner2.png" alt="banner1">
            </div>
        </div>
    </div>
</div>

<!-- barra verde -->
<div class="barraVerde verde">
    <div class="row">
        <div class="col-lg-9 col-md-9 col-sm-10 col-xs-9">
            <h3 class="chamada">São mais de 200 opções para você achar uma oportunidade.</h3>
            <h2>Aproveite, é grátis.</h2>
        </div>
        <div class="col-lg-3 col-md-3 col-sm-2 col-xs-3">
            <button class="btn btnAmarelo amarelo" data-toggle="modal" data-target="#tipoCadastro">Cadastra-se</button>
        </div>
    </div>
</div>

<!-- corpo -->
<div class="warapper">
    <div class="container-fluid">
        <section>
            <div class="row mTop-80">
                <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1"></div>
                <div class="tituloSub col-lg-10 col-md-10 col-sm-10 col-xs-10">
                    <h4 class="submenu"><img src="img/linhaAmarela.svg">PRINCIPAIS VAGAS<img src="img/linhaAmarela.svg"></h4>
                </div>
                <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1"></div>
            </div>

            <div class="flex-container">
                <c:forEach var="v" items="${vagas}" >
                    <div class="flex-item">
                        <h4 class="card-title">${v.nome}</h4>
                        <p class="card-text">${v.idEmpresa.cidade} - ${v.idEmpresa.estado}</p>
                        <p>${v.idEmpresa.nomefantasia}</p>
                        <span class="card-label">Descrição</span>
                        <p class="card-descricao">${v.descricaoFormatada}</p>
                        <form action="HomeCentral" method="POST">
                            <input type="hidden" value="detalheVaga" name="op">
                            <input type="hidden" value="${v.id}" name="idVaga">
                            <input class="saibaMais" type="submit" value="saiba mais..">
                        </form>
                        <c:if test="${usuario != null}">
                            <div class="center">
                                <button class="btn btnCandidatar amarelo clickBotaoCandidatarVaga" data-target="#confirmacaoCandidatar" data-toggle="modal" value="${v.id}">Candidatar a vaga</button>
                            </div>
                        </c:if>
                    </div>
                </c:forEach>
            </div>
        </section>

        <section>
            <div class="row">
                <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1"></div>
                <div class="tituloSub col-lg-10 col-md-10 col-sm-10 col-xs-10">
                    <h4 class="submenu"><img src="img/linhaAmarela.svg">ESTATÍSTICAS<img src="img/linhaAmarela.svg"></h4>
                </div>
                <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1"></div>
            </div>

            <div class="row">
                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 center">
                    <div class="contador">
                        <span>254</span>
                        <p>Vagas Preenchidas</p>
                    </div>
                </div>
                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 center">
                    <div class="contador">
                        <span>163</span>
                        <p>Empresas cadastradas</p>
                    </div>
                </div>
                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 center">
                    <div class="contador">
                        <span>451</span>
                        <p>Currículos Cadastrados</p>
                    </div>
                </div>
            </div>
        </section>
    </div>
</div>

