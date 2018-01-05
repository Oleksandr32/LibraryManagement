package com.project.librarymanagement.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleksandr Lysun on 03.01.2018.
 * In this package, I implemented the pattern "Service Locator"
 * For future modifications
 */

public class Cache {

    // logging, I use log4j2
    private static final Logger logger = LogManager.getLogger( Cache.class );

    private List<Service> services;

    public Cache(){
        services = new ArrayList<Service>();
    }

    public Service getService(String serviceName){

        for (Service service : services) {
            if( service.getName().equalsIgnoreCase( serviceName ) ){
                logger.info("Returning cached  " + serviceName + " object" );
                return service;
            }
        }

        return null;
    }

    public void addService(Service newService){
        boolean exists = false;

        for (Service service : services) {
            if( service.getName().equalsIgnoreCase( newService.getName() ) ){
                exists = true;
            }
        }

        if( !exists ){
            services.add(newService);
        }
    }
}
