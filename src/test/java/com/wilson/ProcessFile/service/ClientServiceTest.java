package com.wilson.ProcessFile.service;

import com.wilson.ProcessFile.util.Constants;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ClientServiceTest {

    @InjectMocks
    private ClientService clientService;

    @Test
    public void countSalesman_sucesuful(){
       Integer result = clientService.countClient(Constants.stringStream);
       assertEquals("2",result);
    }
}
