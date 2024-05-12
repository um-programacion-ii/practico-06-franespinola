package org.example.servicios;

import org.example.clases.Farmacia;
import org.example.clases.Medicamento;
import org.example.clases.Receta;
import org.example.DAO.RecetaDAO;
import org.example.clases.Drogueria;

import java.util.ArrayList;
import java.util.List;

public class GestionFarmaciaService {
    private static GestionFarmaciaService instance;
    private Farmacia farmacia;
    private RecetaDAO recetaDAO;

    private GestionFarmaciaService() {
        this.farmacia = new Farmacia(new ArrayList<>());
        this.recetaDAO = new RecetaDAO();
    }

    public static GestionFarmaciaService getInstance() {
        if (instance == null) {
            instance = new GestionFarmaciaService();
        }
        return instance;
    }

    public void comprarMedicamentos(Receta receta) {
        for (Medicamento medicamento : receta.getMedicamentos()) {
            if (farmacia.comprarMedicamento(medicamento.getNombre()).isEmpty()) {
                // El medicamento no está en stock, se solicita a la droguería
                iniciarPedidoDrogueria(medicamento, 1); // Solicita 1 unidad del medicamento
                farmacia.comprarMedicamento(medicamento.getNombre()); // Vuelve a intentar comprar
            }
        }
    }

    private void iniciarPedidoDrogueria(Medicamento medicamento, int cantidad) {
        Drogueria drogueria = new Drogueria(); // Crea una instancia de la droguería
        farmacia.hacerPedidoADrogueria(drogueria.suministrarMedicamento(medicamento.getNombre(), medicamento.getDescripcion(), cantidad), cantidad);
        finalizarPedidoDrogueria();
    }

    private void finalizarPedidoDrogueria() {
        // Lógica para finalizar el pedido a la droguería
        System.out.println("Pedido a la droguería finalizado");
    }
}