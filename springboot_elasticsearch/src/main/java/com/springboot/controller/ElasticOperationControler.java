package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.data.elasticsearch.core.document.Document;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ElasticOperationControler {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchTemplate;

    @GetMapping("createIndex")
    public boolean createIndex(String indexName){
        IndexOperations indexOperations = elasticsearchTemplate.indexOps(IndexCoordinates.of(indexName));
        return indexOperations.create();
    }

    @GetMapping("deleteIndex")
    public boolean deleteIndex(String indexName){
        IndexOperations indexOperations = elasticsearchTemplate.indexOps(IndexCoordinates.of(indexName));
        return indexOperations.delete();
    }

    @GetMapping("indexIsExist")
    public boolean indexIsExist(String indexName){
        IndexOperations indexOperations = elasticsearchTemplate.indexOps(IndexCoordinates.of(indexName));
        return indexOperations.exists();
    }

    @GetMapping("getMapping")
    public Map getMapping(String indexName){
        IndexOperations indexOperations = elasticsearchTemplate.indexOps(IndexCoordinates.of(indexName));
        Map<String, Object> mapping = indexOperations.getMapping();
        return mapping;
    }

    @GetMapping("getSetting")
    public Map getSetting(String indexName){
        IndexOperations indexOperations = elasticsearchTemplate.indexOps(IndexCoordinates.of(indexName));
        Map<String, Object> settings = indexOperations.getSettings();
        return settings;
    }
}
