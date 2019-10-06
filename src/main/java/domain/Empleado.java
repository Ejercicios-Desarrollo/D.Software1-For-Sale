package domain;

public class Empleado {
    private String nombre;
    private double comisiones;
    private int cantidadReservas;
    private int operacionesConcretadas;

    public Empleado(String nombre){
        this.nombre = nombre;
        this.cantidadReservas = 0;
        this.operacionesConcretadas = 0;
        this.comisiones = 0;
    }

    public void concretarOperacion(Inmueble inmueble, Cliente cliente){
        inmueble.operacion.getEstadoOperacion().concretar(cliente, this, inmueble);
        comisiones += cobrarComision(inmueble);
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
