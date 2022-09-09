package co.edu.unisabana.usuario.service;

import co.edu.unisabana.usuario.repository.dao.BookDao;
import co.edu.unisabana.usuario.service.library.RegisterBookLibrary;
import co.edu.unisabana.usuario.service.library.model.Book;
import co.edu.unisabana.usuario.service.library.model.CategoryBook;
import co.edu.unisabana.usuario.service.library.port.AddBookPort;
import co.edu.unisabana.usuario.service.library.port.RegisterBookPort;
import co.edu.unisabana.usuario.service.library.port.SearchBookPort;
import co.edu.unisabana.usuario.service.model.User;
import co.edu.unisabana.usuario.service.user.port.RegisterUserPort;
import co.edu.unisabana.usuario.service.user.RegisterUserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class RegisterBookLibraryTest {

    @InjectMocks
    private RegisterBookLibrary service;
    @Mock
    private SearchBookPort searchBookPort;
    @Mock
    private AddBookPort addBookPort;
    @Mock
    private RegisterBookPort registerBookPort;

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
        Book book = new Book("", 1001, "Yo", false, null);
        Mockito.when(searchBookPort.validateExistsBook("")).thenReturn(false);
        //La unica que encontre fue decirle que valide el livro con un string vacio
        int result = service.registerBook(book);

        assertEquals(2, result);

        /*

        //Esto no cuenta y estoy cansado

        System.out.println(book.getName() + " <---- AQUI");

        int result;

        if (book.getName() == "" || book.getName() == null) {
            result = 2;
        } else {
            result = 1;
        }

        assertEquals(2,result);

         */

    }
}