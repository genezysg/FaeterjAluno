$.calendarOptions = {
weeks : [ 'Domingo', 'Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sábado' ],
weekabbrs : [ 'Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sab' ],
months : [ 'Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro' ],
monthabbrs : [ 'Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez' ],
 
// left-most day in the calendar
// 0 - Sunday, 1 - Monday, ... , 6 - Saturday
startIn : 0,
}

jQuery.fn.jCalAdd = function (dados)
	{
		cal = $.cal;
		
		cal.setData(dados);
	}

jQuery.fn.jCalendar = function (dados, callback)
{
	var args = $.calendarOptions;
	args['caldata'] = dados;
	if (callback != undefined) args['onDayClick'] = callback;
	
	var cal = $(this).calendario(args);

	function updateMonthYear() {
		$( '#custom-month' ).html( cal.getMonthName() );
		$( '#custom-year' ).html( cal.getYear() );
	}
	
	$( '#custom-next' ).on( 'click', function() {
		cal.gotoNextMonth( updateMonthYear );
	} );
	$( '#custom-prev' ).on( 'click', function() {
		cal.gotoPreviousMonth( updateMonthYear );
	} );
	$( '#custom-current' ).on( 'click', function() {
		cal.gotoNow( updateMonthYear );
	} );
	
	$.cal = cal;
	updateMonthYear();
}