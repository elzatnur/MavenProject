package com.elzat.tests;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class readingProperties {
    @Test
    public void reading_from_properties() throws IOException {
        Properties properties = new Properties();
        FileInputStream file = new FileInputStream("MavenProject/configuration.properties");
        properties.load(file);
        System.out.println(properties.getProperty("browser"));
        System.out.println(properties.getProperty("env"));
        System.out.println(properties.getProperty("username"));
        System.out.println(properties.getProperty("password"));
    }
}
