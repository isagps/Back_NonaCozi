package org.nonacozi.domain.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ReceitaCriarRequest {
    private String nome;
    private String descricao;
    private String modoPreparo;
    private Integer tempoPreparoMinutos;
    private List<String> ingredientes;
}
