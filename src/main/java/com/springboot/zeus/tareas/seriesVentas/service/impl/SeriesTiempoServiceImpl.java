package com.springboot.zeus.tareas.seriesVentas.service.impl;

import com.springboot.zeus.tareas.seriesVentas.model.FechaSerie;
import com.springboot.zeus.tareas.seriesVentas.payload.ClienteVentaMes;
import com.springboot.zeus.tareas.seriesVentas.payload.Clientes;
import com.springboot.zeus.tareas.seriesVentas.payload.ComportamientoVentasCliente;
import com.springboot.zeus.tareas.seriesVentas.payload.DatoTipos;
import com.springboot.zeus.tareas.seriesVentas.repository.SeriesTiempoRepository;
import com.springboot.zeus.tareas.seriesVentas.service.SeriesTiempoService;
import com.springboot.zeus.tareas.seriesVentas.util.FormatearFecha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service("seriesTiempoService")
public class SeriesTiempoServiceImpl implements SeriesTiempoService {

    @Autowired
    @Qualifier("seriesTiempoRepository")
    private SeriesTiempoRepository seriesTiempoRepository;

    @Override
    public void generarSerieFechaMaestro() {

        Calendar calendarioInicio = GregorianCalendar.getInstance();
        calendarioInicio.set(2009, Calendar.DECEMBER, 1);

        Calendar calendarioFin = GregorianCalendar.getInstance();
        calendarioFin.set(2030, Calendar.DECEMBER, 1);

        System.out.println("fecha inicio: "+calendarioInicio.getTime().toLocaleString());
        System.out.println("fecha fin: "+calendarioFin.getTime().toLocaleString());

        int difA = calendarioFin.get(Calendar.YEAR) - calendarioInicio.get(Calendar.YEAR);
        int difM = difA * 12 + calendarioFin.get(Calendar.MONTH) - calendarioInicio.get(Calendar.MONTH);
        System.out.println(difM);

        Calendar fechaPrimerDiaMes =  Calendar.getInstance();
        Calendar fechaUltimoDiaMes =  Calendar.getInstance();

        fechaPrimerDiaMes.setTime( calendarioInicio.getTime() );

        FormatearFecha formatear = new FormatearFecha();
        seriesTiempoRepository.eliminarFechasMaestro();

        for ( int i = 1; i <= difM; i++ ) {

            fechaPrimerDiaMes.add( fechaPrimerDiaMes.MONTH, 1 );
            //System.out.println("iniciao" + fechaPrimerDiaMes.getTime().toString() );
            fechaUltimoDiaMes.setTime( fechaPrimerDiaMes.getTime());
            fechaUltimoDiaMes.set(fechaPrimerDiaMes.DATE, fechaPrimerDiaMes.getActualMaximum(fechaPrimerDiaMes.DATE));

            String fechaInicio = formatear.formato_dd_mm_yyyy( fechaPrimerDiaMes.getTime());
            String fechaFin = formatear.formato_dd_mm_yyyy( fechaUltimoDiaMes.getTime());
            seriesTiempoRepository.adicionarFechasMaestro(i, fechaInicio, fechaFin );
        }
    }

    @Override
    public void generaSerieVentasDeClientes() {
        FormatearFecha formatear = new FormatearFecha();
        //for
        // obtener fecha inicio fin de venta de cliente
        // cod cliente
        int codCliente = 1622419;
        int codAreaEmpresa = 46;
       // generaSerieVentasPorMesDeCliente(codCliente);
        int codGestion = 16;
        int codMes = 5;

      //   generaSerieVentasPorMesDeCliente2(codAreaEmpresa, codCliente);
        List<Integer> clientes = seriesTiempoRepository.obtieneClientesLineasVersiones(codAreaEmpresa, codGestion, codMes);
        for (Integer cliente: clientes ) {
            generaSerieVentasPorMesDeCliente2(codAreaEmpresa, cliente);
        }
    }

    @Override
    public void generaSerieComportamientovVentas() {

        int codCliente = 1622419;
        int codAreaEmpresa = 46;
     //   generaSerieCobranzasPorMesDeCliente(codAreaEmpresa, codCliente);
       // generaSerieDescuentoFidelidadPorMesDeCliente(codAreaEmpresa, codCliente);
        int codGestion = 16;
        int codMes = 5;

        //   generaSerieVentasPorMesDeCliente2(codAreaEmpresa, codCliente);
        List<Integer> clientes = seriesTiempoRepository.obtieneClientesLineasVersiones(codAreaEmpresa, codGestion, codMes);
        for (Integer cliente: clientes ) {
            generaSerieVentasPorMesDeCliente2(codAreaEmpresa, cliente);
            generaSerieCobranzasPorMesDeCliente(codAreaEmpresa, cliente);
            generaSerieDescuentoFidelidadPorMesDeCliente(codAreaEmpresa, cliente);
        }
    }

    @Override
    public ComportamientoVentasCliente obtieneComportamientoDeVentasPorCliente(int codCliente) {

        FormatearFecha formatear = new FormatearFecha();

       // int codCliente = 1622419;
        List<Date> fechas = seriesTiempoRepository.obtieneListadoMesesComportamiento(codCliente);
        ComportamientoVentasCliente lista = new ComportamientoVentasCliente();

        DatoTipos tiempo = new DatoTipos();
        tiempo.setTipo("Fecha");

        DatoTipos ventas = new DatoTipos();
        ventas.setTipo("Ventas");

        DatoTipos cobranzas = new DatoTipos();
        cobranzas.setTipo("Cobranzas");

        DatoTipos fidelidades = new DatoTipos();
        fidelidades.setTipo("Descuento fidelidad");

        for (Date fecha: fechas ) {
            String fechaMes = formatear.formato_yyyy_MM_dd( fecha );
            tiempo.getDato().add( fechaMes );

            Integer montoVenta = seriesTiempoRepository.obtieneVentasClienteDelMes(codCliente, fechaMes);
            Integer montoCobranza = seriesTiempoRepository.obtieneCobranzasClienteDelMes(codCliente, fechaMes);
            Integer montoFidelidad =seriesTiempoRepository.obtieneDescuentoFidelidadClienteDelMes(codCliente, fechaMes);

            String datoVenta = "null";
            String datoCobranza = "null";
            String datoFidelidad = "null";

            if ( montoVenta != null ) datoVenta = montoVenta.toString();
            if ( montoCobranza != null ) datoCobranza = montoCobranza.toString();
            if ( montoFidelidad != null ) datoFidelidad = montoFidelidad.toString();

            ventas.getDato().add(datoVenta);
            cobranzas.getDato().add(datoCobranza);
            fidelidades.getDato().add(datoFidelidad);
        }

        lista.setTiempo(tiempo);
        lista.getDatos().add(ventas);
        lista.getDatos().add(cobranzas);
        lista.getDatos().add(fidelidades);

        return lista;
    }

    public void generaSerieDescuentoFidelidadPorMesDeCliente(int codAreaEmpresa, int codCliente){
        FormatearFecha formatear = new FormatearFecha();
        FechaSerie fechaSerie = seriesTiempoRepository.obtieneFechaMinimaFechaMaximaDeDescuentoFidelidadDeCliente(codCliente);

        if(fechaSerie != null) {
            fechaSerie = inicializaFechaSerie( fechaSerie );
            seriesTiempoRepository.eliminaSerieDescuentoFidelidadCliente( codCliente );
            List<FechaSerie> fechaSeries = seriesTiempoRepository.obtieneListadoSerieFecha(fechaSerie.getFechaInicio(), fechaSerie.getFechaFin());
            for (FechaSerie fecha: fechaSeries ) {
                String fechaInicio = formatear.formato_yyyy_MM_dd(fecha.getFechaInicio());
                String fechaFin = formatear.formato_yyyy_MM_dd(fecha.getFechaFin());
                Double montoDescuentoFidelidad = seriesTiempoRepository.obtieneDescuentoFidelidadPorMesDeCliente(fechaInicio, fechaFin + " 23:59:59", codCliente);
                if( montoDescuentoFidelidad != null ) {
                    seriesTiempoRepository.insertarDescuentoFidelidadDeMesDeCliente(codAreaEmpresa, codCliente, fechaFin, montoDescuentoFidelidad );
                } else {
                    seriesTiempoRepository.insertarDescuentoFidelidadDeMesDeCliente(codAreaEmpresa, codCliente, fechaFin, (double) 0);
                }
            }
        }
    }

    private FechaSerie inicializaFechaSerie(FechaSerie fechaSerie) {
        Calendar fechaPrimerDiaMes =  Calendar.getInstance();
        Calendar fechaUltimoDiaMes =  Calendar.getInstance();

        fechaPrimerDiaMes.setTime( fechaSerie.getFechaInicio() );
        fechaPrimerDiaMes.set( fechaPrimerDiaMes.DAY_OF_MONTH, 1); //A la fecha actual le pongo el día 1

        fechaUltimoDiaMes.setTime( fechaSerie.getFechaFin() );
        fechaUltimoDiaMes.set(fechaUltimoDiaMes.DATE, fechaUltimoDiaMes.getActualMaximum(fechaUltimoDiaMes.DATE));

        fechaSerie.setFechaInicio( fechaPrimerDiaMes.getTime() );
        fechaSerie.setFechaFin( fechaUltimoDiaMes.getTime());
        return fechaSerie;
    }

    public void generaSerieCobranzasPorMesDeCliente(int codAreaEmpresa, int codCliente){
        FormatearFecha formatear = new FormatearFecha();
        FechaSerie fechaSerie = seriesTiempoRepository.obtieneFechaMinimaFechaMaximaDeCobranzaDeCliente(codCliente);
        if ( fechaSerie != null ) {
            seriesTiempoRepository.eliminaSerieCobranzaCliente( codCliente );
            List<FechaSerie> fechaSeries = seriesTiempoRepository.obtieneListadoSerieFecha(fechaSerie.getFechaInicio(), fechaSerie.getFechaFin());
            for (FechaSerie fecha: fechaSeries ) {
                String fechaInicio = formatear.formato_yyyy_MM_dd(fecha.getFechaInicio());
                String fechaFin = formatear.formato_yyyy_MM_dd(fecha.getFechaFin());
                Double montoCobranza = seriesTiempoRepository.obtieneCobranzaPorMesDeCliente(fechaInicio, fechaFin + " 23:59:59", codCliente);
                if( montoCobranza != null ) {
                    seriesTiempoRepository.insertarCobranzaDeMesDeCliente(codAreaEmpresa, codCliente, fechaFin, montoCobranza );
                } else {
                    seriesTiempoRepository.insertarCobranzaDeMesDeCliente(codAreaEmpresa, codCliente, fechaFin, (double) 0);
                }
            }
        }
    }

    public void generaSerieVentasPorMesDeCliente2(int codAreaEmpresa, int codCliente){
        FormatearFecha formatear = new FormatearFecha();
        FechaSerie fechaSerie = seriesTiempoRepository.obtieneFechaInicioFechaFinDeVentaDeCliente(codCliente);
        if (fechaSerie != null) {
            List<FechaSerie> fechaSeries = seriesTiempoRepository.obtieneListadoSerieFecha(fechaSerie.getFechaInicio(), fechaSerie.getFechaFin());
            seriesTiempoRepository.eliminaVentasPorProductosClienteDelMes( codCliente );
            for (FechaSerie fecha: fechaSeries ) {
                String fechaInicio = formatear.formato_yyyy_MM_dd(fecha.getFechaInicio());
                String fechaFin = formatear.formato_yyyy_MM_dd(fecha.getFechaFin());
                List<ClienteVentaMes> clienteVentaMes = seriesTiempoRepository.obtieneVentasPorProductoPorMesDeCliente(fechaInicio, fechaFin + " 23:59:59", codCliente);

                if ( clienteVentaMes.size() > 0 ) {
                    for (ClienteVentaMes venta: clienteVentaMes ) {
                        seriesTiempoRepository.insertaVentaProductoClientePorMes(codAreaEmpresa, codCliente, venta.getCodPresentacion(), fechaFin, venta.getMontoVenta(), venta.getCantidadVenta());
                    }
                } else {
                    seriesTiempoRepository.insertaVentaProductoClientePorMes(codAreaEmpresa, codCliente, 0, fechaFin, 0, 0);
                }
            }
        }
    }



    /*
    public void generaSerieVentasPorMesDeCliente(int codCliente){
        FormatearFecha formatear = new FormatearFecha();
        FechaSerie fechaSerie = seriesTiempoRepository.obtieneFechaInicioFechaFinDeVentaDeCliente(codCliente);
        List<FechaSerie> fechaSeries = seriesTiempoRepository.obtieneListadoSerieFecha(fechaSerie.getFechaInicio(), fechaSerie.getFechaFin());
        seriesTiempoRepository.eliminaVentasPorProductosClienteDelMes( codCliente );
        for (FechaSerie fecha: fechaSeries ) {
            String fechaInicio = formatear.formato_yyyy_MM_dd(fecha.getFechaInicio());
            String fechaFin = formatear.formato_yyyy_MM_dd(fecha.getFechaFin());
            seriesTiempoRepository.generaAdicionaVentasPorProductosClienteDelMes( fechaInicio, fechaFin + " 23:59:59", codCliente);
        }
    }
*/

}
