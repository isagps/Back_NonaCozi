package org.nonacozi.domain.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ReceitaResponse {
    private Integer id;
    private String nome;
    private String descricao;
    private String modoPreparo;
    private Integer tempoPreparoMinutos;
    private List<String> ingredientes;
    private Integer porcoes;
}
