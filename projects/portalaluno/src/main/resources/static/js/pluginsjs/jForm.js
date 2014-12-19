
/*
 *
 */

jQuery.fn.SaveDefaults = function ()
{
	var elements = $(this).find("input, textarea");
	var defaults = {}; // plainObject
	var nome = "";
	var valor = "";
	
	$(elements).each(function(){
		nome = $(this).attr("name");
		valor = $(this).val();
		defaults[nome] = valor;
	});
	
	$.defaultsaved = defaults;
}

jQuery.fn.RestoreDefaults = function ()
{
	var elements = $(this).find("input, textarea");
	var defaults = $.defaultsaved; // plainObject
	var nome = "";
	
	$(elements).each(function(){
		nome = $(this).attr("name");
		$(this).val(defaults[nome]);
	});
}

$.fn.ajax_submit = function() {
	
	var callback = $(this).attr('data-callback');
	var url = $(this).attr('action') || $(this).attr('href');
	var update_target = $(this).attr('data-update');
	var append_target = $(this).attr('data-appendTo') || $(this).attr('data-append');
	var prepend_target = $(this).attr('data-prependTo') || $(this).attr('data-prepend');
	
	$.ajax( url, {
		data: $(this).serialize(),
		type: "POST",
		dataType: "html",
		context: this,
		success: function(data) {
			if (callback) { callback.call(); }
			if (update_target) { $(update_target).html(data); }
			if (append_target) { $(append_target).append(data); }
			if (prepend_target) { $(prepend_target).prepend(data); }
		},
		error: function(data) {
			console.log(data);
		}
	});
};

$.fn.ajax_submitReturn = function() {
	
	var callback = $(this).attr('data-callback');
	var url = $(this).attr('action') || $(this).attr('href');
	var update_target = $(this).attr('data-update');
	var append_target = $(this).attr('data-appendTo') || $(this).attr('data-append');
	var prepend_target = $(this).attr('data-prependTo') || $(this).attr('data-prepend');
	
	$.ajax( url, {
		data: $(this).serialize(),
		type: "POST",
		dataType: "html",
		context: this,
		success: function(data) {
			if (callback) { callback.call(); }
			if (update_target) { $(update_target).html(data); }
			if (append_target) { $(append_target).append(data); }
			if (prepend_target) { $(prepend_target).prepend(data); }
			return true;
		},
		error: function(data) {
			console.log(data);
			return false;
		}
	});
};


$.fn.autoAjax = function() {
	$(this).ajax_submit();
	$('.dadossalvos').modal();
	return false;
};

$.fn.autoAjaxSemModal = function() {
	$(this).ajax_submit();
	return false;
};

$.fn.autoAjaxValidate = function() {
	var bootstrapValidator = $('form').data('bootstrapValidator');
	if (!bootstrapValidator.isValid()) return;

	$(this).ajax_submit();
	return false;
};

$.fn.autoAjaxValidateReturn = function() {
	var bootstrapValidator = $('form').data('bootstrapValidator');
	if (!bootstrapValidator.isValid()) return;

	return $(this).ajax_submitReturn();
};

$.fn.autoAjaxRel = function() {
	var bootstrapValidator = $('form').data('bootstrapValidator');
	if (!bootstrapValidator.isValid()) return;

	$('#relContainer').html("<div id='loading'><img src='/siger/img/loadingAnimation.gif'></div>");
	$('#relModal').modal();

	$(this).ajax_submit();
	return false;
};
/*
$('form[data-remote="auto-ajax"]').live('onsubmit', function(){
	return $(this).autoAjax();
});
*/