package br.com.casadocodigo.loja.models;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class CarrinhoCompras implements Serializable {

    private Map<CarrinhoItem, Integer> itensCarrinho = new LinkedHashMap<>();

    public void add(CarrinhoItem item) {
        itensCarrinho.put(item, getQuantidadeItem(item) + 1);
    }

    public Integer getQuantidadeItem(CarrinhoItem item) {
        if (!itensCarrinho.containsKey(item)) {
            itensCarrinho.put(item, 0);
        }

        return itensCarrinho.get(item);
    }

    public Collection<CarrinhoItem> getItens() {
        System.out.println(itensCarrinho.keySet());
        return itensCarrinho.keySet();
    }

    public int getQuantidade() {
        return itensCarrinho.values().stream().reduce(0, (proximo, acumulador) -> proximo + acumulador);
    }

    public BigDecimal getTotal(CarrinhoItem item) {
        return item.getTotal(getQuantidadeItem(item));
    }

    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (CarrinhoItem item : itensCarrinho.keySet()) {
            total = total.add(getTotal(item));
        }
        return total;
    }

    public Map<CarrinhoItem, Integer> getItensCarrinho() {
        return itensCarrinho;
    }

    public void setItensCarrinho(Map<CarrinhoItem, Integer> itensCarrinho) {
        this.itensCarrinho = itensCarrinho;
    }

    public void remover(Integer produtoId, TipoPreco tipoPreco) {
        Produto produto = new Produto();
        produto.setId(produtoId);
        itensCarrinho.remove(new CarrinhoItem(produto, tipoPreco));
    }
}
