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
import com.example.demo.entity.Sold;

@Data
@Builder
@Generated
@NoArgsConstructor
@AllArgsConstructor
public class SaleSaveRequest
{

    private BigDecimal price;

    private List<SoldListRequest> products;

    public static Sale toModel( SaleSaveRequest sale )
    {
        List<Sold> products =
            sale.getProducts().stream().map( SoldListRequest::toModel ).collect( Collectors.toList() );
        return Sale.builder().price( sale.getPrice() ).sold( products ).build();
    }

}
