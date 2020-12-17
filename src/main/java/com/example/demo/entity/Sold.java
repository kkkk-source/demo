package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
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
@Table( name = "sold" )
@IdClass( SoldId.class )
public class Sold
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
