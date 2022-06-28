package io.community.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Environment {

        public static final String URL;
        public static final String UI_USERNAME;
        public static final String UI_PASSWORD;

        public static final String GRAPHURI;



    static{
        Properties properties = null;
        String environment = System.getProperty("environment") != null ? environment = System.getProperty("environment") : ConfigReader.get("environment");

        System.out.println(environment +" is running");

        try {

            String path = System.getProperty("user.dir") + "/src/test/resources/Environments/" + environment + ".properties";

            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        URL = properties.getProperty("url");
        UI_USERNAME = properties.getProperty("UIUsername");
        UI_PASSWORD = properties.getProperty("UIPassword");
        GRAPHURI= properties.getProperty("GraphURI");



    }


}
