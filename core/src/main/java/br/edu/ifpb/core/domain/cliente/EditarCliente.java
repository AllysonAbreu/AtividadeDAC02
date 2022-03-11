package br.edu.ifpb.core.domain.cliente;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.Objects;

@Stateless
public class EditarCliente {

    @EJB
    private Clientes clientes;

    public Cliente editarCliente(Cliente cliente) {
        Objects.requireNonNull(cliente,"O cliente não pode ser nulo");
        return clientes.atualizar(cliente.getId(), cliente);
    }
}
