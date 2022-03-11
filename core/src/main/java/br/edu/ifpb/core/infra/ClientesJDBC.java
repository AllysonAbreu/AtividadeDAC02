package br.edu.ifpb.core.infra;

import br.edu.ifpb.core.domain.cliente.Cliente;
import br.edu.ifpb.core.domain.cliente.Clientes;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

@Stateless
public class ClientesJDBC implements Clientes {

    @Resource(lookup = "java:app/jdbc/pgadmin")
    private DataSource dataSource;



    @Override
    public Cliente salvar(Cliente cliente) {
        try {
            PreparedStatement statement = this.dataSource
                    .getConnection()
                    .prepareStatement(
                            "INSERT INTO clientela(nome, cpf) VALUES(?,?) RETURNING *; "
                    );
            statement.setString(1,cliente.getNome());
            statement.setString(2,cliente.getCpf());
            ResultSet result = statement.executeQuery();
            if(result.next())
                return criarCliente(result);
        } catch (SQLException e) {
            Logger.getLogger(ClientesJDBC.class.getName()).log(Level.SEVERE,null,e);
        }
        return null;
    }

    @Override
    public Cliente atualizar(int id, Cliente cliente) {
        try{
            PreparedStatement statement = this.dataSource
                    .getConnection()
                    .prepareStatement(
                            "UPDATE clientela SET nome=?, cpf=? WHERE id=? RETURNING *"
                    );
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getCpf());
            statement.setInt(3, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
                return criarCliente(resultSet);
        } catch (SQLException e) {
            Logger.getLogger(ClientesJDBC.class.getName()).log(Level.SEVERE,null,e);;
        }
        return null;
    }

    @Override
    public Cliente encontrarPorId(int id) {
        try {
            PreparedStatement statement = this.dataSource
                    .getConnection()
                    .prepareStatement(
                            "SELECT * FROM clientela WHERE id=?"
                    );
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
                return criarCliente(resultSet);
        } catch (SQLException e) {
            Logger.getLogger(ClientesJDBC.class.getName()).log(Level.SEVERE,null,e);;
        }
        return null;
    }

    @Override
    public List<Cliente> listar() {
        try {
            List<Cliente> clientes = new ArrayList<>();
            ResultSet result = this.dataSource
                    .getConnection()
                    .prepareStatement(
                            "SELECT * FROM clientela"
                    ).executeQuery();

            while (result.next()){
                clientes.add(
                        criarCliente(result)
                );
            }
            return clientes;
        } catch (SQLException e) {
            Logger.getLogger(ClientesJDBC.class.getName()).log(Level.SEVERE,null,e);;
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public void remover(int id) {
        try {
            PreparedStatement statement = this.dataSource
                    .getConnection()
                    .prepareStatement(
                            "DELETE FROM clientela WHERE id=?"
                    );
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(ClientesJDBC.class.getName()).log(Level.SEVERE,null,e);;
        }
    }

    private Cliente criarCliente(ResultSet result) throws SQLException {
        String nome = result.getString("nome");
        String cpf = result.getString("cpf");
        int id = result.getInt("id");
        return new Cliente(id,nome, cpf);
    }

}
