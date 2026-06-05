package com.petshop.model;
import java.util.ArrayList;
public class TesteMain {
    public static void main(String[] args) {
        Dono dono=new Dono("12345678900", "Lucas", "lucas@email.com", null, new ArrayList<>(), new ArrayList<>());
        Pet pet=new Pet("Tatu", "cão", "salsicha", "pequeno", dono);
        System.out.println("Dono: "+dono.getNome()+", Pet: "+pet.getNome());
        
    }
}
