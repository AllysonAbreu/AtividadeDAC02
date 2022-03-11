package br.edu.ifpb.core.domain.produto;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.Objects;

@Stateless
public class NovoProduto {

    @EJB
    private Produtos produtos;

    public Produto novoProduto(Produto produto) {
        Objects.requireNonNull(produto,"O produto não pode ser nulo");
        return produtos.salvar(produto);
    }
}
