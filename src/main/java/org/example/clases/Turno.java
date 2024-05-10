package org.example.clases;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Turno {
    private Paciente paciente;
    private Medico medico;
    private Especialidad especialidad;
    private String tipo; // This can be "particular" or "con obra social"
}