package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.entity.Produto;
import com.ecommerce.ecommerce.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService service;

    @GetMapping
    public ResponseEntity<Iterable<Produto>> listar() {

        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscar(@PathVariable Long id) {

        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Produto> criar(
            @Valid @RequestBody Produto produto) {

        return ResponseEntity.status(201)
                .body(service.salvar(produto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody Produto dados) {

        return ResponseEntity.ok(service.atualizar(id, dados));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        service.deletar(id);

        return ResponseEntity.noContent().build();
    }

}