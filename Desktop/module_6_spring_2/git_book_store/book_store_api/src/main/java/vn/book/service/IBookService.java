package vn.book.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.book.model.Book;

import java.util.Optional;

public interface IBookService {

    Page<Book> findAllBook(Pageable pageable);

    Optional<Book> findById(int id);
}
