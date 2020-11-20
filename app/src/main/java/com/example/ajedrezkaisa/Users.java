package com.example.ajedrezkaisa;

public class Users {

    private String idPersona,Nombre,Apellido,Edad,Correo,Contrasena,Documento;

    public Users() {

    }

    public Users(String idPersona, String nombre, String apellido, String edad, String correo, String contrasena, String documento) {
        this.idPersona = idPersona;
        Nombre = nombre;
        Apellido = apellido;
        Edad = edad;
        Correo = correo;
        Contrasena = contrasena;
        Documento = documento;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getEdad() {
        return Edad;
    }

    public void setEdad(String edad) {
        Edad = edad;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String contrasena) {
        Contrasena = contrasena;
    }

    public String getDocumento() {
        return Documento;
    }

    public void setDocumento(String documento) {
        Documento = documento;
    }
}
