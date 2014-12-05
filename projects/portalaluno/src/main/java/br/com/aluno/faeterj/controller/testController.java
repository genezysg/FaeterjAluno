package br.com.aluno.faeterj.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.aluno.faeterj.model.entity.Aluno;
import br.com.aluno.faeterj.model.entity.Disciplina;
import br.com.aluno.faeterj.model.entity.Turma;
import br.com.aluno.faeterj.model.repository.AlunoRepository;
import br.com.aluno.faeterj.model.repository.DisciplinaRepository;
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
	private DisciplinaRepository drepository;
	 
    @RequestMapping(value="/testeTurma", method=RequestMethod.GET)
    public String greetingForm(Model model) {
    
    
    	
    Aluno aluno = new Aluno(); 
    aluno.setNome("eric");
    
    
    repository.save(aluno); 	
   
    Disciplina disciplina= new Disciplina();
    disciplina.setNome("oo2");
    drepository.save(disciplina);
    
   Turma turma = new Turma();
    turma.setAno("2014-2");
    turma.setDisciplina(disciplina);
    trepository.save(turma);
    
    Set<Turma> turmas = new HashSet<Turma>();
    turmas.add(turma);
    aluno.setTurmas(turmas);
    
    Set<Aluno> alunos = new HashSet<Aluno>();
    alunos.add(aluno);    
    turma.setAlunos(alunos);
    
    repository.save(aluno);
    trepository.save(turma);
    
   //   model.addAttribute("turma", turma);
    return "novo";
    }



}