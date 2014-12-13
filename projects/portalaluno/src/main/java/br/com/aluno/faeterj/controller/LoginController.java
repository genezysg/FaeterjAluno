package br.com.aluno.faeterj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.aluno.faeterj.model.entity.Login;

@Controller
public class LoginController {

	
	@RequestMapping("/")
	public String index(Login login,Model model){
		//model.addAttribute("login",new Login());
		return "novaprincipal";
	}
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public String Autenticacao(@ModelAttribute Login login, Model model)
	{
		if (login.Autentica())
		{
			model.addAttribute("login",login);
			return "aluno";
		}
		return "novaprincipal";
		
			
	}
}
