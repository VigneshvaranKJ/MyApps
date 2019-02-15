package com.chainsys.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class BookDAO {
	/*
	 * precondition id, name and price should be a valid data
	 */

	ResultSet resultSet = null;

	public void addBook(Book book) throws Exception {
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "insert into book(id,name,price) values(?,?,?)";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setInt(1, book.id);
			preparedStatement.setString(2, book.name);
			preparedStatement.setInt(3, book.price);
			int rows = preparedStatement.executeUpdate();
			System.out.println("Rows inserted:" + rows);
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// throw new Exception("Unable to insert book");
		}
	}

	public void deleteBook(Book book) throws SQLException, ClassNotFoundException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "delete from book where id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, book.id);
		int rows = preparedStatement.executeUpdate();
		System.out.println("Rows deleted:" + rows);
		ConnectionUtil.close(connection, preparedStatement, resultSet);
	}

	public void updateBook(Book book) throws SQLException,
			ClassNotFoundException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "update book set name=? where id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		System.out.println("ENTER THE NAME TO BE UPDATED:");
		preparedStatement.setString(1, book.name);
		System.out.println("Enter the id:");
		preparedStatement.setInt(2, book.id);
		int rows = preparedStatement.executeUpdate();
		System.out.println("Rows updated:" + rows);
		ConnectionUtil.close(connection, preparedStatement, resultSet);
	}

	public Book findById(Book book) throws SQLException, ClassNotFoundException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select id,name,price from book where id =?";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, book.id);
		ResultSet rset1 = preparedStatement.executeQuery();
		Book b = null;
		if (rset1.next()) {
			b = new Book();
			b.id = resultSet.getInt("id");
			b.name = resultSet.getString("name");
			b.price = resultSet.getInt("price");

			// System.out.println(rset1.getInt("id"));
			// System.out.println(rset1.getString("name"));
			// System.out.println(rset1.getInt("price"));

		}
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		return b;
	}

	public ArrayList<Book> findALL() throws SQLException,
			ClassNotFoundException {

		String sql = "select id,name,price from book";
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet rset1 = preparedStatement.executeQuery();
		ArrayList<Book> list = new ArrayList<Book>();
		while (rset1.next()) {
			Book b = new Book();
			b.id = resultSet.getInt("id");
			b.name = resultSet.getString("name");
			b.price = resultSet.getInt("price");
			list.add(b);
			// System.out.println(rset1.getInt("id") + " "
			// + rset1.getString("name") + " " + rset1.getInt("price"));

		}
		ConnectionUtil.close(connection, preparedStatement, resultSet);
		return list;
	
}}
