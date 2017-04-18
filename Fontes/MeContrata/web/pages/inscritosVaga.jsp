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
            <div class="row mTop-30"> 
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="flex-container">

                        <c:forEach var="cv" items="${candidatosVaga}">
                            <div class="flex-item-detalhe-inscrito">
                                <div class="row">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <h4 class="card-title">${cv.idCandidato.nome}</h4>
                                    </div>

                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 mTop-20">
                                        <span class="card-label">Dados Pessoais</span>
                                    </div>
                                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                                        <label class="control-label" for="">E-mail</label>
                                        <p>${cv.idCandidato.email}</p>
                                    </div>
                                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                                        <label class="control-label" for="">Data Nascimento</label>
                                        <p>${cv.idCandidato.dataFormatada}</p>
                                    </div>
                                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                                        <label class="control-label" for="">CPF</label>
                                        <p>${cv.idCandidato.cpf}</p>
                                    </div>

                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 mTop-20">
                                        <span class="card-label">Informações Profissionais</span>
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <label class="control-label" for="">Experiências Proficionais</label>
                                        <p>${cv.idCandidato.experienciaProfissional}</p>
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 mTop-20">
                                        <span class="card-label">Informações Acadêmicas</span>
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <label class="control-label" for="">Formação, cursos, títulos</label>
                                        <p>${cv.idCandidato.formacaoAcademica}</p>
                                    </div>
                                </div>
                                <div class="row center">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 mTop-20">
                                        <button class="btn btnContratar amarelo" value="${cv.id}" data-target="#confirmacaoContratar" data-toggle="modal">Contratar</button>
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
