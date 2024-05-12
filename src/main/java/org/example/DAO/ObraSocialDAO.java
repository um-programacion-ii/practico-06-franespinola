package org.example.DAO;

import org.example.clases.ObraSocial;

import java.util.HashMap;
import java.util.Map;

public class ObraSocialDAO {
    private Map<String, ObraSocial> obrasSociales = new HashMap<>();

    public void guardarObraSocial(ObraSocial obraSocial) {
        obrasSociales.put(obraSocial.getNombre(), obraSocial);
    }

    public ObraSocial buscarObraSocial(String nombre) {
        return obrasSociales.get(nombre);
    }
}
