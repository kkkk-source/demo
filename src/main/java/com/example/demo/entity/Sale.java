package com.example.demo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
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
@Table( name = "sale" )
@Builder( toBuilder = true )
public class Sale
    implements Serializable
{

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @NotNull
    @NotBlank
    private LocalDateTime date;

    @NotNull
    @NotBlank
    @ManyToOne
    private Store store;

    @OneToMany( mappedBy = "sale", fetch = FetchType.EAGER )
    private List<SaleLineItem> saleLineItems;
}
