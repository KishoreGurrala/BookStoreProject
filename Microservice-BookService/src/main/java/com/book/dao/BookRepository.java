package com.book.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.book.entity.Book;

public interface BookRepository extends JpaRepository<Book, String>{
	
	@Transactional
    @Modifying
    @Query(value = "UPDATE Books SET QUANTITY = :value WHERE BOOK_ID = :condition", nativeQuery = true)
    void updateData(@Param("value") String value, @Param("condition") String condition);

}
