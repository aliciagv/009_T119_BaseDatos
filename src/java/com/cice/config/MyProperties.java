/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cice.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author cice
 */
public class MyProperties {
    private static MyProperties instance;
    private Properties properties;
    
   public static MyProperties getInstance() {
    
       return instance;
       
    }
    
    public static void init(String path) throws FileNotFoundException, IOException {
    
        if (instance==null) {
            instance =new MyProperties();
            instance.properties = new Properties();
            instance.properties.load(new FileInputStream(path));
            
        
        } else getInstance();
    }
}
