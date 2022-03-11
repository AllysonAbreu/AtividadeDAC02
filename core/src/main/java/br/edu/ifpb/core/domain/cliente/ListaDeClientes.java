package br.edu.ifpb.core.domain.cliente;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class ListaDeClientes {

    @EJB
    private Clientes clientes;

    public List<Cliente> todosOsClientes(){
        return this.clientes.listar();
    }
}
