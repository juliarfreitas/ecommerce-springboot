package com.ecommerce.ecommerce.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record ProdutoRequestDTO(

        @NotBlank(message = "Nome é obrigatório")
        @Size(max = 150)
        String nome,

        @DecimalMin(value = "0.01", message = "Preço deve ser maior que zero")
        BigDecimal preco,

        @Size(max = 500)
<<<<<<< HEAD
        String descricao,

        Long categoriaId
) {}
=======
        String descricao

) {
}
>>>>>>> 936737bb15d0414b3f0aaa1cc51f6ccd5dd3ddbb
