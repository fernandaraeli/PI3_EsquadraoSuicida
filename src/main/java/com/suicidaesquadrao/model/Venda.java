
package com.suicidaesquadrao.model;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Venda {
    
    int idVenda;
    int numItem;
    int idCliente;
    int idUsuario;
    int idProduto;
    String numVenda;
    String nomeProduto;
    Double preco;
    Double totalPagar;
    int quantidade;
    Double subtotal;
    String statusVenda;
    Date dataVenda;

    public Venda() {
    }

    public Venda(int idVenda, int numItem, int idCliente, int idUsuario, int idProduto, String numVenda, String nomeProduto, Double preco, Double totalPagar, int quantidade, Double subtotal, String statusVenda, Date dataVenda) {
        this.idVenda = idVenda;
        this.numItem = numItem;
        this.idCliente = idCliente;
        this.idUsuario = idUsuario;
        this.idProduto = idProduto;
        this.numVenda = numVenda;
        this.nomeProduto = nomeProduto;
        this.preco = preco;
        this.totalPagar = totalPagar;
        this.quantidade = quantidade;
        this.subtotal = subtotal;
        this.statusVenda = statusVenda;
        this.dataVenda = dataVenda;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getNumItem() {
        return numItem;
    }

    public void setNumItem(int numItem) {
        this.numItem = numItem;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNumVenda() {
        return numVenda;
    }

    public void setNumVenda(String numVenda) {
        this.numVenda = numVenda;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public String getStatusVenda() {
        return statusVenda;
    }

    public void setStatusVenda(String statusVenda) {
        this.statusVenda = statusVenda;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(Double totalPagar) {
        this.totalPagar = totalPagar;
    }
    
   
    public String getData() {
        String myData;
        myData = DateFormat.getDateInstance().format(this.dataVenda);
    return myData;
}
    
       public void setDataVendaRel(Date dataVenda) {
        this.dataVenda = dataVenda;
    }
    
}
