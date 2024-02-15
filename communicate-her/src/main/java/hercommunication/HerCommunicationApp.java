/** This is the main class for the application.
 * @author pedro de castro tedesco
 * @since 15/02/2024
 * @see Spring and SpringBoot in Action (Craig Walls, 2021)
 * */

package hercommunication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HerCommunicationApp
{
    public static void main(String[] args)
    {
        SpringApplication.run(HerCommunicationApp.class, args);
    };//end of main()
};//end of HerCommunicationApp