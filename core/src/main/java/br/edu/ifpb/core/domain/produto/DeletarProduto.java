package br.edu.ifpb.core.domain.produto;


import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class DeletarProduto {
    @EJB
    private Produtos produtos;

    public void deletarProduto(Produto produto) {
        produtos.remover(produto.getId());
    }
}
