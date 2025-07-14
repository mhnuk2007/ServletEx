package com.learning;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class App {
    public static void main(String[] args) throws LifecycleException {
        System.out.println("Hello World!");

        Tomcat tomcat = new Tomcat(); // Creates a new embedded Tomcat instance

        Context context = tomcat.addContext("", new File(".").getAbsolutePath());
        // Adds a new web context with root path "" and uses current directory as the base

        tomcat.addServlet(context, "HelloServlet", new HelloServlet());
        // Registers HelloServlet with the context

        context.addServletMappingDecoded("/hello", "HelloServlet");
        // Maps /hello URL to HelloServlet

        tomcat.start();                // Starts the server
        tomcat.getServer().await();    // Keeps server running (very important!)
    }
}
