package com.springboot.zeus.tareas.seriesVentas.repository;

import com.springboot.zeus.tareas.seriesVentas.mapper.SeriesTiempoMapper;
import com.springboot.zeus.tareas.seriesVentas.model.FechaSerie;
import com.springboot.zeus.tareas.seriesVentas.payload.ClienteVentaMes;
import com.springboot.zeus.tareas.seriesVentas.payload.Clientes;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Repository("seriesTiempoRepository")
public class SeriesTiempoRepository {

    @Autowired
    private SeriesTiempoMapper seriesTiempoMapper;

    public void eliminarFechasMaestro(){
        seriesTiempoMapper.eliminarFechasMaestro();
    }

    public void adicionarFechasMaestro(int codSerieFecha, String fechaInicio, String fechaFin ){
        seriesTiempoMapper.adicionarFechasMaestro( codSerieFecha, fechaInicio, fechaFin );
    }

    public FechaSerie obtieneFechaInicioFechaFinDeVentaDeCliente(int codCliente) {
       return seriesTiempoMapper.obtieneFechaInicioFechaFinDeVentaDeCliente(codCliente);
    }

    public List<FechaSerie> obtieneListadoSerieFecha(Date fechaInicio, Date fechaFin){
        return seriesTiempoMapper.obtieneListadoSerieFecha( fechaInicio, fechaFin );
    }

    public void eliminaVentasPorProductosClienteDelMes(int codCliente){
        seriesTiempoMapper.eliminaVentasPorProductosClienteDelMes( codCliente );
    }

    public List<ClienteVentaMes> obtieneVentasPorProductoPorMesDeCliente(String fechaInicio, String fechaFin, int codCliente){
        return seriesTiempoMapper.obtieneVentasPorProductoPorMesDeCliente( fechaInicio, fechaFin, codCliente );
    }
    public void generaAdicionaVentasPorProductosClienteDelMes(String fechaInicio, String fechaFin, int codCliente){
        seriesTiempoMapper.generaAdicionaVentasPorProductosClienteDelMes(fechaInicio, fechaFin, codCliente);
    }

    public void insertaVentaProductoClientePorMes(int codAreaEmpresa, int codCliente, int codPresentacion, String fechaInicio, double montoVenta, double cantidadVenta) {
        seriesTiempoMapper.insertaVentaProductoClientePorMes(codAreaEmpresa, codCliente, codPresentacion, fechaInicio,  montoVenta, cantidadVenta);
    }

    public List<Integer> obtieneClientesLineasVersiones(int codAreaEmpresa, int codGestion, int codMes) {
       return seriesTiempoMapper.obtieneClientesLineasVersiones(codAreaEmpresa, codGestion, codMes);
    }

    public FechaSerie obtieneFechaMinimaFechaMaximaDeCobranzaDeCliente(int codCliente) {
        return seriesTiempoMapper.obtieneFechaMinimaFechaMaximaDeCobranzaDeCliente(codCliente);
    }

    public void eliminaSerieCobranzaCliente(int codCliente) {
        seriesTiempoMapper.eliminaSerieCobranzaCliente( codCliente );
    }

    public Double obtieneCobranzaPorMesDeCliente(String fechaInicio, String fechaFin, int codCliente) {
        return seriesTiempoMapper.obtieneCobranzaPorMesDeCliente(fechaInicio, fechaFin, codCliente );
    }

    public void insertarCobranzaDeMesDeCliente(int codAreaEmpresa, int codCliente, String fechaInicio, Double montoCobranza) {
        seriesTiempoMapper.insertarCobranzaDeMesDeCliente(codAreaEmpresa, codCliente, fechaInicio, montoCobranza);
    }

    public FechaSerie obtieneFechaMinimaFechaMaximaDeDescuentoFidelidadDeCliente(int codCliente) {
        return seriesTiempoMapper.obtieneFechaMinimaFechaMaximaDeDescuentoFidelidadDeCliente(codCliente);
    }

    public void eliminaSerieDescuentoFidelidadCliente(int codCliente) {
        seriesTiempoMapper.eliminaSerieDescuentoFidelidadCliente( codCliente );
    }

    public Double obtieneDescuentoFidelidadPorMesDeCliente(String fechaInicio, String fechaFin, int codCliente) {
        return seriesTiempoMapper.obtieneDescuentoFidelidadPorMesDeCliente( fechaInicio, fechaFin, codCliente );
    }

    public void insertarDescuentoFidelidadDeMesDeCliente(int codAreaEmpresa, int codCliente, String fechaInicio, Double montoDescuentoFidelidad) {
        seriesTiempoMapper.insertarDescuentoFidelidadDeMesDeCliente( codAreaEmpresa, codCliente, fechaInicio, montoDescuentoFidelidad );
    }

    public List<Date> obtieneListadoMesesComportamiento(int codCliente) {
        return seriesTiempoMapper.obtieneListadoMesesComportamiento(codCliente);
    }

    public Integer obtieneVentasClienteDelMes(int codCliente, String fechaMes) {
        return seriesTiempoMapper.obtieneVentasClienteDelMes( codCliente, fechaMes );
    }

    public Integer obtieneCobranzasClienteDelMes(int codCliente, String fechaMes) {
        return seriesTiempoMapper.obtieneCobranzasClienteDelMes( codCliente, fechaMes );
    }

    public Integer obtieneDescuentoFidelidadClienteDelMes(int codCliente, String fechaMes) {
        return seriesTiempoMapper.obtieneDescuentoFidelidadClienteDelMes( codCliente, fechaMes );
    }
}
