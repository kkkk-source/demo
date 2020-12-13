package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.MapsId;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "sale_product")
@Data
@Generated
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
//@IdClass(SaleProductKey.class)
public class SaleProduct implements Serializable {

    //@Id
    //private Long saleId;

    //@Id
    //private Long productId;
    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "saleId")
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @NotNull
    @NotBlank
    private Integer amount;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

}
