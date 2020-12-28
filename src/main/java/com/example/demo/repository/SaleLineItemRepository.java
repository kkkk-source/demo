package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.SaleLineItem;
import com.example.demo.entity.SaleLineItemId;

@Repository
public interface SaleLineItemRepository
    extends JpaRepository<SaleLineItem, SaleLineItemId>
{
}
