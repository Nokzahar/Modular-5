package com.modular5.model;

public class Reserva {
    private int id;
    private int vueloId;
    private String nombrePasajero;
    private String emailPasajero;

    public Reserva() {}

    public Reserva(int vueloId, String nombrePasajero, String emailPasajero) {
        this.vueloId = vueloId;
        this.nombrePasajero = nombrePasajero;
        this.emailPasajero = emailPasajero;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getVueloId() { return vueloId; }
    public void setVueloId(int vueloId) { this.vueloId = vueloId; }

    public String getNombrePasajero() { return nombrePasajero; }
    public void setNombrePasajero(String nombrePasajero) { this.nombrePasajero = nombrePasajero; }

    public String getEmailPasajero() { return emailPasajero; }
    public void setEmailPasajero(String emailPasajero) { this.emailPasajero = emailPasajero; }
}