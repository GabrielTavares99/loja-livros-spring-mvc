package br.com.casadocodigo.loja.controllers;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.models.CarrinhoCompras;
import br.com.casadocodigo.loja.models.CarrinhoItem;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/carrinho")
@Scope(value = WebApplicationContext.SCOPE_SESSION)
public class CarrinhoComprasController {

    @Autowired
    ProdutoDAO produtoDAO;

    @Autowired
    CarrinhoCompras carrinhoCompras;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView itens() {
        return new ModelAndView("carrinho/itens");
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView add(Integer produtoId, TipoPreco tipoPreco) {
        ModelAndView modelAndView = new ModelAndView("redirect:/carrinho");
        CarrinhoItem carrinhoItem = criaItem(produtoId, tipoPreco);
        carrinhoCompras.add(carrinhoItem);
        return modelAndView;
    }

    private CarrinhoItem criaItem(Integer produtoId, TipoPreco tipoPreco) {
        Produto produto = produtoDAO.findById(produtoId);
        return new CarrinhoItem(produto, tipoPreco);
    }


    @RequestMapping(value = "/remover", method = RequestMethod.POST)
    public ModelAndView remover(Integer produtoId, TipoPreco tipoPreco) {
        carrinhoCompras.remover(produtoId, tipoPreco);
        return new ModelAndView("redirect:/carrinho");
    }

}
