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
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
            <h3 class="chamada">São mais de 200 opções para você achar uma oportunidade.</h3>
            <h2>Aproveite, é grátis.</h2>
        </div>
    </div>
</div>

<!-- corpo -->
<div class="warapper">
    <div class="container-fluid">
        <section>
            
            <div class="row">
                <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1"></div>
                <div class="tituloSub col-lg-10 col-md-10 col-sm-10 col-xs-10 center">
                    <h4 class="submenu"><img src="img/linhaAmarela.svg">MINHAS VAGAS<img src="img/linhaAmarela.svg"></h4>
                </div>
                <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1"></div>
            </div>
            <div class="row mTop-50"> 
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
                                <div class="center">
                                    <button class="btn btnCandidatos verde">${v.numeroCandidatosInscritos} candidatos incritos</button>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </section>
    </div>
</div>