package br.edu.ifpb.core.domain.produto;

import java.util.List;

public interface Produtos {

    Produto salvar(Produto produto);
    Produto atualizar(int id, Produto produto);
    Produto encontrarPorId(int id);
    List<Produto> listar();
    void remover(int id);

}
