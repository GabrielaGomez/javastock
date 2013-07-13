package frd.app;

import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

import frd.db.ProductManager;
import frd.model.Product;
import frd.model.User;

public class ProdUI {

	public static void showAll() {
		System.out.println( "=================================" );
		System.err.println( " ID | NAME | CREATOR | DATE" );
/*		try {
			for( Product u : ProductManager.getProduct() ){
				System.out.println( u.getId() + " | " + u.getName() + " | " + u.getDescription() );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
*/		System.out.println( "=================================" );
	}
	
	public static void add(Scanner scanIn) {
		System.out.println( "=>AGREGAR PRODUCTO" );
		System.out.println( ">Ingrese el ID:" );
		String id = scanIn.nextLine();
		System.out.println( ">Ingrese el NOMBRE:" );
		String name = scanIn.nextLine();
		System.out.println( ">Ingrese la DESCRIPCION:" );
		String description = scanIn.nextLine();
		try {
			ProductManager.insertProduct( Integer.parseInt(id), name, "admin", new Date() );
		} catch (NumberFormatException e) {
			System.err.println("El ID ingresado es incorrecto!");
		} catch (SQLException e) {
			System.err.println("Error al guardar los datos en la base.");
		}
		System.out.println( "=================================" );
	}

	public static void del(Scanner scanIn) {
		System.out.println( "=>BORRAR PRODUCTO" );
		System.out.println( ">Ingrese el ID:" );
		String id = scanIn.nextLine();
		try {
			ProductManager.deleteProduct( Integer.parseInt(id) );
		} catch (NumberFormatException e) {
			System.err.println("El ID ingresado es incorrecto!");
		} catch (SQLException e) {
			System.err.println("Error al eliminar el producto en la base.");
		}
		System.out.println( "=================================" );
	}

	
}
