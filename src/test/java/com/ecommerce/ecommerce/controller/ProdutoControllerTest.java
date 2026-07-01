package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.entity.Produto;
import com.ecommerce.ecommerce.service.ProdutoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
<<<<<<< HEAD
import org.springframework.test.context.bean.override.mockito.MockitoBean;
=======
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
>>>>>>> 936737bb15d0414b3f0aaa1cc51f6ccd5dd3ddbb
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

<<<<<<< HEAD
    @MockitoBean
=======
    @MockBean
>>>>>>> 936737bb15d0414b3f0aaa1cc51f6ccd5dd3ddbb
    private ProdutoService service;

    @Test
    @DisplayName("Deve listar produtos")
    void deveListarProdutos() throws Exception {

        Produto produto = new Produto();
<<<<<<< HEAD
=======

>>>>>>> 936737bb15d0414b3f0aaa1cc51f6ccd5dd3ddbb
        produto.setId(1L);
        produto.setNome("Teclado Gamer");
        produto.setPreco(BigDecimal.valueOf(299.90));

        when(service.listarTodos())
                .thenReturn(List.of(produto));

<<<<<<< HEAD
        mockMvc.perform(get("/api/v1/produtos"))
=======
        mockMvc.perform(get("/api/v1/produtos")
                        .contentType(MediaType.APPLICATION_JSON))
>>>>>>> 936737bb15d0414b3f0aaa1cc51f6ccd5dd3ddbb
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome")
                        .value("Teclado Gamer"));
    }
<<<<<<< HEAD
=======

>>>>>>> 936737bb15d0414b3f0aaa1cc51f6ccd5dd3ddbb
}