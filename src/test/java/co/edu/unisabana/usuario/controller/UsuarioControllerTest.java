package co.edu.unisabana.usuario.controller;

import co.edu.unisabana.usuario.AbstractTest;
import co.edu.unisabana.usuario.dto.UserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioControllerTest extends AbstractTest {

  @Autowired
  private TestRestTemplate restTemplate;


  private static final String PATH_DATA = "/data";

  @Test
  public void Given_BasicTest_When_callData_Then_successful() {
    ResponseEntity<UserDTO> result = restTemplate.getForEntity(PATH_DATA, UserDTO.class);
    assertEquals(1, result.getBody().getAge());
  }
}
