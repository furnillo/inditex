package com.inditex.prices.infraestructure.mapper;

import com.inditex.prices.domain.model.ProductPrice;
import com.inditex.prices.infraestructure.entity.PriceEntity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    List<ProductPrice> toProductPrices(List<PriceEntity> priceEntities);

    @Mappings({
            @Mapping(target = "id", source = "productId"),
            @Mapping(target = "brand", source = "brand.name")
    })
    ProductPrice toProductPrice(PriceEntity priceEntity);
}
