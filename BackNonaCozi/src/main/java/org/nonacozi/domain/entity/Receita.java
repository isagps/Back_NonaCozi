package org.nonacozi.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "receita")
@Getter
@Setter
@NoArgsConstructor
public class Receita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Column(columnDefinition = "TEXT")
    private String modoPreparo;

    @Column(nullable = false)
    private Integer tempoPreparoMinutos;

    @Column
    private Integer porcoes;

    @ElementCollection
    @CollectionTable(name = "ingredientes", joinColumns = @JoinColumn(name = "receita_id"))
    @Column(name = "ingrediente", nullable = false)
    private List<String> ingredientes;
}