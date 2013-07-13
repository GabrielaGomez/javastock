package frd.db;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import frd.model.Product;

public class ProductManager extends JDBCManager {
	public static void createDbProductTable() throws SQLException {
		String createTableSQL = "CREATE TABLE DBPRODUCT("
				+ "PRODUCT_ID NUMERIC(5) NOT NULL, "
				+ "PRODUCTNAME VARCHAR(20) NOT NULL, "
				+ "DESCRIPTION VARCHAR(20) NOT NULL "
				+ "PRIMARY KEY (PRODUCT_ID) "
				+ ")";

		execute( createTableSQL );
	}
	
	public static void insertProduct(int productId, String productname, String description, Date creation) throws SQLException{
		String insertTableSQL = "INSERT INTO DBPRODUCT"
			+ "(PRODUCT_ID, PRODUCTNAME, DESCRIPTION) " + "VALUES"
			+ "("+productId+", '"+productname+"', '"+description+"', " + "to_date('"
			+ dateFormat.format(creation.getTime()) + "', 'yyyy/mm/dd hh24:mi:ss'))";
		
		executeUpdate( insertTableSQL );
	}
	
	public static void updateProduct(int productId, String productname, String description) throws SQLException{
		String updateTableSQL = "UPDATE DBPRODUCT"
			+ " SET PRODUCTNAME = '"+productname+"' "
			+ " WHERE PRODUCT_ID = "+productId;
		
		execute( updateTableSQL );
	}
	
	public static void deleteProduct(int productId) throws SQLException{
		String deleteTableSQL = "DELETE FROM DBPRODUCT WHERE PRODUCT_ID = "+productId;
		
		execute( deleteTableSQL );
	}
	
	public static List<Product> getProducts() throws SQLException{
		List<Product> result = new ArrayList<Product>();
		
		String selectTableSQL = "SELECT * from DBPRODUCT";
		
		for( HashMap<String,Object> register : executeQuery( selectTableSQL ) ){
			//Creo el producto a partir de los datos obtenidos de la base
			Product usr = new Product();

			if( register.containsKey("product_id") )
				usr.setId( ((BigDecimal) register.get("product_id")).intValue() );
			
			if( register.containsKey("productname") )
				usr.setName((String) register.get("productname") );
			
			if( register.containsKey("description") )
				usr.setDescription((String) register.get("description") );
			
			result.add( usr );
		}
		
		return result;
	}
}