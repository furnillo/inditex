package com.inditex.prices.infraestructure.persistence;

import com.inditex.prices.domain.model.ProductPrice;
import com.inditex.prices.domain.repository.PriceRepository;
import com.inditex.prices.infraestructure.entity.PriceEntity;
import com.inditex.prices.infraestructure.exception.ProductNotFoundException;
import com.inditex.prices.infraestructure.mapper.PriceMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ProductPriceAdapter implements PriceRepository {

    private final SpringDataPriceRepository repository;
    private final PriceMapper mapper;

    @Override
    public List<ProductPrice> findByProductId(Integer id) {
        List<PriceEntity> prices = repository.findByProductId(id);
        if(prices.isEmpty()) {
            throw new ProductNotFoundException("product not found");
        }
        return mapper.toProductPrices(prices);
    }
}
