package ru.andryxa.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.andryxa.spring.entity.Book;


@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {
    Book findById(int id);
}
