package com.example.servingwebcontent.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDto {
    @JsonProperty("product_id")
    private Long productId;
    @JsonProperty("name_product")
    private String nameProduct;
    @JsonProperty("stock_id")
    private Long stockId;
    @JsonProperty("amount_on_stock")
    private Integer amountOnStock;
    @JsonProperty("amount_on_sale")
    private Integer amountOnSale;
    @JsonProperty("price_product")
    private Float priceProduct;
}
