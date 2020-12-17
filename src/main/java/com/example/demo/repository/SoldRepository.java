package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Sold;
import com.example.demo.entity.SoldId;

@Repository
public interface SoldRepository
    extends JpaRepository<Sold, SoldId>
{
    List<Sold> findBySaleId( Long id );
}
