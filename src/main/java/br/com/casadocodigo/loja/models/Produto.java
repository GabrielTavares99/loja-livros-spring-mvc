package br.com.casadocodigo.loja.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Produto {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nome;
    private String descricao;
    private int paginas;

    @ElementCollection
    private List<Preco> precos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", paginas='" + paginas + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }


    public List<Preco> getPrecos() {
        return precos;
    }

    public void setPrecos(List<Preco> precos) {
        this.precos = precos;
    }
}
