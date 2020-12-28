package com.example.demo.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import com.example.demo.entity.Store;

@Data
@Builder
@Generated
@NoArgsConstructor
@AllArgsConstructor
public class CreateStoreRequest
{

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String address;

    public static Store toModel( CreateStoreRequest storeToCreate )
    {
        return Store.builder().name( storeToCreate.getName() ).address( storeToCreate.getAddress() ).build();
    }
}
