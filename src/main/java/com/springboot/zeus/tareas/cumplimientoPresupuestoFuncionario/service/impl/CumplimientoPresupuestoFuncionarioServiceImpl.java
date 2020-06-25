package com.springboot.zeus.tareas.cumplimientoPresupuestoFuncionario.service.impl;

import com.springboot.zeus.tareas.cumplimientoPresupuestoFuncionario.model.FechaInicioFin;
import com.springboot.zeus.tareas.cumplimientoPresupuestoFuncionario.repository.CumplimientoPresupuestoFuncionarioRepository;
import com.springboot.zeus.tareas.cumplimientoPresupuestoFuncionario.service.CumplimientoPresupuestoFuncionarioService;
import com.springboot.zeus.tareas.cumplimientoPresupuestoFuncionario.util.FormatearFecha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("cumplimientoPresupuestoFuncionarioService")
public class CumplimientoPresupuestoFuncionarioServiceImpl implements CumplimientoPresupuestoFuncionarioService {

    @Autowired
    @Qualifier("cumplimientoPresupuestoFuncionarioRepository")
    private CumplimientoPresupuestoFuncionarioRepository repositoryCumplimientoFuncionario;

    @Override
    public void actualizaVentasParaSeguimientoPresupuestoFuncionario() {

        FormatearFecha formatoFecha = new FormatearFecha();
        String fechaInicio = "";
        String fechaFin = "";

        int codigoPresupuestoSeguimiento = repositoryCumplimientoFuncionario.obtenerCodigoPresupuestoFuncionarioActual();
        FechaInicioFin fechaInicioFin = repositoryCumplimientoFuncionario.obtenerFechaInicioFechaFinDePresupuestoActual(codigoPresupuestoSeguimiento);

        fechaInicio = formatoFecha.formato_yyyy_MM_dd( fechaInicioFin.getFechaInicio()) + " 00:00:00";
        fechaFin = formatoFecha.formato_yyyy_MM_dd( fechaInicioFin.getFechaFin()) + " 23:59:59";;

        List<Integer> listaRegionales = repositoryCumplimientoFuncionario.obtenerAreasEmpresaDeVentas();

        for (Integer codAreaEmpresa: listaRegionales ) {
            repositoryCumplimientoFuncionario.eliminarVentasDeSeguimientoPresupuesto(codigoPresupuestoSeguimiento, codAreaEmpresa);
            repositoryCumplimientoFuncionario.generarVentasDeSeguimientoPresupuesto(fechaInicio, fechaFin, codigoPresupuestoSeguimiento, codAreaEmpresa);
        }

        repositoryCumplimientoFuncionario.actualizaPersonalClienteEnVentasSeguimiento( codigoPresupuestoSeguimiento );

    }
}
