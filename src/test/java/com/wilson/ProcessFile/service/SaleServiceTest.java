package com.wilson.ProcessFile.service;

import com.wilson.ProcessFile.util.Constants;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SaleServiceTest {

    @InjectMocks
    private SaleService saleService;

    @Test
    public void idMaxSaleFiles_sucesuful(){
       String result = saleService.idMaxSaleFiles(Constants.stringStream);
       assertEquals("10",result);
    }
}
