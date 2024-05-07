package ar.edu.unju.fi.ejercicio6.interfaces.funcionales;

public interface Converter<T, T1> {
	static <T> boolean isNotNull(T t) {
		return t != null;
	}
	
	default void mostrarObjeto(T1 t1) {
		System.out.println("Objeto - " + t1.toString());
	}
}
