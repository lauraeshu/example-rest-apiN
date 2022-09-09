package co.edu.unisabana.usuario.service.user.port;

import co.edu.unisabana.usuario.service.library.model.Book;
import co.edu.unisabana.usuario.service.model.User;

public interface RegisterBookLibraryPort {

    boolean addNewBook(Book book);
}

