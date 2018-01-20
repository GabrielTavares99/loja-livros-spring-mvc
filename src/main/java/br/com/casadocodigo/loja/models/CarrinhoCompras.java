package br.com.casadocodigo.loja.models;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.LinkedHashMap;
import java.util.Map;

@Scope(value = WebApplicationContext.SCOPE_SESSION)
@Component
public class CarrinhoCompras {

    private Map<CarrinhoItem, Integer> itensCarrinho = new LinkedHashMap<>();

    public void add(CarrinhoItem item){
        itensCarrinho.put(item, getQuantidadeItem(item)+1);
    }

    public Integer getQuantidadeItem(CarrinhoItem item){
        if (!itensCarrinho.containsKey(item)){
            itensCarrinho.put(item, 0);
        }
        return itensCarrinho.get(item);
    }

    public int getQuantidade() {
        return itensCarrinho.values().stream().reduce(0, (proximo,acumulador) -> proximo + acumulador);
    }

    public Map<CarrinhoItem, Integer> getItensCarrinho() {
        return itensCarrinho;
    }

    public void setItensCarrinho(Map<CarrinhoItem, Integer> itensCarrinho) {
        this.itensCarrinho = itensCarrinho;
    }
}
