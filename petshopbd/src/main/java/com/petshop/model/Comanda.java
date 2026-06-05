package com.petshop.model;

public class Comanda {
    private Integer idComanda;
    private Float precoTotal;
    private MetodoPagamento metodoPagamento;
    private Integer idRegistro;

    public Comanda(Integer idComanda, Float precoTotal, MetodoPagamento metodoPagamento, Integer idRegistro) {
        this.idComanda = idComanda;
        this.precoTotal = precoTotal;
        this.metodoPagamento = metodoPagamento;
        this.idRegistro = idRegistro;
    }

    public Integer getIdComanda() {
        return this.idComanda;
    }

    public void setIdComanda(Integer idComanda) {
        this.idComanda = idComanda;
    }

    public Float getPrecoTotal() {
        return this.precoTotal;
    }

    public void setPrecoTotal(Float precoTotal) {
        this.precoTotal = precoTotal;
    }

    public MetodoPagamento getMetodoPagamento() {
        return this.metodoPagamento;
    }

    public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public Integer getIdRegistro() {
        return this.idRegistro;
    }

    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }
}
