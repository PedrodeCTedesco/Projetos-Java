package templatesTest;
//JUnit 5
import com.hermanas.landingPage.services.controller.ServicesController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import static org.hamcrest.Matchers.containsString;
//Mockito
import static org.mockito.Mockito.*;
//Spring Framework
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.ui.Model;
//Project
import com.hermanas.landingPage.services.ClientRequestedServices;
import com.hermanas.landingPage.services.CommunicationServices;
import com.hermanas.landingPage.services.Services;

//API Java
//AssertJ
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ContextConfiguration(classes = ServicesController.class)
@WebMvcTest(ServicesController.class)
public class ServicesControllerTest
{
    //Fields
    @Autowired
    private MockMvc mockMvc;
    private ServicesController servicesControllerMock; //mocks the behavior of ServicesController
    @Autowired
    private ServicesController servicesController;
    //Setup
    @BeforeEach
    void init()
    {
       servicesControllerMock = mock(ServicesController.class);
       servicesController = new ServicesController();
    };//end of init();

    //Tests
    @Nested
    @DisplayName("<== Test the endpoint ==>")
    class TestingTheEndpoint
    {
        @Test
        @DisplayName("Mocks to see if services path and services logical name are correct")
        void serviceControllerTest() throws Exception
        {
            mockMvc.perform(MockMvcRequestBuilders.get("/services"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.view().name("services"));
        };//end of serviceControllerTest() throws Exception;

        @Test
        @DisplayName("check to see if showServicePage() method works")
        void showServicePageMustReturnServiceLogicalName()
        {
            when(servicesControllerMock.showServicePage())
                    .thenReturn("/services");
        };//showServicePageMustReturnServiceLogicalName();

        @Test
        @DisplayName("check to see if showServicePage() method works with real instance of ServiceController")
        void showServicePageMustReturnServiceLogicalNameWithRealInstanceOfServiceController()
        {
            assertThat(servicesController.showServicePage())
                    .isEqualTo("services");
        };//showServicePageMustReturnServiceLogicalName();

        @Test
        @DisplayName("services template is viewed when a GET request is made to /services")
        void homePageMustShowTheHomeTemplateWhenGETRequestIsMadeToTheRootPath() throws Exception
        {
            mockMvc.perform(get("/services")) //here the mock object mocks a GET request to the root path
                    .andExpect(status().isOk()) //expects HTTP status code 200
                    .andExpect(view().name("services")); //expects home page view with logical name set as "home"
                    //.andExpect(content().string(
                      //      containsString("Como podemos te ajudar?")));
        };//end of homePageMustShowTheHomeTemplateWhenGETRequestIsMadeToTheRootPath()
    };//end of TestingTheEndpoint

    @Nested
    @DisplayName("<== Check the methods of model attribute ==>")
    class checkTheReturnOfMethods
    {
        @Test
        @DisplayName("check if servicesRequestedByClient() returns the ClientRequestedServices object")
        void servicesRequestedByClientMethodShouldReturnClientRequestedServicesObject()
        {
            //Call the method in a real instance of ServiceController.
            //Don't need to use a mock because the method as no dependencies
            assertThat(servicesController.servicesRequestedByClient())
                    .isEqualTo(new ClientRequestedServices());
        };//end of servicesRequestedByClientMethodShouldReturnClientRequestedServicesObject();
    };//end of checkTheReturnOfMethods;

    @Test
    @DisplayName("check if addServicesToModel() is invoked with the correct values")
    void addServicesToModelMethodShouldBeInvoked()
    {
        //Instantiate real ServiceController. This is required to test the behavior of the method.
        //We cannot use a mock, because they are used to simulate dependencies of external interactions,
        //not the class under test itself.
        ServicesController servicesController = new ServicesController();

        //Create a mock to simulate the Model that addServicesToModel(...) needs.
        Model modelMock = mock(Model.class);

        //Call the method on the real controller object
        servicesController.addServicesToModel(modelMock);

        //Verify that addServicesToModel(Model model) was invoked. We call the modelMock because in
        //the body of addServicesToModel(...) we call the addAttribute() on the model parameter.
        verify(modelMock).addAttribute(eq("servicesOffered"), anyMap());
    };//end of addServicesToModelMethodShouldBeInvoked();

};//end of ServicesControllerTest;
