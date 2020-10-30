package com.example.servingwebcontent.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDto {
    @JsonProperty("product_id")
    private Long productId;

    private String nameProduct;
    @JsonProperty("stock_id")
    private Long stockId;
    private Integer amountOnStock;
    private Integer amountOnSale;
    private Float priceProduct;
}
