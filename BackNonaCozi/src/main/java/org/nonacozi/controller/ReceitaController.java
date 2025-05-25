package org.nonacozi.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.nonacozi.domain.request.ReceitaAtualizarRequest;
import org.nonacozi.domain.request.ReceitaCriarRequest;
import org.nonacozi.domain.request.ReceitaFiltroRequest;
import org.nonacozi.domain.response.ReceitaResponse;
import org.nonacozi.service.ReceitaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("receitas")
public class ReceitaController {

    private final ReceitaService receitaService;

    @Operation(summary = "Cria uma nova receita", description = "Recebe os dados da receita e retorna a receita criada com seu ID")
    @PostMapping
    public ResponseEntity<ReceitaResponse> salvar(@RequestBody ReceitaCriarRequest request) {
        ReceitaResponse receitaResponse = receitaService.criar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(receitaResponse);
    }

    @Operation(summary = "Buscar receita por ID", description = "Retorna os dados de uma receita com base no ID informado")
    @GetMapping("/{id}")
    public ResponseEntity<ReceitaResponse> buscarPorId(@PathVariable Integer id) {
        ReceitaResponse receitaResponse = receitaService.obterResponsePorId(id);
        return ResponseEntity.ok(receitaResponse);
    }

    @Operation(summary = "Deleta uma receita por ID")
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        receitaService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Atualiza uma receita por ID")
    @PatchMapping("{id}")
    public ResponseEntity<ReceitaResponse> atualizar(@PathVariable Integer id, @RequestBody ReceitaAtualizarRequest request) {
        ReceitaResponse response = receitaService.atualizar(id, request);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Busca receitas com filtros e paginação")
    @GetMapping
    public ResponseEntity<Page<ReceitaResponse>> buscarTodos(
            @ModelAttribute ReceitaFiltroRequest filtro,
            Pageable pageable
    ) {
        Page<ReceitaResponse> receitas = receitaService.buscarTodos(filtro, pageable);
        return ResponseEntity.ok(receitas);
    }

}
