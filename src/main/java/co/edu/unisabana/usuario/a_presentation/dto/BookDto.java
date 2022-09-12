package co.edu.unisabana.usuario.a_presentation.dto;

import co.edu.unisabana.usuario.c_logic.library.model.Book;
import co.edu.unisabana.usuario.c_logic.library.model.CategoryBook;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookDto {

    private String name;
    private int year;
    private String author;
    private String rated;
    private String category;


    public Book toModel() {
        boolean rRated = rated.equals("Adult");
        return new Book(this.name, this.year, this.author, rRated, CategoryBook.fromString(category));
    }
}
