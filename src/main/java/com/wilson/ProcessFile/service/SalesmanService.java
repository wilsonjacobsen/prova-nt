package com.wilson.ProcessFile.service;

import com.wilson.ProcessFile.model.Sale;
import com.wilson.ProcessFile.process.mapping.SaleMapping;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class SalesmanService {
    public Integer countSalesman(Stream<String> lines) {
        return Math.toIntExact(lines.map(line -> line.split("ç"))
                .parallel()
                .filter(line -> line[0].equals("001"))
                .count());
    }

    public String nameMinSalesman(Stream<String> file) {

        return file.map(line -> line.split("ç"))
                .parallel()
                .filter(line -> line[0].equals("003"))
                .map(line -> SaleMapping.from(line))
                .collect(Collectors.groupingBy(Sale::getIdSalesman, Collectors.summingDouble(s -> s.getTotal().doubleValue())))
                .entrySet()
                .stream()
                .min(Comparator.comparingDouble(Map.Entry::getValue))
                .map(Map.Entry::getKey).get();
    }
}
