package com.project.librarymanagement.service;

/**
 * Created by Oleksandr Lysun on 03.01.2018.
 * In this package, I implemented the pattern "Service Locator"
 * For future modifications
 */

public class ServiceLocator {

    private static Cache cache;

    static {
        cache = new Cache();
    }

    public static Service getService(String name){

        Service service = cache.getService( name );

        if(service != null){
            return service;
        }

        InitialContext context = new InitialContext();
        service = (Service)context.lookup( name );
        cache.addService( service );

        return service;
    }
}
