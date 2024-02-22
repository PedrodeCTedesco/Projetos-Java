/** This is the main class for the application.
 * @author pedro de castro tedesco
 * @since 15/02/2024
 * @see Spring and SpringBoot in Action (Craig Walls, 2021)
 * */

package com.hermanas.landingPage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** The @SpringBootApplication is a composite annotation that combines three in one.
 * 1) @SpringBootConfiguration --> designates this class as a configuration class.
 * 2) @EnableAutoConfiguration --> enables Spring Boot automatically configuration. This annotation tells
 * Spring Boot automatically configure any components that it thinks you'll need.
 * 3) @ComponentScan --> enables component scanning. This lets you declare other classes with annotations
 * like @Component, @Controller and @Service to have Spring automatically discover and register them as components
 * int the Spring application context.
 * */

@SpringBootApplication
public class HerCommunicationApp
{
    public static void main(String[] args)
    {
        SpringApplication.run(HerCommunicationApp.class, args);
    };//end of main()
};//end of HerCommunicationApp