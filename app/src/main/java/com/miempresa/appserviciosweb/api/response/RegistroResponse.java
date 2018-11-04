package com.miempresa.appserviciosweb.api.response;

public class RegistroResponse {

    private boolean success;
    private int id_usuario;
    private String tokenSesion;
    private String mensaje;

    public boolean isSuccess() {
        return success;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public String getTokenSesion() {
        return tokenSesion;
    }

    public String getMensaje() {
        return mensaje;
    }
}
