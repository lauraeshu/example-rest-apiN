package co.edu.unisabana.usuario.d_persistence.dao.userapi;

import co.edu.unisabana.usuario.c_logic.model.User;

public interface RegisterUserPort {

  boolean addNewUser(User user);
}
