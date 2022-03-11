package br.edu.ifpb.core.domain.venda;

import br.edu.ifpb.core.domain.produto.Produto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Venda {
    private int id;
    private LocalDate data;
    private List<Produto> produtos;

    public Venda(int id, LocalDate data) {
        this.id = id;
        this.data = data;
        produtos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void addProduto(Produto produto){
        this.produtos.add(produto);
    }

    public void removeProduto(Produto produto){
        this.produtos.remove(produto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venda venda = (Venda) o;
        return id == venda.id && data.equals(venda.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data);
    }
}
