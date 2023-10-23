package com.inditex.prices.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ProductPrice {
    private Integer id;
    private String brand;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer priceList;
    private Integer priority;
    private BigDecimal price;
    private String curr;
}
