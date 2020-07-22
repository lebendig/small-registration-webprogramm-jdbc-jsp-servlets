package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.BeanProduct;
import connection.SingletonConnection;

public class DaoProduct {
	Connection connection;

	public DaoProduct() {

		connection = SingletonConnection.getConnection();

	}

	public void save(BeanProduct product) {
		String sql = "INSERT INTO public.products(name, qty, price) VALUES (?, ?, ?)";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, product.getName());
			statement.setString(2, product.getQty());
			statement.setString(3, product.getPrice());

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

	
	
	
	public boolean hasProduct(String name) {
		String sql = "SELECT count(1) as qtd FROM public.products where name = '" + name + "'";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				
				return resultSet.getInt("qtd") > 0;
			}
	
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}
	
	
	public List<BeanProduct> getProducts(){
		
		 List<BeanProduct> list = new ArrayList();
		 
		String sql = "Select * from public.products";
		try {
		PreparedStatement statement = connection.prepareStatement(sql);
		
		
		ResultSet result = statement.executeQuery();
		while (result.next()) {
			BeanProduct product = new BeanProduct();
			product.setId(result.getLong("id"));
			product.setName(result.getString("name"));
			product.setPrice(result.getString("price"));
			product.setQty(result.getString("qty"));
			
			list.add(product);
			
			
		}
		
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public void delete(String id) {
		
		String sql = "Delete from public.products where id = '" + id + "'";
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
	
	
	
	
	public void update(BeanProduct product) {
		String sql = "UPDATE public.products SET name=?, qty=?, price=? WHERE id = '" + product.getId() + "'";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, product.getName());
			statement.setString(2, product.getQty());
			statement.setString(3, product.getPrice());
			
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
	
	
	public BeanProduct findProductById(String id){
		
		BeanProduct product = new BeanProduct();
		 
		String sql = "Select * from public.products";
		try {
		PreparedStatement statement = connection.prepareStatement(sql);
		
		
		ResultSet result = statement.executeQuery();
		if (result.next()) {

			product.setId(result.getLong("id"));
			product.setName(result.getString("name"));
			product.setPrice(result.getString("price"));
			product.setQty(result.getString("qty"));
			
			
			
		}
		
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return product;
	}
	
	public Long findID(BeanProduct product) {
		Long id = 0L;
		String sql = "SELECT * FROM public.products where name = '" + product.getName() + "'";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				
				id = resultSet.getLong("id");
			}
	
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
		
		
		
	}
		
		
	}

