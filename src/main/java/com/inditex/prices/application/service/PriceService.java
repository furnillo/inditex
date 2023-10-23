package com.inditex.prices.application.service;

import com.inditex.prices.infraestructure.rest.dto.PriceCriteria;
import com.inditex.prices.infraestructure.rest.dto.PriceResponse;

public interface PriceService {
    PriceResponse getPriceToApply(PriceCriteria priceCriteria) throws Exception;
}
