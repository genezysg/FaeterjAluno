package br.com.aluno.faeterj;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("principal");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/inscricoes").setViewName("inscricoes");
        registry.addViewController("/historico").setViewName("historico");
        registry.addViewController("/declaracao").setViewName("declaracao");
        registry.addViewController("/contato").setViewName("contato");
        //registry.addViewController("/login").setViewName("login");
       // registry.addViewController("../fragments/header").setViewName("/fragments :: header");
        
        

}
}