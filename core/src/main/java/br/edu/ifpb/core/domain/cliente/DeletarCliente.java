package br.edu.ifpb.core.domain.cliente;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.Objects;

@Stateless
public class DeletarCliente {
    @EJB
    private Clientes clientes;

    public void deletarCliente(Cliente cliente) {
        clientes.remover(cliente.getId());
    }
}
