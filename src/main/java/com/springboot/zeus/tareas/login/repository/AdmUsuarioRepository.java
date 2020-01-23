package com.springboot.zeus.tareas.login.repository;

import com.springboot.zeus.tareas.login.model.Usuario;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface AdmUsuarioRepository {

    public Usuario buscarUsuarioPorNombre(String nombreUsuario);
    public Usuario findById(Long id);

}
