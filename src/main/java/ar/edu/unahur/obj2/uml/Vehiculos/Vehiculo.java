package ar.edu.unahur.obj2.uml.Vehiculos;

public abstract class Vehiculo {
    private Boolean estaDisponible;

    public Vehiculo(Boolean estaDisponible) { 
        this.estaDisponible = estaDisponible;
    }

    public Boolean estaDisponible() { return estaDisponible; }

    public void setDisponibilidad(Boolean estaDisponible) {
        this.estaDisponible = estaDisponible;
    }
}