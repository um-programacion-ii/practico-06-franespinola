package org.example;

import org.example.clases.*;
import org.example.DAO.*;
import org.example.servicios.AtencionMedicoService;
import org.example.servicios.GestionFarmaciaService;
import org.example.servicios.GestionTurnoService;
import org.example.exceptions.MedicoNoDisponibleException;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Configurar datos iniciales
        configurarDatosIniciales();

        // Obtener instancias de los servicios
        GestionTurnoService gestionTurnoService = GestionTurnoService.getInstance();
        AtencionMedicoService atencionMedicoService = AtencionMedicoService.getInstance();
        GestionFarmaciaService gestionFarmaciaService = GestionFarmaciaService.getInstance();

        // Crear un paciente
        Paciente paciente = new Paciente("Juan Perez", ObraSocialDAO.getInstance().buscarObraSocial("OSDE"), 12345);

        // Solicitar un turno
        try {
            gestionTurnoService.solicitarTurno(paciente, "Cardiología", "OSDE", false);
        } catch (MedicoNoDisponibleException e) {
            System.out.println(e.getMessage());
            return; // Salir si no hay médicos disponibles
        }

        // Obtener el turno del paciente (asumiendo que se guarda en el DAO)
        Turno turno = TurnoDAO.getInstance().buscarTurno(1); // Deberías tener una lógica para obtener el turno actual

        // Finalizar el turno y generar receta
        atencionMedicoService.finalizarTurno(turno);

        // Obtener la receta del paciente (asumiendo que se guarda en el DAO)
        Receta receta = RecetaDAO.getInstance().buscarReceta(1); // Deberías tener una lógica para obtener la receta actual

        // Comprar los medicamentos
        if (receta != null) {
            gestionFarmaciaService.comprarMedicamentos(receta);
        }

        System.out.println("Programa finalizado.");
    }

    private static void configurarDatosIniciales() {
        // Crear Obras Sociales
        ObraSocial osde = new ObraSocial("OSDE", new ArrayList<>());
        ObraSocial swissMedical = new ObraSocial("Swiss Medical", new ArrayList<>());

        // Guardar Obras Sociales en DAO
        ObraSocialDAO.getInstance().guardarObraSocial(osde);
        ObraSocialDAO.getInstance().guardarObraSocial(swissMedical);

        // Crear Especialidades
        Especialidad cardiologia = new Especialidad("Cardiología", "Especialidad del corazón");
        Especialidad traumatologia = new Especialidad("Traumatología", "Especialidad de huesos y músculos");

        // Guardar Especialidades en DAO
        EspecialidadDAO.getInstance().guardarEspecialidad(cardiologia);
        EspecialidadDAO.getInstance().guardarEspecialidad(traumatologia);

        // Crear Médicos
        Medico medico1 = new Medico("Dr. Juan Carlos", "Cardiología", List.of(osde), true);
        Medico medico2 = new Medico("Dra. Ana Maria", "Traumatología", List.of(swissMedical), false);

        // Guardar Médicos en DAO
        MedicoDAO.getInstance().guardarMedico(medico1);
        MedicoDAO.getInstance().guardarMedico(medico2);
    }
}



