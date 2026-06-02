package com.petshop.model;

public class Comanda {
    private Integer idComanda;
    private Float precoTotal;

    public Comanda(Integer idComanda, Float precoTotal) {
        this.idComanda = idComanda;
        this.precoTotal = precoTotal;
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
}
