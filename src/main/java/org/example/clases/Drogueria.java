package org.example.clases;

import org.example.DAO.DrogueriaDAO;

public class Drogueria {
    private DrogueriaDAO drogueriaDAO;

    public Drogueria() {
        this.drogueriaDAO = new DrogueriaDAO();
    }

    public Medicamento suministrarMedicamento(String nombre, String descripcion, int cantidad) {
        Medicamento medicamento = drogueriaDAO.buscarMedicamento(nombre);
        if (medicamento == null) {
            medicamento = new Medicamento(nombre, descripcion, cantidad);
            drogueriaDAO.guardarMedicamento(medicamento);
        } else {
            drogueriaDAO.actualizarStockMedicamento(nombre, cantidad);
        }
        return medicamento;
    }
}