package co.edu.unisabana.usuario.service.library.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Book {

    private final String name;
    private final int year;
    private final String author;
    private final boolean rRated;
    private final CategoryBook category;
}
