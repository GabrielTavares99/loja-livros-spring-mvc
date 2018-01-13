package br.com.casadocodigo.loja.controllers;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.infra.FileSaver;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;
import br.com.casadocodigo.loja.utils.Strings;
import br.com.casadocodigo.loja.validations.ProdutoValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/produtos")
public class ProdutosController {

    @Autowired
    ProdutoDAO produtoDAO;

    @Autowired
    FileSaver fileSaver;

    private static final Logger logger = Logger.getLogger(ProdutosController.class);

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        dataBinder.addValidators(new ProdutoValidation());
    }

    @RequestMapping(value = "/form")
    public ModelAndView form(Produto produto){
        logger.info("Acessando formulário de produtos");
        ModelAndView modelAndView = new ModelAndView("produtos/form");
        modelAndView.addObject("tipos", TipoPreco.values());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView gravar(MultipartFile sumario, @Valid Produto produto, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            logger.warn("ERRO DE VALIDAÇÃO DE PRODUTOS");
            return form(produto);
        }

        System.out.println(sumario.getOriginalFilename());

        produto.setSumarioPath(fileSaver.write("arquivos-sumario", sumario));
        System.out.println(produto);
        produtoDAO.gravar(produto);
        redirectAttributes.addFlashAttribute(Strings.ATRIBUTO_MENSAGEM_SUCESSO, "Produto cadastrado com sucesso");
//        tem que redicionar pra matar a requisição de post, senão bug do F5
        return new ModelAndView("redirect:/produtos");
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar(){
        ModelAndView modelAndView = new ModelAndView("produtos/lista");
        List<Produto> produtos = produtoDAO.listar();
        modelAndView.addObject("produtos", produtos);
        return modelAndView;
    }

}
