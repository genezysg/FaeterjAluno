package br.com.aluno.faeterj.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.aluno.faeterj.model.entity.Aluno;
import br.com.aluno.faeterj.model.entity.Inscricao;
import br.com.aluno.faeterj.model.repository.AlunoRepository;
import br.com.aluno.faeterj.model.repository.InscricaoRepository;

@Controller

public class InscricaoController {
	
	
	@Autowired
	private AlunoRepository repository;
	@Autowired
	private InscricaoRepository Irepository;
	@RequestMapping(value="/principal", method=RequestMethod.GET)
	public String mostrarPrincipal(Model model){
		 
		try{
			Aluno aluno = repository.findOne(1L); //busca uma aluno pelo ID
			  
			Set <Inscricao> inscricoes = aluno.getInscricao();
		
			for(Inscricao i: aluno.getInscricao())
				   System.out.println(i.getMediaFinal());
			   model.addAttribute("Aluno", aluno);
			   model.addAttribute("inscricoes",inscricoes);			   
			   
			   
			   return "principal";
			   
		}
		catch (Exception e){
			return "redirect: /testeTurma"; 
		}
		
	}


}
