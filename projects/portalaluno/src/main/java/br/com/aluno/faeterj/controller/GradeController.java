package br.com.aluno.faeterj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.aluno.faeterj.model.entity.Disciplina;
import br.com.aluno.faeterj.model.repository.DisciplinaRepository;

@Controller
//@Transactional
//@ComponentScan
public class GradeController {

	
	 @Autowired
	private DisciplinaRepository repository;
	 
    @RequestMapping(value="/novo", method=RequestMethod.GET)
    public String greetingForm(Model model) {
    
    Disciplina disciplina = repository.findOne(2L); //busca uma disciplina pelo ID
    model.addAttribute("disciplina", disciplina);
    return "novo";
    }



}