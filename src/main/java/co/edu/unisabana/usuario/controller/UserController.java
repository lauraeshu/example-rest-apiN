package co.edu.unisabana.usuario.controller;


import co.edu.unisabana.usuario.dto.UserDTO;
import co.edu.unisabana.usuario.dto.UserDTOResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

  @GetMapping("/hello")
  public String greeting() {
    return "Hola Mundo";
  }


  @GetMapping(value = "/data")
  public UserDTO dataUser() {
    return new UserDTO("d", "s", 1);
  }

  @GetMapping(value = "/data/{variable}/{otroDato}")
  public UserDTO dataUserWithPathVarible(@PathVariable String variable,
      @PathVariable String otroDato) {
    return new UserDTO(variable, "s", 1);
  }

  @GetMapping("/search")
  public UserDTOResponse datos(@RequestParam String q) {
    List<UserDTO> lista = new ArrayList<>();
    lista.add(new UserDTO("Richard", "a", 20));
    lista.add(new UserDTO("Jhonatan", "a", 21));
    lista.add(new UserDTO("laura", "Espitia", 19));
    lista.add(new UserDTO("laura", "Piraneque", 19));

    List<UserDTO> resultados = new ArrayList<>();
    lista.forEach(dato -> {
      if (dato.getName().contains(q)) {
        resultados.add(dato);
      }
    });
    return new UserDTOResponse(resultados);
  }
}
