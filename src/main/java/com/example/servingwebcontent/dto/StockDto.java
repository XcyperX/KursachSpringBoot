package com.example.servingwebcontent.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class StockDto {
    @JsonProperty("stock_id")
    private Long stockId;

    @JsonProperty("name")
    @NotBlank
    private String stockName;
}
