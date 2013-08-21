package frd.app;

import java.util.Scanner;

import frd.app.ui.MainWindow;

public class Main {
	private static Scanner scanIn = new Scanner(System.in);

	public static void main(String[] args){
		// Inicio la interfaz de escritorio
		(new MainWindow()).setVisible(true);

		/*
		 * Interfaz de usuario por consola
		 * 
		System.out.println("*********** Iniciando ***********");
		System.out.println("q:salir, u:listar usuarios, u-add:agregar usuario, u-del:borrar usuario");
		
		String response = scanIn.nextLine();
		while( !"q".equalsIgnoreCase(response) ){

			if( "u".equalsIgnoreCase(response) ){
				UserUI.showAll();
			}
			
			if( "u-add".equalsIgnoreCase(response) ){
				UserUI.add( scanIn );
			}
			
			if( "u-del".equalsIgnoreCase(response) ){
				UserUI.del( scanIn );
			}
			
			System.out.println(">");
			response = scanIn.nextLine();
		}
		
        System.out.println("*********** Fin de app ***********");
        */
	}
}
