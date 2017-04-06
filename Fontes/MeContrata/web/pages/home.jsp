<%-- 
    Document   : home
    Created on : 05/04/2017, 23:05:25
    Author     : vinicius
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--banner-->
<div class="row text-center">
	<div class="banner">
		<div class="campoBusca">
			<input type="text" name="search" class="form-control-search-pricnipal" placeholder="Digite um cargo, empresa ou localidade">
			<button class="btn botaoBusca" onclick="window.location.href='resultado_busca.html'")">Encontrar Vaga</button>
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
			<div class="row mTop-80">
				<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1"></div>
				<div class="tituloSub col-lg-10 col-md-10 col-sm-10 col-xs-10">
					<h4 class="submenu"><img src="img/linhaAmarela.svg">PRINCIPAIS VAGAS<img src="img/linhaAmarela.svg"></h4>
				</div>
				<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1"></div>
			</div>

			<div class="flex-container">
				<div class="flex-item">
					<h4 class="card-title">Programador Java</h4>
					<p class="card-text">Juiz de Fora - MG</p>
					<p>Empresa: Stefanini</p>
					<span class="card-label">Pré-requisitos</span>
					<p class="card-descricao">Nunc id odio id nibh eleifend cursus vitae at sapien. Phasellus massa arcu, varius vitae euismod quis, ullamcorper eu erat.</p>
					<span class="saibaMais">saiba mais...</span>
					<div class="center">
						<button class="btn btnCandidatar amarelo" onclick="alert('Efetua Cadastro vaga')" onclick="alert('Efetua Cadastro vaga')">Cadastrar a esta vaga</button>
					</div>
				</div>
				<div class="flex-item">
					<h4 class="card-title">Programador Java</h4>
					<p class="card-text">Juiz de Fora - MG</p>
					<p>Empresa: Stefanini</p>
					<span class="card-label">Pré-requisitos</span>
					<p class="card-descricao">Nunc id odio id nibh eleifend cursus vitae at sapien. Phasellus massa arcu, varius vitae euismod quis, ullamcorper eu erat.</p>
					<span class="saibaMais">saiba mais...</span>
					<div class="center">
						<button class="btn btnCandidatar amarelo" onclick="alert('Efetua Cadastro vaga')">Cadastrar a esta vaga</button>
					</div>
				</div>
				<div class="flex-item">
					<h4 class="card-title">Programador Java</h4>
					<p class="card-text">Juiz de Fora - MG</p>
					<p>Empresa: Stefanini</p>
					<span class="card-label">Pré-requisitos</span>
					<p class="card-descricao">Nunc id odio id nibh eleifend cursus vitae at sapien. Phasellus massa arcu, varius vitae euismod quis, ullamcorper eu erat.</p>
					<span class="saibaMais">saiba mais...</span>
					<div class="center">
						<button class="btn btnCandidatar amarelo" onclick="alert('Efetua Cadastro vaga')">Cadastrar a esta vaga</button>
					</div>
				</div>
				<div class="flex-item">
					<h4 class="card-title">Programador Java</h4>
					<p class="card-text">Juiz de Fora - MG</p>
					<p>Empresa: Stefanini</p>
					<span class="card-label">Pré-requisitos</span>
					<p class="card-descricao">Nunc id odio id nibh eleifend cursus vitae at sapien. Phasellus massa arcu, varius vitae euismod quis, ullamcorper eu erat.</p>
					<span class="saibaMais">saiba mais...</span>
					<div class="center">
						<button class="btn btnCandidatar amarelo" onclick="alert('Efetua Cadastro vaga')">Cadastrar a esta vaga</button>
					</div>
				</div>
				<div class="flex-item"><h4 class="card-title">Programador Java</h4>
					<p class="card-text">Juiz de Fora - MG</p>
					<p>Empresa: Stefanini</p>
					<span class="card-label">Pré-requisitos</span>
					<p class="card-descricao">Nunc id odio id nibh eleifend cursus vitae at sapien. Phasellus massa arcu, varius vitae euismod quis, ullamcorper eu erat.</p>
					<span class="saibaMais">saiba mais...</span>
					<div class="center">
						<button class="btn btnCandidatar amarelo" onclick="alert('Efetua Cadastro vaga')">Cadastrar a esta vaga</button>
					</div>
				</div>
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
