package br.edu.ifpb.core.web;

import br.edu.ifpb.core.domain.cliente.*;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.io.Serializable;
import java.util.List;

@Named // Use @javax.faces.bean.ManagedBean on outdated environments.
@SessionScoped // Use @javax.faces.bean.RequestScoped on outdated environments.
public class ControladorClientes implements Serializable {

    @Inject
    private ListaDeClientes listarClientes;
    @Inject
    private NovoCliente cadastrarCliente;
    @Inject
    private EditarCliente editarCliente;
    @Inject
    private DeletarCliente deletarCliente;

    private Cliente cliente = new Cliente(0, "", "");

    public List<Cliente> list(){
        return this.listarClientes.todosOsClientes();
    }

    public String edit(Cliente cliente){
        this.cliente = cliente;
        return "/clientes/form.xhtml?faces-redirect=true";
    }

    public String delete(Cliente cliente){
        deletarCliente.deletarCliente(cliente);
        return "/clientes/list.xhtml?faces-redirect=true";
    }

    public String submit() {
        String result = "Cliente{id: "+ cliente.getId() +", nome: "+ cliente.getNome() +", cpf: "+ cliente.getCpf()+"}";
        System.out.println(result);
        if (cliente.getId()==0){
            this.create();
        }
        else{
            this.update();
        }
        this.cliente = new Cliente(0, "", "");
        return "/clientes/list.xhtml?faces-redirect=true";
    }

    private void update() {
        editarCliente.editarCliente(cliente);
    }

    private void create() {
        cadastrarCliente.novoCliente(cliente);
    }

    public Cliente getCliente() {
        return cliente;
    }

}