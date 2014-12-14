package br.com.aluno.faeterj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import br.com.aluno.faeterj.model.entity.Aluno;
import br.com.aluno.faeterj.model.repository.AlunoRepository;


@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableJpaRepositories
public class Application {

    public static void main(String[] args) {
    	
        ConfigurableApplicationContext context = SpringApplication.run(Application.class);
       // AlunoRepository alunorepository = context.getBean(AlunoRepository.class);
        //DisciplinaRepository disciplinarepository = context.getBean(DisciplinaRepository.class);
        
       /* 

        Aluno aluno=new Aluno();
        aluno.setNome("genezys");
        alunorepository.save(aluno);
        
        Disciplina disciplina =new Disciplina();
        disciplina.setNome("psw");
        disciplina.setProfessor("andre neves");
        disciplina.setCargaHoraria(45);
        disciplinarepository.save(disciplina);
       
        context.close();
         */
       
    }

}