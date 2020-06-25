package com.springboot.zeus.tareas.seriesVentas.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatearFecha {

    //Date date = StringToDate_ddmmyyyy("2015-12-06");
    public Date StringToDate_ddmmyyyy(String s){

        Date result = null;
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            result  = dateFormat.parse(s);
        }

        catch(ParseException e){
            e.printStackTrace();

        }
        return result ;
    }

    public String formato_dd_mm_yyyy(Date fecha ) {
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        return formateador.format( fecha );
    }

    public String formato_yyyy_MM_dd(Date fecha ) {
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        return formateador.format( fecha );
    }
}
