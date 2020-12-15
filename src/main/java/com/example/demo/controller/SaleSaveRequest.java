package com.example.demo.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import com.example.demo.service.ProductListSaveCmd;
import com.example.demo.service.SaleSaveCmd;

@Data
@Builder
@Generated
@NoArgsConstructor
@AllArgsConstructor
public class SaleSaveRequest
{

    private BigDecimal price;

    private List<ProductListSaveRequest> products;

    public static SaleSaveCmd toModel( SaleSaveRequest saleToCreate )
    {
        List<ProductListSaveCmd> productsToAssociate =
            saleToCreate.getProducts().stream().map( ProductListSaveRequest::toModel ).collect( Collectors.toList() );
        return SaleSaveCmd.builder().price( saleToCreate.getPrice() ).products( productsToAssociate ).build();
    }
}
