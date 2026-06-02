package com.petshop.model;

public class StatusServico {
    private Integer idStatus;
    private String descricao;

    public StatusServico(Integer idStatus, String descricao) {
        this.idStatus = idStatus;
        this.descricao = descricao;
    }

    public Integer getIdStatus() {
        return this.idStatus;
    }

    public void setIdStatus(Integer idStatus) {
        this.idStatus = idStatus;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
