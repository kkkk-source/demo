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
public class SaleSaveResponse
{

    private Long id;

    private BigDecimal price;

    private List<SoldListResponse> products;

    public static SaleSaveResponse fromModel( Sale sale )
    {
        List<SoldListResponse> products =
            sale.getSold().stream().map( SoldListResponse::fromModel ).collect( Collectors.toList() );
        return SaleSaveResponse.builder().id( sale.getId() ).price( sale.getPrice() ).products( products ).build();
    }

}
