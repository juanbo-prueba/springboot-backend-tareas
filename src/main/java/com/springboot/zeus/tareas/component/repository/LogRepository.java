package com.springboot.zeus.tareas.component.repository;

import com.springboot.zeus.tareas.component.model.Log;
import com.springboot.zeus.tareas.component.mapper.LogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("logRepository")
public class LogRepository {

    @Autowired
    private LogMapper logMapper;

    public void guardarLog( Log log ) {
        logMapper.guardar( log );
    }
}
