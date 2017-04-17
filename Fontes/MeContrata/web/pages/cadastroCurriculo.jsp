<%-- 
    Document   : cadastroCurriculo
    Created on : 06/04/2017, 02:33:04
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
                    <span id="textoDestaque">Preencha com suas informações educacionais e suas experiências profissionais. Quanto mais completo seu currículo, maior a chance de ser escolhido por alguma empresa.</span>
                </div>
                <div class="col-lg-2 col-md-2 col-sm-2 col-xs-12">
                </div>
            </div>

            <div class="row mTop-50">
                <div class="col-lg-2 col-md-1 col-sm-1 col-xs-12"></div>
                <div class="col-lg-8 col-md-10 col-sm-10 col-xs-12">
                    <div class="corpoCadastro">
                        <form class="form-group mTop-20" action="HomeCentral" method="POST">
                            <input type="hidden" name="op" value="salvarCurriculo">
                            <h3 class="tituloCadastro">MEU CURRÍCULO</h3>

                            <div class="row mTop-50">
                                <span class="subtituloCadastro mTop-5">Informações Profissionais</span>

                                <div class="row">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <label class="control-label" for="experienciaProfissional">Experiências profissionais, área de atuação, situação atual</label>
                                        <textarea class="form-control" name="experienciaProfissional" rows="6">${usuario.experienciaProfissional}</textarea>
                                    </div>
                                </div>

                                <div class="row mTop-50">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <span class="subtituloCadastro">Informações Acadêmicas</span>
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 mTop-20">
                                        <label class="control-label" for="academico">Formação, cursos, títulos</label>
                                        <textarea class="form-control" name="academico" rows="6">${usuario.formacaoAcademica}</textarea>
                                    </div>
                                </div>
                                    
                                <div class="row">
                                    <div class="col-lg-3 col-md-3 col-sm-6 col-xs-6">
                                    </div>
                                    <div class="col-lg-3 col-md-3 col-sm-6 col-xs-6">
                                    </div>
                                    <div class="col-lg-3 col-md-3 col-sm-6 col-xs-6">
                                    </div>
                                    <div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 direita">
                                        <button class="btn btnVerdeAcao verde">Cadastrar</button>
                                    </div>
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


<!-- MODAL CADASTRO VAGA SUCESSO -->
<div class="modal fade" id="cadastroCurriculoSuc">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- Modal Body -->
            <div class="modal-body">
                <div class="form-group">
                    <div class="row">
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 center">
                            <h4 class="bemVindo">SUCESSO!</h4><br>
                            <span class="textoDestaque">Currículo cadastrado com sucesso. Agora é só aproveitar, buscar e se cadastrar à vaga perfeita para você.</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- FIM DA MODAL -->