

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

		// SLICK SLIDER
		$('.single-item').slick({
			dots: true,
			autoplay: true,
			autoplaySpeed: 2000,
		});


	});
