package web.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import web.DbConnection;

public class UserManager {
	private Connection connect;
	private ResultSet result;
	
	public UserManager() {
	}

	private void initConnection() {
		try {
			this.connect =  DbConnection.initConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void create(User user) throws SQLException {
		initConnection();
		
		PreparedStatement requete = connect.prepareStatement("INSERT INTO users (username, email, password, firstname, lastname, phone, address) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?);");

		requete.setString(1, user.getUsername());
		requete.setString(2, user.getEmail());
		requete.setString(3, user.getPassword());
		requete.setString(4, user.getFirstname());
		requete.setString(5, user.getLastname());
		requete.setString(6, user.getPhone());
		requete.setString(7, user.getAddress());

		requete.executeUpdate();
		connect.close();

	} 

	public User findOne(long id) throws SQLException {
		initConnection();
		
		
		PreparedStatement requete = connect.prepareStatement("SELECT * FROM users WHERE id=?");

		requete.setLong(1, id);
		User user = new User();

		ResultSet result = requete.executeQuery();
		while(result.next()) {
			user.setId(result.getInt("id"));
			user.setUsername(result.getString("username"));
			user.setEmail(result.getString("email"));
			user.setPassword(result.getString("password"));
			user.setFirstname(result.getString("firstname"));
			user.setLastname(result.getString("lastname"));
			user.setPhone(result.getString("phone"));
			user.setAddress(result.getString("address"));
		}
		connect.close();
		return user;
	}

	public ArrayList<User> findAll() throws SQLException {
		initConnection();
		
		ArrayList<User> usersList = new ArrayList<User>();

		PreparedStatement requete = connect.prepareStatement("SELECT * FROM users;");

		result = requete.executeQuery(); 
		while(result.next()) {
			User user = new User();
			user.setId(result.getInt("id"));
			user.setUsername(result.getString("username"));
			user.setEmail(result.getString("email"));
			user.setPassword(result.getString("password"));
			user.setFirstname(result.getString("firstname"));
			user.setLastname(result.getString("lastname"));
			user.setPhone(result.getString("phone"));
			user.setAddress(result.getString("address"));
			
			usersList.add(user);
		}
		connect.close();
		return usersList;
	}

	public void update(User user) throws SQLException {
		initConnection();
		
		PreparedStatement requete = connect.prepareStatement("UPDATE books "
				+ "SET username = ?, email = ?, password = ?, firstname = ?, lastname = ?, phone = ?, address = ? "
				+ "WHERE id = ?;");

		requete.setString(1, user.getUsername());
		requete.setString(2, user.getEmail());
		requete.setString(3, user.getPassword());
		requete.setString(4, user.getFirstname());
		requete.setString(5, user.getLastname());
		requete.setString(6, user.getPhone());
		requete.setString(7, user.getAddress());
		requete.setLong(9, user.getId());


		requete.executeUpdate();
		connect.close();
	}

	public void delete(long id) throws SQLException {
		initConnection();
		
		PreparedStatement requete = connect.prepareStatement("DELETE FROM users WHERE id = ?;");

		requete.setLong(1, id);

		requete.executeUpdate();
		connect.close();
	}
}
