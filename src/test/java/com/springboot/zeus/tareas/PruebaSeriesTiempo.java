package com.springboot.zeus.tareas;

import com.springboot.zeus.tareas.seriesVentas.service.SeriesTiempoService;
import com.springboot.zeus.tareas.seriesVentas.service.impl.SeriesTiempoServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PruebaSeriesTiempo {

    @Autowired
    private SeriesTiempoServiceImpl seriesTiempoService;

    @Test
    public void testVerificarGenerarSerieFechaMaestro(){

        //seriesTiempoService.generarSerieFechaMaestro();
       //   seriesTiempoService.generaSerieVentasDeClientes();
          seriesTiempoService.generaSerieComportamientovVentas();
      //    seriesTiempoService.obtieneComportamientoDeVentasPorCliente();
    }
}
