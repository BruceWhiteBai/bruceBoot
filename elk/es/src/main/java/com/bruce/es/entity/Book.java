package com.bruce.es.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

//http://120.79.197.131:9200/product
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "product", type = "book")
public class Book {
    @Id
    @JsonProperty("auto_id")
    String id;
    @JsonProperty("name")
    String name;

    @JsonProperty("message")
    String message;

    @JsonProperty("type")
    String type;

    @JsonProperty("bookStatus")
    String bookStatus;


}