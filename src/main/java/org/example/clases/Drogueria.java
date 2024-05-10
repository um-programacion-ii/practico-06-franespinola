package org.example.clases;


public class Drogueria {

    public Medicamento suministrarMedicamento(String nombre, String descripcion, int cantidad) {
        return new Medicamento(nombre, descripcion, cantidad);
    }
}