package com.petshop.model;

public class Telefone {
    private Integer idTel;
    private String ddd;
    private String numero;
    private String descricao;

    public Telefone(Integer idTel, String ddd, String numero, String descricao) {
        this.idTel = idTel;
        this.ddd = ddd;
        this.numero = numero;
        this.descricao = descricao;
    }

    public Integer getIdTel() {
        return this.idTel;
    }

    public void setIdTel(Integer idTel) {
        this.idTel = idTel;
    }

    public String getDdd() {
        return this.ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
