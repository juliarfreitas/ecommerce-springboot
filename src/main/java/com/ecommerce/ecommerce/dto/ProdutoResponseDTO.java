package com.ecommerce.ecommerce.dto;

import com.ecommerce.ecommerce.entity.Produto;

import java.math.BigDecimal;

public record ProdutoResponseDTO(

        Long id,
        String nome,
        BigDecimal preco,
        String descricao

) {

    public static ProdutoResponseDTO fromEntity(Produto produto) {

        return new ProdutoResponseDTO(
                produto.getId(),
                produto.getNome(),
                produto.getPreco(),
                produto.getDescricao()
        );
    }

}