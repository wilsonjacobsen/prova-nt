package com.wilson.ProcessFile.service;

import com.wilson.ProcessFile.model.Sale;
import com.wilson.ProcessFile.process.mapping.SaleMapping;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.stream.Stream;

@Service
public class SaleService {
    public String idMaxSaleFiles(Stream<String> file) {
        return file.map(line -> line.split("ç"))
                .parallel()
                .filter(line -> line[0].equals("003"))
                .map(line -> SaleMapping.from(line))
                .max(Comparator.comparing(Sale::getTotal)).get().getId();
    }

}
