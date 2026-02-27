package com.test.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.BookDao;
import com.test.entity.Book;
import com.test.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private  BookDao bookDao;
	
	@Override
	public Book saveBook(Book book) {
		// TODO Auto-generated method stub
		return bookDao.saveBook(book);
	}

	@Override
	public Book updateBook(Book book) {
		// TODO Auto-generated method stub
		return bookDao.updateBook(book);
	}

	@Override
	public Optional<Book> getBookById(int id) {
		// TODO Auto-generated method stub
		return bookDao.getBookById(id);
	}

	@Override
	public List<Book> deleteBookById(int id) {
		// TODO Auto-generated method stub
		return bookDao.deleteBookById(id);
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookDao.getAllBooks();
	}

}
