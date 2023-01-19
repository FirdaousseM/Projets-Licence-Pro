package web.book;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

import web.DbConnection;


public class BookManager{

	private Connection connect;
	private ResultSet result;
	
	public BookManager() {
	}

	private void initConnection() {
		try {
			this.connect =  DbConnection.initConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void create(Book book) throws SQLException {
		initConnection();
		
		PreparedStatement requete = connect.prepareStatement("INSERT INTO books (title, author, synopsys, price, rating, genre, cover, editor) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?);");

		requete.setString(1, book.getTitle());
		requete.setString(2, book.getAuthor());
		requete.setString(3, book.getSynopsys());
		requete.setBigDecimal(4, BigDecimal.valueOf(book.getPrice()));
		requete.setInt(5, book.getRating());
		requete.setString(6, book.getGenre());
		requete.setString(7, book.getCover());
		requete.setString(8, book.getEditor());

		requete.executeUpdate();
		connect.close();

	} 

	public Book findOne(long id) throws SQLException {
		initConnection();
		
		
		PreparedStatement requete = connect.prepareStatement("SELECT * FROM books WHERE id=?");

		requete.setLong(1, id);
		Book book = new Book();

		ResultSet result = requete.executeQuery();
		while(result.next()) {
			book.setId(result.getInt("id"));
			book.setTitle(result.getString("title"));
			book.setAuthor(result.getString("author"));
			book.setSynopsys(result.getString("synopsys"));
			book.setPrice(result.getDouble("price"));
			book.setRating(result.getInt("rating"));
			book.setGenre(result.getString("genre"));
			book.setCover(result.getString("cover"));
			book.setEditor(result.getString("editor"));
		}
		connect.close();
		return book;
	}

	public ArrayList<Book> findAll() throws SQLException {
		initConnection();
		
		ArrayList<Book> booksList = new ArrayList<Book>();

		PreparedStatement requete = connect.prepareStatement("SELECT * FROM books;");

		result = requete.executeQuery(); 
		while(result.next()) {
			Book book = new Book();
			book.setId(result.getInt("id"));
			book.setTitle(result.getString("title"));
			book.setAuthor(result.getString("author"));
			book.setSynopsys(result.getString("synopsys"));
			book.setPrice(result.getDouble("price"));
			book.setRating(result.getInt("rating"));
			book.setGenre(result.getString("genre"));
			book.setCover(result.getString("cover"));
			book.setEditor(result.getString("editor"));
			
			booksList.add(book);
		}
		connect.close();
		return booksList;
	}

	public void update(Book book) throws SQLException {
		initConnection();
		
		PreparedStatement requete = connect.prepareStatement("UPDATE books "
				+ "SET title = ?, author = ?, synopsys = ?, price = ?, rating = ?, genre = ?, cover = ?, editor = ? "
				+ "WHERE id = ?;");

		requete.setString(1, book.getTitle());
		requete.setString(2, book.getAuthor());
		requete.setString(3, book.getSynopsys());
		requete.setBigDecimal(4, BigDecimal.valueOf(book.getPrice()));
		requete.setInt(5, book.getRating());
		requete.setString(6, book.getGenre());
		requete.setString(7, book.getCover());
		requete.setString(8, book.getEditor());
		requete.setLong(9, book.getId());


		requete.executeUpdate();
		connect.close();
	}

	public void delete(long id) throws SQLException {
		initConnection();
		
		PreparedStatement requete = connect.prepareStatement("DELETE FROM books WHERE id = ?;");

		requete.setLong(1, id);

		requete.executeUpdate();
		connect.close();
	}

}

