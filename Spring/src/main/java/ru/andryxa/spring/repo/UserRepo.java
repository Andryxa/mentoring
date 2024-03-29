package ru.andryxa.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.andryxa.spring.entity.User;


@Repository
public interface UserRepo extends JpaRepository<User, Integer> { }
