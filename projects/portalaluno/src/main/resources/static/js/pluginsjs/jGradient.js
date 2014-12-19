

/*
 * direction: true - vertical; false-horizontal.
 * way: true - esquerda->direta / cima->baixo; false - contrário.
 */
jQuery.fn.jGradient = function (direction, way)
{
	var branco = "#FFFFFF";
	var cor = jQuery(this).css('background-color');
	
	if (way)
	{
		var mscolor1 = branco;
		var mscolor2 = cor;
	}
	else
	{
		var mscolor1 = cor;
		var mscolor2 = branco;
	}
	
	if (direction)
	{
		var msdir = 0;
		if (way)
		{
			var wkdir = "center top, center bottom";
			var mzdir = "top center";
		}
		else
		{
			var wkdir = "center bottom, center top";
			var mzdir = "bottom center";
		}
	}
	else
	{
		var msdir = 1;
		if (way)
		{
			var wkdir = "left center, right center";
			var mzdir = "center left";
		}
		else
		{
			var wkdir = "right center, left center";
			var mzdir = "center right";
		}
		
	}
	
	jQuery(this).css('filter','progid:DXImageTransform.Microsoft.gradient(startColorstr=\''+mscolor1+'\', endColorstr=\''+mscolor2+'\', gradientType='+msdir+')');
	jQuery(this).css('background-image','-webkit-gradient(linear, '+wkdir+', color-stop(0.1, #FFFFFF), color-stop(0.99, '+cor+'))');
	jQuery(this).css('background-image','-moz-linear-gradient('+mzdir+', #FFFFFF 0%, '+cor+' 100%)');
	jQuery(this).css('background-image','-o-linear-gradient('+mzdir+', #FFFFFF 0%, '+cor+' 100%)');

/*

ms -> 1-horiz; 0-vertical
wk ->

background-image: linear-gradient(bottom, rgb(214,200,194) 16%, rgb(255,240,233) 58%);
background-image: -o-linear-gradient(bottom, rgb(214,200,194) 16%, rgb(255,240,233) 58%);
background-image: -moz-linear-gradient(bottom, rgb(214,200,194) 16%, rgb(255,240,233) 58%);
background-image: -webkit-linear-gradient(bottom, rgb(214,200,194) 16%, rgb(255,240,233) 58%);
background-image: -ms-linear-gradient(bottom, rgb(214,200,194) 16%, rgb(255,240,233) 58%);

background-image: -webkit-gradient(
	linear,
	left bottom,
	left top,
	color-stop(0.16, rgb(214,200,194)),
	color-stop(0.58, rgb(255,240,233))
);

sintaxes:
http://tilowr.com.br/css-3-%E2%80%93-fazendo-degrade-com-webkit-gradient/
 */

}