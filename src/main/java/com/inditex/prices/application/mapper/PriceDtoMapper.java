package com.inditex.prices.application.mapper;

import com.inditex.prices.domain.model.ProductPrice;
import com.inditex.prices.infraestructure.rest.dto.PriceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PriceDtoMapper {

    @Mapping(target = "productId", source = "id")
    PriceResponse toPriceResponse(ProductPrice productPrice);
}
