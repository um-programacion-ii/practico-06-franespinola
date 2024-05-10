package org.example.clases;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Receta {
    private Paciente paciente;
    private Medico medico;
    private List<Medicamento> medicamentos;
}