package ar.edu.unahur.obj2.uml.Vehiculos;

public class Bicicleta extends Vehiculo {
    private Integer rodado;

	public Bicicleta(Boolean estaDisponible, Integer rodado) {
		super(estaDisponible);
		this.rodado = rodado;
	}

	public Integer getRodado() { return rodado; }

	public void setRodado(Integer rodado) { this.rodado = rodado; }
}