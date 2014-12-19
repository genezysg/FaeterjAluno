package br.com.aluno.faeterj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//Controller
public class AgendaController {
//RequestMapping(value="/agenda", method=RequestMethod.GET)
    public String greetingForm(Model model) {
       
    	return "agendaxx";
    }

}
