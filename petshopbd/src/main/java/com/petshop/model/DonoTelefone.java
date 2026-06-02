package com.petshop.model;

public class DonoTelefone {
    private Dono dono;
    private Telefone idTel;

    public DonoTelefone(Dono dono, Telefone idTel) {
        this.dono = dono;
        this.idTel = idTel;
    }

    public Dono getDono() {
        return this.dono;
    }

    public void setDono(Dono dono) {
        this.dono = dono;
    }

    public Telefone getIdTel() {
        return this.idTel;
    }

    public void setIdTel(Telefone idTel) {
        this.idTel = idTel;
    }
    
}
