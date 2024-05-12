package org.example.clases;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Medico {
    private String nombre;
    private String especialidad;
    private List<ObraSocial> obrasSociales;
    private boolean atiendeParticular;
}