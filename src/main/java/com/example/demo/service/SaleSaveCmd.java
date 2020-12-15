package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import com.example.demo.entity.Sale;
import com.example.demo.entity.SaleProduct;

@Data
@Builder
@Generated
@NoArgsConstructor
@AllArgsConstructor
public class SaleSaveCmd {

    @NotNull
    @NotBlank
    private BigDecimal price;

    private List<ProductListSaveCmd> products;

    public static Sale toModel(@NotNull SaleSaveCmd saleToCreate) {
        List<SaleProduct> productsToAssociate = saleToCreate.getProducts().stream().map(ProductListSaveCmd::toModel).collect(Collectors.toList());
        return Sale.builder().products(productsToAssociate).build();
    }
}
