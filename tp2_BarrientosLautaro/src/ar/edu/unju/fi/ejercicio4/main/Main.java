package ar.edu.unju.fi.ejercicio4.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;

public class Main {
	private static ArrayList<Jugador> jugadores;
    private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		
		int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    altaJugador();
                    break;
                case 2:
                    mostrarJugadores();
                    break;
                case 3:
                    modificarPosicion();
                    break; 
                case 4:
                   eliminarJugador();
                    break;
                case 5:
                    System.out.println("FIN DEL PROGRAMA");
                    break;
                default:
                    System.out.println("Opción inválida. Elija una opción válida.");
            }
        } while (opcion != 5);
    }

    private static void mostrarMenu() {
        System.out.println("Menú de opciones:");
        System.out.println("1 - Alta de jugador");
        System.out.println("2 - Mostrar todos los jugadores");
        System.out.println("3 - Modificar la posición de un jugador");
        System.out.println("4 - Eliminar un jugador");
        System.out.println("5 - Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void altaJugador() {
    	jugadores = new ArrayList<>();
    	// Solicitar datos del jugador
        System.out.println("\nAlta de Jugador:");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Fecha de Nacimiento (yyyy-mm-dd): ");
        LocalDate fechaNacimiento = LocalDate.parse(scanner.nextLine());
        System.out.print("Nacionalidad: ");
        String nacionalidad = scanner.nextLine();
        System.out.print("Estatura (en metros): ");
        double estatura = scanner.nextDouble();
        System.out.print("Peso (en kg): ");
        double peso = scanner.nextDouble();
        scanner.nextLine(); 
        // Seleccionar posición
        int i=1;
        for(Posicion posicion : Posicion.values()){
			System.out.println(i+" - "+posicion);
			i++;
		}
        System.out.print("Seleccione la posición del jugador: ");
        int posicionIndex = scanner.nextInt();
        Posicion posicion = Posicion.values()[posicionIndex - 1];
        scanner.nextLine(); 
        // Crear jugador y agregarlo a la lista
        jugadores.add(new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, estatura, peso, posicion));
        System.out.println("¡Jugador agregado correctamente!\n");
    }
	
    
    
    private static void mostrarJugadores() {
        if (jugadores.isEmpty()) {
            System.out.println("\nNo hay jugadores registrados.");
        } else {
            System.out.println("\nJugadores registrados:");
            for (Jugador jugador : jugadores) {
                System.out.println(jugador);
            }
        }
    }
    
    
    		
    private static void modificarPosicion() {
    	try {
    	    if (jugadores.isEmpty()) {
    	        System.out.println("\nNo hay jugadores registrados.");
    	    } else {
    	        System.out.println("\nModificar la posición de un jugador:");
    	        System.out.print("Ingrese el nombre del jugador: ");
    	        String nombre = scanner.nextLine(); // Tomar el nombre del jugador
    	        System.out.print("Ingrese el apellido del jugador: ");
    	        String apellido = scanner.nextLine();
    	        // Buscar al jugador por nombre y apellido
    	        boolean encontrado = false;
    	        for (Jugador jugador : jugadores) {
    	            if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
    	            	System.out.println("*****Ingrese los nuevos datos del jugador*****");
    	            	System.out.print("Fecha de Nacimiento (yyyy-mm-dd): ");
    	                LocalDate fechaNacimiento = LocalDate.parse(scanner.nextLine());
						System.out.println("Nacionalidad: ");
						String nacionalidad = scanner.nextLine();
						jugador.setNacionalidad(nacionalidad);
						System.out.println("Estatura: ");
						double estatura = scanner.nextDouble();
						jugador.setEstatura(estatura);
						System.out.println("Peso: ");
						double peso = scanner.nextDouble();
						jugador.setPeso(peso);
						System.out.println("Posición: ");
    	            	// Mostrar posiciones disponibles
    	                System.out.println("Posiciones:");
    	                for (Posicion posicion : Posicion.values()) {
    	                    System.out.println((posicion.ordinal() + 1) + " - " + posicion);
    	                }
    	                System.out.print("Seleccione la nueva posición del jugador: ");
    	                int posicionIndex = scanner.nextInt();
    	                Posicion nuevaPosicion = Posicion.values()[posicionIndex - 1];
    	                scanner.nextLine(); 
    	                // Modificar la posición del jugador
    	                jugador.setPosicion(nuevaPosicion);
    	                System.out.println("Los cambios se realizaron de manera correcta.");
    	                encontrado = true;
    	                break;
    	            }
    	        }
    	        if (!encontrado) {
    	            System.out.println("Jugador no encontrado.");
    	        }
    	    }  
    	    }catch(InputMismatchException e) {
				System.out.println("Error: Se esparaba un valor numérico para estatura o peso."); 
			}catch(Exception e) {
				System.out.println("Error inespaerado: "+e.getMessage());
			}
    	}
    	
    private static void eliminarJugador() {
        if (jugadores.isEmpty()) {
            System.out.println("\nNo hay jugadores registrados.");
        } else {
            System.out.println("\nEliminar un jugador:");
            System.out.print("Ingrese el nombre del jugador: ");
            String nombre = scanner.nextLine(); // Tomar el nombre del jugador
            System.out.print("Ingrese el apellido del jugador: ");
            String apellido = scanner.nextLine();

            // Buscar al jugador por nombre y apellido
            boolean encontrado = false;
            Iterator<Jugador> iterator = jugadores.iterator();
            while (iterator.hasNext()) {
                Jugador jugador = iterator.next();
                if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
                    iterator.remove(); // Eliminar el jugador
                    System.out.println("¡Jugador eliminado correctamente!");
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("Jugador no encontrado.");
            }
        }
    }


    
 }


