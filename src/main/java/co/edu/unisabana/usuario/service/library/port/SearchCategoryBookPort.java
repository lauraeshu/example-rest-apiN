package co.edu.unisabana.usuario.service.library.port;

import co.edu.unisabana.usuario.repository.dao.entity.BookEntity;

import java.util.List;

public interface SearchCategoryBookPort {


    List searchCategoryBook(String bookCategory);
}
