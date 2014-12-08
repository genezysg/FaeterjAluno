package br.com.aluno.faeterj.extrator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import br.com.aluno.faeterj.extrator.*;

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
		
		// DisciplinaRepository disciplinarepository =
		// context.getBean(DisciplinaRepository.class);

//		Iterable<Login> logins = loginrepository.findAll();
		Iterable<Aluno> alunos = alunorepository.findAll();
//		System.out.println("Todos os logins nessa porra com findAll():");
//		System.out.println("-------------------------------");
//		for (Login login : logins) {
//			System.out.println(login.getNomeAcesso() + "\n" + login.getSenha());
//		}
		System.out.println("Todos os alunos nessa porra com findAll():");
		System.out.println("-------------------------------");
		for (Aluno aluno : alunos) {
			System.out.println("\nNome: " + aluno.getNome() + "\nMatricula: " 
					+ aluno.getMatriculaAluno() + "\ne-mail: " + aluno.getEmail()+"\n");
		}

		System.out.println();

		context.close();

	}

}