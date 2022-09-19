package co.edu.unisabana.usuario.controller;

import co.edu.unisabana.usuario.AbstractTest;
import co.edu.unisabana.usuario.a_presentation.dto.BookDto;
import co.edu.unisabana.usuario.a_presentation.dto.BookReponse;
import co.edu.unisabana.usuario.a_presentation.dto.UserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookControllerTest extends AbstractTest {
    private static final String PATH_REGISTER_BOOK = "/book/register";

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void Given_not_exists_previusly_When_call_register_book_then_registerbook() {
        BookDto dto = new BookDto("La isla del tesoro", 1950, "Robert", "Comercial", "suave");

        ResponseEntity<BookReponse> bookReponseResponseEntity =
                restTemplate.postForEntity(PATH_REGISTER_BOOK, dto, BookReponse.class);
        assertEquals("Nuevo libro registrado", bookReponseResponseEntity.getBody().getData());
    }

    @Test
    public void Given_register_previusly_When_call_register_book_then_updateBooks() {
        BookDto dto = new BookDto("La isla del tesoro", 1950, "Robert", "Comercial", "suave");
        restTemplate.postForEntity(PATH_REGISTER_BOOK, dto, BookReponse.class);

        ResponseEntity<BookReponse> otroRegistro =
                restTemplate.postForEntity(PATH_REGISTER_BOOK, dto, BookReponse.class);
        assertEquals("Actualizada cantidad", otroRegistro.getBody().getData());
    }
}
