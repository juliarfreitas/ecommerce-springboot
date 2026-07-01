package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.entity.Categoria;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CategoriaRepositoryTest {

    @Autowired
    private CategoriaRepository repository;

    @Test
    @DisplayName("Deve salvar categoria com sucesso")
    void deveSalvarCategoria() {

        Categoria categoria = new Categoria();

        categoria.setNome("Eletrônicos");

        Categoria salva = repository.save(categoria);

        assertNotNull(salva.getId());
        assertEquals("Eletrônicos", salva.getNome());
    }

    @Test
    @DisplayName("Deve listar categorias")
    void deveListarCategorias() {

        Categoria categoria = new Categoria();

        categoria.setNome("Games");

        repository.save(categoria);

        List<Categoria> lista = repository.findAll();

        assertFalse(lista.isEmpty());
    }

}