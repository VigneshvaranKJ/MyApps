package com.chainsys.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class Book {
	public int id;
	public String name;
	public int price;
	public LocalDate published_date;
	

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		// 1.load the class
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 2.Getting the connection
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection connection = DriverManager.getConnection(url, "hr", "hr");
		System.out.println(connection);

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the operation to be done.");
		System.out
				.println(" 1- INSERT  2- UPDATE  3- DELETE  4- SELECT 5- ALL");
		int no = scanner.nextInt();
		switch (no) {
		case 1:
			String sql1 = "insert into book(id,name,price) values(?,?,?)";
			PreparedStatement preparedStatement1 = connection
					.prepareStatement(sql1);
			System.out.println("ENTER THE ID:");
			preparedStatement1.setInt(1, scanner.nextInt());
			System.out.println("ENTER THE NAME:");
			preparedStatement1.setString(2, scanner.next());
			System.out.println("ENTER THE PRICE:");
			preparedStatement1.setInt(3, scanner.nextInt());
			int rows = preparedStatement1.executeUpdate();
			System.out.println("Rows inserted:" + rows);
			break;

		case 2:
			String sql2 = "update book set id=? where id=100";
			PreparedStatement preparedStatement2 = connection
					.prepareStatement(sql2);
			System.out.println("ENTER THE NEW ID:");
			preparedStatement2.setInt(1, scanner.nextInt());
			int rows2 = preparedStatement2.executeUpdate();
			System.out.println("Rows updated:" + rows2);
			break;

		case 3:
			String sql3 = "delete from book where id=?";
			PreparedStatement preparedStatement3 = connection
					.prepareStatement(sql3);
			System.out.println("ENTER THE ID TO BE DELETED:");
			preparedStatement3.setInt(1, scanner.nextInt());
			int rows3 = preparedStatement3.executeUpdate();
			System.out.println("Rows deleted:" + rows3);
			break;

		case 4:
			String sql4 = "select id,name, price from book where id = ?";
			PreparedStatement preparedStatement4 = connection
					.prepareStatement(sql4);
			System.out.println("Enter the book id:");
			preparedStatement4.setString(1, scanner.next());
			ResultSet rset = preparedStatement4.executeQuery();
			if (rset.next()) {

				System.out.println(rset.getInt("id"));
				System.out.println(rset.getString("name"));
				System.out.println(rset.getInt("price"));
				break;
			}

		case 5:
			String sql5 = "select id,name,price from book";
			// System.out.println(sql5);
			PreparedStatement preparedStatement5 = connection
					.prepareStatement(sql5);
			ResultSet rset1 = preparedStatement5.executeQuery();
			while (rset1.next()) {

				System.out.println(rset1.getInt("id"));
				System.out.println(rset1.getString("name"));
				System.out.println(rset1.getInt("price"));

			}
			break;
		case 6:
			String sql6 = "alter table book add DOA date  = ? ";
			PreparedStatement preparedStatement6 = connection.prepareStatement(sql6);
			System.out.println("Enter the date: ");
			String date = scanner.next();
			LocalDate Date = LocalDate.parse(date);
			ResultSet rset2 = preparedStatement6.executeQuery();
			while(rset2.next())
			{
				System.out.println(rset2.getInt("id"));
				System.out.println(rset2.getString("name"));
				System.out.println(rset2.getInt("price"));
				System.out.println(rset2.getDate("Date"));
			}
			
			
			
		}
		
		scanner.close();

	}

}
