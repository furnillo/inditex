package com.inditex.prices.application.service;

import com.inditex.prices.application.mapper.PriceDtoMapper;
import com.inditex.prices.domain.model.ProductPrice;
import com.inditex.prices.domain.repository.PriceRepository;
import com.inditex.prices.infraestructure.rest.dto.PriceCriteria;
import com.inditex.prices.infraestructure.rest.dto.PriceResponse;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DomainPriceService implements PriceService {

    private final PriceRepository repository;
    private final PriceDtoMapper mapper;

    @Override
    public PriceResponse getPriceToApply(PriceCriteria priceCriteria) {
        List<ProductPrice> prices = repository.findByProductId(priceCriteria.getProductId());
        ProductPrice priceToApply = prices.stream()
                .filter(p -> isPriceApplicable(p, priceCriteria.getApplicationDate()))
                .max(Comparator.comparing(ProductPrice::getPriority))
                .orElseThrow(NoSuchElementException::new);

        return mapper.toPriceResponse(priceToApply);
    }

    private boolean isPriceApplicable(ProductPrice productPrice,LocalDateTime validDateTime) {
        return validDateTime.isEqual(productPrice.getStartDate()) ||
                (validDateTime.isAfter(productPrice.getStartDate()) &&
                        validDateTime.isBefore(productPrice.getEndDate()));
    }
}
