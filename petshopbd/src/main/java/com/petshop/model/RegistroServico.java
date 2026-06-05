package com.petshop.model;

public class RegistroServico {
    private Integer idRegistro;
    private String data;
    private Dono dono;
    private Pet idPet;
    private StatusServico status;
    private Servico servico;

    public RegistroServico(String data, Dono dono, Pet idPet, StatusServico status, Servico servico) {
        this.data = data;
        this.dono = dono;
        this.idPet = idPet;
        this.status = status;
        this.servico = servico;
    }

    public Integer getIdRegistro() {
        return this.idRegistro;
    }

    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Dono getDono() {
        return this.dono;
    }

    public void setDono(Dono dono) {
        this.dono = dono;
    }

    public Pet getIdPet() {
        return this.idPet;
    }

    public void setIdPet(Pet idPet) {
        this.idPet = idPet;
    }

    public StatusServico getStatus() {
        return this.status;
    }

    public void setStatus(StatusServico status) {
        this.status = status;
    }

    public Servico getServico() {
        return this.servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

}
