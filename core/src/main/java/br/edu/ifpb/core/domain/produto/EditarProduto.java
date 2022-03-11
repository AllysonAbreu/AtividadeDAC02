package br.edu.ifpb.core.domain.produto;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.Objects;

@Stateless
public class EditarProduto {

    @EJB
    private Produtos produtos;

    public Produto editarProduto(Produto produto) {
        Objects.requireNonNull(produto,"O produto não pode ser nulo");
        return produtos.atualizar(produto.getId(), produto);
    }
}
