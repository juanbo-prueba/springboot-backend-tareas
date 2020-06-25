package com.springboot.zeus.tareas.seriesVentas.service;

import com.springboot.zeus.tareas.seriesVentas.payload.ComportamientoVentasCliente;

public interface SeriesTiempoService {

    public abstract void generarSerieFechaMaestro();
    public abstract void generaSerieVentasDeClientes();
    public abstract void generaSerieComportamientovVentas();
    public abstract ComportamientoVentasCliente obtieneComportamientoDeVentasPorCliente(int codCliente);
}
