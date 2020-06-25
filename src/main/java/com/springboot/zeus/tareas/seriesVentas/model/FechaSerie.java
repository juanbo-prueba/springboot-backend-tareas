package com.springboot.zeus.tareas.seriesVentas.model;

import java.util.Date;

public class FechaSerie {

    private Date fechaInicio;
    private Date fechaFin;

    public FechaSerie() {
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
}
