package com.app.bookstore.exemplary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExemplaryRepository extends JpaRepository<Exemplary, Integer>{
	
//	@Query("SELECT e FROM exemplary e JOIN e.book b ON b.id = :bookId ")
//	List<Exemplary> findExemplariesByBookId(@Param("bookId") Integer bookId);
	
	
	List<Exemplary> findByBookId(Integer bookId);

}
