package com.example.demo.repository;

import com.example.demo.entity.SaleProduct;
import com.example.demo.entity.SaleProductKey;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SaleProductRepository extends JpaRepository<SaleProduct, SaleProductKey> {

}
