package org.example.clases;

import lombok.*;

@Data
@AllArgsConstructor
@Getter
@Setter
public class Paciente {
    private String nombre;
    private ObraSocial obraSocial;
    private Integer numeroAfiliado;
}