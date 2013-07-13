package frd.test;

import java.sql.SQLException;
import java.util.Date; 
import frd.db.ProductManager;
import frd.model.Product;

public class TestDBProduct {

	public static void main(String[] args){
		System.out.println("*********** Iniciando TEST DBProduct ***********");
		try{
			//creo la tabla dbProduct
			ProductManager.createDbProductTable();
			System.out.println( "Tabla Producto Creada!" );
			
			//cargo dos producto
			ProductManager.insertProduct(1, "Producto 1", "admin", new Date());
			ProductManager.insertProduct(2, "Producto 2", "admin", new Date());
			System.out.println( "Dos productos creados!" );

			//obtengo los productos de la bd
			System.out.println( "Listando productos:" );
			for( Product usr : ProductManager.getProducts() ){
				System.out.println( usr );
			}

			//modificando producto
			ProductManager.updateProduct(2, "Producto 2 Modif", "admin");
			System.out.println( "Producto 2 modificado!" );
			
			//obtengo los producto de la bd
			System.out.println( "Listando productos:" );
			for( Product usr : ProductManager.getProducts() ){
				System.out.println( usr );
			}

			//borrar producto
			ProductManager.deleteProduct(1);
			System.out.println( "Producto 1 eliminado!" );
			
			//obtengo los producto de la bd
			System.out.println( "Listando producto:" );
			for( Product usr : ProductManager.getProducts() ){
				System.out.println( usr );
			}

		}catch(SQLException ex){
			System.err.println( "ERROR: " + ex.getLocalizedMessage() );
		}
		System.out.println("*********** Fin TEST DBUProducts ***********");
	}
	
}
