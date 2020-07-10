package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.BeanUser;
import connection.SingletonConnection;




public class DaoUser {
	Connection connection;
	
	
	public DaoUser() {
		connection = SingletonConnection.getConnection();
	}
	
	
	public void save(BeanUser user) {
		
		String sql = "INSERT INTO public.user(login, password) VALUES (?,?)";
		try {
			PreparedStatement prepared = connection.prepareStatement(sql);
			
			
			prepared.setString(1, user.getLogin());
			prepared.setString(2, user.getPassword());
			prepared.execute();
			connection.commit();
			
		
		} catch (SQLException e) {
			
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		
		
	}
	
	
	
	
	public List<BeanUser> getUsers(){
		List<BeanUser> listUser = new ArrayList<BeanUser>();
		
		String sql = "Select login, password from public.user";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				BeanUser user = new BeanUser();
				
				user.setLogin(resultSet.getString("login"));
				user.setPassword(resultSet.getString("password"));
				listUser.add(user);
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		return listUser;
		
		
		
	}

}
