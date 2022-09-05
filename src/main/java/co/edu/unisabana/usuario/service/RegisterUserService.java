package co.edu.unisabana.usuario.service;

import co.edu.unisabana.usuario.service.model.User;
import co.edu.unisabana.usuario.service.port.RegisterUserPort;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserService {

  private RegisterUserPort registerUserPort;

  RegisterUserService(RegisterUserPort registerUserPort) {
    this.registerUserPort = registerUserPort;
  }

  public boolean registerUser(User user) {
    if (user.getName() == null || user.getName().isEmpty()) {
      throw new IllegalArgumentException("The name cannot be empty");
    }
    return registerUserPort.addNewUser(user);

  }
}