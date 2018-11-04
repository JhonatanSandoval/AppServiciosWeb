package com.miempresa.appserviciosweb.api.request;

public class RegistroRequest {

    private String nombres;
    private String apellidos;
    private String email;
    private String password;

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
