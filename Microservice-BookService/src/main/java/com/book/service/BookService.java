package com.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.book.dao.BookRepository;
import com.book.entity.Book;
import com.book.exceptions.BookNotFoundException;
import com.book.exceptions.BookOutofStockException;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	// To add book
	public void addBook(Book book) {
		bookRepository.save(book);
	}

	// To get All books
	public List<Book> getBooks() {

		List<Book> list = bookRepository.findAll();
		return list;
	}

	// To book by using Id
	public Book getBookById(String id) {
		Book book;
		book = bookRepository.findById(id)
				.orElseThrow(() -> new BookNotFoundException("No book  found with the Id: " + id));

		return book;
	}

	// To update book quantity
	public Book updateBookQuantity(String id) {
		Book book;
		book = bookRepository.findById(id)
				.orElseThrow(() -> new BookNotFoundException("No book found with the Id: " + id));
		return book;
	}

	// To delete book
	public void deleteBook(@PathVariable("bookId") String bookId) {
		try {
			bookRepository.deleteById(bookId);
		} catch (Exception e) {
			throw new BookNotFoundException("No book found with the Id: " + bookId);
		}

	}
	
	
	public String cartQuantity(String bookId, int quantity) {
		Book book;
		book = bookRepository.findById(bookId)
				.orElseThrow(() -> new BookNotFoundException("No book found with the Id: " + bookId));

		int quantityOFBook = book.getQuantity();
		int updateQuantity = quantityOFBook - quantity;
		if (quantityOFBook <= 0 || updateQuantity < 0) {
			return "Book is out of stock";
		}
		return "Done";
	}

	// To manage quantity
	public String quantityManager(String bookId, int quantity) {
		Book book;
		book = bookRepository.findById(bookId)
				.orElseThrow(() -> new BookNotFoundException("No book found with the Id: " + bookId));

		int quantityOFBook = book.getQuantity();
		int updateQuantity = quantityOFBook - quantity;
		if (quantityOFBook <= 0 || updateQuantity < 0) {
			throw new BookOutofStockException("Book is out of stock");
		}

		bookRepository.updateData(updateQuantity + "", bookId);
		return "null";
	}
}
