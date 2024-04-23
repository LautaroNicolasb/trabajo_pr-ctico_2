package ar.edu.unju.fi.ejercicio1.main;

import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Producto;


public class Main {
	
	static ArrayList<String>productos;
	static Scanner scanner;
	static Producto producto;
	
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
						//mostrarProductos();break;
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
		int i=1;
			System.out.println("----- Alta de Producto -----\n");
			System.out.println("Ingrese datos del producto:");
			System.out.println("Código: ");
			String codigo = scanner.nextLine();
			System.out.println("Descripción: ");
			String descripcion = scanner.nextLine();
			System.out.println("Precio unitario: ");
			double precioUnitario = scanner.nextDouble();
		    
			System.out.println("----- Categoría -----\n");
			for(Producto.Categoria categoria : Producto.Categoria.values()) {
				System.out.println(i+" - "+categoria);
				i++;
			}
			System.out.println("\n");
			System.out.println("Elija una opcióm: ");
			int opcionOrigen = scanner.nextInt();
			System.out.println("\n");
			i = 1;
			System.out.println("----- Origen de fabricación -----\n");
			for(Producto.OrigenFabricacion origen : Producto.OrigenFabricacion.values()) {
				System.out.println(i+" - "+origen);
				i++;
			}
			System.out.println("Elija una opcióm: ");
			int opcionCategoria = scanner.nextInt();
			System.out.println("\n");
			productos = new ArrayList<>();
			productos.add(new Producto(codigo, descripcion, precioUnitario, opcionOrigen, opcionCategoria));
		
	}


}
