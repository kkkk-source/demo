package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.controller.SaleSaveRequest;
import com.example.demo.entity.Sale;
import com.example.demo.entity.Sold;
import com.example.demo.entity.Product;
import com.example.demo.repository.SaleRepository;
import com.example.demo.repository.SoldRepository;

@Service
@Transactional
public class SaleService
{

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private SoldRepository soldRepository;

    public Sale create( @NotNull SaleSaveRequest saleToCreateRequest )
    {
        Sale saleToCreate = SaleSaveRequest.toModel( saleToCreateRequest );
        Sale saleCreated = saleRepository.save( saleToCreate );
        BigDecimal total = new BigDecimal( 0 );
        BigDecimal amount, price;
        for ( Sold sold : saleToCreate.getSold() )
        {
            amount = new BigDecimal( sold.getAmount() );
            price = sold.getProduct().getPrice().multiply( amount );
            total = total.add( price );
            sold.setSale( saleCreated );
            soldRepository.save( sold );
        }
        saleCreated.setPrice( total );
        return saleRepository.save( saleCreated );
    }

    @Transactional( readOnly = true )
    public Sale findById( @NotNull Long id )
    {
        return saleRepository.findById( id ).get();
    }
}
