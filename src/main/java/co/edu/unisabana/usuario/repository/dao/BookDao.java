package co.edu.unisabana.usuario.repository.dao;

import co.edu.unisabana.usuario.repository.dao.entity.BookEntity;
import co.edu.unisabana.usuario.service.library.model.Book;
import co.edu.unisabana.usuario.service.library.model.CategoryBook;
import co.edu.unisabana.usuario.service.library.port.AddBookPort;
import co.edu.unisabana.usuario.service.library.port.RegisterBookPort;
import co.edu.unisabana.usuario.service.library.port.SearchBookCategoryPort;
import co.edu.unisabana.usuario.service.library.port.SearchBookPort;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Repository
public class BookDao implements SearchBookPort, RegisterBookPort, AddBookPort, SearchBookCategoryPort {

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


}
