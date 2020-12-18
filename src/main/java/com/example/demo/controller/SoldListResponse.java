package com.example.demo.controller;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import com.example.demo.entity.Sold;

@Data
@Builder
@Generated
@NoArgsConstructor
@AllArgsConstructor
public class SoldListResponse
{

    private Long id;

    private String name;

    private Integer amount;

    private BigDecimal price;

    public static SoldListResponse fromModel( Sold sold )
    {
        return SoldListResponse.builder().id( sold.getProduct().getId() ).name( sold.getProduct().getName() ).amount( sold.getAmount() ).price( sold.getProduct().getPrice() ).build();
    }

}
