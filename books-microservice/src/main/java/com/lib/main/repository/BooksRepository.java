package com.lib.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lib.main.entity.Books;


public interface BooksRepository extends JpaRepository<Books,Integer>{

}
