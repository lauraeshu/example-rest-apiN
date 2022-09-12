package co.edu.unisabana.usuario.c_logic.model;

import lombok.Data;

@Data
public class User {

  private String name;
  private String lastName;
  private int age;
  private boolean active;
}
