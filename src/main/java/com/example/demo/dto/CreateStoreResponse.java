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
public class CreateStoreResponse
{

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String address;

    public static CreateStoreResponse fromModel( Store storeCreated )
    {
        return CreateStoreResponse.builder().name( storeCreated.getName() ).address( storeCreated.getAddress() ).build();
    }
}
