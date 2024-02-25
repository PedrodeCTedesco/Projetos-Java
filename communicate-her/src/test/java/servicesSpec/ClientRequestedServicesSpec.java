package servicesSpec;
//JUnit 5
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.*;
import static org.junit.jupiter.api.Assertions.*;

//Package imports
import com.hermanas.landingPage.services.ClientRequestedServices;
import com.hermanas.landingPage.services.CommunicationServices;
import com.hermanas.landingPage.services.Services;
//API Java
import java.lang.reflect.Parameter;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
//AssertJ
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("<== ClientRequestedServicesSpec ==>")
@ExtendWith(ClientRequestedServicesParameterResolver.class)
public class ClientRequestedServicesSpec
{
    private ClientRequestedServices renataCarvalho;

    @BeforeEach
    void init(Map<String, ClientRequestedServices> requestedServices)
    {
        renataCarvalho = requestedServices.get("Renata Carvalho");
    };//end of init(...);

    @Nested
    @DisplayName("Check the constructor")
    class CheckConstructorArgs
    {
        @Test
        @DisplayName("clientName should throw IllegalArgumentException when empty")
        void clientNameShouldThrowIllegalArgumentExceptionWhenEmpty()
        {
            IllegalArgumentException t = assertThrows(IllegalArgumentException.class,
                    ()-> {new ClientRequestedServices("", renataCarvalho.getClientCompanyName(),
                            renataCarvalho.getClientPhone(), renataCarvalho.getClientCity(),
                            renataCarvalho.getClientBusinessArea(), renataCarvalho.getServices());},
                    "Should throw IllegalArgumentException because clientName value is empty");

            assertEquals("Client name cannot be empty or null", t.getMessage());
        };//end of clientNameShouldThrowIllegalArgumentExceptionWhenEmpty()

        @Test
        @DisplayName("clientName should throw IllegaArgumentException when null")
        void clientNameShouldThrowIllegalArgumentExceptionWhenNull()
        {
            IllegalArgumentException t = assertThrows(IllegalArgumentException.class,
                    ()-> {new ClientRequestedServices(null, renataCarvalho.getClientCompanyName(),
                            renataCarvalho.getClientPhone(), renataCarvalho.getClientCity(),
                            renataCarvalho.getClientBusinessArea(), renataCarvalho.getServices());},
                    "Should throw IllegalArgumentException because clientName value is empty");

            assertEquals("Client name cannot be empty or null", t.getMessage());
        };//end of clientNameShouldThrowIllegalArgumentExceptionWhenNull()

        @Test
        @DisplayName("clientCompanyName should throw IllegalArgumentException when empty")
        void clientCompanyNameShouldThrowIllegalArgumentExceptionWhenEmpty()
        {
            IllegalArgumentException t = assertThrows(IllegalArgumentException.class,
                    ()-> {new ClientRequestedServices(renataCarvalho.getClientName(), "",
                            renataCarvalho.getClientPhone(), renataCarvalho.getClientCity(),
                            renataCarvalho.getClientBusinessArea(), renataCarvalho.getServices());},
                    "Should throw IllegalArgumentException because clientCompanyName value is empty");

            assertEquals("Client company name cannot be empty or null", t.getMessage());
        };//end of clientNameShouldThrowIllegalArgumentExceptionWhenEmpty()

        @Test
        @DisplayName("clientCompanyName should throw IllegalArgumentException when null")
        void clientCompanyNameShouldThrowIllegalArgumentExceptionWhenNull()
        {
            IllegalArgumentException t = assertThrows(IllegalArgumentException.class,
                    ()-> {new ClientRequestedServices(renataCarvalho.getClientName(), null,
                            renataCarvalho.getClientPhone(), renataCarvalho.getClientCity(),
                            renataCarvalho.getClientBusinessArea(), renataCarvalho.getServices());},
                    "Should throw IllegalArgumentException because clientCompanyName value is empty");

            assertEquals("Client company name cannot be empty or null", t.getMessage());
        };//end of clientCompanyNameShouldThrowIllegalArgumentExceptionWhenNull()

        @Test
        @DisplayName("clientPhone should throw IllegalArgumentException when empty")
        void clientPhoneShouldThrowIllegalArgumentExceptionWhenEmpty()
        {
            IllegalArgumentException t = assertThrows(IllegalArgumentException.class,
                    ()-> {new ClientRequestedServices(renataCarvalho.getClientName(),
                            renataCarvalho.getClientCompanyName(),
                            "", renataCarvalho.getClientCity(),
                            renataCarvalho.getClientBusinessArea(), renataCarvalho.getServices());},
                    "Should throw IllegalArgumentException because clientPhone value is empty");

            assertEquals("Client phone cannot be empty or null", t.getMessage());
        };//end of clientPhoneShouldThrowIllegalArgumentExceptionWhenEmpty()

        @Test
        @DisplayName("clientPhone should throw IllegalArgumentException when null")
        void clientPhoneShouldThrowIllegalArgumentExceptionWhenNull()
        {
            IllegalArgumentException t = assertThrows(IllegalArgumentException.class,
                    ()-> {new ClientRequestedServices(renataCarvalho.getClientName(),
                            renataCarvalho.getClientCompanyName(),
                            null, renataCarvalho.getClientCity(),
                            renataCarvalho.getClientBusinessArea(), renataCarvalho.getServices());},
                    "Should throw IllegalArgumentException because clientPhone value is mull");

            assertEquals("Client phone cannot be empty or null", t.getMessage());
        };//end of clientPhoneShouldThrowIllegalArgumentExceptionWhenNull()

        @Test
        @DisplayName("clientCity should throw IllegalArgumentException when null")
        void clientCityShouldThrowIllegalArgumentExceptionWhenNull()
        {
            IllegalArgumentException t = assertThrows(IllegalArgumentException.class,
                    ()-> {new ClientRequestedServices(renataCarvalho.getClientName(),
                            renataCarvalho.getClientCompanyName(),
                            renataCarvalho.getClientPhone(), null,
                            renataCarvalho.getClientBusinessArea(), renataCarvalho.getServices());},
                    "Should throw IllegalArgumentException because clientCity value is mull");

            assertEquals("Client city cannot be empty or null", t.getMessage());
        };//end of clientCityShouldThrowIllegalArgumentExceptionWhenNull()

        @Test
        @DisplayName("clientCity should throw IllegalArgumentException when empty")
        void clientCityShouldThrowIllegalArgumentExceptionWhenEmpty()
        {
            IllegalArgumentException t = assertThrows(IllegalArgumentException.class,
                    ()-> {new ClientRequestedServices(renataCarvalho.getClientName(),
                            renataCarvalho.getClientCompanyName(),
                            renataCarvalho.getClientPhone(), "",
                            renataCarvalho.getClientBusinessArea(), renataCarvalho.getServices());},
                    "Should throw IllegalArgumentException because clientCity value is empty");

            assertEquals("Client city cannot be empty or null", t.getMessage());
        };//end of clientCityShouldThrowIllegalArgumentExceptionWhenEmpty()

        @Test
        @DisplayName("clientBusinessArea should throw IllegalArgumentException when empty")
        void clientBusinessAreaShouldThrowIllegalArgumentExceptionWhenEmpty()
        {
            IllegalArgumentException t = assertThrows(IllegalArgumentException.class,
                    ()-> {new ClientRequestedServices(renataCarvalho.getClientName(),
                            renataCarvalho.getClientCompanyName(),
                            renataCarvalho.getClientPhone(), renataCarvalho.getClientCity(),
                            "", renataCarvalho.getServices());},
                    "Should throw IllegalArgumentException because clientBusinessArea value is empty");

            assertEquals("Client business area cannot be empty or null", t.getMessage());
        };//end of clientBusinessAreaShouldThrowIllegalArgumentExceptionWhenEmpty()

        @Test
        @DisplayName("clientBusinessArea should throw IllegalArgumentException when null")
        void clientBusinessAreaShouldThrowIllegalArgumentExceptionWhenNull()
        {
            IllegalArgumentException t = assertThrows(IllegalArgumentException.class,
                    ()-> {new ClientRequestedServices(renataCarvalho.getClientName(),
                            renataCarvalho.getClientCompanyName(),
                            renataCarvalho.getClientPhone(), renataCarvalho.getClientCity(),
                            null, renataCarvalho.getServices());},
                    "Should throw IllegalArgumentException because clientBusinessArea value is null");

            assertEquals("Client business area cannot be empty or null", t.getMessage());
        };//end of clientBusinessAreaShouldThrowIllegalArgumentExceptionWhenNull()

        @Test
        @DisplayName("services should throw IllegalArgumentException when null")
        void servicesShouldThrowIllegalArgumentExceptionWhenNull()
        {
            IllegalArgumentException t = assertThrows(IllegalArgumentException.class,
                    ()-> {new ClientRequestedServices(renataCarvalho.getClientName(),
                            renataCarvalho.getClientCompanyName(),
                            renataCarvalho.getClientPhone(), renataCarvalho.getClientCity(),
                            renataCarvalho.getClientBusinessArea(), null);},
                    "Should throw IllegalArgumentException because services value is null");

            assertEquals("You must order at least one service", t.getMessage());
        };//end of servicesShouldThrowIllegalArgumentExceptionWhenNull()

        @Test
        @DisplayName("services should throw IllegalArgumentException when empty")
        void servicesShouldThrowIllegalArgumentExceptionWhenEmpty()
        {
            IllegalArgumentException t = assertThrows(IllegalArgumentException.class,
                    ()-> {new ClientRequestedServices(renataCarvalho.getClientName(),
                            renataCarvalho.getClientCompanyName(),
                            renataCarvalho.getClientPhone(), renataCarvalho.getClientCity(),
                            renataCarvalho.getClientBusinessArea(), List.of());},
                    "Should throw IllegalArgumentException because services value is empty");

            assertEquals("You must order at least one service", t.getMessage());
        };//end of servicesShouldThrowIllegalArgumentExceptionWhenEmpty()

    };//CheckConstructorArgs

    @Nested
    @DisplayName("Check query methods")
    class CheckQueryMethods
    {
        @Test
        @DisplayName("confirm that query methods works")
        void confirmAllQueryMethods()
        {
            assertAll("Check the query methods of the object",
                    ()-> assertThat("Renata Carvalho").isEqualTo(renataCarvalho.getClientName()),
                    ()-> assertThat("Clínica Renata Carvalho").isEqualTo(renataCarvalho.getClientCompanyName()),
                    ()-> assertThat("(33) 3333-3333").isEqualTo(renataCarvalho.getClientPhone()),
                    ()-> assertThat("Belo Horizonte").isEqualTo(renataCarvalho.getClientCity()),
                    ()-> assertThat("Psicologia alimentar").isEqualTo(renataCarvalho.getClientBusinessArea()),
                    ()-> assertThat(renataCarvalho.getServices()).isEqualTo(renataCarvalho.getServices()));
        };//end of confirmAllQueryMethods();
    };//end of CheckQueryMethods
};//end of ClientRequestedServicesSpec

class ClientRequestedServicesParameterResolver implements ParameterResolver
{
    @Override
    public boolean supportsParameter(final ParameterContext parameterContext,
                                     final ExtensionContext extensionContext) throws ParameterResolutionException
    {
        Parameter parameter = parameterContext.getParameter();
        return Objects.equals(parameter.getParameterizedType().getTypeName(),
                "java.util.Map<java.lang.String, com.hermanas.landingPage.services.ClientRequestedServices>");
    };//end of supportsParameter(...);


    @Override
    public Object resolveParameter(final ParameterContext parameterContext,
                                   final ExtensionContext extensionContext) throws ParameterResolutionException
    {
        //The data structure used to injection
        Map<String, ClientRequestedServices> clientRequestedServicesTestData = new HashMap<>();

        //CommunicationServices objects
        CommunicationServices communicationServices = new CommunicationServices("Roteiros",
                "RTN", CommunicationServices.Type.FIXED);

        List<Services> servicesList = getServices(communicationServices);

        //Create data test
        clientRequestedServicesTestData.put("Renata Carvalho", new ClientRequestedServices("Renata Carvalho",
                "Clínica Renata Carvalho", "(33) 3333-3333", "Belo Horizonte",
                "Psicologia alimentar", servicesList));

        return clientRequestedServicesTestData;
    };//end of resolveParameter(...);

    private static List<Services> getServices(CommunicationServices communicationServices)
    {
        CommunicationServices communicationServices1 = new CommunicationServices("Marketing de influência",
                "MKTINFLUENCIA", CommunicationServices.Type.FIXED);

        //List of CommunicationServices
        List<CommunicationServices> communicationServicesList = Arrays.asList(communicationServices, communicationServices1);

        //Services objects
        Services services = new Services(communicationServicesList, LocalDate.of(2024, Month.JANUARY, 12),
                "Planejamento estratégico");

        Services services1 = new Services(communicationServicesList, LocalDate.of(2024, Month.JANUARY, 20),
                "Produção de vídeo");

        //List of Services
        return Arrays.asList(services, services1);
    };//end of getServices(CommunicationServices communicationServices);
};//end of ClientRequestedServicesParameterResolver implements ParameterResolver
