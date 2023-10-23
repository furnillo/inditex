package com.inditex.prices.domain.repository;

import com.inditex.prices.domain.model.ProductPrice;
import java.util.List;

public interface PriceRepository {
    List<ProductPrice> findByProductId(Integer id);
}
