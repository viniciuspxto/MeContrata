<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- corpo -->
<div class="warapper mTop-120">
    <div class="container-fluid">
        <section>

            <div class="row">
                <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1"></div>
                <div class="tituloSub col-lg-10 col-md-10 col-sm-10 col-xs-10 center">
                    <h4 class="submenu"><img src="img/linhaAmarela.svg">NOTIFICAÇÕES<img src="img/linhaAmarela.svg"></h4>
                </div>
                <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1"></div>
            </div>
            <div class="row mTop-30"> 
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="flex-container">
                        <c:forEach var="n" items="${notificacoes}">
                            <div class="flex-item-detalhe-inscrito">
                                <div class="row">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <p>Você foi selecionado pela empresa <span class="card-label">${n.idCandidatoVaga.idVaga.idEmpresa.nomefantasia}</span> para preencher a vaga de <span class="card-label">${n.idCandidatoVaga.idVaga.nome}</span>.</p>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </section>
    </div>
</div>
