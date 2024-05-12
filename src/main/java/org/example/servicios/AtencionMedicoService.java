package org.example.servicios;

import org.example.clases.*;
import org.example.DAO.RecetaDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AtencionMedicoService {
    private static AtencionMedicoService instance;
    private RecetaDAO recetaDAO;

    private AtencionMedicoService() {
        this.recetaDAO = new RecetaDAO();
    }

    public static AtencionMedicoService getInstance() {
        if (instance == null) {
            instance = new AtencionMedicoService();
        }
        return instance;
    }

    public void finalizarTurno(Turno turno) {
        if (new Random().nextBoolean()) { // Decide aleatoriamente si genera una receta
            List<Medicamento> medicamentos = new ArrayList<>();
            int cantidadMedicamentos = new Random().nextInt(3) + 1; // Genera entre 1 y 3 medicamentos
            for (int i = 0; i < cantidadMedicamentos; i++) {
                medicamentos.add(new Medicamento("Medicamento" + (i + 1), "Descripción del medicamento", 1)); // Crea medicamentos con valores de prueba
            }
            Receta receta = new Receta(turno.getPaciente(), turno.getMedico(), medicamentos);
            recetaDAO.guardarReceta(receta);
        }
    }
}