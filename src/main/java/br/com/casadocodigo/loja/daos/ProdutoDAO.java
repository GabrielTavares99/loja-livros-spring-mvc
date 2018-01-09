package br.com.casadocodigo.loja.daos;

import br.com.casadocodigo.loja.models.Produto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProdutoDAO {

    @PersistenceContext
    EntityManager entityManager;

    public void gravar(Produto produto){
        entityManager.persist(produto);
    }

    public List<Produto> listar() {
        return entityManager.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
    }
}
