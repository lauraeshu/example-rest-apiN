package co.edu.unisabana.usuario.dao;

import co.edu.unisabana.usuario.d_persistence.dao.BookDao;
import co.edu.unisabana.usuario.d_persistence.dao.UserDao;
import co.edu.unisabana.usuario.c_logic.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class UserDaoTest {

    private UserDao userDao = new UserDao();

    @Test
    public void Given_Add_user_When_UserDao_Then_Return_false() {
        User user = new User();
        assertFalse(userDao.addNewUser(user));
    }

}
