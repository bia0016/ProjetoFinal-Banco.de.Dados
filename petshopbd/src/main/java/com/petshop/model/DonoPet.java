package com.petshop.model;

public class DonoPet {
    private Dono dono;
    private Pet idPet;

    public DonoPet(Dono dono, Pet idPet) {
        this.dono = dono;
        this.idPet = idPet;
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

}
