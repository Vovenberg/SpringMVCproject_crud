package com.web;

import com.web.entities.ClientsEntity;
import com.web.services.ClientsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Vladimir on 05.11.2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@ContextConfiguration(classes = WebMagistrApplication.class)
public class ServicesTest {

    @Autowired
    ClientsService clientsService;

    @Test
    public void testClients() {
        clientsService.add(new ClientsEntity("sdsdf", 234, 23, "ddscf", 23));
        List<ClientsEntity> list = this.clientsService.getAll();
        assertNotNull(list);
        assertNotNull(clientsService.getById(list.get(0).getIdClient()));
    }

}
