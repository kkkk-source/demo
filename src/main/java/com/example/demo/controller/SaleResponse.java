package com.example.demo.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import com.example.demo.entity.Sale;

@Data
@Builder
@Generated
@NoArgsConstructor
@AllArgsConstructor
public class SaleResponse
{

    private BigDecimal price;

    private List<ProductListResponse> products;

    public static SaleResponse fromModel( Sale sale )
    {
        List<ProductListResponse> products =
            sale.getProducts().stream().map( ProductListResponse::fromModel ).collect( Collectors.toList() );
        return SaleResponse.builder().price( sale.getPrice() ).products( products ).build();
    }
}
