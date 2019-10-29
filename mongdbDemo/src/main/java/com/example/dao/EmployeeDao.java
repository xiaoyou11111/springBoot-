package com.example.dao;


import com.example.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeDao {

    @Autowired
    private MongoTemplate template;

    //保存对象
    public void saveTest(Employee employee) {
        template.save(employee);
    }

    //根据名称查询
    public Employee findByName(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        Employee one = template.findOne(query, Employee.class);
        return one;
    }

    //修改对象
    public void update(Employee employee) {
        Query query = new Query(Criteria.where("id").is(employee.getId()));
        Update update = new Update().set("age", employee.getAge()).set("name", employee.getName());

        template.updateFirst(query, update, Employee.class);
    }

    //删除对象
    public void deleteById(String id){
        Query query =new Query(Criteria.where("id").is(id));
        template.remove(query,Employee.class);
    }

}
