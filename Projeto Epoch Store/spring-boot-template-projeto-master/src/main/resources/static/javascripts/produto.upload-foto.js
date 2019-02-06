var Epoch = Epoch || {};
Epoch.UploadFoto = (function(){
	function UploadFoto(){
		this.uploadDrop = $('#upload-drop');
		this.containerFoto = $('.js-container-foto'); 
	}
	
	UploadFoto.prototype.iniciar = function(){
		var settings = {
				type:'json',
				filelimit: 1,
				allow: '*.(jpg|jpeg|png)',
				action: '/fotos/'+ this.uploadDrop.data('codigo'),
				complete: onUploadCompleto.bind(this),
				beforeSend: adicionarCsrfToken
		};
		
		UIkit.uploadSelect($('#upload-select'), settings);
		UIkit.uploadDrop(this.uploadDrop, settings);
	}
	
	function onUploadCompleto(foto){
		this.uploadDrop.addClass('hidden');
		this.containerFoto.prepend('<img src="' + foto.url + '" class="img-responsive" style="margin: auto;"/>');
	}
	
	function adicionarCsrfToken(xhr){
		var header = $('input[name=_csrf_header]').val();
		var token = $('input[name=_csrf]').val();;
		xhr.setRequestHeader(header, token);
	}
	
	return UploadFoto;
})();

$(function(){
	var uploadFoto = new Epoch.UploadFoto();
	uploadFoto.iniciar();
});