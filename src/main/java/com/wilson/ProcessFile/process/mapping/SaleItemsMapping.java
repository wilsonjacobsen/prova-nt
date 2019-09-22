package com.wilson.ProcessFile.process.mapping;

import com.wilson.ProcessFile.model.SaleItem;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SaleItemsMapping {
    private SaleItemsMapping(){}
    public static List<SaleItem> from(String line){
        final List<String> array = Arrays.asList(line.substring(1, line.length() - 1).split(","));

        return array.stream().map(l -> l.split("-"))
                .map(v -> SaleItem.builder()
                        .id(v[0])
                        .quantity(Integer.parseInt(v[1]))
                        .price(new BigDecimal(v[2]))
                        .build()
                ).collect(Collectors.toList());
    }
}
