package com.wilson.ProcessFile.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Getter
public class Sale {
    private final String id;
    private final List<SaleItem> items;
    private final String idSalesman;
    private final BigDecimal total;
}
