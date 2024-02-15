/** This is the test class for the home page template of the web application.
 * @author pedro de castro tedesco
 * @see Spring and Spring Boot in Action (Craig Walls, chapter 1, 2021)
 * @since 15/02/2024
 * */

package templatesTest;

import hercommunication.HomePageController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ContextConfiguration(classes = HomePageController.class)
//@SpringBootTest(classes = HomePageController.class)
@WebMvcTest(HomePageController.class) //WebTest for HomePageController
public class HomePageControllerTest
{

    //Fields
    @Autowired
    private MockMvc mockMvc; //injects MockMvc

    @Test
    @DisplayName("home page template is viewed when a GET request is made to the root path")
    void homePageMustShowTheHomeTemplateWhenGETRequestIsMadeToTheRootPath() throws Exception
    {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk()) //expects HTTP status code 200
                .andExpect(view().name("home")) //expects home page view
                .andExpect(content().string(
                        containsString("Bem-vinda a nossa página de serviços!")));


    };//end of homePageMustShowTheHomeTemplateWhenGETRequestIsMadeToTheRootPath()
};//end of HomePageControllerSpec
