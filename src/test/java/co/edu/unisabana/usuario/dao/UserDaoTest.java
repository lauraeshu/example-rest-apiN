package co.edu.unisabana.usuario.dao;

import co.edu.unisabana.usuario.d_persistence.dao.BookDao;
import co.edu.unisabana.usuario.d_persistence.dao.UserDao;
import co.edu.unisabana.usuario.c_logic.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserDaoTest {

    private UserDao userDao = new UserDao();

    @Test
    public void Given_Register_book_When_BookDao_Then_Increase_array_size() {
        User user = new User();
        assertEquals(1, BookDao.listBooks.size());
    }

}
