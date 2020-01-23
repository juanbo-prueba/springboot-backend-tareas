package com.springboot.zeus.tareas.login.model;

public class Usuario {

    private Long id;
    private int codAreaEmpresa;
    private int codCargo;
    private String name;
    private String username;
    private String email;
    private String password;

    public Usuario() {
    }

    public Usuario(Long id, String name, String username, String email, String password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Usuario(Long id, int codAreaEmpresa, int codCargo, String name, String username, String email) {
        this.id = id;
        this.codAreaEmpresa = codAreaEmpresa;
        this.codCargo = codCargo;
        this.name = name;
        this.username = username;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCodAreaEmpresa() {
        return codAreaEmpresa;
    }

    public void setCodAreaEmpresa(int codAreaEmpresa) {
        this.codAreaEmpresa = codAreaEmpresa;
    }

    public int getCodCargo() {
        return codCargo;
    }

    public void setCodCargo(int codCargo) {
        this.codCargo = codCargo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
