package co.edu.unisabana.usuario.d_persistence.dao;

import co.edu.unisabana.usuario.d_persistence.dao.bookapi.*;
import co.edu.unisabana.usuario.d_persistence.dao.entity.BookEntity;
import co.edu.unisabana.usuario.c_logic.library.model.Book;
import co.edu.unisabana.usuario.c_logic.library.model.CategoryBook;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Repository
public class BookDao implements SearchBookPort, RegisterBookPort, AddBookPort, SearchBookCategoryPort, QuantityOfBooksPort, SearchAuthorsBooksPort {

    public static List<BookEntity> listBooks = new ArrayList<>();

    @Override
    public boolean validateExistsBook(String nameBook) {
        AtomicBoolean exists = new AtomicBoolean(false);
        listBooks.forEach(book -> {
            if (book.getName().equals(nameBook)) {
                exists.set(true);
            }
        });
        return exists.get();
    }

    @Override
    public List searchCategoryBook(String bookCategory) {
        List<BookEntity> listCategoryBook = new ArrayList<>();
        CategoryBook categoryBook = CategoryBook.fromString(bookCategory);
        listBooks.forEach(book -> {
            if (book.getCategory().equals(categoryBook.name())) {
                listCategoryBook.add(book);
            }
        });
        return listCategoryBook;
    }

    @Override
    public void registerBook(Book newBook) {
        BookEntity bookEntity = BookEntity.fromModel(newBook);
        bookEntity.setId(listBooks.size() + 1);
        listBooks.add(bookEntity);
    }

    @Override
    public boolean addBook(String name) {
        for (BookEntity book : listBooks) {
            if (book.getName().equals(name)) {
                book.setQuantity(book.getQuantity() + 1);
                return true;
            }
        }
        throw new IllegalArgumentException("No existe libro para actualizar");
    }
    @Override
    public boolean quantityOfBooks(int size) {
        if(listBooks.size() > 7) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public List searchAuthorsBooks(String authorsBooks) {
        List<BookEntity> listFromAuthor = new ArrayList<>();
        listBooks.forEach(book -> {
            if (book.getAuthor().equals(authorsBooks)) {
                listFromAuthor.add(book);
            }
        });
        return listFromAuthor;
    }
}
