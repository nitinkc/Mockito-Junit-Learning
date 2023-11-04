package org.learn;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by nitin on Sunday, November/17/2019 at 8:00 PM
 */
@Entity(name = "currency_exchange")
@Component
public record CurrencyExchangeEntity (
    @Id Long id,
    @Column(name = "currency_from") String from,
    @Column(name = "currency_to") String to,
    BigDecimal conversionMultiple,
    int port
    )
{ }