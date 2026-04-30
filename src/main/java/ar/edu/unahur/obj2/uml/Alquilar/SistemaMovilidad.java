package ar.edu.unahur.obj2.uml.Alquilar;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.uml.Vehiculos.Vehiculo;

public class SistemaMovilidad {
    private static final SistemaMovilidad instance = new SistemaMovilidad();
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Vehiculo> vehiculos = new ArrayList<>();
    private List<Alquiler> alquileres = new ArrayList<>();
    private SistemaMovilidad() {}

    public static SistemaMovilidad getInstance() { return instance; }

	public void registrarUsuario(Usuario unUsuario) { usuarios.add(unUsuario); }

    public void registrarVehiculo(Vehiculo unVehiculo) { vehiculos.add(unVehiculo); }

    public void registrarAlquiler(Usuario usuario, Vehiculo vehiculo, String fechaIni, String fechaFin) {
        if (!vehiculos.contains(vehiculo)) { throw new RuntimeException("El vehículo no está en el sistema"); }
        if (!vehiculo.estaDisponible()) { throw new RuntimeException("El vehículo no está disponible"); }
        else {
            Alquiler alquiler = new Alquiler(usuario, vehiculo, fechaIni, fechaFin);
            alquiler.concretar(usuario, vehiculo);
            alquileres.add(alquiler);
        }
    }

    public List<Vehiculo> getVehiculosDisponibles() { return vehiculos.stream().filter(v -> v.estaDisponible()).toList(); }

    public List<Alquiler> getAlquileres() { return alquileres; }

	public void limpiarElSistema() {
        usuarios.clear();
        vehiculos.clear();
        alquileres.clear();
    }
}