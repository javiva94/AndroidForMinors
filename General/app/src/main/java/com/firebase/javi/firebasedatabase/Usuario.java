package com.firebase.javi.firebasedatabase;

/**
 * Created by javi on 26/4/18.
 */

public class Usuario {

    String usuarioId;
    String usuarioNombre;
    String usuarioGenero;
    String usuarioEdad;

    public Usuario(){

    }

    public Usuario(String usuarioId, String usuarioNombre, String usuarioGenero, String usuarioEdad) {
        this.usuarioId = usuarioId;
        this.usuarioNombre = usuarioNombre;
        this.usuarioGenero = usuarioGenero;
        this.usuarioEdad = usuarioEdad;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public String getUsuarioGenero() {
        return usuarioGenero;
    }

    public String getUsuarioEdad() {
        return usuarioEdad;
    }
}

