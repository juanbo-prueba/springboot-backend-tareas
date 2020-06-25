package com.springboot.zeus.tareas.seriesVentas.payload;

public class Clientes {

    private int codAreaEmpresa;
    private int codCliente;

    public Clientes() {
    }

    public int getCodAreaEmpresa() {
        return codAreaEmpresa;
    }

    public void setCodAreaEmpresa(int codAreaEmpresa) {
        this.codAreaEmpresa = codAreaEmpresa;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }
}
