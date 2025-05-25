package org.nonacozi.repository.specification;


import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import org.nonacozi.domain.entity.Receita;
import org.nonacozi.domain.request.ReceitaFiltroRequest;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class ReceitaSpecification {

    public static Specification<Receita> comFiltros(ReceitaFiltroRequest filtro) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filtro.getNome() != null && !filtro.getNome().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("nome")), "%" + filtro.getNome().toLowerCase() + "%"));
            }

            if (filtro.getTempoPreparoMinutos() != null) {
                predicates.add(cb.equal(root.get("tempoPreparoMinutos"), filtro.getTempoPreparoMinutos()));
            }

            if (filtro.getIngrediente() != null && !filtro.getIngrediente().isEmpty()) {
                Join<Receita, String> ingredientesJoin = root.join("ingredientes");
                predicates.add(cb.like(cb.lower(ingredientesJoin), "%" + filtro.getIngrediente().toLowerCase() + "%"));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
