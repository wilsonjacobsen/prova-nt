package com.wilson.ProcessFile.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class SaleItem {
    private final String id;
    private final Integer quantity;
    private final BigDecimal price;
}
