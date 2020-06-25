package com.springboot.zeus.tareas.cumplimientoPresupuestoFuncionario.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatearFecha {

    public FormatearFecha() {
    }

    public String formato_yyyy_MM_dd(Date fecha ) {
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        return formateador.format( fecha );
    }
}
