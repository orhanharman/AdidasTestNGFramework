package com.adidas.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
//this class has only one job, read "configuration.properties" that we created, and get the key names in there,
//then give us the values

    private static Properties properties;

    //This code is inside the static block because static blocks runs first and once
    static {

        try {
            //what file to read, read the file into java, finds the file using this "string"
            FileInputStream input = new FileInputStream("configuration.properties");
            //properties > a class that store properties in key/value format
            properties = new Properties();
            //the values from the file is loaded / fed into the properties object
            properties.load(input);

            input.close();
        } catch (Exception e) {
            System.out.println("Failed to load properties file!");
            e.printStackTrace();
        }
    }

    //the responsibility of this method is, reading the key name and giving the value of that key
    public static String get(String keyName) {

        return properties.getProperty(keyName);
    }

}
