package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.entity.Produto;
import com.ecommerce.ecommerce.repository.ProdutoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProdutoServiceTest {

    @Mock
    private ProdutoRepository repository;

    @InjectMocks
    private ProdutoService service;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Deve salvar produto com sucesso")
    void deveSalvarProduto() {

        Produto produto = new Produto();

        produto.setNome("Mouse Gamer");
        produto.setPreco(BigDecimal.valueOf(199.90));

        when(repository.save(any(Produto.class)))
                .thenReturn(produto);

        Produto salvo = service.salvar(produto);

        assertNotNull(salvo);
        assertEquals("Mouse Gamer", salvo.getNome());

        verify(repository, times(1))
                .save(produto);
    }

}