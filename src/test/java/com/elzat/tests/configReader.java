package com.elzat.tests;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configReader {
    private static Properties properties = new Properties();

    static{
        try {
            FileInputStream file = new FileInputStream("MavenProject/configuration.properties");
            properties.load(file);

        } catch (IOException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }

    }
    public static String getProp(String keyword){
        return properties.getProperty(keyword);
    }
}
