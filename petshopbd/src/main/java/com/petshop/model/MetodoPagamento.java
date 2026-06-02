package com.petshop.model;

public class MetodoPagamento {
    private Integer idPag;
    private String descricao;

    public MetodoPagamento(Integer idPag, String descricao) {
        this.idPag = idPag;
        this.descricao = descricao;
    }

    public Integer getIdPag() {
        return this.idPag;
    }

    public void setIdPag(Integer idPag) {
        this.idPag = idPag;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
