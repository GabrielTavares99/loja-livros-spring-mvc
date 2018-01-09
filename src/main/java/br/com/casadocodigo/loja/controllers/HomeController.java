package br.com.casadocodigo.loja.controllers;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    private static final Logger logger = Logger.getLogger(HomeController.class);
    @RequestMapping("/")
    public String index(){
        logger.info("INICIO APP");
        System.out.println("Entrando na home da CDC");
        return "home";
    }

}
