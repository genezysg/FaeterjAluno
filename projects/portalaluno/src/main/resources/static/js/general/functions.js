function objectLength(obj)
{
	var count = 0;
	$.each(obj, function(key, val)
	{
		if (val) count++;
	});
	
	return count;
}

function IncElementKey(nome,nivel,novo)
{
	novo = novo || -1; // padrao
	if (isUndefined(nome)) return "";
	var res = nome.match(/\[([0-9]*)\]/g); // destacando as chaves [n]
	if (!(nivel > 0)) nivel = res.length;
	var temp = "";
	var keyslength = 0;
	
	for( key in res ) { keyslength = keyslength + res[key].length; } // contando o tamanho das chaves no nome
	var novonome = nome.substr(0, nome.length - keyslength); // pegando nome puro
	
	for( key in res )
	{
		if (key == nivel-1)
		{
			if (novo == -1)
			{ // inc key atual
				temp = res[key].substr(1, res[key].length-2);
				novo = parseInt(temp) + 1;
			}
			
			novonome = novonome + '[' + novo + ']';
		}
		else
		{
			novonome = novonome + res[key];
		}
	}
	
	return novonome;
}

function isUndefined(myvar)
{
	if ((myvar == undefined) || (myvar == null) || (!myvar))
		return true;
	else
		return false;
}

function addLine(arg)
{
	var testevar = typeof arg;
	if (testevar == "object")
	{
		var tabletarget = $(arg).closest("table");
		var trtarget = $(arg).closest("tr");
		var lasttr = $(tabletarget).find("tbody > tr:last-child");
		
		if (!trtarget.is(lasttr)) return;
		$(tabletarget).jLineCopier();
	}
	else
	{
		table = $("#"+arg);
		$(table).jLineCopier();
	}
}

function replaceAll(mystring, token, newtoken) {
	tmpstring = new String(mystring);
	while (tmpstring.indexOf(token) != -1) {
		tmpstring = tmpstring.replace(token, newtoken);
	}
	return tmpstring;
}

function ValidDate(date){
	var pieces = date.split("/");
	
	// pretratamento
	var diastr = pieces[0] || "";
	var messtr = pieces[1] || "";
	var anostr = pieces[2] || "";

	if (anostr.length == 2){
		if (parseInt(anostr) < 50)
			anostr = "20"+anostr;
		else
			anostr = "19"+anostr;
	}

	// misc
	var dia = parseInt(diastr);
	var mes = parseInt(messtr);
	var ano = parseInt(anostr);
	
	// validando
	if (!(mes >= 1 || mes <= 12))
		return false;
	if (!(dia >= 1 || dia <= 31))
		return false;
	if ((mes==4 || mes==6 || mes==9 || mes==11) && dia==31)
		return false;
	if (mes == 2){
		var isleap = (ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0));
		if (dia > 29 || (dia==29 && !isleap))
			return false;
	}
	if (!(ano > 1900 && ano < 2100))
		return false;

	return true;
}

function StrToDate(date){
	var pieces = date.split("/");
	
	// pretratamento
	var diastr = pieces[0] || "";
	var messtr = pieces[1] || "";
	var anostr = pieces[2] || "";

	if (anostr.length == 2){
		if (parseInt(anostr) < 50)
			anostr = "20"+anostr;
		else
			anostr = "19"+anostr;
	}
	
	if (messtr.length == 1){
		messtr = "0"+messtr;
	}
	
	if (diastr.length == 1){
		diastr = "0"+diastr;
	}
	
	return anostr+"-"+messtr+"-"+diastr;
}

function WrapDate(date){
	var nativeDate = StrToDate(date);
	var pieces = nativeDate.split("-");
	
	return new Date(pieces[0],pieces[1],pieces[2]);
}

function ValidTime(time){

	// padronizando
	time = replaceAll(time, "hs", ":");
	time = replaceAll(time, "HS", ":");
	time = replaceAll(time, "h", ":");
	time = replaceAll(time, "H", ":");
	
	// pegando os pedacos
	var pieces = time.split(":");
		
	// pretratamento
	var horastr = pieces[0] || "";
	var minstr = pieces[1] || "";

	if (minstr.length == 0){
		minstr = "00";
	}
	
	// misc
	var hora = parseInt(horastr);
	var min = parseInt(minstr);
	
	// validando
	if (!(hora >= 0 || hora <= 23))
		return false;
	if (!(min >= 0 || min <= 59))
		return false;

	return true;
}

function validaCNPJ(CNPJ){
	
    if (!CNPJ) return true;
    
    if (CNPJ == "00.000.000/0000-00") return false;
    
    CNPJ = CNPJ.replace(".","");
    CNPJ = CNPJ.replace(".","");
    CNPJ = CNPJ.replace("-","");
    CNPJ = CNPJ.replace("/","");

    var a = [];
    var b = new Number;
    var c = [6,5,4,3,2,9,8,7,6,5,4,3,2];
    for(i=0; i<12; i++){
      a[i] = CNPJ.charAt(i);
      b += a[i] * c[i+1];
    }
    if((x = b % 11) < 2){
      a[12] = 0
    }else{
      a[12] = 11-x
    }
    b = 0;
    for(y=0; y<13; y++){
      b += (a[y] * c[y]);
    }
    if((x = b % 11) < 2){
      a[13] = 0;
    }else{
      a[13] = 11-x;
    }

    if((CNPJ.charAt(12) != a[12]) || (CNPJ.charAt(13) != a[13])) return false;

    return true;
}


function validaCPF(c){
	
	if ((c == undefined) || (c.length == 0)) return true;

	var numeros, digitos, soma, i, resultado, digitos_iguais, cpf = c.replace(/\D+/g, '');

	if ((cpf == undefined) || (cpf.length == 0)) return false;

	digitos_iguais = 1;

	if (cpf.length != 11) return false;
	
	for (i = 0; i < cpf.length - 1; i++)
		if (cpf.charAt(i) != cpf.charAt(i + 1)){
			digitos_iguais = 0;
			break;
		}

	if (!digitos_iguais){
		numeros = cpf.substring(0,9);
		digitos = cpf.substring(9);
		soma = 0;
		for (i = 10; i > 1; i--)
			soma += numeros.charAt(10 - i) * i;
			
		resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
		if (resultado != digitos.charAt(0)){
			return false;
		}
			
		numeros = cpf.substring(0,10);
		soma = 0;
		for (i = 11; i > 1; i--)
			soma += numeros.charAt(11 - i) * i;
			
		resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
		if (resultado != digitos.charAt(1))
			return false;
		else
			return true;
	}
	else {
			return false;
	}
}
