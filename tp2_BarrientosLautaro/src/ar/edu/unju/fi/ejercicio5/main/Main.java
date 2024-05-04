package ar.edu.unju.fi.ejercicio5.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio5.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio5.model.PagoTarjeta;

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
	            System.out.println("1 - Mostrar productos");
	            System.out.println("2 - Realizar compra");
	            System.out.println("3 - Salir");
	            System.out.print("Seleccione una opción: ");
	            opcion = scanner.nextInt();
	            switch (opcion) {
                case 1:
                    mostrarProductos(productos);
                    break;
                case 2:
                    realizarCompra(productos);
                    break;
                case 3:
                    System.out.println("Fin del programa.");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
		}while(opcion != 3);
	}
	
	//funcion para precargar la lista
	
	private static ArrayList<Producto> precargarProductos() {
        ArrayList<Producto> productos = new ArrayList<>();

        // Suponiendo que la clase Producto ya está definida con sus atributos y un constructor que inicializa todos los atributos
        for (int i = 0; i < 2; i++) {
    
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
     
	
	private static void mostrarProductos(ArrayList<Producto> productos) {
        System.out.println("Listado de productos disponibles:");
        for (Producto producto : productos) {
            System.out.println(producto);
        }
	}
	
    private static void realizarCompra(ArrayList<Producto> productos) {
            Scanner scanner = new Scanner(System.in);
            ArrayList<Producto> productosSeleccionados = new ArrayList<>();
            double total = 0;
            
            //mostrar productos disponibles
            mostrarProductos(productos);
            
            //selecionar productos para comprar
            System.out.print("Ingrese el número de producto que desea comprar (0 para finalizar): ");
            int numeroProducto;
            do {
                numeroProducto = scanner.nextInt();
                if (numeroProducto > 0 && numeroProducto <= productos.size()) {
                    Producto producto = productos.get(numeroProducto - 1);
                    if (producto.getDisponible()) {
                        productosSeleccionados.add(producto);
                        total += producto.getPrecioUnitario();
                        producto.setDisponible(false); // Marcar como no disponible
                        System.out.println("Producto agregado al carrito.");
                        producto.setDisponible(false);
                    } else {
                        System.out.println("Este producto no está disponible.");
                    }
                } else if (numeroProducto != 0) {
                    System.out.println("Número de producto inválido.");
                }
            } while (numeroProducto != 0);
            
            // mostrar opciones de pago
            
            System.out.println("Total a pagar: " + total);
            System.out.println("Seleccione una opción de pago:");
            System.out.println("1 - Pago efectivo");
            System.out.println("2 - Pago con tarjeta");
            int opcionPago = scanner.nextInt();
            
            //realizar el pago 
     
            switch (opcionPago) {
	            case 1:
	                PagoEfectivo pagoEfectivo = new PagoEfectivo(total, LocalDate.now());
	                pagoEfectivo.realizarPago(total);
	                pagoEfectivo.imprimirRecibo();
	                break;
	            case 2:
	                scanner.nextLine(); // Consumir el salto de línea pendiente
	                System.out.print("Ingrese el número de tarjeta: ");
	                String numeroTarjeta = scanner.nextLine();
	                String fechaPagoStr = scanner.nextLine();
	                System.out.println(fechaPagoStr);
	                LocalDate fechaPago = LocalDate.now();
	                PagoTarjeta pagoTarjeta = new PagoTarjeta(numeroTarjeta, fechaPago, total);
	                pagoTarjeta.realizarPago(total);
	                pagoTarjeta.imprimirRecibo();
	                break;
	            default:
	                System.out.println("Opción de pago inválida.");
	                break;
            }
            
    }
    
    
    
        
}
