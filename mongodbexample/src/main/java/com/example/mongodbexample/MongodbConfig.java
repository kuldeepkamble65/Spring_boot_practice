package com.example.mongodbexample;

import org.springframework.context.annotation.Bean;

import java.net.UnknownHostException;
import java.util.Properties;

public class MongodbConfig {
    @Bean
    public MongoDaoImpl mongoDao() throws UnknownHostException {
        Properties prop = PropertyUtil.getProperties("mongoDb");
        String host = prop.getProperty("mongo_host");
        String port = prop.getProperty("mongo_port");
        String dbName = prop.getProperty("mongo_database");
        String mongoClientURI;
        boolean isAuthenticate = Boolean.parseBoolean(prop.getProperty("is_authenticate", "false"));
        if (isAuthenticate) {
            String username = prop.getProperty("mongo_username");
            String password = prop.getProperty("mongo_password");
            mongoClientURI = "mongodb://" + username + ":" + password + "@" + host + ":" + port + "/" + dbName;
        } else {
            mongoClientURI = "mongodb://" + host + ":" + port + "/" + dbName;
        }
        return new MongoDaoImpl(mongoClientURI, dbName);
    }
}
