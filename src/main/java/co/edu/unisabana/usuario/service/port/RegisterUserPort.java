package co.edu.unisabana.usuario.service.port;

import co.edu.unisabana.usuario.service.model.User;

public interface RegisterUserPort {

  boolean addNewUser(User user);
}
