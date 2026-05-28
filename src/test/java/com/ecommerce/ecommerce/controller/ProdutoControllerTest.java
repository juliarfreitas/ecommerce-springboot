package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.entity.Produto;
import com.ecommerce.ecommerce.service.ProdutoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProdutoController.class)
class ProdutoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProdutoService service;

    @Test
    @DisplayName("Deve listar produtos")
    void deveListarProdutos() throws Exception {

        Produto produto = new Produto();

        produto.setId(1L);
        produto.setNome("Teclado Gamer");
        produto.setPreco(BigDecimal.valueOf(299.90));

        when(service.listarTodos())
                .thenReturn(List.of(produto));

        mockMvc.perform(get("/api/v1/produtos")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome")
                        .value("Teclado Gamer"));
    }

}