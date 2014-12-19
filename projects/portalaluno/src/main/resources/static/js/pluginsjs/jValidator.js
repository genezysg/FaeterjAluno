jQuery.fn.jValidator = function (options)
{
	$.noCrossRefer = false;
	
	var validatorSettings = {
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        container: '#formMessages',
        fields: {
            data: {
              selector: '.fieldDate',
          	  trigger: 'change',
                validators: {
                    notEmpty: {
                        message: 'Data não pode estar em branco'
                    },
                    date: {
                        message: 'Data inválida',
                        format: 'DD/MM/YYYY'
                    }
                }
            },
            hora: {
              selector: '.fieldTime',
          	  trigger: 'change',
                validators: {
                    notEmpty: {
                        message: 'Hora não pode estar em branco'
                    },
                    callback: {
                        message: 'Hora inválida',
                        callback: function(value, validator) {
                        	if (value.trim() == "") return true;
                            return ValidTime(value);
                        }
                    }
                }
            },
            cpf: {
                selector: '.fieldCpf',
            	  trigger: 'change',
                  validators: {
                      notEmpty: {
                          message: 'CPF não pode estar em branco'
                      },
                      callback: {
                          message: 'CPF inválido',
                          callback: function(value, validator) {
                          	  if (value.trim() == "") return true;
                              return validaCPF(value);
                          }
                      }
                  }
            },
            cnpj: {
                selector: '.fieldCnpj',
            	  trigger: 'change',
                  validators: {
                      notEmpty: {
                          message: 'CNPJ não pode estar em branco'
                      },
                      callback: {
                          message: 'CNPJ inválido',
                          callback: function(value, validator) {
                          	  if (value.trim() == "") return true;
                              return validaCNPJ(value);
                          }
                      }
                  }
            }
        }
    };
	
	/*
	                callback: {
                        message: 'Data inválida',
                        callback: function(value, validator) {
                        	if (value.trim() == "") return true;
                            return ValidDate(value);
                        }
                    }
	 */
	// campos required
	$(this).find('.fieldRequired').each(function(key, element){
		// misc
		var id = $(element).attr('id');
		var name = $(element).attr('name');
		
		// label
		var label = $(element).attr('data-label');
		if (label == undefined) label = $("label[for='"+id+"']").html();
		if (label == undefined) label = $(element).attr('placeholder');
		
		// se ha label...
		if (label != undefined){

			// definindo msg
			var msg = "";
			
			if ($(element).is("input[type='text'], input[type='password'], textarea")){
				msg = label+" não pode estar em branco";
			}
			
			if ($(element).is("input[type='radio'], input[type='checkbox'], select")){
				msg = label+" deve ser selecionado";
			}
			
			// criando campo no validade
			novoRequired = {
	                validators: {
	                    notEmpty: {
	                        message: msg
	                    }
	                }
			}
			
			validatorSettings['fields'][name] = novoRequired;
		}
	});
	
	// campos periodo from
	$(this).find('.fieldPeriodFrom, .fieldPeriodTo').each(function(key, element){
		
		// handle hidden
		if ($(element).attr('type') == "hidden") return;
		
		// misc
		if ($(element).is('.fieldPeriodFrom')){
			var other = "fieldPeriodTo";
			var direction = 1;
		}
		else {
			var other = "fieldPeriodFrom";
			var direction = 2;
		}
		
		var id = $(element).attr('id');
		var name = $(element).attr('name');
		var dateGroup = $(element).attr('data-dategroup');
		
		// label
		var label = $(element).attr('data-label');
		if (label == undefined) label = $("label[for='"+id+"']").html();
		if (label == undefined) label = $(element).attr('placeholder');
		
		// pegar o campo 'other'
		var campoOther = $(element).closest('form').find("."+other+"[data-dategroup='"+dateGroup+"']")[0];
		var idOther = $(campoOther).attr('id');
		var nameOther = $(campoOther).attr('name');
		
		// label 'other'
		if ($(campoOther).attr('type') == "hidden"){
			//var labelOther = $(campoOther).val();
			var labelOther = "";
		}
		else {
			var labelOther = $(campoOther).attr('data-label');
			if (labelOther == undefined) labelOther = $("label[for='"+idOther+"']").html();
			if (labelOther == undefined) labelOther = $(campoOther).attr('placeholder');
		}
		
		// ##########
		
		// se ha label...
		if (label != undefined){

			// definindo msgs
			msgRequired = label+" não pode estar em branco";
			msgValid = label+" inválida";
            if (direction == 1)
            	msgPeriod = label+" deve ser menor ou igual a "+labelOther;
            else
            	msgPeriod = label+" deve ser maior ou igual a "+labelOther;
			
			// criando campo no validade
			novoCampo = {
	          	  trigger: 'change',
	                validators: {
	                    notEmpty: {
	                        message: msgRequired
	                    },
			            date: {
			                message: msgValid,
			                format: 'DD/MM/YYYY'
			            },
		                callback: {
	                        message: msgPeriod,
	                        callback: function(value, validator, $field) {
	                            var m = WrapDate(value);
	                            var n_obj = $($field).closest('form').find("input[name='"+nameOther+"']");
	                            var n_str = $(n_obj).val();
	                            var n = WrapDate(n_str);

	                            if (direction == 1)
	                            	var result = (m <= n ? true:false);
	                            else
	                            	var result = (m >= n ? true:false);
	                            
	                            if ($(n_obj).attr("type") == "hidden"){
	                            	var msgtmp = msgPeriod+$(n_obj).val();
	                            	return { valid: result, message: msgtmp};
	                            }
	                            else {
		                            if (!$.noCrossRefer){
		                            	$.noCrossRefer = true;
		                            	$($field).closest('form').bootstrapValidator('revalidateField', nameOther);	                            
		                            }
		                            else {
		                            	$.noCrossRefer = false;
		                            }
		                            
		                            return result;
	                            }
	                        }
	                    }
	                }
			}
			
			validatorSettings['fields'][name] = novoCampo;
		}
	});
	
	if (!(options == undefined)){
		validatorSettings = $.extend({}, validatorSettings, options);
	}
	
	$(this).bootstrapValidator(validatorSettings);
}