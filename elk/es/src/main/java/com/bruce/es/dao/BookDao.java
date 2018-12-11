package com.bruce.es.dao;

import com.bruce.es.entity.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface  BookDao extends ElasticsearchRepository<Book,String> {
}
