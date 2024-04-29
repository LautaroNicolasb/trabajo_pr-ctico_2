package ar.edu.unju.fi.ejercicio2.main;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio2.constantes.Mes;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;

public class Main {
	
	private static ArrayList<Efemeride>efemerides;
	private static Scanner scanner;
	
	public static void main(String[] args) {
		
		int opcion = 0;
		scanner = new Scanner(System.in);
			do {
				System.out.println("----- MENÚ -----");
				System.out.println("1 – Crear efemeéride.");
				System.out.println("2 – Mostrar efeméride.");
				System.out.println("3 – Eliminar efeméride.");
				System.out.println("4 – Modificar efeméride.");
				System.out.println("5 – SALIR.");
				System.out.println("Elija una opción: ");
				opcion=scanner.nextInt();
				scanner.nextLine();
			
				switch(opcion){
					case 1:
						altaEfemeride();break;
					case 2:
						mostrarEfemeride();break;
					case 3:
						eliminarEfemeride();break;
					case 4:
						 //modificarEfemeride();break;
					case 5:
						System.out.println("FIN DEL PROGRAMA");break;
					default:
						System.out.println("Opción incorrecta. Por favor, ingrese una opción válida.");
				}
				
			}while(opcion!=5);
	}
	
	public static void altaEfemeride() {
		try {
			efemerides = new ArrayList<>();
			System.out.println("<<<<<Alta Efemeride>>>>>");
			System.out.println("Código: ");
			String codigo = scanner.nextLine();
			int i=1;
			System.out.println("Ingrese el numero del mes correspondiente:");
			int numMes = scanner.nextInt();
			scanner.nextLine();
			while(numMes < 1 || numMes > 12){
						System.out.println("Mes inválido, ingrese un numero del 1 al 12. ");
						numMes = scanner.nextInt();
						}
					 Mes mes = Mes.values()[numMes - 1];
					 System.out.println("Día:");
				     String dia = scanner.next();
				     System.out.println("Detalle: ");
				     String detalle = scanner.nextLine();
				     scanner.nextLine();
				     efemerides.add(new Efemeride(codigo,mes,dia,detalle));
				     System.out.println("Alta de efemeride correcta\n");
		}catch(InputMismatchException e) {
			System.out.println("Error: Se esperaba un valor numérico.");
		}catch(NoSuchElementException e) {
			System.out.println("Error: No se encontraron más tokens en la entrada.");
		}catch(IllegalStateException e) {
			System.out.println("Error: Problema con el estado del Scanner.");
		}catch(Exception e) {
			System.out.println("Error inesperado: "+e.getMessage());
		}		     
	}
	    
	
	public static void mostrarEfemeride() {
		 try {
			    System.out.println("\n");
				System.out.println("---- Efemerides ----\n");
				efemerides.forEach(j->System.out.println(j));
				System.out.println("\n");
		  }catch(NullPointerException e){
			  System.out.println("Error: La lista de efemerides no ha sido inicializada.");
		  }catch(Exception e) {
			  System.out.println("Error: "+e.getMessage());
		  }
	}
	
	public static void eliminarEfemeride() {
		if (efemerides.isEmpty()) {
			System.out.println("Lista vacía");
		}else {
			System.out.println("Ingrese el código del efeméride a eliminar: ");
			String codigo = scanner.nextLine();
			boolean eliminado = false;
			for(int i = 0; i<efemerides.size(); i++) {
				if (efemerides.get(i).getCodigo().equals(codigo)) {
					efemerides.remove(i);
					eliminado = true;
					System.out.println("Se eliminó el efeméride.");
					break;
				}
			}
		}
	}

}
