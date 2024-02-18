package servicesSpec;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.*;
import services.CommunicationServices;

import java.lang.reflect.Parameter;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("<== CommunicationServicesSpec")
@ExtendWith(CommunicationServicesParameterResolver.class)
public class CommunicationServicesSpec
{
    //Fields
    private CommunicationServices marketingInfluencia;
    private CommunicationServices roteiros;

    @BeforeEach
    void init (Map<String, CommunicationServices> dataTest)
    {
        marketingInfluencia = dataTest.get("Marketing de influência");
        roteiros = dataTest.get("Roteiros");
    };//end of init(...)

    @Nested
    @DisplayName("Check the values of the arguments")
    class ArgumentsValue
    {
        @Test
        @DisplayName("name value should not be empty")
        void nameValueCannotBeEmpty()
        {
            String invalidName = "";
            IllegalArgumentException t = assertThrows(IllegalArgumentException.class,
                    ()-> {new CommunicationServices(invalidName, roteiros.getId(),
                            CommunicationServices.Type.MKTDIGITAL);},
                    "Should throw IllegalArgumentException because name value is empty");
            assertEquals("Name cannot be null or empty", t.getMessage());
        };//end of nameValueCannotBeEmpty();

        @Test
        @DisplayName("name value should not be null")
        void nameValueCannotBeNull()
        {
            String invalidName = null;
            IllegalArgumentException t = assertThrows(IllegalArgumentException.class,
                    ()-> {new CommunicationServices(invalidName, marketingInfluencia.getId(),
                            CommunicationServices.Type.MKTDIGITAL);},
                    "Should throw IllegalArgumentException because name value is null");
            assertEquals("Name cannot be null or empty", t.getMessage());
        };//end of nameValueCannotBeEmpty();

        @Test
        @DisplayName("Id value should not be empty")
        void iDValueCannotBeEmpty()
        {
            String invalidId = "";
            IllegalArgumentException t = assertThrows(IllegalArgumentException.class,
                    ()-> {new CommunicationServices("someName", invalidId,
                            CommunicationServices.Type.MKTDIGITAL);},
                    "Should throw IllegalArgumentException because Id value is empty");
            assertEquals("Id cannot be null of empty", t.getMessage());
        };//end of iDValueCannotBeEmpty();

        @Test
        @DisplayName("Id value should not be null")
        void iDValueCannotBeNull()
        {
            String invalidId = null;
            IllegalArgumentException t = assertThrows(IllegalArgumentException.class,
                    ()-> {new CommunicationServices("someName", invalidId,
                            CommunicationServices.Type.MKTDIGITAL);},
                    "Should throw IllegalArgumentException because Id value is empty");
            assertEquals("Id cannot be null of empty", t.getMessage());
        };//end of iDValueCannotBeNull();

        @Test
        @DisplayName("Type value must be valid")
        void typeValueMustBeMKTDigitalOrSite()
        {
            IllegalArgumentException t = assertThrows(IllegalArgumentException.class,
                    ()-> {new CommunicationServices("Site", "SITE",
                            null);}, "Type value must be valid");
            assertEquals("Type must be: MKTDIGITAL or SITE", t.getMessage());
        };//end of typeValueMustBeMKTDigitalOrSite();

    };//end of ArgumentsValue
};//end of CommunicationServicesSpec

class CommunicationServicesParameterResolver implements ParameterResolver
{
    @Override
    public boolean supportsParameter(final ParameterContext parameterContext,
                                     final ExtensionContext extensionContext) throws ParameterResolutionException
    {
        Parameter parameter = parameterContext.getParameter();
        return Objects.equals(parameter.getParameterizedType().getTypeName(),
                "java.util.Map<java.lang.String, services.CommunicationServices>");
    };//end of supportsParameter(...);

    @Override
    public Object resolveParameter(final ParameterContext parameterContext,
                                   final ExtensionContext extensionContext) throws ParameterResolutionException
    {
        //The data structure used to injection
        Map<String, CommunicationServices> communicationServicesTestData = new HashMap<>();

        //Create data test
        communicationServicesTestData.put("Roteiros", new CommunicationServices("Roteiros", "RTN",
                CommunicationServices.Type.MKTDIGITAL));
        communicationServicesTestData.put("Marketing de influência",
                new CommunicationServices("Marketing de influência", "MKTINFLUENCIA",
                        CommunicationServices.Type.MKTDIGITAL));

        return communicationServicesTestData;
    };//end of resolveParameter(...);
};//end of ServicesParameterResolver implements ParameterResolver
