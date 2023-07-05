package com.app.bookstore.book;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface BookRepository extends JpaRepository<Book, Integer>{
	 List<Book> findByTitle(String title);
	 List<Book> findByTitleContains(String title);
	 
//	 @Query("SELECT b FROM book b JOIN book_author ba ON b.id = ba.bookAuthorPk.bookId JOIN author a ON a.id = ba.bookAuthorPk.authorId WHERE (b.title LIKE %:field% OR a.name LIKE %:field% )")
//	 List<Book> findBookByTitleOrAuthorName(@Param("field") String field);
	 
	 @Query("SELECT b FROM book b JOIN b.authors a WHERE (b.title LIKE %:field% OR a.name LIKE %:field% )")
	 List<Book> findBookByTitleOrAuthorName(@Param("field") String field);
	 
	 @Query("SELECT b FROM book b JOIN b.authors a ORDER BY b.id LIMIT :pageSize OFFSET :pageNumber")
	 List<Book> findAllPaginated(@Param("pageSize") Integer pageSize,@Param("pageNumber") Integer pageNumber);
	 
	 List<Book> findByOrderByIdAsc();
	 
	 @Query("SELECT b FROM book b LEFT JOIN b.authors a  WHERE b.title like %:field% ORDER BY b.id ")
	 List<Book> findAllBooks(Pageable pageable,@Param("field") String field);


}
