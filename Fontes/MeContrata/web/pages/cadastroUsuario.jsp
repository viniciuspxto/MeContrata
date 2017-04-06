<%-- 
    Document   : cadastroUsuario
    Created on : 05/04/2017, 22:36:44
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
			<button class="btn btnAmarelo amarelo" onclick="alert('Tela Cadastrar Curriculo')">Cadastra-se</button>
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
                                <form class="form-group mTop-20" action="">
                                        <div class="row">
                                                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                                        <label class="control-label" for="nome">E-mail</label>
                                                        <input type="mail" name="nome" class="form-control">
                                                </div>
                                        </div>

                                        <div class="row">
                                                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
                                                        <label class="control-label" for="nome">Senha</label>
                                                        <input type="password" name="nome" class="form-control">
                                                </div>
                                                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
                                                        <label class="control-label" for="nome">Repita a Senha</label>
                                                        <input type="password" name="nome" class="form-control">
                                                </div>
                                                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
                                                </div>
                                                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
                                                </div>
                                        </div>

                                        <div class="row mTop-50">
                                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                                        <span class="subtituloCadastro">Dados Pessoais</span>
                                                </div>
                                                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 mTop-20">
                                                        <label class="control-label" for="nome">Nome</label>
                                                        <input type="mail" name="nome" class="form-control">
                                                </div>
                                        </div>

                                        <div class="row">
                                                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
                                                        <label class="control-label" for="nome">Data Nascimento</label>
                                                        <input type="text" name="dataNascimento" class="form-control">
                                                </div>
                                                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
                                                        <label class="control-label" for="nome">CPF</label>
                                                        <input type="text" name="cpf" class="form-control">
                                                </div>
                                                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
                                                        <label class="control-label" for="nome">Telefone</label>
                                                        <input type="text" name="telefone" class="form-control">
                                                </div>
                                        </div>

                                        <div class="row">
                                                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                                        <label class="control-label" for="nome">Adicionar Foto</label>
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
                                                        <button class="btn btnVerdeAcao verde">Cadastrar</button>
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
