package com.example.demo.service;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import com.example.demo.entity.SaleProduct;
import com.example.demo.entity.Product;

@Data
@Builder
@Generated
@NoArgsConstructor
@AllArgsConstructor
public class ProductListSaveCmd {

    @NotNull
    @NotBlank
    private Long id;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private Integer amount;

    @NotNull
    @NotBlank
    private BigDecimal price;

    public static SaleProduct toModel(@NotNull ProductListSaveCmd productToAssociate) {
        Product product = Product.builder().id(productToAssociate.getId()).name(productToAssociate.getName()).price(productToAssociate.getPrice()).build();
        return SaleProduct.builder().product(product).amount(productToAssociate.getAmount()).build();
    }
}
