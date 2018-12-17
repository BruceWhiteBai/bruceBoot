package com.bruce.cassandra.entity;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
@Data
@AllArgsConstructor
public class Employee {
    @PrimaryKey
    private int id;
    private String name;
    private String address;
    private String email;
    private int age;

}
