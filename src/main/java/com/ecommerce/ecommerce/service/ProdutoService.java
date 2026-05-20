package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.entity.Produto;
import com.ecommerce.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.ecommerce.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;

    @Transactional
    public Iterable<Produto> listarTodos() {
        return repository.findAll();
    }

    @Transactional
    public Produto buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Produto", id));
    }

    @Transactional
    public Produto salvar(Produto produto) {
        return repository.save(produto);
    }

    @Transactional
    public Produto atualizar(Long id, Produto dados) {

        Produto atual = buscarPorId(id);

        atual.setNome(dados.getNome());
        atual.setPreco(dados.getPreco());
        atual.setDescricao(dados.getDescricao());

        return repository.save(atual);
    }

    @Transactional
    public void deletar(Long id) {

        Produto produto = buscarPorId(id);

        repository.delete(produto);
    }

}