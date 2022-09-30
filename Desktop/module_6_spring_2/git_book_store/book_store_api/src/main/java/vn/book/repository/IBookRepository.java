package vn.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.book.model.Book;

public interface IBookRepository extends JpaRepository<Book, Integer> {
}
