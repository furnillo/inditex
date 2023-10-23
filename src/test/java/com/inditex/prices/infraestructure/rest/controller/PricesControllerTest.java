package com.inditex.prices.infraestructure.rest.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.inditex.prices.infraestructure.rest.dto.PriceResponse;
import com.inditex.prices.infraestructure.rest.dto.PriceResponseTest;
import java.time.LocalDateTime;
import java.time.Month;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PricesControllerTest {

    private final String RESOURCE_URL = "/prices";

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void firstTestCaseGivesTwoApplicationDatesReturnsFirstPriceData() {
        LocalDateTime priceApplicationDateTime =
                LocalDateTime.of(2020, Month.JUNE, 14,10,0,0);

        ResponseEntity<PriceResponse> response = restTemplate.
                getForEntity(getUrlWithParams(priceApplicationDateTime),PriceResponse.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertTrue(response.getBody().equals(PriceResponseTest.buildFirstPriceTestData()));
    }

    @Test
    public void secondTestCaseGivesTwoApplicationDatesReturnsSecondPriceData() {
        LocalDateTime priceApplicationDateTime =
                LocalDateTime.of(2020, Month.JUNE, 14,16,0,0);

        ResponseEntity<PriceResponse> response = restTemplate.
                getForEntity(getUrlWithParams(priceApplicationDateTime),PriceResponse.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertTrue(response.getBody().equals(PriceResponseTest.buildSecondPriceTestData()));
    }

    @Test
    public void ThirdTestCaseGivesTwoApplicationDatesReturnsFirstPriceData() {
        LocalDateTime priceApplicationDateTime =
                LocalDateTime.of(2020, Month.JUNE, 14,21,0,0);

        ResponseEntity<PriceResponse> response = restTemplate.
                getForEntity(getUrlWithParams(priceApplicationDateTime),PriceResponse.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertTrue(response.getBody().equals(PriceResponseTest.buildFirstPriceTestData()));
    }

    @Test
    public void fourthTestCaseGivesTwoApplicationDatesReturnsThirdPriceData() {
        LocalDateTime priceApplicationDateTime =
                LocalDateTime.of(2020, Month.JUNE, 15,10,0,0);

        ResponseEntity<PriceResponse> response = restTemplate.
                getForEntity(getUrlWithParams(priceApplicationDateTime),PriceResponse.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertTrue(response.getBody().equals(PriceResponseTest.buildThirdPriceTestData()));
    }

    @Test
    public void fifthTestCaseGivesTwoApplicationDatesReturnsFourthPriceData() {
        LocalDateTime priceApplicationDateTime =
                LocalDateTime.of(2020, Month.JUNE, 16,21,0,0);

        ResponseEntity<PriceResponse> response = restTemplate.
                getForEntity(getUrlWithParams(priceApplicationDateTime),PriceResponse.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertTrue(response.getBody().equals(PriceResponseTest.buildFourthPriceTestData()));
    }

    private String getUrlWithParams(LocalDateTime priceApplicationDateTime) {
        MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
        params.add("productId","35455");
        params.add("brandId","1");
        params.add("applicationDate", priceApplicationDateTime.toString());
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(RESOURCE_URL)
                .queryParams(params);
        return builder.buildAndExpand(params).toUriString();
    }
}
