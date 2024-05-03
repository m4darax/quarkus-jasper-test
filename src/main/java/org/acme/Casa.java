package org.acme;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Casa implements Serializable {

    private String apellido;
    private String nombre;

    private String P_UNIDAD_EJECUTORA_RUC;
    private List<ListaDatos> CABECERA_I;
    private List<ListaDatos> DETALLES_I;
}
