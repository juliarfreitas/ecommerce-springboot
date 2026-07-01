package com.ecommerce.ecommerce.service;

<<<<<<< HEAD
import com.ecommerce.ecommerce.dto.ProdutoRequestDTO;
import com.ecommerce.ecommerce.entity.Categoria;
import com.ecommerce.ecommerce.entity.Produto;
import com.ecommerce.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.ecommerce.repository.CategoriaRepository;
import com.ecommerce.ecommerce.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
=======
import com.ecommerce.ecommerce.entity.Produto;
import com.ecommerce.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.ecommerce.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
>>>>>>> 936737bb15d0414b3f0aaa1cc51f6ccd5dd3ddbb

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;
<<<<<<< HEAD
    private final CategoriaRepository categoriaRepository;

    @Transactional(readOnly = true)
=======

    @Transactional
>>>>>>> 936737bb15d0414b3f0aaa1cc51f6ccd5dd3ddbb
    public Iterable<Produto> listarTodos() {
        return repository.findAll();
    }

<<<<<<< HEAD
    @Transactional(readOnly = true)
=======
    @Transactional
>>>>>>> 936737bb15d0414b3f0aaa1cc51f6ccd5dd3ddbb
    public Produto buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Produto", id));
    }

    @Transactional
<<<<<<< HEAD
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

=======
    public Produto salvar(Produto produto) {
>>>>>>> 936737bb15d0414b3f0aaa1cc51f6ccd5dd3ddbb
        return repository.save(produto);
    }

    @Transactional
    public Produto atualizar(Long id, Produto dados) {

        Produto atual = buscarPorId(id);

        atual.setNome(dados.getNome());
        atual.setPreco(dados.getPreco());
        atual.setDescricao(dados.getDescricao());
<<<<<<< HEAD
        atual.setCategoria(dados.getCategoria());
=======
>>>>>>> 936737bb15d0414b3f0aaa1cc51f6ccd5dd3ddbb

        return repository.save(atual);
    }

    @Transactional
    public void deletar(Long id) {

        Produto produto = buscarPorId(id);
<<<<<<< HEAD
        repository.delete(produto);
    }
=======

        repository.delete(produto);
    }

>>>>>>> 936737bb15d0414b3f0aaa1cc51f6ccd5dd3ddbb
}