package com.example.demo.controller;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import com.example.demo.entity.Sold;
import com.example.demo.entity.Product;

@Data
@Builder
@Generated
@NoArgsConstructor
@AllArgsConstructor
public class SoldListRequest
{

    private Long id;

    private String name;

    private Integer amount;

    private BigDecimal price;

    public static Sold toModel( SoldListRequest sold )
    {
        Product product = Product.builder().id( sold.getId() ).name( sold.getName() ).price( sold.getPrice() ).build();
        return Sold.builder().amount( sold.getAmount() ).product( product ).build();
    }

}
