package com.web;

import com.web.entities.AccountsEntity;
import com.web.entities.ClientsEntity;
import com.web.services.ClientsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebMagistrApplicationTests {
    @Autowired
    ClientsService service;

    @Test
    public void contextLoads() {
        ClientsEntity clientsEntity = new ClientsEntity("sd",23,34,"df",23);
        service.add(clientsEntity);
        System.out.println(service.getAll());
    }

}
