package br.edu.ifpb.core.domain.cliente;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.Objects;

@Stateless
public class NovoCliente {

    @EJB
    private Clientes clientes;

    public Cliente novoCliente(Cliente cliente) {
        Objects.requireNonNull(cliente,"O cliente não pode ser nulo");
        return clientes.salvar(cliente);
    }
}
