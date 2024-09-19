package com.Spring.Restaurante.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique=true)
    private int numero_mesas;

    private boolean ocupada;

    public Mesa() {}

    public Mesa(int id, int numero_mesas, boolean ocupada) {
        this.id = id;
        this.numero_mesas = numero_mesas;
        this.ocupada = ocupada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero_mesas() {
        return numero_mesas;
    }

    public void setNumero_mesas(int numero_mesas) {
        this.numero_mesas = numero_mesas;
    }

    public boolean getOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }
}