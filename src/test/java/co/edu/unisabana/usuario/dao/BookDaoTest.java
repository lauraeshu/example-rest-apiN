package co.edu.unisabana.usuario.dao;

import co.edu.unisabana.usuario.repository.dao.BookDao;
import co.edu.unisabana.usuario.repository.dao.entity.BookEntity;
import co.edu.unisabana.usuario.service.library.model.Book;
import co.edu.unisabana.usuario.service.library.model.CategoryBook;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BookDaoTest {

    private BookDao bookDao = new BookDao();

    @Test
    public void Given_Register_book_When_BookDao_Then_Succesful() {
        CategoryBook categoryBook = CategoryBook.fromString("suave");
        Book book = new Book("100 años de soledad", 1967, "Gabriel García Márquez",
                false, categoryBook);
        bookDao.registerBook(book);
        assertEquals(1, BookDao.listBooks.size());
    }

    @Test
    public void Given_Add_a_book_When_BookDao_Then_Succesful() {
        CategoryBook categoryBook = CategoryBook.fromString("suave");
        Book book = new Book("100 años de soledad", 1967, "Gabriel García Márquez",
                false, categoryBook);
        bookDao.registerBook(book);
        assertTrue(bookDao.addBook("100 años de soledad"));
    }

    @Test
    public void Given_Check_existence_When_BookDao_Then_Succesful() {
        CategoryBook categoryBook = CategoryBook.fromString("suave");
        Book book = new Book("100 años de soledad", 1967, "Gabriel García Márquez",
                false, categoryBook);
        bookDao.registerBook(book);
        assertTrue(bookDao.validateExistsBook("100 años de soledad"));
    }

    @Test
    public void Given_Check_existence_When_BookDao_Then_Failed() {
        CategoryBook categoryBook = CategoryBook.fromString("suave");
        Book book = new Book("100 años de soledad", 1967, "Gabriel García Márquez",
                false, categoryBook);
        bookDao.registerBook(book);
        assertFalse(bookDao.validateExistsBook("El ángel de la última oportunidad"));
    }

    @Test
    public void Given_Search_book_category_When_BookDao_Then_Succesful() {
        CategoryBook categoryBook = CategoryBook.fromString("suave");
        Book book = new Book("100 años de soledad", 1967, "Gabriel García Márquez",
                false, categoryBook);
        bookDao.registerBook(book);
        List books = bookDao.searchCategoryBook("suave");
        assertEquals(1, books.size());
    }

    @Test
    public void Given_Authors_Name_When_BookDao_Then_Return_Authors_Books() {
        CategoryBook categoryBook = CategoryBook.fromString("suave");

        Book book = new Book("100 años de soledad", 1967, "Gabriel García Márquez",
                false, categoryBook);

        Book book2 = new Book("El amor en tiempos de cólera", 1985, "Gabriel García Márquez",
                false, categoryBook);

        Book book3 = new Book("Once minutos", 2003, "Paulo Coelho",
                false, categoryBook);

        bookDao.registerBook(book);
        bookDao.registerBook(book2);
        bookDao.registerBook(book3);

        List books = bookDao.searchAuthorsBooks("Gabriel García Márquez");

        assertEquals(2, books.size());
    }
}
