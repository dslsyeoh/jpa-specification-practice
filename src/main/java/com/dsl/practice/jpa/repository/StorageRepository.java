package com.dsl.practice.jpa.repository;

import com.dsl.practice.jpa.specs.StorageSpecifications;
import com.dsl.practice.jpa.domain.StorageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageRepository extends JpaRepository<StorageEntity, Long>, StorageSpecifications
{
}
