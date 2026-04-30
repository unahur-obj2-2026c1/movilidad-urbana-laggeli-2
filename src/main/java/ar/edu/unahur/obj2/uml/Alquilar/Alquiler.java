package ar.edu.unahur.obj2.uml.Alquilar;

import ar.edu.unahur.obj2.uml.Vehiculos.Vehiculo;

public class Alquiler {
    private String fechaInicial;
    private String fechaFinal;
    private Usuario usuario;
    private Vehiculo vehiculo;

    public Alquiler(Usuario usuario, Vehiculo vehiculo, String fechaInicial, String fechaFinal) {
        this.usuario = usuario;
        this.vehiculo = vehiculo;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
    }

    public void concretar(Usuario usuario, Vehiculo vehiculo) {
        vehiculo.setDisponibilidad(false);
        usuario.agregarAlquiler(this);
    }
}