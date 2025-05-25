package org.nonacozi.repository;

import org.nonacozi.domain.entity.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Integer>, JpaSpecificationExecutor<Receita> {
}
