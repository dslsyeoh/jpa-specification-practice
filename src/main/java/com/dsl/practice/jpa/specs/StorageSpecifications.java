package com.dsl.practice.jpa.specs;

import com.dsl.practice.jpa.domain.StorageEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;

public interface StorageSpecifications extends JpaSpecificationExecutor<StorageEntity>
{
    static Specification<StorageEntity> hasStore(String name)
    {
        return (root, cq, cb) -> cb.equal(root.get("name"), name);
    }

    static Specification<StorageEntity> hasStock()
    {
        return (root, cq, cb) -> cb.greaterThan(root.get("quantity"), 0);
    }

    static Specification<StorageEntity> combine(Map<String, String> map)
    {
        return (root, cq, cb) -> cb.and(map.entrySet().stream().map(entry -> toPredicate(cb, root, entry))
                .filter(Objects::nonNull).toArray(Predicate[]::new));
    }

    static Predicate toPredicate(CriteriaBuilder cb, Root<StorageEntity> root, Map.Entry<String, String> entry)
    {
        String key = entry.getKey();
        String value = entry.getValue();
        switch (key)
        {
            case "name":
                return cb.equal(root.get(key), value);
            case "quantity":
                return cb.greaterThan(root.get(key), 0);
            default:
                return null;
        }
    }

}
