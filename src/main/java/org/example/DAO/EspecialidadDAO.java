package org.example.DAO;

import org.example.clases.Especialidad;

import java.util.HashMap;
import java.util.Map;

public class EspecialidadDAO {
    private Map<String, Especialidad> especialidades = new HashMap<>();

    public void guardarEspecialidad(Especialidad especialidad) {
        especialidades.put(especialidad.getNombre(), especialidad);
    }

    public Especialidad buscarEspecialidad(String nombre) {
        return especialidades.get(nombre);
    }
}
