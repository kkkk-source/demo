package com.example.demo.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@Generated
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class SaleProductKey
    implements Serializable
{

    private Long sale;

    private Long product;
}
