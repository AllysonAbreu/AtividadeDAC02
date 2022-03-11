package br.edu.ifpb.core.domain.venda;

import br.edu.ifpb.core.domain.produto.Produto;

import java.util.List;

public interface Vendas {

    Venda salvar(Venda venda);
    Venda atualizar(int id, Venda venda);
    Venda encontrarPorId(int id);
    List<Produto> listar();
    void remover(int id);

    void salvarItensVenda(List<Produto> produtos);
    List<Produto> listarItensVenda(int id); // encontrar produtos associados à uma venda por id
}
