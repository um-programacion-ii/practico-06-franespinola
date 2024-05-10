package org.example.clases;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class Farmacia {
    private List<Medicamento> stockMedicamentos;

    public Farmacia(List<Medicamento> stockMedicamentos) {
        this.stockMedicamentos = stockMedicamentos;
    }

    public Optional<Medicamento> comprarMedicamento(String nombre) {
        for (Medicamento medicamento : stockMedicamentos) {
            if (medicamento.getNombre().equals(nombre) && medicamento.getCantidadDisponible() > 0) {
                medicamento.setCantidadDisponible(medicamento.getCantidadDisponible() - 1);
                return Optional.of(medicamento);
            }
        }
        return Optional.empty();
    }

    public void hacerPedidoADrogueria(Medicamento medicamento, int cantidad) {
        medicamento.setCantidadDisponible(medicamento.getCantidadDisponible() + cantidad);
    }
}