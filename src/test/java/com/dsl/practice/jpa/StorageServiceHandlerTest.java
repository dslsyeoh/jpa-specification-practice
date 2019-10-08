package com.dsl.practice.jpa;

import com.dsl.practice.jpa.services.StorageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StorageServiceHandlerTest
{
    @Autowired
    private StorageService storageService;

    @Test
    public void checkStock_Cake()
    {
        assertEquals("CAKE 10", storageService.checkStock("CAKE"));
    }

    @Test
    public void checkStock_Cake2()
    {
        assertEquals("CAKE 2 5", storageService.checkStock("CAKE 2"));
    }

    @Test
    public void checkStock_Cake3()
    {
        assertEquals("CAKE 3 out of stocks", storageService.checkStock("CAKE 3"));
    }


    @Test
    public void checkStock_NotFound()
    {
        assertEquals("CAKE 5 not found", storageService.checkStock("CAKE 5"));
    }

    @Test
    public void checkStockWithMap()
    {
        Map<String, String> map = new HashMap<>();
        map.put("name", "CAKE");
        map.put("quantity", "10");
        assertEquals("CAKE 10", storageService.checkStock(map));
    }

    @Test
    public void checkStockWithMap_2()
    {
        Map<String, String> map = new HashMap<>();
        map.put("name", "CAKE 2");
        map.put("quantity", "5");
        assertEquals("CAKE 2 5", storageService.checkStock(map));
    }

    @Test
    public void checkStockWithMap_3()
    {
        Map<String, String> map = new HashMap<>();
        map.put("name", "CAKE 3");
        map.put("quantity", "0");
        assertEquals("CAKE 3 out of stocks", storageService.checkStock(map));
    }

    @Test
    public void checkStockWithMap_NotFound()
    {
        Map<String, String> map = new HashMap<>();
        map.put("name", "CAKE 5");
        map.put("quantity", "10");
        assertEquals("CAKE 5 not found", storageService.checkStock(map));
    }
}
