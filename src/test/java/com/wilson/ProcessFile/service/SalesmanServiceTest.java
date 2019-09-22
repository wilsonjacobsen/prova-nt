package com.wilson.ProcessFile.service;

import com.wilson.ProcessFile.util.Constants;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SalesmanServiceTest {

    @InjectMocks
    private SalesmanService salesmanService;

    @Test
    public void nameMinSalesman_sucesuful(){
       String result = salesmanService.nameMinSalesman(Constants.stringStream);
       assertEquals("Paulo",result);
    }
    @Test
    public void countSalesman_sucesuful(){
       Integer result = salesmanService.countSalesman(Constants.stringStream);
       assertEquals("2",result);
    }
}
