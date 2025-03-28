package com.JavaApisWeb.code.empleado.entidades;

public class Empleado {
    private long id;
    private String nombre;
    private String apellido;
    private String posicion;

    public Empleado() {
    }

    public Empleado(long id, String nombre, String apellido, String posicion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.posicion = posicion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
}
