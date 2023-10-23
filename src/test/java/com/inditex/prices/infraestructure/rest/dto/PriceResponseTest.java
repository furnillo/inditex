package com.inditex.prices.infraestructure.rest.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;

public class PriceResponseTest {

    public static PriceResponse buildFirstPriceTestData() {
        return PriceResponse.builder()
                .productId(35455)
                .brand("ZARA")
                .priceList(1)
                .startDate(LocalDateTime.of(2020, Month.JUNE,14,0,0,0))
                .endDate(LocalDateTime.of(2020, Month.DECEMBER,31,23,59,59))
                .price(new BigDecimal("35.50"))
                .build();
    }

    public static PriceResponse buildSecondPriceTestData() {
        return PriceResponse.builder()
                .productId(35455)
                .brand("ZARA")
                .priceList(2)
                .startDate(LocalDateTime.of(2020, Month.JUNE,14,15,0,0))
                .endDate(LocalDateTime.of(2020, Month.JUNE,14,18,30,00))
                .price(new BigDecimal("25.45"))
                .build();
    }

    public static PriceResponse buildThirdPriceTestData() {
        return PriceResponse.builder()
                .productId(35455)
                .brand("ZARA")
                .priceList(3)
                .startDate(LocalDateTime.of(2020, Month.JUNE,15,0,0,0))
                .endDate(LocalDateTime.of(2020, Month.JUNE,15,11,00,00))
                .price(new BigDecimal("30.50"))
                .build();
    }

    public static PriceResponse buildFourthPriceTestData() {
        return PriceResponse.builder()
                .productId(35455)
                .brand("ZARA")
                .priceList(4)
                .startDate(LocalDateTime.of(2020, Month.JUNE,15,16,0,0))
                .endDate(LocalDateTime.of(2020, Month.DECEMBER,31,23,59,59))
                .price(new BigDecimal("38.95"))
                .build();
    }
}
