package com.modular5.model;

public class Vuelo {
    private int id;
    private String numeroVuelo; //
    private String origen;
    private String destino;
    private String hora;

    public Vuelo(int id, String numeroVuelo, String origen, String destino, String hora) {
        this.id = id;
        this.numeroVuelo = numeroVuelo;
        this.origen = origen;
        this.destino = destino;
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroVuelo() {
        return numeroVuelo;
    }

    public void setNumeroVuelo(String numeroVuelo) {

        this.numeroVuelo = numeroVuelo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {

        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }


    public void setDestino(String destino) {

        this.destino = destino;
    }

    public String getHora() {
        return hora;
    }


    public void setHora(String hora) {

        this.hora = hora;
    }
}