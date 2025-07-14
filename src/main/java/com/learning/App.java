package com.learning;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class App {
    public static void main(String[] args) throws LifecycleException {
        System.out.println("Hello World!");

        Tomcat tomcat = new Tomcat(); // Creates embedded Tomcat
        tomcat.setPort(8080);         // Default port

        // Empty context path, using current directory as base
        Context context = tomcat.addContext("", null);

        // Register servlet
        tomcat.addServlet(context, "HelloServlet", new HelloServlet());
        context.addServletMappingDecoded("/hello", "HelloServlet");

        tomcat.start();
        tomcat.getServer().await();
    }
}
