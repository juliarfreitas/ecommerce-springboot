package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.dto.ProdutoRequestDTO;
import com.ecommerce.ecommerce.entity.Categoria;
import com.ecommerce.ecommerce.entity.Produto;
import com.ecommerce.ecommerce.repository.CategoriaRepository;
import com.ecommerce.ecommerce.repository.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProdutoServiceTest {

    @InjectMocks
    private ProdutoService service;

    @Mock
    private ProdutoRepository repository;

    @Mock
    private CategoriaRepository categoriaRepository;

    @Test
    void deveSalvarProdutoComCategoria() {

        // ARRANGE (mock da categoria)
        Categoria categoria = new Categoria();
        categoria.setId(1L);

        when(categoriaRepository.findById(1L))
                .thenReturn(Optional.of(categoria));

        Produto produtoSalvo = new Produto();
        produtoSalvo.setId(1L);
        produtoSalvo.setNome("Mouse");

        when(repository.save(any(Produto.class)))
                .thenReturn(produtoSalvo);

        // DTO de entrada
        ProdutoRequestDTO dto = new ProdutoRequestDTO(
                "Mouse",
                new BigDecimal("100.00"),
                "Mouse gamer",
                1L
        );

        // ACT
        Produto result = service.salvar(dto);

        // ASSERT
        assertNotNull(result);
        assertEquals("Mouse", result.getNome());

        verify(repository, times(1)).save(any(Produto.class));
        verify(categoriaRepository, times(1)).findById(1L);
    }

    @Test
    void deveSalvarProdutoSemCategoria() {

        when(repository.save(any(Produto.class)))
                .thenAnswer(i -> i.getArgument(0));

        ProdutoRequestDTO dto = new ProdutoRequestDTO(
                "Teclado",
                new BigDecimal("200.00"),
                "Teclado mecânico",
                null
        );

        Produto result = service.salvar(dto);

        assertNotNull(result);
        assertEquals("Teclado", result.getNome());

        verify(repository, times(1)).save(any(Produto.class));
        verify(categoriaRepository, never()).findById(any());
    }
}