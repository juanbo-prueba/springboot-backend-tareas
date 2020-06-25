package com.springboot.zeus.tareas.seriesVentas.payload;

import java.util.ArrayList;
import java.util.List;

public class ComportamientoVentasCliente {

    private DatoTipos tiempo;
    private ArrayList<DatoTipos> datos = new ArrayList<>();

    public ComportamientoVentasCliente() {
    }

    public DatoTipos getTiempo() {
        return tiempo;
    }

    public void setTiempo(DatoTipos tiempo) {
        this.tiempo = tiempo;
    }

    public ArrayList<DatoTipos> getDatos() {
        return datos;
    }

    public void setDatos(ArrayList<DatoTipos> datos) {
        this.datos = datos;
    }
}
