package com.example.demo.controller;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import com.example.demo.service.ProductListSaveCmd;

@Data
@Builder
@Generated
@NoArgsConstructor
@AllArgsConstructor
public class ProductListSaveRequest
{

    private Long id;

    private String name;

    private Integer amount;

    private BigDecimal price;

    public static ProductListSaveCmd toModel( ProductListSaveRequest productToAssociate )
    {
        return ProductListSaveCmd.builder().name( productToAssociate.getName() )
            .price( productToAssociate.getPrice() )
            .amount( productToAssociate.getAmount() ).build();
    }
}
