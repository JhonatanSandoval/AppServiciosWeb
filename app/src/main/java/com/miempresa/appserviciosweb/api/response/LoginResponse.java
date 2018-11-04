package com.miempresa.appserviciosweb.api.response;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("success")
    private boolean success;

    private int id_usuario;
    private String nombres;
    private String apellidos;
    private String tokenSesion;
    private String mensaje;

    public boolean isSuccess() {
        return success;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getTokenSesion() {
        return tokenSesion;
    }

    public String getMensaje() {
        return mensaje;
    }
}
