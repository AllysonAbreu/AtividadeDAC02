package br.edu.ifpb.core.domain.produto;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class DetalharProduto {
    @EJB
    private Produtos produtos;

    public Produto detalheDeProduto(Produto produto){
        return produtos.encontrarPorId(produto.getId());
    }
}
