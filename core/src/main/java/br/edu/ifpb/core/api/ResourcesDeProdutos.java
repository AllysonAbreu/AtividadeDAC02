package br.edu.ifpb.core.api;

import br.edu.ifpb.core.domain.produto.DetalharProduto;
import br.edu.ifpb.core.domain.produto.ListaDeProduto;
import br.edu.ifpb.core.domain.produto.Produto;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Stateless
@Path("produtos")
public class ResourcesDeProdutos {
    @Inject
    private ListaDeProduto listaDeProduto;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Produto> todosOsProdutos(){
        return this.listaDeProduto.todosOsProdutos();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{descricao}")
    public List<Produto> detalharProduto(@PathParam("descricao") String descricao){
        return this.listaDeProduto.produtosPorDescricao(descricao);
    }
}
