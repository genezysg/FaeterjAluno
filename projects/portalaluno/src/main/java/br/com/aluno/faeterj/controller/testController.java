package br.com.aluno.faeterj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.aluno.faeterj.model.entity.Disciplina;
import br.com.aluno.faeterj.model.entity.Turma;
import br.com.aluno.faeterj.model.repository.DisciplinaRepository;
import br.com.aluno.faeterj.model.repository.TurmaRepository;

@Controller
//@Transactional
//@ComponentScan
public class testController {

	
	 @Autowired
	private DisciplinaRepository repository;
	 @Autowired
		private TurmaRepository trepository;
	 
    @RequestMapping(value="/testeTurma", method=RequestMethod.GET)
    public String greetingForm(Model model) {
    
    Disciplina disciplina = new Disciplina();
    Turma turma = new Turma();
    disciplina.setNome("oo2");
    repository.save(disciplina);
    turma.setDisciplina(disciplina);
    
    trepository.save(turma); 
    
    
    
        model.addAttribute("disciplina", disciplina);
    return "novo";
    }



}