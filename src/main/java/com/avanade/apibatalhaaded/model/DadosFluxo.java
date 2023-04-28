package com.avanade.apibatalhaaded.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DadosFluxo implements Serializable {

    private Long qtdFaces;
    private Long valorSorteado;
}
