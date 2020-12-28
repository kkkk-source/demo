package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@Entity
@Generated
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "store" )
@Builder( toBuilder = true )
public class Store
    implements Serializable
{

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String address;

    @OneToMany( mappedBy = "store", fetch = FetchType.LAZY )
    private List<Item> items;

    @OneToMany( mappedBy = "store", fetch = FetchType.LAZY )
    private List<Sale> sales;
}
