<%-- 
    Document   : cadastrarVaga
    Created on : 06/04/2017, 02:31:46
    Author     : vinicius
--%>

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
            <div class="row resultadoBusca mTop-80">
                <div class="row">
                    <div class="col-lg-2 col-md-1 col-sm-1 col-xs-12"></div>
                    <div class="col-lg-8 col-md-10 col-sm-10 col-xs-12">
                        <div class="corpoCadastro">
                            <h3 class="tituloCadastro">CADASTRO DE VAGA</h3>
                            <form class="form-group" action="HomeCentral?op=cadastrarVaga" method="POST">
                                <div class="row">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <label class="control-label" for="nomeVaga">Nome da Vaga</label>
                                        <input type="text" name="nomeVaga" class="form-control" required="required">
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <label class="control-label" for="descricao">Descrição</label>
                                        <textarea name="descricao" class="form-control" rows="3" required="required"></textarea>
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <label class="control-label" for="requistos">Pré-requisitos</label>
                                        <textarea name="requisitos" class="form-control" rows="3" required="required"></textarea>
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <label class="control-label" for="beneficios">Benefícios</label>
                                        <textarea name="beneficios" class="form-control" rows="3" required="required"></textarea>
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
                                        <button type="submit" class="btn btnVerdeAcao verde">Cadastrar</button>
                                    </div>
                                </div>
                            </form>
                            
                        </div>
                    </div>
                    <div class="col-lg-2 col-md-1 col-sm-1 col-xs-12"></div>
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

<!-- MODAL CADASTRO VAGA SUCESSO -->
<div class="modal fade" id="cadastroVagaSuc">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- Modal Body -->
            <div class="modal-body">
                <div class="form-group">
                    <div class="row">
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 center">
                            <h4 class="bemVindo">SUCESSO!</h4><br>
                            <span class="textoDestaque">Vaga cadastrada com sucesso. Agora é só acompanhar os candidatos à essa vaga atravês do menu "Minhas Vagas".</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- FIM DA MODAL -->
