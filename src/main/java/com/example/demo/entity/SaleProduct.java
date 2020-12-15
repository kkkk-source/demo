package com.example.demo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
@Builder( toBuilder = true )
@Table( name = "sale_product" )
@IdClass( SaleProductKey.class )
public class SaleProduct
    implements Serializable
{

    @Id
    @ManyToOne
    private Sale sale;

    @Id
    @ManyToOne
    private Product product;

    @NotNull
    @NotBlank
    private Integer amount;
}
