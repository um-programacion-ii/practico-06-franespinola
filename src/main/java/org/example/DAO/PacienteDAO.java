package org.example.DAO;

import org.example.clases.Paciente;

import java.util.HashMap;
import java.util.Map;

public class PacienteDAO {
    private Map<Integer, Paciente> pacientes = new HashMap<>();

    public void guardarPaciente(Paciente paciente) {
        pacientes.put(paciente.getNumeroAfiliado(), paciente);
    }

    public Paciente buscarPaciente(int numeroAfiliado) {
        return pacientes.get(numeroAfiliado);
    }
}
