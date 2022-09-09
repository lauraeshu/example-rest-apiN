package co.edu.unisabana.usuario.service;

import co.edu.unisabana.usuario.service.library.RegisterBookLibrary;
import co.edu.unisabana.usuario.service.library.model.Book;
import co.edu.unisabana.usuario.service.library.model.CategoryBook;
import co.edu.unisabana.usuario.service.library.port.AddBookPort;
import co.edu.unisabana.usuario.service.library.port.SearchBookPort;
import co.edu.unisabana.usuario.service.user.RegisterUserService;
import co.edu.unisabana.usuario.service.user.port.RegisterBookLibraryPort;
import co.edu.unisabana.usuario.service.user.port.RegisterUserPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)

public class RegisterBookLibraryTest{

    @InjectMocks
    private RegisterBookLibrary service;

    @Mock
    private RegisterBookLibraryPort registerBookLibraryPort;
    @Mock
    private SearchBookPort searchBookPort;
    @Mock
    private AddBookPort addBookPort;

    @Test
    public void Given_Book_Exist_When_RegisterBookLibrary_Then_Return_1(){
        CategoryBook categoryBook = CategoryBook.fromString("suave");
        Book book = new Book("100 años de soledad",1968,
                "Gabriel Garcia Marquez",false,categoryBook);

        Mockito.when(searchBookPort.validateExistsBook(book.getName())).thenReturn(true);
        int result = service.registerBook(book);
        assertEquals(1,result);

    }
    @Test
    public void Given_Book_Does_Not_Exist_When_RegisterBookLibrary_Then_Return_2() {


    }



}
