package com.example.controller;

import com.example.dao.EmployeeDao;
import com.example.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class EmployeeController {

    @Autowired
    private EmployeeDao mapper;

    @GetMapping("/save")
    public void save(){
        Employee employee=new Employee();
        employee.setAge(15.0);
        employee.setName("lili");
        mapper.saveTest(employee);
    }

    @GetMapping("/findByName")
    public Employee findByName(){

        return mapper.findByName("lili");
    }

    @GetMapping("/update")
    public void update(){
        Employee employee=new Employee();
        employee.setId("5db6ab34f554ca6511b27ceb");
        employee.setAge(6.0);
        employee.setName("hema");
        mapper.update(employee);

    }

}
