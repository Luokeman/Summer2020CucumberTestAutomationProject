package com.vytrack.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationReader {
    private static final Properties properties = new Properties();

    static {
        try(InputStream in = new FileInputStream("Configuration.properties")){
            properties.load(in);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Failed to load properties files");
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
