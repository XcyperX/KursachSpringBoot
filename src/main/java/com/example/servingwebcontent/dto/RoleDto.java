package com.example.servingwebcontent.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class RoleDto {
    @JsonProperty("role_id")
    private Long roleId;

    @JsonProperty("name")
    @NotBlank
    private String name;
}
