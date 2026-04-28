package ar.edu.unahur.obj2.uml.Vehiculos;

public class Monopatin extends Vehiculo {
    private String marca;

	public Monopatin(Boolean estaDisponible, String marca) {
		super(estaDisponible);
		this.marca = marca;
	}

	public String getMarca() { return marca; }

	public void setMarca(String marca) { this.marca = marca; }
}