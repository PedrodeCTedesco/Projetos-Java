/** This is the test class for the home page template of the web application.
 *
 * @author pedro de castro tedesco
 * @see Spring and Spring Boot in Action (Craig Walls, chapter 1, 2021)
 * @since 15/02/2024
 * */

package templatesTest;
//Project imports
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import hercommunication.HomePageController;

//JUnit 5
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//Spring Framework
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//Hamcrest
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ContextConfiguration(classes = HomePageController.class)
@WebMvcTest(HomePageController.class) //WebTest for HomePageController
public class HomePageControllerTest
{
    //Fields
    @Autowired
    private MockMvc mockMvc; //injects MockMvc object to mock the request

    @Test
    @DisplayName("home page template is viewed when a GET request is made to the root path")
    void homePageMustShowTheHomeTemplateWhenGETRequestIsMadeToTheRootPath() throws Exception
    {
        mockMvc.perform(get("/")) //here the mock object mocks a GET request to the root path
                .andExpect(status().isOk()) //expects HTTP status code 200
                .andExpect(view().name("home")) //expects home page view with logical name set as "home"
                .andExpect(content().string(
                        containsString("Bem-vinda a nossa página de serviços!")));
    };//end of homePageMustShowTheHomeTemplateWhenGETRequestIsMadeToTheRootPath()

    @Test
    @DisplayName("should return the image of the home page")
    void confirmThatExistsAnImageTagInTheHomePage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML_VALUE + ";charset=UTF-8"))
                .andExpect(xpath("//img").exists());
    };//end of confirmThatExistsAnImageTagInTheHomePage() throws Exception

    @Test
    public void testHomePage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("home")); // Check if it returns the correct view name
    }

};//end of HomePageControllerSpec
