

	jQuery(document).ready(function($) {


		// ABRE FECHA ABA PERFIL
		$('#LoginUsuario').click(function(){
			$('#abaLoginUsuario').toggle();
		});

		$('#LoginEmpresa').click(function(){
			$('#abaLoginEmpresa').toggle();
		});

		$('#perfilUsuario').click(function(){
			$('#abaPerfil').toggle();
		});
                
                $('#perfilEmpresa').click(function(){
			$('#abaPerfilEmpresa').toggle();
		});

		// SLICK SLIDER
		$('.single-item').slick({
			dots: true,
			autoplay: true,
			autoplaySpeed: 2000,
		});
                
                // BOTÃO CANDIDATAR VAGA
                $('.clickBotaoCandidatarVaga').click(function(){
                    $("#pegarIdVaga").val(this.value);                  
                });
                
                // ABRE E MOSTRA VAGAS POR TIPO
                $("#btnVagasAbertas").click(function(){
                   $("#divVagasAbertas").css("display","block");
                   $("#divVagasPreenchidas").css("display","none");
                });
                
                $("#btnVagasPreenchidas").click(function(){
                   $("#divVagasAbertas").css("display","none");
                   $("#divVagasPreenchidas").css("display","block");
                });
                
                // BOTÃO CONTRATAR
                $('.btnContratar').click(function(){
                    $("#pegarIdCandidatoVaga").val(this.value);                  
                });

	});
