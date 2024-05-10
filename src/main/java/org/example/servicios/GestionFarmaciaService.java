package org.example.servicios;

public class GestionTurnoService {
    private static GestionTurnoService instance;
    private Map<Integer, Turno> turnos;

    private GestionTurnoService() {
        turnos = new HashMap<>();
    }

    public static GestionTurnoService getInstance() {
        if (instance == null) {
            instance = new GestionTurnoService();
        }
        return instance;
    }

    // Métodos para gestionar turnos
}

