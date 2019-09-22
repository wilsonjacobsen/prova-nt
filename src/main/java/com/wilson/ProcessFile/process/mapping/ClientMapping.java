package com.wilson.ProcessFile.process.mapping;

import com.wilson.ProcessFile.model.Sale;

public class ClientMapping {
    private ClientMapping(){}
    public static Sale from(String[] line){
        return Sale.builder()
                .id(line[0])
                .build();
    }
}
