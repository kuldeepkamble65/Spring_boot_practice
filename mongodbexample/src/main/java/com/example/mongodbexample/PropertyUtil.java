package com.example.mongodbexample;

import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {

    public static Properties getProperties(String fileName) {
        InputStream addrStream = null;
        Properties properties = null;
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            addrStream = classLoader.getResourceAsStream(fileName + ".properties");
            if (addrStream != null) {
                properties = new Properties();
                properties.load(addrStream);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (addrStream != null) {
                    addrStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return properties;
    }
}

