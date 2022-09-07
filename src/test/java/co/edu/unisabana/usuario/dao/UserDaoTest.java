package co.edu.unisabana.usuario.dao;

import co.edu.unisabana.usuario.repository.dao.BookDao;
import co.edu.unisabana.usuario.repository.dao.UserDao;
import co.edu.unisabana.usuario.service.library.model.Book;
import co.edu.unisabana.usuario.service.library.model.CategoryBook;
import co.edu.unisabana.usuario.service.model.User;
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
