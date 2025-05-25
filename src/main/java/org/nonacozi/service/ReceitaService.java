package org.nonacozi.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.nonacozi.domain.entity.Receita;
import org.nonacozi.domain.mapper.ReceitaMapper;
import org.nonacozi.domain.request.ReceitaAtualizarRequest;
import org.nonacozi.domain.request.ReceitaCriarRequest;
import org.nonacozi.domain.request.ReceitaFiltroRequest;
import org.nonacozi.domain.response.ReceitaResponse;
import org.nonacozi.exception.exceptions.EntidadeNaoEncontradaException;
import org.nonacozi.repository.ReceitaRepository;
import org.nonacozi.repository.specification.ReceitaSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class ReceitaService {

    private final ReceitaRepository receitaRepository;
    private final ReceitaMapper receitaMapper;

    public ReceitaResponse criar(ReceitaCriarRequest request) {
        log.info("Recebendo requisição para criar receita: {}", request);

        Receita receita = receitaMapper.toEntity(request);
        Receita salvo = receitaRepository.save(receita);
        ReceitaResponse response = receitaMapper.toResponse(salvo);

        log.info("Resposta retornada: {}", response);
        return response;
    }

    public Optional<Receita> buscarPorId(Integer id) {
        log.info("Buscando receita com ID: {}", id);
        Optional<Receita> receita = receitaRepository.findById(id);
        log.info("Receita encontrada: {}", receita);
        return receita;
    }

    public Receita obterPorId(Integer id) {
        return buscarPorId(id).orElseThrow(() -> new EntidadeNaoEncontradaException("Receita com ID " + id + " não encontrada."));
    }

    public ReceitaResponse obterResponsePorId(Integer id) {
        return receitaMapper.toResponse(obterPorId(id));
    }

    public void deletarPorId(Integer id) {
        log.info("Tentando deletar receita com ID: {}", id);

        obterPorId(id);
        receitaRepository.deleteById(id);

        log.info("Receita com ID {} deletada com sucesso", id);
    }

    public ReceitaResponse atualizar(Integer id, ReceitaAtualizarRequest request) {
        log.info("Atualizando receita com ID: {}, dados: {}", id, request);

        Receita receita = obterPorId(id);

        receitaMapper.updateFromRequest(request, receita);

        Receita atualizada = receitaRepository.save(receita);
        log.info("Receita atualizada: {}", atualizada);

        return receitaMapper.toResponse(atualizada);
    }

    public Page<ReceitaResponse> buscarTodos(ReceitaFiltroRequest filtro, Pageable pageable) {
        log.info("Buscando receitas com filtros: {} e paginação: {}", filtro, pageable);
        Page<Receita> pagina = receitaRepository.findAll(ReceitaSpecification.comFiltros(filtro), pageable);
        return pagina.map(receitaMapper::toResponse);
    }


}