package ar.edu.unahur.obj2.uml.Alquilar;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.uml.Vehiculos.Vehiculo;

public class Usuario {
    private String nombre;
    private List<Alquiler> alquileres = new ArrayList<>();

    public Usuario(String nombre) { this.nombre = nombre; }

    public String getNombre() { return nombre; }

    public void agregarAlquiler(Alquiler alquiler) { alquileres.add(alquiler); }

    public void alquilar(Vehiculo vehiculo, String inicio, String fin) {
        SistemaMovilidad.getInstance().registrarAlquiler(this, vehiculo, inicio, fin);
    }

	public List<Alquiler> getAlquileres() { return alquileres; }

	public void setAlquileres(List<Alquiler> alquileres) { this.alquileres = alquileres; }
}