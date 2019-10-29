package com.example.domain;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data  //可以自动生成getter和setter方法
@ToString //可以自动生成toString方法
@Document("employee")
public class Employee {
    @Id
    private String id;
    private String name;
    private Double age;
}
