package org.gb.springbootlesson3.repository;

import org.gb.springbootlesson3.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaBookRepository extends JpaRepository<Book,Long>{
    Book findByName(String name);
}
