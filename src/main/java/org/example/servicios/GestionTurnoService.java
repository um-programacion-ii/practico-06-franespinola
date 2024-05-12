package org.example.servicios;

import org.example.clases.*;
import org.example.DAO.*;

import java.util.List;
import java.util.Random;

public class GestionTurnoService {
    private static GestionTurnoService instance;
    private PacienteDAO pacienteDAO;
    private MedicoDAO medicoDAO;
    private EspecialidadDAO especialidadDAO;
    private TurnoDAO turnoDAO;

    private GestionTurnoService() {
        this.pacienteDAO = new PacienteDAO();
        this.medicoDAO = new MedicoDAO();
        this.especialidadDAO = new EspecialidadDAO();
        this.turnoDAO = new TurnoDAO();
    }

    public static GestionTurnoService getInstance() {
        if (instance == null) {
            instance = new GestionTurnoService();
        }
        return instance;
    }

    public void solicitarTurno(Paciente paciente, String nombreEspecialidad, String nombreObraSocial, boolean esParticular) {
        Especialidad especialidad = especialidadDAO.buscarEspecialidad(nombreEspecialidad);
        Medico medico;
        if (esParticular) {
            List<Medico> medicosDisponibles = medicoDAO.listarMedicosParticulares();
            medico = medicosDisponibles.get(new Random().nextInt(medicosDisponibles.size())); // Seleccionar médico aleatorio
        } else {
            List<Medico> medicosDisponibles = medicoDAO.buscarMedicosPorEspecialidadYObraSocial(nombreEspecialidad, nombreObraSocial);
            if (medicosDisponibles.isEmpty()) {
                throw new RuntimeException("No hay medicos disponibles para la especialidad y obra social indicadas");
            }
            medico = medicosDisponibles.get(new Random().nextInt(medicosDisponibles.size())); // Seleccionar médico aleatorio
        }
        Turno turno = new Turno(paciente, medico, especialidad, esParticular ? "particular" : "con obra social");
        turnoDAO.guardarTurno(turno);
    }
}
