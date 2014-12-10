package br.com.aluno.faeterj;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/novaprincipal").setViewName("novaprincipal");
        registry.addViewController("/novahome").setViewName("novahome");
        registry.addViewController("/novainscricoes").setViewName("novainscricoes");
        registry.addViewController("/novahistorico").setViewName("novahistorico");
        registry.addViewController("/novadeclaracao").setViewName("novadeclaracao");
        registry.addViewController("/novacontato").setViewName("novacontato");
       // registry.addViewController("../fragments/header").setViewName("/fragments :: header");
        
        

}
}