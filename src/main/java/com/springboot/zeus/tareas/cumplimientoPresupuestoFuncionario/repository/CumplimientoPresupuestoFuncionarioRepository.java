package com.springboot.zeus.tareas.cumplimientoPresupuestoFuncionario.repository;

import com.springboot.zeus.tareas.cumplimientoPresupuestoFuncionario.mapper.CumplimientoPresupuestoFuncionarioMapper;
import com.springboot.zeus.tareas.cumplimientoPresupuestoFuncionario.model.FechaInicioFin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("cumplimientoPresupuestoFuncionarioRepository")
public class CumplimientoPresupuestoFuncionarioRepository {

    @Autowired
    private CumplimientoPresupuestoFuncionarioMapper cumplimientoPresupuestoFuncionarioMapper;


    public int obtenerCodigoPresupuestoFuncionarioActual() {
        return cumplimientoPresupuestoFuncionarioMapper.obtenerCodigoPresupuestoFuncionarioActual();
    }

    public FechaInicioFin obtenerFechaInicioFechaFinDePresupuestoActual( int codPresupuesto) {
        return cumplimientoPresupuestoFuncionarioMapper.obtenerFechaInicioFechaFinDePresupuestoActual( codPresupuesto );
    }

    public List<Integer> obtenerAreasEmpresaDeVentas() {
        return cumplimientoPresupuestoFuncionarioMapper.obtenerAreasEmpresaDeVentas();
    }

    public void eliminarVentasDeSeguimientoPresupuesto( int codPresupuesto, int codAreaEmpresa ) {
        cumplimientoPresupuestoFuncionarioMapper.eliminarVentasDeSeguimientoPresupuesto( codPresupuesto, codAreaEmpresa);
    }

    public void generarVentasDeSeguimientoPresupuesto(String fechaInicio, String fechaFin, int codPresupuesto, int codAreaEmpresa){
        cumplimientoPresupuestoFuncionarioMapper.generarVentasDeSeguimientoPresupuesto(fechaInicio, fechaFin, codPresupuesto, codAreaEmpresa);
    }

    public void actualizaPersonalClienteEnVentasSeguimiento( int codPresupuesto ) {
        cumplimientoPresupuestoFuncionarioMapper.actualizaPersonalClienteEnVentasSeguimiento( codPresupuesto );
    }
}
