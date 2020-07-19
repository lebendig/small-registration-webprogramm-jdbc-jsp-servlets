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
		
		String sql = "INSERT INTO public.user(login, password, name) VALUES (?,?,?)";
		try {
			PreparedStatement prepared = connection.prepareStatement(sql);
			
			
			prepared.setString(1, user.getLogin());
			prepared.setString(2, user.getPassword());
			prepared.setString(3, user.getName());
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
	
	
	public boolean hasUser(String login) {
		
		BeanUser user = new BeanUser();
		try {
		String sql = " Select count(1) as qtd from public.user WHERE login = '" + login + "'";
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet resultSet = statement.executeQuery();
				
				if (resultSet.next()) {
					
				
			return resultSet.getInt("qtd") > 0 ; //TRUE
				}
				
				
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return false;
	
	}
	
	public List<BeanUser> getUsers(){
		List<BeanUser> listUser = new ArrayList<BeanUser>();
		
		String sql = "Select * from public.user";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				BeanUser user = new BeanUser();
				
				user.setId(resultSet.getLong("id"));	
				user.setLogin(resultSet.getString("login"));
				user.setName(resultSet.getString("name"));
				listUser.add(user);
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		return listUser;
		
		
		
	}
	
	
	public void delete(String id) {
		String sql = "DELETE FROM public.user where login = '" + id + "'";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.execute();
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
	
	
	public BeanUser getUser(String id) {
		BeanUser user = new BeanUser();
		try {
		String sql = " Select * from public.user WHERE id = '" + id + "'";
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet resultSet = statement.executeQuery();
				
				if (resultSet.next()) {
					
					
				user.setId( resultSet.getLong("id"));	
				user.setLogin(resultSet.getString("login"));	
				user.setPassword(resultSet.getString("password"));
				user.setName(resultSet.getString("name"));
				return user;
				}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
return user;
	}
	
	
	public void update(BeanUser user) {
		String sql = "UPDATE public.user SET login= ?, password = ?, name=? WHERE id = '" + user.getId() +"'";
		try {
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, user.getLogin());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getName());

			statement.executeUpdate();
			
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

}
