package com.dsl.practice.jpa.services;

import com.dsl.practice.jpa.domain.StorageEntity;
import com.dsl.practice.jpa.repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

import static com.dsl.practice.jpa.specs.StorageSpecifications.*;

@Service
public class StorageServiceHandler implements StorageService
{
    @Autowired
    private StorageRepository storageRepository;

    @Override
    public String checkStock(String name)
    {
        Optional<StorageEntity> entity = storageRepository.findOne(hasStore(name));
        return entity.map(storageEntity -> {
            Optional<StorageEntity> result = storageRepository.findOne(hasStore(name).and(hasStock()));
            return result.map(res -> res.getName() + " " + res.getQuantity()).orElseGet(() -> name + " out of stocks");
        }).orElse(name + " not found");
    }

    @Override
    public String checkStock(Map<String, String> map)
    {
        String name = map.get("name");

        Optional<StorageEntity> entity = storageRepository.findOne(hasStore(name));
        return entity.map(storageEntity -> {
            Optional<StorageEntity> result = storageRepository.findOne(combine(map));
            return result.map(res -> res.getName() + " " + res.getQuantity()).orElseGet(() -> name + " out of stocks");
        }).orElse(name + " not found");
    }
}
