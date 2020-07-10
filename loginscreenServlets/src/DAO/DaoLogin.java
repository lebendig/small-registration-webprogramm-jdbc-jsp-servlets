package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.BeanUser;
import connection.SingletonConnection;

public class DaoLogin {
	private Connection connection;
	
	public DaoLogin() {
		
		connection = SingletonConnection.getConnection();
	}
	

	public boolean validateLogin(String login, String password) throws Exception {
		String sql = "Select login, password from public.user where login = '" + login + "' AND password = '" + password+"'";
		PreparedStatement prepared = connection.prepareStatement(sql);
		ResultSet resultSet = prepared.executeQuery();
		
		if (resultSet.next()) {
			return true; //contains user
		} else {
			return false; // dont contains user
		}
		
	}
	
	
	

}
