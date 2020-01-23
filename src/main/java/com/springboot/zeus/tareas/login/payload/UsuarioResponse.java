package com.springboot.zeus.tareas.login.payload;

import com.springboot.zeus.tareas.login.model.Usuario;

public class UsuarioResponse {

    private String accessToken;
    private String tokenType = "Bearer";
    private boolean logeoExito;
    private Usuario usuario = new Usuario();

    public UsuarioResponse() {
    }

    public UsuarioResponse(Usuario usuario ) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioResponse(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public boolean isLogeoExito() {
        return logeoExito;
    }

    public void setLogeoExito(boolean logeoExito) {
        this.logeoExito = logeoExito;
    }
}
