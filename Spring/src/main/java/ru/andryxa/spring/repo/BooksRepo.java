package ru.andryxa.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.andryxa.spring.entity.Books;


@Repository
public interface BooksRepo extends JpaRepository<Books, Integer> {
    Books findById(int id);
}
