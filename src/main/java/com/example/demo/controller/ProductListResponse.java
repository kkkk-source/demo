package com.example.demo.controller;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import com.example.demo.entity.SaleProduct;

@Data
@Builder
@Generated
@NoArgsConstructor
@AllArgsConstructor
public class ProductListResponse
{

    private String name;

    private Integer amount;

    private BigDecimal price;

    public static ProductListResponse fromModel( SaleProduct association )
    {
        return ProductListResponse.builder().name( association.getProduct().getName() ).price( association.getProduct().getPrice() ).amount( association.getAmount() ).build();
    }
}
