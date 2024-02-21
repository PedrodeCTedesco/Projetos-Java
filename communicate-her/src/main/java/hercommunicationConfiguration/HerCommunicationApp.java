/** This is the main class for the application.
 * @author pedro de castro tedesco
 * @since 15/02/2024
 * @see Spring and SpringBoot in Action (Craig Walls, 2021)
 * */

package hercommunicationConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

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
    //Fields
    @Autowired
    private ApplicationContext applicationContext;



    public static void main(String[] args)
    {
        /** The run() method of the SpringApplication class performs the actual bootstrapping of the
         * application creating the Spring application context. The two parameters passed are the
         * configuration class and the command-line arguments.
         * */
        SpringApplication.run(HerCommunicationApp.class, args);
    };//end of main()
};//end of HerCommunicationApp