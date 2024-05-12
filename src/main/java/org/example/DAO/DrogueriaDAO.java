package org.example.DAO;

import org.example.clases.Medicamento;

import java.util.HashMap;
import java.util.Map;

public class DrogueriaDAO {
    private Map<String, Medicamento> medicamentos = new HashMap<>(); // Usamos el nombre del medicamento como clave

    public void guardarMedicamento(Medicamento medicamento) {
        medicamentos.put(medicamento.getNombre(), medicamento);
    }

    public Medicamento buscarMedicamento(String nombre) {
        return medicamentos.get(nombre);
    }

    public void actualizarStockMedicamento(String nombre, int cantidad) {
        Medicamento medicamento = medicamentos.get(nombre);
        if (medicamento != null) {
            medicamento.setCantidadDisponible(medicamento.getCantidadDisponible() + cantidad);
        }
    }
