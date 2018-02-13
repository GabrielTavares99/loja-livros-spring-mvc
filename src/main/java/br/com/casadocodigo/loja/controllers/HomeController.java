package br.com.casadocodigo.loja.controllers;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private static final Logger logger = Logger.getLogger(HomeController.class);
    @RequestMapping("/")
    public ModelAndView index(){
        logger.info("INICIO APP");
        System.out.println("Entrando na home da CDC");
        return new ModelAndView("home");
    }

}
