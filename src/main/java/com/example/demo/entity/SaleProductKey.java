package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

@Data
@Generated
@NoArgsConstructor
@AllArgsConstructor
public class SaleProductKey implements Serializable {

    @Column(name = "sale_id")
    private Long saleId;

    @Column(name = "product_id")
    private Long productId;
}
