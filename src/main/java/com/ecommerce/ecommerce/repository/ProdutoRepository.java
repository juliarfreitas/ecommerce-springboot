package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByNomeContainingIgnoreCase(String nome);

}