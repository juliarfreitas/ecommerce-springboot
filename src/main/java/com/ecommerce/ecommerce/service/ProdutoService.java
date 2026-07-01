package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.dto.ProdutoRequestDTO;
import com.ecommerce.ecommerce.entity.Categoria;
import com.ecommerce.ecommerce.entity.Produto;
import com.ecommerce.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.ecommerce.repository.CategoriaRepository;
import com.ecommerce.ecommerce.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;
    private final CategoriaRepository categoriaRepository;

    @Transactional(readOnly = true)
    public Iterable<Produto> listarTodos() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Produto buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Produto", id));
    }

    @Transactional
    public Produto salvar(ProdutoRequestDTO dto) {

        Produto produto = new Produto();

        produto.setNome(dto.nome());
        produto.setPreco(dto.preco());
        produto.setDescricao(dto.descricao());

        if (dto.categoriaId() != null) {
            Categoria categoria = categoriaRepository.findById(dto.categoriaId())
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Categoria", dto.categoriaId()));

            produto.setCategoria(categoria);
        }

        return repository.save(produto);
    }

    @Transactional
    public Produto atualizar(Long id, Produto dados) {

        Produto atual = buscarPorId(id);

        atual.setNome(dados.getNome());
        atual.setPreco(dados.getPreco());
        atual.setDescricao(dados.getDescricao());
        atual.setCategoria(dados.getCategoria());

        return repository.save(atual);
    }

    @Transactional
    public void deletar(Long id) {

        Produto produto = buscarPorId(id);
        repository.delete(produto);
    }
}