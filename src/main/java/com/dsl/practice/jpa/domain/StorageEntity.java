package com.dsl.practice.jpa.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "storage")
public class StorageEntity
{
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private int quantity;
}
