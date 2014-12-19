$.jLineCopier =
{
    defaults:
    {
        DefaultValues: {},
		FillValueClass: "fillValue",
		FillBlankClass: "fillBlank",
		NoCopyClass: "noCopy",
		BeforeShow: function(){}
    }
};

$.jLineCopierDefaultOptions = {};

/*
 * Duplicates table line with special features. It will make a copy of the last line.
 * State of the copy depends on many options and parameters.
 * 
 * Parameters:
 *		"level": level of multi-level array (e.g myVar[2][4][1]) to modify.
 *				First level is 1. Default level is the last level (most on right).
 *		"newKey": new key to put in assigned level. Default is increase level's existing key.
 * 		"options": is a PlainObject containing some option below:
 * 			DefaultValues: array/list of default values to elements.
 *						Key is CSS class for the target element (column class). Value is new value to assign to.
 *			FillValueClass: defines alternative name for class fillValue.
 *			FillBlankClass: defines alternative name for class fillBlank.
 *			NoCopyClass: defines alternative name for class noCopy.
 *			BeforeShow: defines a function to run before show the duplicated line.
 * 
 * Classes:
 *		fillValue: elements who fill with your model's value. If used in TD or TR, applies to every element contained for.
 *		fillBlank: cells (TD) who fill blank.
 *		noCopy: elements who dont must be copied.
 *
 * Custom default options can be defined in "$.jLineCopierDefaultOptions".
 */
jQuery.fn.jLineCopier = function (level, newKey, options)
{
	var inputers = "input[type='text'],input[type='hidden'],input[type='color'],input[type='date'],input[type='datetime'],input[type='datetime-local'],input[type='email'],input[type='file'],input[type='month'],input[type='number'],input[type='password'],input[type='range'],input[type='search'],input[type='tel'],input[type='time'],input[type='url'],input[type='week']";
	var noninputers = "input[type='button'],input[type='checkbox'],input[type='image'],input[type='radio'],input[type='reset'],input[type='submit']";
	var checkinputers = "input[type='checkbox'],input[type='radio']";
	
	// misc
	// ### level and newKey defaults is handled into IncElementKey functions. ###
	var tbody = $(this).children('tbody');
	var oldLine = $(tbody).children('tr:last-child');
	var newLine = $(oldLine).clone(true, true);
	var oldName = "";
	var newName = "";
	var filledValue = "";
	var filledElements = {};
	
	// limpando os elementos
	//$(newLine).find("input, select, textarea, button").val("");
	
	// arrumando objeto "options"
	var options = $.extend({}, $.jLineCopier.defaults, $.jLineCopierDefaultOptions, options);
	
	// limpando celulas fillBlank
	$(newLine).children("td."+options.FillBlankClass).empty();
	
	// eliminando elementos NoCopy
	$(newLine).find("."+options.NoCopyClass).remove();
	
	/*
	// buscando TDs ou elementos soltos com a classe fillValue
	if ($(newLine).hasClass(options.FillValueClass))
	{
		filledElements = $(newLine).find("input, select, textarea, button");
	}
	else
	{
		filledElements = $(newLine).children("td."+options.FillValueClass).find("input, select, textarea, button");
		filledElements = filledElements.add($(newLine).find("."+options.FillValueClass).filter("input, select, textarea, button"));
	}
	
	$(filledElements).each(function(index, element)
	{
		oldName = $(element).attr('name');
		filledValue = $(oldLine).find("*[name='"+oldName+"']").val();
		$(element).val(filledValue);
	});
	*/
	
	if ($(newLine).hasClass(options.FillValueClass))
	{
		// nesta rotina, todo mundo eh fillValue. Entao, devolve aos selects e textareas que perdem por padrao
		$(newLine).find("select, textarea").each(function(index, element){
			if ($(element).closest("tr").hasClass(options.FillValueClass))
			{
				oldName = $(element).attr('name');
				filledValue = $(oldLine).find("*[name='"+oldName+"']").val();
				$(element).val(filledValue);
			}
		});
	}
	else
	{
		// buscando os elementos editaveis pelo usuario que estiverem com fillValue ou em TD com fillValue para marca-los
		$(newLine).find(inputers+", select, textarea").each(function(index, element){
			if ($(element).closest("td").hasClass(options.FillValueClass)) $(element).addClass('tmpJLCfv');
			if ($(element).hasClass(options.FillValueClass)) $(element).addClass('tmpJLCfv');
		});
		
		// buscando elementos nao-editaveis e marcando eles tambem
		$(newLine).find(noninputers+", button").addClass('tmpJLCfv');
		
		// limpando o value dos que nao estao marcados
		$(newLine).find("input:not(.tmpJLCfv), select:not(.tmpJLCfv), textarea:not(.tmpJLCfv), button:not(.tmpJLCfv)").val("");
		
		// recolocando o value nos selectboxes e textareas, que perdem o value por padrao
		$(newLine).find("select.tmpJLCfv, textarea.tmpJLCfv").each(function(index, element){
			oldName = $(element).attr('name');
			filledValue = $(oldLine).find("*[name='"+oldName+"']").val();
			$(element).val(filledValue);
		});

		// removando marcacao (classe temporaria)
		$(newLine).find(".tmpJLCfv").removeClass("tmpJLCfv");
		
		// tratando checkboxes e radios separadamente (o "value" deles eh atraves do "checked")
		$(newLine).find(checkinputers).each(function(index, element){
			if ($(element).closest("td, div, section, fieldset, span").hasClass(options.FillValueClass)) return;
			if ($(element).hasClass(options.FillValueClass)) return;
			
			$(element).prop("checked", false);
		});
	}
	
	// atribuindo defaults values
	var dv = options.DefaultValues;
	for (key in dv)
		$(newLine).find("."+key).val(dv[key]);
	
	// trocando nome de cada elemento na nova linha
	$(newLine).find("input, select, textarea, button").each(function(index, element)
	{
		oldName = $(element).attr('name');
		newName = IncElementKey(oldName, level, newKey);
		$(element).attr('name', newName);
	});
	
	// executando before show
	if ($.isFunction(options.BeforeShow)) options.BeforeShow();
	
	// jogando a linha na tela
	$(tbody).append(newLine);
}
