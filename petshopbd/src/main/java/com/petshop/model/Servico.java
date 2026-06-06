package com.petshop.model;

public class Servico {
    private Integer idServico;
    private String tipo;
    private String descricao;
    private Float preco;

    public Servico(String tipo, String descricao, Float preco) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.preco = preco;
    }

    public Integer getIdServico() {
        return this.idServico;
    }

    public void setIdServico(Integer idServico) {
        this.idServico = idServico;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getPreco() {
        return this.preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }    
}
