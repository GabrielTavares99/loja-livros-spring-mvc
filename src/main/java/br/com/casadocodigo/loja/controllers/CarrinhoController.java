package br.com.casadocodigo.loja.controllers;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.models.CarrinhoCompras;
import br.com.casadocodigo.loja.models.CarrinhoItem;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
@RequestMapping(value = "/carrinho")
public class CarrinhoController {

    @Autowired
    private ProdutoDAO produtoDAO;

    @Autowired
    CarrinhoCompras carrinhoCompras;

    @RequestMapping(value = "/add")
    public ModelAndView add(Integer produtoId, TipoPreco tipoPreco){
        ModelAndView modelAndView = new ModelAndView("redirect:/produtos");
        CarrinhoItem carrinhoItem = criaItem(produtoId, tipoPreco);
        carrinhoCompras.add(carrinhoItem);
        return modelAndView;
    }

    private CarrinhoItem criaItem(Integer produtoId, TipoPreco tipoPreco) {
        Produto produto = produtoDAO.findById(produtoId);
        return new CarrinhoItem(produto, tipoPreco);
    }

}
