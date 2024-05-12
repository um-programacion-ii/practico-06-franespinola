package org.example.DAO;

import org.example.clases.Turno;

import java.util.HashMap;
import java.util.Map;

public class TurnoDAO {
    private Map<Integer, Turno> turnos = new HashMap<>();
    private int contadorId = 1;

    public void guardarTurno(Turno turno) {
        turnos.put(contadorId++, turno);
    }

    public Turno buscarTurno(int id) {
        return turnos.get(id);
    }
}
