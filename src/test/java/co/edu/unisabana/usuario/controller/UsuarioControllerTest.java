package co.edu.unisabana.usuario.controller;

import co.edu.unisabana.usuario.AbstractTest;
import co.edu.unisabana.usuario.a_presentation.dto.UserDTO;
import co.edu.unisabana.usuario.a_presentation.dto.UserDTOResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import javax.xml.ws.Response;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioControllerTest extends AbstractTest {

    @Autowired
    private TestRestTemplate restTemplate;


    private static final String PATH_DATA = "/data";
    private static final String PATH_DATOS = "/search?q=";

    /**
     * Given: Dado que (Precondicones)
     * When: Que voy hacer/probar
     * Then: Cual debería ser el resultado
     */

    @Test
    public void Given_BasicTest_When_callData_Then_successful() {
        ResponseEntity<UserDTO> result = restTemplate.getForEntity(PATH_DATA, UserDTO.class);
        assertEquals(20, result.getBody().getAge());
    }

    @Test
    public void Given_Wrong_information_When_callDatos_Then_return_empty() {
        ResponseEntity<UserDTOResponse> result = restTemplate.getForEntity(PATH_DATOS + "abc",
                UserDTOResponse.class);
        System.out.println(result);
        assertTrue(result.getBody().getData().isEmpty());
    }

    @Test
    public void Given_Ok_information_When_callDatos_Then_return_three_data() {
        ResponseEntity<UserDTOResponse> result = restTemplate.getForEntity(PATH_DATOS + "a",
                UserDTOResponse.class);
        assertEquals(3, result.getBody().getData().size());
    }

    @Test
    public void Given_search_laura_When_invoke_search_Then_return_1_records() {
        ResponseEntity<UserDTOResponse> result = restTemplate.getForEntity(PATH_DATOS + "laura",
                UserDTOResponse.class);
        assertEquals(1, result.getBody().getData().size());
        assertTrue(result.getBody().getData().size() == 1);
        //assertFalse(result.getBody().getData().isEmpty());
    }
}
