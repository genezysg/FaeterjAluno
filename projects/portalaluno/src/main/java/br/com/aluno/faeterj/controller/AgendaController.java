package br.com.aluno.faeterj.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.aluno.faeterj.model.entity.Anotacao;
import br.com.aluno.faeterj.model.repository.AnotacaoRepository;

@Controller
public class AgendaController {

	@Autowired
	private AnotacaoRepository repository;
	
	@RequestMapping(value="/agenda", method=RequestMethod.GET)
	public String carregaAgenda(Model model) {
		Iterable<Anotacao> anotacoes = repository.findAll();
		Map<String,String> lista = new HashMap<String,String>(200);
		
		// montando itens de dados
		for (Anotacao anotacao: anotacoes){
			lista.put(anotacao.getDataToString(), anotacao.getTexto());
		}
		
		model.addAttribute("dados", lista);
		
		return "agenda";
	}

	@RequestMapping(value="/agendasave", method=RequestMethod.POST)
    //public String salvaAgenda(HttpServletRequest request) { // outra forma de fazer
    public String salvaAgenda(Model model, @RequestParam(value="dados", required=false) String dadosstr) {
   	
		//String dadosstr = request.getParameter("dados");
		String[] dados = dadosstr.split("##BR##");
		String minhaData, meuTexto;
		Anotacao anotacao;
		
		for (String linha: dados){
			String[] partes = linha.split("##:##");
			
			minhaData = partes[0];
			if (partes.length > 1)
				meuTexto = partes[1];
			else
				meuTexto = "";
			
			anotacao = new Anotacao();
			anotacao.setData(minhaData);
			anotacao.setTexto(meuTexto);
			repository.save(anotacao);
		}
		
    	return "agendaAJAXSuccess";
    }
}
