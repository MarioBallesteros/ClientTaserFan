package com.dam.ClientTaserFan.model;

public class Vehiculo {
    private String matricula;
    private float precioHora;
    private String marca;
    private String descripcion;
    private String color;
    private int bateria;
    private String fechaAdq;
    private String carnet;
    private String estado;

    private TipoVehiculo tipoVehiculo;


    public Vehiculo(TipoVehiculo tipoVehiculo,String matricula, float precioHora, String marca, String descripcion, String color, int bateria, String fechaAdq, String estado, String carnet) {
        this.tipoVehiculo = tipoVehiculo;
        this.matricula = matricula;
        this.precioHora = precioHora;
        this.marca = marca;
        this.descripcion = descripcion;
        this.color = color;
        this.bateria = bateria;
        this.fechaAdq = fechaAdq;
        this.estado = estado;
        this.carnet = carnet;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public float getPrecioHora() {
        return precioHora;
    }

    public void setPrecioHora(float precioHora) {
        this.precioHora = precioHora;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getBateria() {
        return bateria;
    }

    public void setBateria(int bateria) {
        this.bateria = bateria;
    }

    public String getFechaAdq() {
        return fechaAdq;
    }

    public void setFechaAdq(String fechaAdq) {
        this.fechaAdq = fechaAdq;
    }

}

