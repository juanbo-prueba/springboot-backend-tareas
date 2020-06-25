package com.springboot.zeus.tareas.seriesVentas.controller;

import com.springboot.zeus.tareas.seriesVentas.payload.ComportamientoVentasCliente;
import com.springboot.zeus.tareas.seriesVentas.service.SeriesTiempoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/prueba")
public class PruebasTest {

    @Autowired
    @Qualifier("seriesTiempoService")
    private SeriesTiempoService seriesTiempoService;

    @GetMapping("/comportamientoVentaCliente/{codCliente}")
    public ComportamientoVentasCliente getCumplimientoPresentacionesFuncionario(@PathVariable("codCliente") int codCliente){
        return seriesTiempoService.obtieneComportamientoDeVentasPorCliente( codCliente );
    }

}

