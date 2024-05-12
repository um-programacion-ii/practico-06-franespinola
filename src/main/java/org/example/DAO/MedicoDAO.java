package org.example.DAO;

import org.example.clases.Medico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MedicoDAO {
    private Map<Integer, Medico> medicos = new HashMap<>();
    private int contadorId = 1;

    public void guardarMedico(Medico medico) {
        medico.setObrasSociales(new ArrayList<>()); // Inicializar la lista de obras sociales
        medicos.put(contadorId++, medico);
    }

    public Medico buscarMedico(int id) {
        return medicos.get(id);
    }

    public List<Medico> buscarMedicosPorEspecialidadYObraSocial(String especialidad, String nombreObraSocial) {
        List<Medico> medicosEncontrados = new ArrayList<>();
        for (Medico medico : medicos.values()) {
            if (medico.getEspecialidad().equals(especialidad) && medico.getObrasSociales().stream()
                    .anyMatch(obraSocial -> obraSocial.getNombre().equals(nombreObraSocial))) {
                medicosEncontrados.add(medico);
            }
        }
        return medicosEncontrados;
    }

    public List<Medico> listarMedicosParticulares() {
        List<Medico> medicosParticulares = new ArrayList<>();
        for (Medico medico : medicos.values()) {
            if (medico.isAtiendeParticular()) {
                medicosParticulares.add(medico);
            }
        }
        return medicosParticulares;
    }

}
