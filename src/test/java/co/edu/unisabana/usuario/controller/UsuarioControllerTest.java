package co.edu.unisabana.usuario.controller;

import co.edu.unisabana.usuario.AbstractTest;
import co.edu.unisabana.usuario.dto.UserDTO;
import co.edu.unisabana.usuario.dto.UserDTOResponse;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioControllerTest extends AbstractTest {

  @Autowired
  private TestRestTemplate restTemplate;


  private static final String PATH_DATA = "/data";
  private static final String PATH_DATOS = "/search?q=";

  @Test
  public void Given_BasicTest_When_callData_Then_successful() {
    ResponseEntity<UserDTO> result = restTemplate.getForEntity(PATH_DATA, UserDTO.class);
    assertEquals(1, result.getBody().getAge());
  }

  @Test
  public void Given_Wrong_information_When_callDatos_Then_return_empty() {
    ResponseEntity<UserDTOResponse> result = restTemplate.getForEntity(PATH_DATOS + "abc",
        UserDTOResponse.class);
    assertTrue(result.getBody().getData().isEmpty());
  }

  @Test
  public void Given_Ok_information_When_callDatos_Then_return_four_data() {
    ResponseEntity<UserDTOResponse> result = restTemplate.getForEntity(PATH_DATOS + "a",
        UserDTOResponse.class);
    assertEquals(4, result.getBody().getData().size());
  }
}
