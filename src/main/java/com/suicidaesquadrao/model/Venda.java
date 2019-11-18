
package com.suicidaesquadrao.model;


public class Venda {
    
    Integer id;
    Integer item;
    Integer idCliente;
    Integer idUsuario;
    Integer idProduto;
    String numVenda;
    String descricao;
    Double preco;
    Integer quantidade;
    Double subtotal;
    String status;

    public Venda() {
    }

    public Venda(Integer id, Integer item, Integer idCliente, Integer idUsuario, Integer idProduto, String numVenda, String descricao, Double preco, Integer quantidade, Double subtotal, String status) {
        this.id = id;
        this.item = item;
        this.idCliente = idCliente;
        this.idUsuario = idUsuario;
        this.idProduto = idProduto;
        this.numVenda = numVenda;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.subtotal = subtotal;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getNumVenda() {
        return numVenda;
    }

    public void setNumVenda(String numVenda) {
        this.numVenda = numVenda;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    

     
    
}
