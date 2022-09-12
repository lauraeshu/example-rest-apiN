package co.edu.unisabana.usuario.c_logic.library;

import co.edu.unisabana.usuario.c_logic.library.model.Book;
import co.edu.unisabana.usuario.d_persistence.dao.bookapi.AddBookPort;
import co.edu.unisabana.usuario.d_persistence.dao.bookapi.RegisterBookPort;
import co.edu.unisabana.usuario.d_persistence.dao.bookapi.SearchBookPort;
import org.springframework.stereotype.Service;

@Service
public class RegisterBookLibrary {

    private final SearchBookPort searchBookPort;
    private final AddBookPort addBookPort;
    private final RegisterBookPort registerBookPort;

    public RegisterBookLibrary(SearchBookPort searchBookPort, AddBookPort addBookPort, RegisterBookPort registerBookPort) {
        this.searchBookPort = searchBookPort;
        this.addBookPort = addBookPort;
        this.registerBookPort = registerBookPort;
    }


    public int registerBook(Book book) {
        boolean exists = searchBookPort.validateExistsBook(book.getName());
        if (exists) {
            addBookPort.addBook(book.getName());
            return 1;
        } else {
            registerBookPort.registerBook(book);
            return 2;
        }
    }
}
