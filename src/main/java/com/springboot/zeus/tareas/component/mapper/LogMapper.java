package com.springboot.zeus.tareas.component.mapper;

import com.springboot.zeus.tareas.component.model.Log;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LogMapper {

    public void guardar(@Param("log") Log log);
}
