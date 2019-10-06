package domain;

import java.util.ArrayList;
import java.util.List;

public class Empleado {
    private String nombre;
    private double comisiones;
    private int cantidadReservas;
    private int operacionesConcretadas;
    private List<Operacion> operaciones;

    public Empleado(String nombre){
        this.nombre = nombre;
        this.cantidadReservas = 0;
        this.operacionesConcretadas = 0;
        this.comisiones = 0;
        this.operaciones = new ArrayList<>();
    }

    public void concretarOperacion(Inmueble inmueble, Cliente cliente){
        inmueble.operacion.getEstadoOperacion().concretar(cliente, this, inmueble);
        comisiones += cobrarComision(inmueble);
    }

    public void agregarOperacion(Operacion unaOperacion){
        this.operaciones.add(unaOperacion);
    }

    public double cobrarComision(Inmueble inmueble){
        return inmueble.operacion.calcularComision();
    }

    public void reservarOperacion(Inmueble inmueble, Cliente cliente){
        inmueble.operacion.getEstadoOperacion().reservar(cliente, this, inmueble);
    }

    public void aumentarCantidadReservas(){
        this.cantidadReservas++;
    }

    public void aumentarOperacionesConcretadas(){
        this.operacionesConcretadas++;
    }

    public double getComisiones() {
        return comisiones;
    }

    public int getCantidadReservas() {
        return cantidadReservas;
    }

    public int getOperacionesConcretadas() {
        return operacionesConcretadas;
    }
}
