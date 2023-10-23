package com.inditex.prices.infraestructure.rest.controller;

import com.inditex.prices.application.service.DomainPriceService;
import com.inditex.prices.infraestructure.rest.dto.PriceCriteria;
import com.inditex.prices.infraestructure.rest.dto.PriceResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/prices")
public class PricesController {

    private final DomainPriceService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PriceResponse> getApplicationPrices(@Valid PriceCriteria priceCriteria) {
        return ResponseEntity.ok(service.getPriceToApply(priceCriteria));
    }
}
