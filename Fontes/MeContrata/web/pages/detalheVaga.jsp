<%-- 
    Document   : detalheVaga
    Created on : 06/04/2017, 00:27:27
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
					<span id="textoDestaque">Encontre a vaga ideal que você procura:</span>
					<div class="campoBuscaInterna">
						<input type="text" name="search" class="form-control-search-pricnipal-Interno" placeholder="Digite um cargo, empresa ou localidade">
						<button class="btn botaoBuscaInterna" onclick="alert('Abre resultado de busca')">Encontrar Vaga</button>
					</div>
				</div>
				<div class="col-lg-2 col-md-2 col-sm-2 col-xs-12">
				</div>
			</div>

			<div class="row">
				<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1"></div>
				<div class="tituloSub col-lg-10 col-md-10 col-sm-10 col-xs-10 center">
					<h4 class="submenu"><img src="img/linhaAmarela.svg">RESULTADO DA BUSCA<img src="img/linhaAmarela.svg"></h4>
					<span id="textoDestaque">Foram encontrados 12 resultados 15 vagas para "programador java"</span>
				</div>
				<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1"></div>
			</div>

			<div class="row mTop-50">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="flex-container">
						<div class="flex-item-detalhe">
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6 colxs-6">
									<h4 class="card-title-detalhe">Programador Java <span class="numVaga">(863543873)</span></h4>
									<p class="card-text">Juiz de Fora - MG</p>
									<p>Empresa: Stefanini</p>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-6 colxs-6 direita">
									<span class="glyphicon glyphicon-heart-empty"></span>
									<span class="glyphicon glyphicon-thumbs-up"></span>
									<span class="glyphicon glyphicon-share"></span>
								</div>
							</div>
							<div class="descVaga">
								<span class="card-label-detalhe">Descrição</span>
								<p class="card-descricao">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent dolor orci, tempor sit amet nisl ac, volutpat accumsan mi. Sed volutpat nisi tortor, vel ultricies felis vulputate eu. Sed viverra pharetra tortor a tristique. Cras imperdiet lectus auctor, viverra arcu eu, maximus elit. Aliquam molestie semper interdum. Aliquam pellentesque quam nec lectus volutpat, sollicitudin vestibulum tellus pretium. Etiam dignissim, nisi et luctus vestibulum, ipsum sem rutrum justo, quis blandit felis odio vel erat. Sed sollicitudin nisl at nisl mollis vestibulum. Donec molestie felis eu auctor bibendum. Integer in lectus efficitur, porta odio a, interdum magna. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec auctor felis. Curabitur orci magna, gravida ut odio sed, mattis hendrerit mauris. Etiam vitae placerat quam, sit amet suscipit nisi. Pellentesque pellentesque dapibus magna, eget rhoncus nisl placerat at. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Ut viverra quam eget dolor porta tempus. Fusce tincidunt luctus ligula mattis auctor.</p>
							</div>
							<div class="desVaga">
								<span class="card-label-detalhe">Pré-requisitos</span>
								<p class="card-descricao">Nunc id odio id nibh eleifend cursus vitae at sapien. Phasellus massa arcu, varius vitae euismod quis, ullamcorper eu erat. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent dolor orci, tempor sit amet nisl ac, volutpat accumsan mi. Sed volutpat nisi tortor, vel ultricies felis vulputate eu. Sed viverra pharetra tortor a tristique.</p>
							</div>
							<div class="descVaga">
								<span class="card-label-detalhe">Benefícios</span>
								<p class="card-descricao">Nunc id odio id nibh eleifend cursus vitae at sapien. Phasellus massa arcu, varius vitae euismod quis, ullamcorper eu erat. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent dolor orci, tempor sit amet nisl ac, volutpat accumsan mi. Sed volutpat nisi tortor, vel ultricies felis vulputate eu. Sed viverra pharetra tortor a tristique.</p>
							</div>

							<div class="row mTop-30">
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 direita">
									<button class="btn btnCandidatar verde" onclick="alert('Efetua Cadastro vaga')" onclick="alert('Efetua Cadastro vaga')">Voltar</button>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 esquerda">
									<button class="btn btnCandidatar amarelo" onclick="alert('Efetua Cadastro vaga')" onclick="alert('Efetua Cadastro vaga')">Cadastrar a esta vaga</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>
</div>
