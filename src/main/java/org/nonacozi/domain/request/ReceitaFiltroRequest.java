package org.nonacozi.domain.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class ReceitaFiltroRequest {
    private String nome;
    private Integer tempoPreparoMinutos;
    private String ingrediente;
}
