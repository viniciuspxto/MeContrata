<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- corpo -->
<div class="warapper">
    <div class="container-fluid">
        <section>
            <div class="row mTop-80">
                <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1"></div>
                <div class="tituloSub col-lg-10 col-md-10 col-sm-10 col-xs-10">
                    <h4 class="submenu"><img src="img/linhaAmarela.svg">MINHAS VAGAS<img src="img/linhaAmarela.svg"></h4>
                </div>
                <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1"></div>
            </div>

            <div class="flex-container">
                <c:forEach var="v" items="${candidatoVagas}" >
                    <div class="flex-item">
                        <h4 class="card-title">${v.idVaga.nome}</h4>
                        <p class="card-text">${v.idVaga.idEmpresa.cidade} - ${v.idVaga.idEmpresa.estado}</p>
                        <p>${v.idVaga.idEmpresa.nomefantasia}</p>
                        <span class="card-label">Descrição</span>
                        <p class="card-descricao">${v.idVaga.descricaoFormatada}</p>
                        <form action="HomeCentral" method="POST">
                            <input type="hidden" value="detalheVaga" name="op">
                            <input type="hidden" value="${v.idVaga.id}" name="idVaga">
                            <input class="saibaMais" type="submit" value="saiba mais..">
                        </form>
                    </div>
                </c:forEach>
            </div>
        </section>
    </div>
</div>
