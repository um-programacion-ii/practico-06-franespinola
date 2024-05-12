package org.example.DAO;

import org.example.clases.Receta;

import java.util.HashMap;
import java.util.Map;

public class RecetaDAO {
    private Map<Integer, Receta> recetas = new HashMap<>();
    private int contadorId = 1;

    public void guardarReceta(Receta receta) {
        recetas.put(contadorId++, receta);
    }

    public Receta buscarReceta(int id) {
        return recetas.get(id);
    }
}
