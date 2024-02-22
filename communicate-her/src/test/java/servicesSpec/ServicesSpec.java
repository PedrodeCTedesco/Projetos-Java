package servicesSpec;

//JUnit 5
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.*;
import com.hermanas.landingPage.services.CommunicationServices;
import com.hermanas.landingPage.services.Services;

//API Java
import java.lang.reflect.Parameter;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@DisplayName("<== ServicesSpec ==>")
@ExtendWith(ServicesParameterResolver.class)
public class ServicesSpec
{
    //Fields
    private Services planejamentoEstrategico;
    private Services marketingConteudo;
    private Services sites;
    private Services services;

    //Constructor
    @BeforeEach
    void init(Map<String, Services> servicesOffered)
    {
        services = new Services();
        planejamentoEstrategico = servicesOffered.get("Planejamento estratégico");
        marketingConteudo = servicesOffered.get("Marketing de conteúdo");
        sites = servicesOffered.get("Site");
    };//end of init(...)

    @Nested
    @DisplayName("query methods of Services class work as expected")
    class QueryMethodsOfServices
    {
        @Test
        @DisplayName("check to see if the instances of the properties of Services are correct")
        void shouldReturnTheCorrectInstancesOfTheFieldsOfServices()
        {
            List<CommunicationServices> communicationServicesList = planejamentoEstrategico.getServicesRequested();
            LocalDate localDateObj = planejamentoEstrategico.getServiceRequestedOn();
            String serviceName = planejamentoEstrategico.getServiceName();

            assertAll("Check the types returned",
                    () -> assertThat(communicationServicesList).isInstanceOf(List.class),
                    () -> assertThat(localDateObj).isInstanceOf(LocalDate.class),
                    () -> assertThat(serviceName).isInstanceOf(String.class));
        };//end of shouldReturnListOfCommunicationServices();

        @Test
        @DisplayName("should check the day, moth and year of servicesRequestedOn property")
        void shouldCheckDayMonthAndYearOfLocalDateInstance()
        {
            int localDateDay = sites.getServiceRequestedOn().getDayOfMonth();
            Month localDateMonth = sites.getServiceRequestedOn().getMonth();
            int localDateYear = sites.getServiceRequestedOn().getYear();

            assertAll("LocalDate object properties",
                    () -> assertThat(localDateDay).isEqualTo(27),
                    ()-> assertThat(localDateMonth).isEqualTo(Month.NOVEMBER),
                    ()-> assertThat(localDateYear).isEqualTo(2023));
        };//end of shouldReturnLocalDateObjectOfServicesRequestedOn();

        @Test
        @DisplayName("should check for the value of serviceName property")
        void theValueOfServiceNameMustBePlanejamentoEstrategico()
        {
            assertThat("Planejamento Estratégico")
                    .isEqualTo(planejamentoEstrategico.getServiceName());
        };//end of theValueOfServiceNameMustBePlanejamentoEstrategico();
    };//end of QueryMethodsOfServices

    @Nested
    @DisplayName("<== Check the constructor arguments ==>")
    class CheckTheValuesOfConstructorArgs
    {
        @Test
        @DisplayName("serviceName cannot be empty")
        void serviceNameCannotBeEmpty()
        {
            assertAll("Check the arguments value",
                    () -> assertThat(sites.getServicesRequested()).isInstanceOf(List.class),
                    () -> assertThat(sites.getServiceRequestedOn()).isInstanceOf(LocalDate.class));

            IllegalArgumentException t = assertThrows(IllegalArgumentException.class,
                    () -> {new Services(sites.getServicesRequested(), sites.getServiceRequestedOn(),
                            "");}, "Must throw exception because string value is empty");
            assertEquals("You must choose a service name", t.getMessage());
        };//end of serviceNameCannotBeNullOrEmpty();

        @Test
        @DisplayName("serviceName cannot be null")
        void serviceNameCannotBeNull()
        {
            assertAll("Check the arguments value",
                    () -> assertThat(sites.getServicesRequested()).isInstanceOf(List.class),
                    () -> assertThat(sites.getServiceRequestedOn()).isInstanceOf(LocalDate.class));

            IllegalArgumentException t = assertThrows(IllegalArgumentException.class,
                    () -> {new Services(sites.getServicesRequested(), sites.getServiceRequestedOn(),
                            null);}, "Must throw exception because string value is empty");
            assertEquals("You must choose a service name", t.getMessage());
        };//end of serviceNameCannotBeNullOrEmpty();

        @Test
        @DisplayName("serviceRequested cannot be null or empty")
        void serviceRequestedCannotBeNull()
        {
            assertAll("Check the arguments value",
                    () -> assertThat(sites.getServiceName()).isInstanceOf(String.class),
                    () -> assertThat(sites.getServiceRequestedOn()).isInstanceOf(LocalDate.class));

            IllegalArgumentException t = assertThrows(IllegalArgumentException.class,
                    () -> {new Services(null, sites.getServiceRequestedOn(), sites.getServiceName());},
                    "Must throw exception because serviceRequested value is null");
            assertEquals("serviceRequested cannot be null or empty", t.getMessage());
        };//end of serviceNameCannotBeNull();

        @Test
        @DisplayName("serviceRequested cannot be empty")
        void serviceRequestedCannotBeEmpty()
        {
            assertAll("Check the arguments value",
                    () -> assertThat(sites.getServiceName()).isInstanceOf(String.class),
                    () -> assertThat(sites.getServiceRequestedOn()).isInstanceOf(LocalDate.class));

            List<CommunicationServices> emptyCommunicationServices = List.of();

            IllegalArgumentException t = assertThrows(IllegalArgumentException.class,
                    () -> {new Services(emptyCommunicationServices, sites.getServiceRequestedOn(),
                            sites.getServiceName());},
                    "Must throw exception because serviceRequested value is empty");
            assertEquals("serviceRequested cannot be null or empty", t.getMessage());
        };//end of serviceNameCannotBeNullOrEmpty();

        @Test
        @DisplayName("LocalDate object's value cannot be in the future")
        void localDateObjectValueCannotBeInTheFuture()
        {
            assertAll("Check the arguments value",
                    () -> assertThat(sites.getServiceName()).isInstanceOf(String.class),
                    () -> assertThat(sites.getServicesRequested()).isInstanceOf(List.class));

            LocalDate futureDate = LocalDate.of(2025, Month.DECEMBER, 2);

            IllegalArgumentException t = assertThrows(IllegalArgumentException.class,
                    () -> {new Services(sites.getServicesRequested(), futureDate,
                            sites.getServiceName());},
                    "Must throw exception because LocalDate value is in the future");
            assertEquals("Date of serviceRequestedOn cannot be in the future", t.getMessage());
        };//end of serviceNameCannotBeNullOrEmpty();

    };//end of CheckTheValuesOfConstructorArgs

};//end of ServicesSpec

//The parameters to be injected in the tests
class ServicesParameterResolver implements ParameterResolver
{
    @Override
    public boolean supportsParameter(final ParameterContext parameterContext,
                                     final ExtensionContext extensionContext) throws ParameterResolutionException
    {
        Parameter parameter = parameterContext.getParameter();
        return Objects.equals(parameter.getParameterizedType().getTypeName(),
                "java.util.Map<java.lang.String, com.hermanas.landingPage.services.Services>");
    };//end of supportsParameter(...);

    @Override
    public Object resolveParameter(final ParameterContext parameterContext,
                                   final ExtensionContext extensionContext) throws ParameterResolutionException
    {
        //The data structure used to injection
        Map<String, Services> servicesOffered = new HashMap<>();
        //The objects of CommunicationServices
        CommunicationServices strategicPlanning = new CommunicationServices("Planejamento estratégico",
                "PLANEST", CommunicationServices.Type.MKTDIGITAL);

        CommunicationServices marketingContent = new CommunicationServices("Marketing de conteúdo",
                "MKTCONT", CommunicationServices.Type.MKTDIGITAL);

        CommunicationServices site = new CommunicationServices("Sites", "STE",
                CommunicationServices.Type.SITE);
        //The property for Services list of communication services
        List<CommunicationServices> servicesRequested = Arrays.asList(strategicPlanning, marketingContent, site);

        //Creating the data test
        servicesOffered.put("Planejamento estratégico", new Services(servicesRequested,
                LocalDate.of(2024, Month.FEBRUARY,16), "Planejamento Estratégico"));

        servicesOffered.put("Marketing de conteúdo", new Services(servicesRequested,
                LocalDate.of(2024, Month.JANUARY, 4), "Marketing de conteúdo"));

        servicesOffered.put("Site", new Services(servicesRequested,
                LocalDate.of(2023, Month.NOVEMBER, 27), "Site"));

        return servicesOffered;
    };//end of resolveParameter(...);
};//end of ServicesParameterResolver implements ParameterResolver
