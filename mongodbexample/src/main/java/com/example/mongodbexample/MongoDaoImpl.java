package com.example.mongodbexample;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.BulkWriteOptions;
import com.mongodb.client.model.WriteModel;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Properties;

@Repository
@Qualifier("mongoDao")
@SuppressWarnings("rawtypes")
public class MongoDaoImpl implements MongoDao, DisposableBean {

    private MongoDatabase mongoDatabase;
    private MongoClient mongoClient;
    DB db;

    public MongoDaoImpl(String mongoClientURI, String dbName) {

        Properties prop = PropertyUtil.getProperties("mongoDb");
        String minConnectionsPerHost = prop.getProperty("mongo_min_connectionsper_host");
        String maxConnectionsPerHost = prop.getProperty("mongo_max_connectionsper_host");
        String maxConnectionIdleTime = prop.getProperty("mongo_max_connection_idle_time");


        MongoClientOptions.Builder options = MongoClientOptions.builder()
                .minConnectionsPerHost(Integer.parseInt(minConnectionsPerHost))
                .connectionsPerHost(Integer.parseInt(maxConnectionsPerHost))
                .maxConnectionIdleTime(Integer.parseInt(maxConnectionIdleTime));


        MongoClientURI connectionURI = new MongoClientURI(mongoClientURI,options);
        mongoClient = new MongoClient(connectionURI);
        db = mongoClient.getDB(dbName);
        mongoDatabase = mongoClient.getDatabase(dbName);
    }



    public MongoDaoImpl() {
    }

    @Override
    public MongoClient getMongoClient() {
        return mongoClient;
    }

    @Override
    public DBCollection getCollection(String collectionName) {
        return db.getCollection(collectionName);
    }

    @Override
    public MongoCollection getMongoCollection(String collectionName) {
        return mongoDatabase.getCollection(collectionName);
    }

    @Override
    public <TargetClass> MongoCollection<TargetClass> getMongoCollection(String collectionName, Class<TargetClass> targetClass) {
        return mongoDatabase.getCollection(collectionName, targetClass);
    }

    @Override
    public DBObject findOne(DBObject query, DBObject projection, String collectionName) {
        return getCollection(collectionName).findOne(query, projection);
    }

    @Override
    public WriteResult upsert(DBObject query, DBObject update, String collectionName) {
        return getCollection(collectionName).update(query, update, true, false);
    }

    @Override
    public WriteResult delete(DBObject query, String collectionName) {
        return getCollection(collectionName).remove(query);
    }

    @Override
    public WriteResult updateMulti(DBObject query, DBObject update, String collectionName) {
        return getCollection(collectionName).updateMulti(query, update);
    }

    @Override
    public void destroy() throws Exception {
        mongoClient.close();
    }

    @Override
    public DBObject findOne(DBObject query, String collectionName) {
        return getCollection(collectionName).findOne(query);
    }
}

