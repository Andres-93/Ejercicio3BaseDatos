package modelo;

public class piloto {

	private int numero;
	private String nombre;
	private String nacionalidad;
	private int edad;
	private String escuderia;
	
	public piloto(int numero, String nombre, String nacionalidad, int edad, String escuderia) {
		this.numero = numero;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.edad = edad;
		this.escuderia = escuderia;
	}

	public int getNumero() {
		return numero;
	}

	public String getNombre() {
		return nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public int getEdad() {
		return edad;
	}

	public String getEscuderia() {
		return escuderia;
	}

	@Override
	public String toString() {
		return "piloto [numero=" + numero + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad + ", edad=" + edad
				+ ", escuderia=" + escuderia + "]";
	}
	
			
}
