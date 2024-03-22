package com.example.mongodbexample;

import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;
import com.mongodb.client.MongoCollection;

public interface MongoDao {

    DBCollection getCollection(String collectionName);

    DBObject findOne(DBObject query, DBObject projection, String collectionName);

    WriteResult upsert(DBObject query, DBObject update, String collectionName);

    WriteResult delete(DBObject query, String collectionName);

    WriteResult updateMulti(DBObject query, DBObject update, String collectionName);

    MongoClient getMongoClient();

    MongoCollection getMongoCollection(String collectionName);


    DBObject findOne(DBObject query, String collectionName);

    <TargetClass> MongoCollection<TargetClass> getMongoCollection(String collectionName, Class<TargetClass> targetClass);
}
