package co.edu.unisabana.usuario.d_persistence.dao.userapi;

import co.edu.unisabana.usuario.c_logic.library.model.Book;

public interface RegisterBookLibraryPort {

    boolean addNewBook(Book book);
}

