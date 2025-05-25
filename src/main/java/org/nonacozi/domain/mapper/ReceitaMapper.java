package org.nonacozi.domain.mapper;

import org.mapstruct.*;
import org.nonacozi.domain.entity.Receita;
import org.nonacozi.domain.request.ReceitaAtualizarRequest;
import org.nonacozi.domain.request.ReceitaCriarRequest;
import org.nonacozi.domain.response.ReceitaResponse;

@Mapper(componentModel = "spring")
public interface ReceitaMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "porcoes", ignore = true)
    Receita toEntity(ReceitaCriarRequest request);

    ReceitaResponse toResponse(Receita request);

    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromRequest(ReceitaAtualizarRequest request, @MappingTarget Receita receita);
}