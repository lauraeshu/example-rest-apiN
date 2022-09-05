package co.edu.unisabana.usuario.repository;

import co.edu.unisabana.usuario.service.model.User;
import co.edu.unisabana.usuario.service.user.port.RegisterUserPort;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao implements RegisterUserPort {

  @Override
  public boolean addNewUser(User user) {

    return false;
  }
}
