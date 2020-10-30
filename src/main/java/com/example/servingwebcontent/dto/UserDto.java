package com.example.servingwebcontent.dto;

import com.example.servingwebcontent.models.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@NoArgsConstructor
public class UserDto {
    @JsonProperty("user_id")
    private Long userId;

    @NotNull
    private String username;
    @NotNull
    private String password;
    @JsonProperty("stock_id")
    private Long stockId;

    @JsonProperty("role_id")
    @NotNull
    private Long roleId;
}
