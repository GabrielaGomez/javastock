package frd.db;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import frd.model.User;

public class ProductManager extends JDBCManager {
	public static void createDbProductTable() throws SQLException {
		String createTableSQL = "CREATE TABLE DBPRODUCT("
				+ "PRODUCT_ID NUMERIC(5) NOT NULL, "
				+ "PRODUCTNAME VARCHAR(20) NOT NULL, "
				+ "DESCRIPCION VARCHAR(20) NOT NULL "
				+ "PRIMARY KEY (PRODUCT_ID) "
				+ ")";

		execute( createTableSQL );
	}
	
	public static void insertProduct(int productId, String productname, String creator, Date creation) throws SQLException{
		String insertTableSQL = "INSERT INTO DBPRODUCT"
			+ "(PRODUCT_ID, PRODUCTNAME, CREATED_BY, CREATED_DATE) " + "VALUES"
			+ "("+productId+", '"+productname+"', '"+creator+"', " + "to_date('"
			+ dateFormat.format(creation.getTime()) + "', 'yyyy/mm/dd hh24:mi:ss'))";
		
		executeUpdate( insertTableSQL );
	}
	
	public static void updateProduct(int productId, String productname, String creator, Date creation) throws SQLException{
		String updateTableSQL = "UPDATE DBPRODUCT"
			+ " SET PRODUCTNAME = '"+productname+"' "
			+ " WHERE PRODUCT_ID = "+productId;
		
		execute( updateTableSQL );
	}
	
	public static void deleteProduct(int productId) throws SQLException{
		String deleteTableSQL = "DELETE FROM DBPRODUCT WHERE PRODUCT_ID = "+productId;
		
		execute( deleteTableSQL );
	}
	/*
	public static List<Product> getProducts() throws SQLException{
		List<Product> result = new ArrayList<Product>();
		
		String selectTableSQL = "SELECT * from DBPRODUCT";
		
		for( HashMap<String,Object> register : executeQuery( selectTableSQL ) ){
			//Creo el usuario a partir de los datos obtenidos de la base
			User usr = new User();

			if( register.containsKey("user_id") )
				usr.setId( ((BigDecimal) register.get("user_id")).intValue() );
			
			if( register.containsKey("username") )
				usr.setUsername((String) register.get("username") );
			
			if( register.containsKey("created_by") )
				usr.setCreatedBy((String) register.get("created_by") );
			
			if( register.containsKey("create_date") )
				usr.setCreateDate((Date) register.get("create_date") );

			result.add( usr );
		}
		
		return result;
	}*/
}