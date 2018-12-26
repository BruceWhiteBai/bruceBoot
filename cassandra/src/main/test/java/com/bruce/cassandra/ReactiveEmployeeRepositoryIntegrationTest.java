package com.bruce.cassandra;

import com.bruce.cassandra.dao.EmployeeRepository;
import com.bruce.cassandra.entity.Employee;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ReactiveEmployeeRepositoryIntegrationTest  {



    @Autowired
    EmployeeRepository repository;

    @Before
    public void setUp() {
        Flux<Employee> deleteAndInsert = repository.deleteAll()
                .thenMany(repository.saveAll(Flux.just(
                        new Employee(111, "John Doe", "Delaware", "jdoe@xyz.com", 31),
                        new Employee(222, "Adam Smith", "North Carolina", "asmith@xyz.com", 43),
                        new Employee(333, "Kevin Dunner", "Virginia", "kdunner@xyz.com", 24),
                        new Employee(444, "Mike Lauren", "New York", "mlauren@xyz.com", 41))));
        //todo
        /*StepVerifier
                .create(deleteAndInsert)
                .expectNextCount(4)
                .verifyComplete();*/
    }

    @Test
    public void givenRecordsAreInserted_whenDbIsQueried_thenShouldIncludeNewRecords() {
        Mono<Long> saveAndCount = repository.count()
                .doOnNext(System.out::println)
                .thenMany(repository
                        .saveAll(Flux.just(
                                new Employee(325, "Kim Jones", "Florida", "kjones@xyz.com", 42),
                                new Employee(654, "Tom Moody", "New Hampshire", "tmoody@xyz.com", 44))))
                .last()
                .flatMap(v -> repository.count())
                .doOnNext(System.out::println);

        //todo
       /* StepVerifier
                .create(saveAndCount)
                .expectNext(6L)
                .verifyComplete();*/
    }

    @Test
    public void givenAgeForFilter_whenDbIsQueried_thenShouldReturnFilteredRecords() {
        //todo
        /* StepVerifier
                .create(repository.findByAgeGreaterThan(35))
                .expectNextCount(2)
                .verifyComplete();*/
    }

}
