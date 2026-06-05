package com.petshop.model;

public class MetodoPagamento {
    private Integer idPag;
    private String tipo;

    public MetodoPagamento(Integer idPag, String tipo) {
        this.idPag = idPag;
        this.tipo = tipo;
    }

    public Integer getIdPag() {
        return this.idPag;
    }

    public void setIdPag(Integer idPag) {
        this.idPag = idPag;
    }

    public String getDescricao() {
        return this.tipo;
    }

    public void setDescricao(String tipo) {
        this.tipo = tipo;
    }

}
