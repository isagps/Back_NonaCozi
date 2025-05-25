package org.nonacozi.domain.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class ReceitaAtualizarRequest {
    private String nome;
    private String descricao;
    private String modoPreparo;
    private Integer tempoPreparoMinutos;
    private Integer porcoes;
    private List<String> ingredientes;
}
