<%-- 
    Document   : cadastroEmpresa
    Created on : 05/04/2017, 22:39:08
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
			<button class="btn btnAmarelo amarelo" data-toggle="modal" data-target="#tipoCadastro">Cadastra-se</button>
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
					<span id="textoDestaque">Cadastre sua empresa e encontre os melhores profissionais para suas vagas disponíveis.</span>
				</div>
				<div class="col-lg-2 col-md-2 col-sm-2 col-xs-12">
				</div>
			</div>

			<div class="row mTop-50">
				<div class="col-lg-2 col-md-1 col-sm-1 col-xs-12"></div>
				<div class="col-lg-8 col-md-10 col-sm-10 col-xs-12">
					<div class="corpoCadastro">
						<h3 class="tituloCadastro">CADASTRO EMPRESA</h3>
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
								<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6 acoes">
								</div>
							</div>

							<div class="row mTop-50">
								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
									<span class="subtituloCadastro">Dados da Empresa</span>
								</div>
							</div>
							<div class="row mTop-20">
								<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
									<label class="control-label" for="nome">CNPJ</label>
									<input type="text" name="cnpj" class="form-control">
								</div>
							</div>
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<label class="control-label" for="nome">Nome Fantasia</label>
									<input type="mail" name="nomeFantasia" class="form-control">
								</div>
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<label class="control-label" for="nome">Razão Social</label>
									<input type="mail" name="razaoSocial" class="form-control">
								</div>
							</div>
							<div class="row">
								<div class="col-lg-2 col-md-2 col-sm-2 col-xs-4">
									<label class="control-label" for="nome">CEP</label>
									<input type="text" name="cep" class="form-control">
								</div>
								<div class="col-lg-5 col-md-5 col-sm-5 col-xs-12">
									<label class="control-label" for="nome">Logradouro</label>
									<input type="text" name="logradouro" class="form-control">
								</div>
								<div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">
									<label class="control-label" for="nome">Nº</label>
									<input type="text" name="numero" class="form-control">
								</div>
								<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
									<label class="control-label" for="nome">Complemento</label>
									<input type="text" name="complemento" class="form-control">
								</div>
								<div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">
									<label class="control-label" for="nome">Bairro</label>
									<input type="text" name="bairro" class="form-control">
								</div>
								<div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">
									<label class="control-label" for="nome">Cidade</label>
									<input type="text" name="cidade" class="form-control">
								</div>
								<div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">
									<label class="control-label" for="nome">Estado</label>
									<select name="estado" class="form-control">
										<option value="ac">Acre</option>
										<option value="al">Alagoas</option>
										<option value="am">Amazonas</option>
										<option value="ap">Amapá</option>
										<option value="ba">Bahia</option>
										<option value="ce">Ceará</option>
										<option value="df">Distrito Federal</option>
										<option value="es">Espírito Santo</option>
										<option value="go">Goiás</option>
										<option value="ma">Maranhão</option>
										<option value="mt">Mato Grosso</option>
										<option value="ms">Mato Grosso do Sul</option>
										<option value="mg" selected>Minas Gerais</option>
										<option value="pa">Pará</option>
										<option value="pb">Paraiba</option>
										<option value="pr">Paraná</option>
										<option value="pe">Pernambuco</option>
										<option value="pi">Piauí</option>
										<option value="rj">Rio de Janeiro</option>
										<option value="rn">Rio Grande do Norte</option>
										<option value="ro">Rondônia</option>
										<option value="rs">Rio Grande do Sul</option>
										<option value="rr">Roraima</option>
										<option value="sc">Santa Catarina</option>
										<option value="se">Sergipe</option>
										<option value="sp">São Paulo</option>
										<option value="to">Tocantins</option>
									</select>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<label class="control-label" for="nome">Adicionar Logotipo (jpeg ou png)</label>
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
