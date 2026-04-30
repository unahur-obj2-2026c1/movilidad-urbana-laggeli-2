package ar.edu.unahur.obj2.uml.Alquilar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.uml.Vehiculos.Bicicleta;
import ar.edu.unahur.obj2.uml.Vehiculos.Monopatin;
import ar.edu.unahur.obj2.uml.Vehiculos.Vehiculo;

public class SistemaMovilidadTest {

    @Test
    void dadoUnRegistroElVehiculoApareceDisponible() {
        SistemaMovilidad sistema = SistemaMovilidad.getInstance();
        sistema.limpiarElSistema();
        Vehiculo bici = new Bicicleta(true, 26);
        sistema.registrarVehiculo(bici);

        assertTrue(sistema.getVehiculosDisponibles().contains(bici));
    }

    @Test
    void dadoUnVehiculoNoRegistradoNoPermiteAlquilarlo() {
        SistemaMovilidad sistema = SistemaMovilidad.getInstance();
        sistema.limpiarElSistema();
        Usuario usuario = new Usuario("Sabrina");
        Vehiculo bici = new Bicicleta(true, 26);
        RuntimeException mensaje = assertThrows(RuntimeException.class, () -> {
            sistema.registrarAlquiler(usuario, bici, "05.08.25", "05.10.25");
        });

        assertEquals("El vehículo no está en el sistema", mensaje.getMessage());
    }

    @Test
    void dadoUnVehiculoNoDisponibleNoPermiteAlquilarlo() {
        SistemaMovilidad sistema = SistemaMovilidad.getInstance();
        sistema.limpiarElSistema();
        Usuario usuario = new Usuario("Juan");
        Vehiculo bici = new Bicicleta(false, 26);
        sistema.registrarVehiculo(bici);
        RuntimeException mensaje = assertThrows(RuntimeException.class, () -> {
            sistema.registrarAlquiler(usuario, bici, "05.08.25", "05.10.25");
        });

        assertEquals("El vehículo no está disponible", mensaje.getMessage());
    }

    @Test
    void dadoUnVehiculoSeAlquilaCorrectamente() {
        SistemaMovilidad sistema = SistemaMovilidad.getInstance();
        sistema.limpiarElSistema();
        Usuario usuario = new Usuario("Pedro");
        Vehiculo bici = new Bicicleta(true, 26);
        sistema.registrarVehiculo(bici);
        sistema.registrarAlquiler(usuario, bici, "05.08.25", "05.10.25");

        assertFalse(bici.estaDisponible());
        assertEquals(1, usuario.getAlquileres().size());
        assertEquals(1, sistema.getAlquileres().size());
    }

    @Test
    void dadoUnNuevoAlquilerElVehiculoDejaDeEstarDisponible() {
        SistemaMovilidad sistema = SistemaMovilidad.getInstance();
        sistema.limpiarElSistema();
        Usuario usuario = new Usuario("Kevin");
        Vehiculo monopatin = new Monopatin(true, "Dualtron");
        sistema.registrarVehiculo(monopatin);
        sistema.registrarAlquiler(usuario, monopatin, "05.08.25", "05.10.25");

        assertFalse(monopatin.estaDisponible());
    }

    @Test
    void dadoUnaListaSeActualizanLosDisponibles() {
        SistemaMovilidad sistema = SistemaMovilidad.getInstance();
        sistema.limpiarElSistema();
        Usuario usuario = new Usuario("Laura");
        Vehiculo v1 = new Bicicleta(true, 26);
        Vehiculo v2 = new Monopatin(true, "Xiaomi");
        sistema.registrarVehiculo(v1);
        sistema.registrarVehiculo(v2);
        sistema.registrarAlquiler(usuario, v1, "05.08.25", "05.10.25");
        
        assertFalse(sistema.getVehiculosDisponibles().contains(v1));
        assertTrue(sistema.getVehiculosDisponibles().contains(v2));
    }

    @Test
    void dadoUnSistemaSeLimpiaCompletamente() {
        SistemaMovilidad sistema = SistemaMovilidad.getInstance();
        sistema.limpiarElSistema();
        sistema.registrarVehiculo(new Bicicleta(true, 26));
        sistema.limpiarElSistema();
        
        assertTrue(sistema.getVehiculosDisponibles().isEmpty());
        assertTrue(sistema.getAlquileres().isEmpty());
    }
}
