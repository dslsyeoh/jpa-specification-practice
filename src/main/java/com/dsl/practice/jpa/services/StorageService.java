package com.dsl.practice.jpa.services;

import java.util.Map;

public interface StorageService
{
    String checkStock(String name);

    String checkStock(Map<String, String> map);
}
