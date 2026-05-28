package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.dto.ProdutoRequestDTO;
import com.ecommerce.ecommerce.dto.ProdutoResponseDTO;
import com.ecommerce.ecommerce.entity.Produto;
import com.ecommerce.ecommerce.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/v1/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService service;

    @GetMapping
    public ResponseEntity<Iterable<ProdutoResponseDTO>> listar() {

        var produtos = service.listarTodos();

        var resposta = StreamSupport.stream(produtos.spliterator(), false)
                .map(ProdutoResponseDTO::fromEntity)
                .toList();

        return ResponseEntity.ok(resposta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> buscar(
            @PathVariable Long id) {

        Produto produto = service.buscarPorId(id);

        return ResponseEntity.ok(
                ProdutoResponseDTO.fromEntity(produto));
    }

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> criar(
            @Valid @RequestBody ProdutoRequestDTO dto) {

        Produto produto = new Produto();

        produto.setNome(dto.nome());
        produto.setPreco(dto.preco());
        produto.setDescricao(dto.descricao());

        Produto salvo = service.salvar(produto);

        return ResponseEntity.status(201)
                .body(ProdutoResponseDTO.fromEntity(salvo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody ProdutoRequestDTO dto) {

        Produto produto = new Produto();

        produto.setNome(dto.nome());
        produto.setPreco(dto.preco());
        produto.setDescricao(dto.descricao());

        Produto atualizado = service.atualizar(id, produto);

        return ResponseEntity.ok(
                ProdutoResponseDTO.fromEntity(atualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(
            @PathVariable Long id) {

        service.deletar(id);

        return ResponseEntity.noContent().build();
    }

}