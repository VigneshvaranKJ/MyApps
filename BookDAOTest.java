package com.chainsys.jdbc;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BookDAOTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddBook()throws Exception {
		BookDAO bookDAO = new BookDAO();
		Book book = new Book();
		book.id = 2;
		book.name ="JAVA";
		book.price=400;
		bookDAO.addBook(book);
		
		Book book1 = new Book();
		book1.id = 1;
		Book b = bookDAO.findById(book1);
		assertEquals(book.id, b.id);
	}

	@Test
	public void testDeleteBook() throws ClassNotFoundException, SQLException {
		BookDAO bookDAO1 = new BookDAO();
		Book booka = new Book();
		booka.id = 2;
		bookDAO1.deleteBook(booka);
		
		Book book2 = new Book();
		book2.id = 2;
		Book b = bookDAO1.findById(booka);
		assertEquals(null, b);
	}

	@Test
	public void testUpdateBook() throws ClassNotFoundException, SQLException{
		BookDAO bookDAO2 = new BookDAO();
		Book bookb = new Book();
		//Book book3 = new Book();
		bookb.id = 1001;
		bookDAO2.findById(bookb);
		bookb.id = 1001;
		bookb.name="CSYS";
		bookDAO2.updateBook(bookb);
		bookDAO2.findById(bookb) ;
		assertEquals(bookb.name,bookDAO2.findById(bookb));
	}

	@Test
	public void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindALL() {
		fail("Not yet implemented");
	}

}
