package org.example.servicios;

import org.example.clases.Medico;

import java.util.HashMap;

public class AtencionMedicoService {
    private static AtencionMedicoService instance;
    private Map<Integer, Medico> medicos;

    private AtencionMedicoService() {
        medicos = new HashMap<>();
    }

    public static AtencionMedicoService getInstance() {
        if (instance == null) {
            instance = new AtencionMedicoService();
        }
        return instance;
    }

    // Métodos para gestionar médicos
}
