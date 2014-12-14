package br.com.aluno.faeterj.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.aluno.faeterj.model.entity.Aluno;
import br.com.aluno.faeterj.model.entity.Inscricao;
import br.com.aluno.faeterj.model.entity.Turma;
import br.com.aluno.faeterj.model.repository.AlunoRepository;
import br.com.aluno.faeterj.model.repository.InscricaoRepository;
import br.com.aluno.faeterj.model.repository.TurmaRepository;

@Controller
//@Transactional
//@ComponentScan
public class testController {

	
	 @Autowired
	private AlunoRepository repository;
	 @Autowired
	private TurmaRepository trepository;
	 @Autowired
	private InscricaoRepository irepository;
	 
    @RequestMapping(value="/testeTurma", method=RequestMethod.GET)
    public String greetingForm(Model model) {
    
    Aluno aluno = new Aluno(); 
    aluno.setNome("eric");  
    repository.save(aluno);
    
    Turma turma = new Turma();
    turma.setSigladisciplina("oo2");;   
    trepository.save(turma);
    
    Inscricao i = new Inscricao(aluno,turma);
    i.setMediaFinal(9.3);
    i.setTotalFaltas(150);
    irepository.save(i);
    
 
    

    irepository.save(i);
    repository.save(aluno);
    trepository.save(turma);
   
    
// model.addAttribute("turma", turma);
    return "novo";
    }



}