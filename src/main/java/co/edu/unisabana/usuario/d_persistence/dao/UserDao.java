package co.edu.unisabana.usuario.d_persistence.dao;

import co.edu.unisabana.usuario.c_logic.model.User;
import co.edu.unisabana.usuario.d_persistence.dao.userapi.RegisterUserPort;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao implements RegisterUserPort {

  @Override
  public boolean addNewUser(User user) {

    return false;
  }
}
