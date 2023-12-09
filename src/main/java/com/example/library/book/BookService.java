package com.example.library.book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Optional<Book> findOne(Long id);

    Book save(Book book);

}