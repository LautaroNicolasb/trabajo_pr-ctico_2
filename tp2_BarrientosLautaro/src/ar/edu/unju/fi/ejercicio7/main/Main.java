package ar.edu.unju.fi.ejercicio7.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio1.model.Producto;

public class Main {
		
		public static Scanner scanner = new Scanner(System.in);
		
		public static void main(String[] args) {
			//precargar productos 
			ArrayList<Producto> productos = precargarProductos();
			//menú de opciones 
			Scanner  scanner = new Scanner(System.in);
			
			int opcion;
			do {
				    System.out.println("Menú de opciones:");
		            System.out.println("1 - Mostrar productos disponibles");
		            System.out.println("2 - Mostrar productos no disponibles");
		            System.out.println("3 - Incrementar precios en un 20%");
		            System.out.println("4 - Mostrar productos de categoría Electrohogar disponibles");
		            System.out.println("5 - Ordenar productos por precio descendente");
		            System.out.println("6 - Mostrar nombres de productos en mayúsculas");
		            System.out.println("7 - Salir");
		            System.out.print("Seleccione una opción: ");
		            opcion = scanner.nextInt();
		            switch (opcion) {
		            case 1:
	                    mostrarProductosDisponibles(productos);
	                    break;
	                case 2:
	                   // mostrarProductosNoDisponibles(productos);
	                    break;
	                case 3:
	                    //productos = incrementarPrecios(productos);
	                    break;
	                case 4:
	                    //mostrarProductosElectrohogarDisponibles(productos);
	                    break;
	                case 5:
	                    //ordenarProductosPorPrecioDescendente(productos);
	                    break;
	                case 6:
	                    //mostrarNombresEnMayusculas(productos);
	                    break;
	                default:
	                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
	            }
			}while(opcion != 7);
		}
		
		//funcion para precargar la lista
		
		private static ArrayList<Producto> precargarProductos() {
	        ArrayList<Producto> productos = new ArrayList<>();

	        // Suponiendo que la clase Producto ya está definida con sus atributos y un constructor que inicializa todos los atributos
	        for (int i = 0; i < 15; i++) {
	    
	    		try {
	    			System.out.println("----- Precarga de Producto -----\n");
	    			System.out.println("Ingrese datos del producto:");
	    			System.out.println("Código: ");
	    			String codigo = scanner.nextLine();
	    			System.out.println("Descripción: ");
	    			String descripcion = scanner.nextLine();
	    			System.out.println("Precio unitario: ");
	    			double precioUnitario = scanner.nextDouble();
	    		    scanner.nextLine();
	    			System.out.println("----- Origen de fabricación -----\n");
	    			int j=1;
	    			for(Producto.OrigenFabricacion origen : Producto.OrigenFabricacion.values()) {
	    				System.out.println(j+" - "+origen);
	    				j++;
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
	    			
	    			
	    			j=1;
	    			System.out.println("----- Categoría -----\n");
	    			for( Producto.Categoria categoria : Producto.Categoria.values() ) {
	    				System.out.println(j+" - "+categoria);
	    				j++;
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
	    			
	    			Boolean disponible = true;
	    			Producto producto = new Producto(codigo,descripcion,precioUnitario,origen,categoria, disponible);
	    			producto.setDisponible(true);
	    			productos.add(producto);
	    			System.out.println("Se creo el producto.");
	    			scanner.nextLine();
	    		}catch(Exception  e) {
	    			System.out.println("Se produjo un una excepcion: "+e.getMessage());
	    		}
	    		
	    	}
	    		return productos;
		}
	   
		
		private static void mostrarProductosDisponibles(List<Producto> productos) {
	        Consumer<Producto> consumer = System.out::println;
	        productos.stream()
	        		.filter(p ->p.getDisponible())
	                .forEach(consumer);
	    }
		
		private static void mostrarProductosNoDisponibles(List<Producto> productos) {
	        Predicate<Producto> predicate = producto -> !producto.getDisponible();
	        productos.stream()
	                .filter(predicate)
	                .forEach(System.out::println);
	    }
		
		private static List<Producto> incrementarPrecios(List<Producto> productos) {
	        Function<Producto, Producto> function = producto -> {
	            producto.setPrecioUnitario(producto.getPrecioUnitario() * 1.2);
	            return producto;
	        };
	        return productos.stream()
	                .map(function)
	                .collect(Collectors.toList());
	    }
		
		 private static void mostrarProductosElectrohogarDisponibles(List<Producto> productos) {
		        Predicate<Producto> predicate = producto ->
		                producto.getCategoria().equals("Electrohogar") && producto.getDisponible();
		        productos.stream()
		                .filter(predicate)
		                .forEach(System.out::println);
		    }
		 
		 private static void ordenarProductosPorPrecioDescendente(List<Producto> productos) {
		        Comparator<Producto> comparator = Comparator.comparing(Producto::getPrecioUnitario).reversed();
		        productos.sort(comparator);
		        productos.forEach(System.out::println);
		    }
		 
		 private static void mostrarNombresEnMayusculas(List<Producto> productos) {
		        Function<Producto, Producto> function = producto -> {
		            producto.setDescripcion(producto.getDescripcion().toUpperCase());
		            return producto;
		        };
		        productos.stream()
		                .map(function)
		                .forEach(System.out::println);
		    }
		

}
