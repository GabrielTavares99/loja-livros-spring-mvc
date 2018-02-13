package br.com.casadocodigo.loja.controllers;

import br.com.casadocodigo.loja.models.CarrinhoCompras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//@Scope(value = WebApplicationContext.SCOPE_SESSION) USAMOS O TARGE CLASS SCOPE
@Controller
@RequestMapping(value = "/pagamento")
public class PagamentoController {

    @Autowired
    private CarrinhoCompras carrinho;

    @RequestMapping(value = "/finalizar", method = RequestMethod.POST)
    public ModelAndView finalizar(RedirectAttributes attributes) {
        System.out.println(carrinho.getTotal());
        attributes.addFlashAttribute("mensagem_sucesso", "Pagamento realizado com sucesso!");
        return new ModelAndView("redirect:/produtos");
    }

}
