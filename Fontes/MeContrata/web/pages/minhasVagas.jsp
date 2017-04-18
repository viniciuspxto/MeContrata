<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!-- corpo -->
<div class="warapper mTop-120">
    <div class="container-fluid">
        <section>
            
            <div class="row">
                <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1"></div>
                <div class="tituloSub col-lg-10 col-md-10 col-sm-10 col-xs-10 center">
                    <h4 class="submenu"><img src="img/linhaAmarela.svg">MINHAS VAGAS<img src="img/linhaAmarela.svg"></h4>
                </div>
                <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1"></div>
            </div>
            <div clas="row">
                <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2"></div>
                <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 center">
                    <div class="btn-group" role="group" aria-label="...">
                        <button id="btnVagasAbertas" type="button" class="btn btn-default btn-vagas">Vagas Abertas</button>
                        <button id="btnVagasPreenchidas" type="button" class="btn btn-default btn-vagas">Vagas Preenchidas</button>
                    </div>
                </div>
                <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2"></div>
            </div>
            <div id="divVagasAbertas" class="row mTop-80"> 
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="flex-container">
                        
                        <c:forEach var="v" items="${vagas}">
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
                                <form action="HomeCentral" method="POST">
                                    <div class="center">
                                        <input type="hidden" name="op" value="usuariosInscritosVaga">
                                        <input type="hidden" value="${v.id}" name="idVaga">
                                        <button class="btn btnCandidatos verde" type="submit">${v.numeroCandidatosInscritos} candidatos incritos</button>
                                    </div>
                                </form>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
            
            <div id="divVagasPreenchidas" class="row mTop-80"> 
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="flex-container">
                        
                        <c:forEach var="v" items="${vagaspreenchidas}">
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
                                
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </section>
    </div>
</div>