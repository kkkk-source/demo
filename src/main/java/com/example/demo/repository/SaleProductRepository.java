package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.SaleProduct;
import com.example.demo.entity.SaleProductKey;

@Repository
public interface SaleProductRepository
    extends JpaRepository<SaleProduct, SaleProductKey>
{
}
