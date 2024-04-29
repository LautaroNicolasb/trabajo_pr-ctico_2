package ar.edu.unju.fi.ejercicio1.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Producto;


public class Main {
	
	private static ArrayList<Producto>productos;
	private static Scanner scanner;
	
	public static void main(String[] args) {
		int opcion = 0;
		scanner = new Scanner(System.in);
			do {
				System.out.println("----- MENÚ -----");
				System.out.println("1 – Crear producto.");
				System.out.println("2 – Mostrar Productos.");
				System.out.println("3 – Modificar Productoo sólo puede modificar: descripción, precio unitario, origen fabricación categoría).");
				System.out.println("4 – Salir.");
				System.out.println("Elija una opción: ");
				opcion=scanner.nextInt();
				scanner.nextLine();
			
				switch(opcion){
					case 1:
						altaProducto();break;
					case 2:
						mostrarProducto();break;
					case 3:
						//modificarProducto();break;
					case 4:
						System.out.println("FIN DEL PROGRAMA");break;
					default:
						System.out.println("Opción incorrecta. Por favor, ingrese una opción válida.");
				}
				
			}while(opcion!=9);
		
	}
	
	public static void altaProducto() {
		productos  = new ArrayList<>(); 
		int i=1;
		try {
			System.out.println("----- Alta de Producto -----\n");
			System.out.println("Ingrese datos del producto:");
			System.out.println("Código: ");
			String codigo = scanner.nextLine();
			System.out.println("Descripción: ");
			String descripcion = scanner.nextLine();
			System.out.println("Precio unitario: ");
			double precioUnitario = scanner.nextDouble();
		    scanner.nextLine();
			System.out.println("----- Origen de fabricación -----\n");
			for(Producto.OrigenFabricacion origen : Producto.OrigenFabricacion.values()) {
				System.out.println(i+" - "+origen);
				i++;
			}
			System.out.println("Elija una opción: ");
			int opcion = scanner.nextInt();
			System.out.println("\n");
			scanner.nextLine();
			Producto.OrigenFabricacion origen = null;
			while(origen == null){ 
				switch (opcion) {
				case 1:
					origen = Producto.OrigenFabricacion.ARGENTINA;break;
				case 2:
					origen = Producto.OrigenFabricacion.CHINA;break;
				case 3:
					origen = Producto.OrigenFabricacion.BRASIL;break;
				case 4:
					origen = Producto.OrigenFabricacion.URUGUAY;break;
				default:
					System.out.println("Erro. Elija una opción");
				}
				if(origen == null ) {
					System.out.println("Elija una opción: ");
					opcion = scanner.nextInt();
					scanner.nextLine();
				}
			}
			
			
			i=1;
			System.out.println("----- Categoría -----\n");
			for( Producto.Categoria categoria : Producto.Categoria.values() ) {
				System.out.println(i+" - "+categoria);
				i++;
			}
			System.out.println("\n");
			System.out.println("Elija una opción: ");
			opcion = scanner.nextInt();
			scanner.nextLine();
			System.out.println("\n");
			Producto.Categoria categoria = null;
			while(categoria == null) {
				switch (opcion) {
				case 1:
					categoria = Producto.Categoria.TELEFONIA;break;
				case 2:
					categoria = Producto.Categoria.INFORMATICA;break;
				case 3:
					categoria = Producto.Categoria.ELECTROHOGAR;break;
				case 4:
					categoria = Producto.Categoria.HERRAMIENTAS;break;
				default:
					System.out.println("Erro. Elija una opción");
				}
				if(categoria == null ) {
					System.out.println("Elija una opción: ");
					opcion = scanner.nextInt();
					scanner.nextLine();
				}
			}
			
			
			productos.add(new Producto(codigo,descripcion,precioUnitario,origen,categoria));
			System.out.println("Se creo el producto.");
			scanner.nextLine();
		}catch(Exception  e) {
			System.out.println("Se produjo un una excepcion: "+e.getMessage());
		}
	}
		
	public static void mostrarProducto(){
		  try {
			    System.out.println("\n");
				System.out.println("---- Productos ----\n");
				productos.forEach(j->System.out.println(j));
				System.out.println("\n");
		  }catch(NullPointerException e){
			  System.out.println("Error: La lista de productos no ha sido inicializada.");
		  }catch(Exception e) {
			  System.out.println("Error: "+e.getMessage());
		  }
	}
	
	
	
	
	
	
}
