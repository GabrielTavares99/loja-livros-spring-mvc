package br.com.casadocodigo.loja.controllers;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import org.apache.log4j.Logger;

import java.util.List;

@Controller
@RequestMapping(value = "/produtos")
public class ProdutosController {

    @Autowired
    ProdutoDAO produtoDAO;

    private static final Logger logger = Logger.getLogger(ProdutosController.class);

    @RequestMapping(value = "/form")
    public ModelAndView form(){
        logger.info("Acessando formulário de produtos");
        ModelAndView modelAndView = new ModelAndView("produtos/form");
        modelAndView.addObject("tipos", TipoPreco.values());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String gravar(Produto produto){
        System.out.println(produto);
        produtoDAO.gravar(produto);
        return "redirect:produtos/lista";
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar(){
        ModelAndView modelAndView = new ModelAndView("produtos/lista");
        List<Produto> produtos = produtoDAO.listar();
        modelAndView.addObject("produtos", produtos);
        return modelAndView;
    }

}
