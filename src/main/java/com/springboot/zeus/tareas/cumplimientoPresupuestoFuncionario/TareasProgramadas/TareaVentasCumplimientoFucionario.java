package com.springboot.zeus.tareas.cumplimientoPresupuestoFuncionario.TareasProgramadas;

import com.springboot.zeus.tareas.cumplimientoPresupuestoFuncionario.service.CumplimientoPresupuestoFuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TareaVentasCumplimientoFucionario {

    @Autowired
    @Qualifier("cumplimientoPresupuestoFuncionarioService")
    private CumplimientoPresupuestoFuncionarioService servicioCumplimiento;

    @Scheduled( cron = "0 10 * * * *")
    public void PresupuestoVentasFuncionario(){
        System.out.println("PRESUPEUSTO 2: " + new Date());

    }

    @Scheduled(cron = "0 10 */1 * * *")
    public void actualizaVentasCumplimientoTarea(){
        System.out.println("Actualiza ventas: " + new Date());
    }
}
