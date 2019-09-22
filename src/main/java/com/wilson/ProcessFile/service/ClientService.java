package com.wilson.ProcessFile.service;

import org.springframework.stereotype.Service;
import java.util.stream.Stream;

@Service
public class ClientService {

    public Integer countClient(Stream<String> lines) {
        return Math.toIntExact(lines.map(line -> line.split("ç"))
                .parallel()
                .filter(line -> line[0].equals("002"))
                .count());
    }
}
