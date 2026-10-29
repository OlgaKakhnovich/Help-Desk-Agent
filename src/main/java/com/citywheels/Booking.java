package com.citywheels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Booking (
        String id,
        String status,
        String bike_type,
        @JsonProperty("rental_price_eur") BigDecimal rentalPriceEur,
        @JsonProperty("booking_fee_eur") BigDecimal bookingFeeEur
        ){

}
