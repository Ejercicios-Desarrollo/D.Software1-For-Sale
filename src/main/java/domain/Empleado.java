package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

    public void concretarOperacion(Inmueble inmueble, Cliente unCliente){
        inmueble.concretarOperacion(this, unCliente);
        comisiones += cobrarComision(inmueble);
    }

    public void reservarOperacion(Inmueble inmueble, Cliente unCliente){
        inmueble.reservarOperacion(this, unCliente);
    }

    public void agregarOperacion(Operacion unaOperacion){
        this.operaciones.add(unaOperacion);
    }

    public double cobrarComision(Inmueble inmueble){
        return inmueble.operacion.calcularComision();
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

    public boolean hayProblemasCon(Empleado unEmpleado){
        Predicate<Operacion> filtro = opEsteEmpleado -> unEmpleado.operaciones.stream().anyMatch(opOtroEmpleado -> opOtroEmpleado.getInmueble().getZona() == opEsteEmpleado.getInmueble().getZona());
        List<Operacion> operacionesEnMismaZona = this.operaciones.stream().filter(filtro).collect(Collectors.toList());
        return operacionesEnMismaZona.stream().anyMatch(o -> o.getUltimoEmpleado() == unEmpleado);
    }
}
