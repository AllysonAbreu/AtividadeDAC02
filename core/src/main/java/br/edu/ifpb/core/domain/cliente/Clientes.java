package br.edu.ifpb.core.domain.cliente;

import java.util.List;

public interface Clientes {

    Cliente salvar(Cliente cliente);
    Cliente atualizar(int id, Cliente cliente);
    Cliente encontrarPorId(int id);
    List<Cliente> listar();
    void remover(int id);

}
