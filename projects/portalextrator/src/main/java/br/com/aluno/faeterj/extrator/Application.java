package br.com.aluno.faeterj.extrator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.aluno.faeterj.extrator.entity.Aluno;
import br.com.aluno.faeterj.extrator.entity.Inscricao;
import br.com.aluno.faeterj.extrator.entity.Turma;
import br.com.aluno.faeterj.extrator.repository.AlunoRepository;
import br.com.aluno.faeterj.extrator.repository.InscricaoRepository;
import br.com.aluno.faeterj.extrator.repository.TurmaRepository;
import br.com.aluno.faeterj.extrator.service.Carga;


@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableJpaRepositories
public class Application {
	


	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication
				.run(Application.class);
	
//		LoginRepository loginrepository = context
//				.getBean(LoginRepository.class);
		AlunoRepository alunorepository = context
				.getBean(AlunoRepository.class);
		TurmaRepository turmarepository = context
			.getBean(TurmaRepository.class);
		InscricaoRepository inscricaorepository = context
				.getBean(InscricaoRepository.class);
		

//		Iterable<Login> logins = loginrepository.findAll();
		Iterable<Aluno> alunos = alunorepository.findAll();
		Iterable<Turma> turmas = turmarepository.findAll();
		Iterable<Inscricao> inscricoes = inscricaorepository.findAll();
		Carga carga=new Carga();
		
		carga.setAluno(alunos);
		carga.setInscricao(inscricoes);
		carga.setTurma(turmas);
		
		carga.save();
		

		context.close();

	}

}