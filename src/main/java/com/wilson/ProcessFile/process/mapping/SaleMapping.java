package com.wilson.ProcessFile.process.mapping;

import com.wilson.ProcessFile.model.Sale;
import com.wilson.ProcessFile.model.SaleItem;

import java.math.BigDecimal;
import java.util.*;

public class  SaleMapping {
    private SaleMapping(){}
    public static Sale from(String[] line){
        final List<SaleItem> items = SaleItemsMapping.from(line[2]);
        return Sale.builder()
                .id(line[1])
                .idSalesman(line[3])
                .items(items)
                .total(items.stream()
                        .map(SaleItem::getPrice)
                        .reduce(BigDecimal.ZERO, BigDecimal::add))
                .build();
    }

}
