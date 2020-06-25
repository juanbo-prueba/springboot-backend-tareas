package com.springboot.zeus.tareas.seriesVentas.payload;

import java.util.ArrayList;
import java.util.List;

public class DatoTipos {

    private String tipo;
    private ArrayList<String> dato = new ArrayList<>();

    public DatoTipos() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<String> getDato() {
        return dato;
    }

    public void setDato(ArrayList<String> dato) {
        this.dato = dato;
    }
}
