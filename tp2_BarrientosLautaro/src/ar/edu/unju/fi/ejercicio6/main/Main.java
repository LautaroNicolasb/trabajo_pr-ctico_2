package ar.edu.unju.fi.ejercicio6.main;

import ar.edu.unju.fi.ejercicio6.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio6.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio6.model.FelinoSalvaje;

public class Main {

	public static void main(String[] args) {
		FelinoDomestico gato = new FelinoDomestico("Garfield", (byte)45, 12f);
		Converter<FelinoDomestico, FelinoSalvaje> converter = x -> new FelinoSalvaje(x.getNombre(), x.getEdad(), x.getPeso());
		FelinoSalvaje felino1 = converter.convert(gato);
		converter.mostrarObjeto(felino1);
		
		FelinoSalvaje leon = new FelinoSalvaje("Tanner", (byte) 20, 186f);
        Converter<FelinoSalvaje, FelinoDomestico> converterInverso = x -> new FelinoDomestico(x.getNombre(), x.getEdad(), x.getPeso());
        // Verificar que el objeto a convertir no es nulo utilizando el método estático isNotNull
        if (Converter.isNotNull(leon)) {
            // Mostrar los datos del objeto felino doméstico
            converterInverso.mostrarObjeto(converterInverso.convert(leon));
        }
		
	}

}
