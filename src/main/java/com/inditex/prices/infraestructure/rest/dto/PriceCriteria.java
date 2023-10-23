package com.inditex.prices.infraestructure.rest.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class PriceCriteria {

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @NotNull(message = "applicationDate cannot be null")
    private LocalDateTime applicationDate;
    @NotNull(message = "productId cannot be null")
    private Integer productId;
    @NotNull(message = "brandId cannot be null")
    private Integer brandId;

}
