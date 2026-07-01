package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.dto.ProdutoRequestDTO;
import com.ecommerce.ecommerce.dto.ProdutoResponseDTO;
import com.ecommerce.ecommerce.entity.Produto;
import com.ecommerce.ecommerce.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
<<<<<<< HEAD

=======
>>>>>>> 936737bb15d0414b3f0aaa1cc51f6ccd5dd3ddbb
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
<<<<<<< HEAD
    public ResponseEntity<ProdutoResponseDTO> buscar(@PathVariable Long id) {

        Produto produto = service.buscarPorId(id);

        return ResponseEntity.ok(ProdutoResponseDTO.fromEntity(produto));
=======
    public ResponseEntity<ProdutoResponseDTO> buscar(
            @PathVariable Long id) {

        Produto produto = service.buscarPorId(id);

        return ResponseEntity.ok(
                ProdutoResponseDTO.fromEntity(produto));
>>>>>>> 936737bb15d0414b3f0aaa1cc51f6ccd5dd3ddbb
    }

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> criar(
            @Valid @RequestBody ProdutoRequestDTO dto) {

<<<<<<< HEAD
        Produto salvo = service.salvar(dto);
=======
        Produto produto = new Produto();

        produto.setNome(dto.nome());
        produto.setPreco(dto.preco());
        produto.setDescricao(dto.descricao());

        Produto salvo = service.salvar(produto);
>>>>>>> 936737bb15d0414b3f0aaa1cc51f6ccd5dd3ddbb

        return ResponseEntity.status(201)
                .body(ProdutoResponseDTO.fromEntity(salvo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody ProdutoRequestDTO dto) {

        Produto produto = new Produto();
<<<<<<< HEAD
=======

>>>>>>> 936737bb15d0414b3f0aaa1cc51f6ccd5dd3ddbb
        produto.setNome(dto.nome());
        produto.setPreco(dto.preco());
        produto.setDescricao(dto.descricao());

        Produto atualizado = service.atualizar(id, produto);

        return ResponseEntity.ok(
                ProdutoResponseDTO.fromEntity(atualizado));
    }

    @DeleteMapping("/{id}")
<<<<<<< HEAD
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
=======
    public ResponseEntity<Void> deletar(
            @PathVariable Long id) {
>>>>>>> 936737bb15d0414b3f0aaa1cc51f6ccd5dd3ddbb

        service.deletar(id);

        return ResponseEntity.noContent().build();
    }
<<<<<<< HEAD
}
=======

}
>>>>>>> 936737bb15d0414b3f0aaa1cc51f6ccd5dd3ddbb
