package com.springboot.zeus.tareas.cumplimientoPresupuestoFuncionario.mapper;

import com.springboot.zeus.tareas.cumplimientoPresupuestoFuncionario.model.FechaInicioFin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CumplimientoPresupuestoFuncionarioMapper {

    public int obtenerCodigoPresupuestoFuncionarioActual();
    public FechaInicioFin obtenerFechaInicioFechaFinDePresupuestoActual(@Param("codPresupuesto") int codPresupuesto);
    public List<Integer> obtenerAreasEmpresaDeVentas();
    public void eliminarVentasDeSeguimientoPresupuesto(@Param("codPresupuesto") int codPresupuesto, @Param("codAreaEmpresa") int codAreaEmpresa);
    public void generarVentasDeSeguimientoPresupuesto(@Param("fechaInicio") String fechaInicio, @Param("fechaFin") String fechaFin,
                                                      @Param("codPresupuesto") int codPresupuesto, @Param("codAreaEmpresa") int codAreaEmpresa);
    public void actualizaPersonalClienteEnVentasSeguimiento(@Param("codPresupuesto") int codPresupuesto);
}
