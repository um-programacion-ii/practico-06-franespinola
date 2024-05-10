package org.example.clases;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ObraSocial {
    private String nombre;
    private List<Medico> medicos;
}