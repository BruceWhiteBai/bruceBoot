package com.bruce.cassandra.dao;

import com.bruce.cassandra.entity.Employee;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import reactor.core.publisher.Flux;

public interface EmployeeRepository extends ReactiveCassandraRepository<Employee, Integer> {
    @AllowFiltering
    Flux<Employee> findByAgeGreaterThan(int age);
}
