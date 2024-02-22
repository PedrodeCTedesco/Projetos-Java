/** This is the main test class for the application.
 * @author pedro de castro tedesco
 * @since 15/02/2024
 * @see Spring and SpringBoot in Action (Craig Walls, 2021)
 * */


import com.hermanas.landingPage.HerCommunicationApp;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = HerCommunicationApp.class)
public class HerCommunicationAppTest
{
    @Test
    public void contextLoads() {}
}
