package com.springboot.zeus.tareas.seriesVentas.mapper;

import com.springboot.zeus.tareas.seriesVentas.model.FechaSerie;
import com.springboot.zeus.tareas.seriesVentas.payload.ClienteVentaMes;
import com.springboot.zeus.tareas.seriesVentas.payload.Clientes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Mapper
public interface SeriesTiempoMapper {

    public void eliminarFechasMaestro();
    public void adicionarFechasMaestro(@Param("codSerieFecha") int codSerieFecha,
                                       @Param("fechaInicio") String fechaInicio,
                                       @Param("fechaFin") String fechaFin );

    // obtiene fecha inicio y fin de venta de cliente
    public FechaSerie obtieneFechaInicioFechaFinDeVentaDeCliente(@Param("codCliente") int codCliente);
    public List<FechaSerie> obtieneListadoSerieFecha(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);

    public void eliminaVentasPorProductosClienteDelMes(@Param("codCliente") int codCliente);
    public List<ClienteVentaMes> obtieneVentasPorProductoPorMesDeCliente(@Param("fechaInicio") String fechaInicio, @Param("fechaFin") String fechaFin, @Param("codCliente") int codCliente);
    public void generaAdicionaVentasPorProductosClienteDelMes(@Param("fechaInicio") String fechaInicio, @Param("fechaFin") String fechaFin, @Param("codCliente") int codCliente);

    public void insertaVentaProductoClientePorMes(@Param("codAreaEmpresa") int codAreaEmpresa, @Param("codCliente") int codCliente, @Param("codPresentacion") int codPresentacion, @Param("fechaInicio") String fechaInicio, @Param("montoVenta") double montoVenta, @Param("cantidadVenta") double cantidadVenta);

    public List<Integer> obtieneClientesLineasVersiones(@Param("codAreaEmpresa") int codAreaEmpresa, @Param("codGestion") int codGestion, @Param("codMes") int codMes);

    public FechaSerie obtieneFechaMinimaFechaMaximaDeCobranzaDeCliente(@Param("codCliente") int codCliente);

    public void eliminaSerieCobranzaCliente(@Param("codCliente") int codCliente);

    public Double obtieneCobranzaPorMesDeCliente(@Param("fechaInicio") String fechaInicio, @Param("fechaFin") String fechaFin, @Param("codCliente") int codCliente);

    public void insertarCobranzaDeMesDeCliente(@Param("codAreaEmpresa") int codAreaEmpresa, @Param("codCliente") int codCliente, @Param("fechaInicio") String fechaInicio, @Param("montoCobranza") Double montoCobranza);

    //
    public FechaSerie obtieneFechaMinimaFechaMaximaDeDescuentoFidelidadDeCliente(@Param("codCliente") int codCliente);

    public void eliminaSerieDescuentoFidelidadCliente(@Param("codCliente") int codCliente);

    public Double obtieneDescuentoFidelidadPorMesDeCliente(@Param("fechaInicio") String fechaInicio, @Param("fechaFin") String fechaFin, @Param("codCliente") int codCliente);

    public void insertarDescuentoFidelidadDeMesDeCliente(@Param("codAreaEmpresa") int codAreaEmpresa, @Param("codCliente") int codCliente, @Param("fechaInicio") String fechaInicio, @Param("montoDescuentoFidelidad") Double montoDescuentoFidelidad);

    // comportamiento de ventas
    public List<Date> obtieneListadoMesesComportamiento(@Param("codCliente") int codCliente);

    public Integer obtieneVentasClienteDelMes(@Param("codCliente") int codCliente, @Param("fechaMes") String fechaMes);

    public Integer obtieneCobranzasClienteDelMes(@Param("codCliente") int codCliente, @Param("fechaMes") String fechaMes);

    public Integer obtieneDescuentoFidelidadClienteDelMes(@Param("codCliente") int codCliente, @Param("fechaMes") String fechaMes);
}
