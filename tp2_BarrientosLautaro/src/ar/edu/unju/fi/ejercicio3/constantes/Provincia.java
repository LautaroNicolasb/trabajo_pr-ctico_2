package ar.edu.unju.fi.ejercicio3.constantes;

public enum Provincia {
		JUJUY(766742, 53219),
	    SALTA(1340403, 155488),
	    TUCUMAN(1448188, 22524),
	    CATAMARCA(367820, 102602),
	    LA_RIOJA(393531, 89680),
	    SANTIAGO_DEL_ESTERO(896461, 136351);
			
		private int cantidadPoblacion;
		private double superficie;
		
		private Provincia(int cantidadPoblacion, int superficie) {
		        this.cantidadPoblacion = cantidadPoblacion;
		        this.superficie = superficie;
		}
		
		public int getCantidadPoblacion() {
			return cantidadPoblacion;
		}



		public void setCantidadPoblacion(int cantidadPoblacion) {
			this.cantidadPoblacion = cantidadPoblacion;
		}



		public double getSuperficie() {
			return superficie;
		}



		public void setSuperficie(double superficie) {
			this.superficie = superficie;
		}



		public double calcularLaDensidadDePoblacion() {
			double densidad = cantidadPoblacion/superficie;
			return densidad;
		}

}
