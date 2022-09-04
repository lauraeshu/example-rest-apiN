package co.edu.unisabana.usuario.dto;

import lombok.*;

//Explicar lombok
@Data
@AllArgsConstructor
public class UserDTO {

  private String name;
  private String lastName;
  private int age;

}