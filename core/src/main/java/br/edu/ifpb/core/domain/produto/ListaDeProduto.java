package br.edu.ifpb.core.domain.produto;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class ListaDeProduto {

    @EJB
    private Produtos produtos;

    public List<Produto> todosOsProdutos(){
        return this.produtos.listar();
    }

    public List<Produto> produtosPorDescricao(String descricao){
        List<Produto> produtos = this.produtos.listar();
        return (List<Produto>) produtos.stream().filter(produto -> produto.getDescricao().contains(descricao));
    }
}
