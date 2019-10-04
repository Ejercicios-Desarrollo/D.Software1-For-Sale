package domain;

public class Empleado {
    private double ganancias;
    private String nombre;
    public Empleado(String nombre){
        this.nombre = nombre;
    }

    public void concretarOperacion(Inmueble inmueble, Cliente cliente){
        inmueble.operacion.getEstadoOperacion().concretar(cliente, this, inmueble);
        ganancias += cobrarComision(inmueble);
    }

    public double cobrarComision(Inmueble inmueble){
        return inmueble.operacion.calcularComision();
    }

    public void reservarOperacion(Inmueble inmueble, Cliente cliente){
        inmueble.operacion.getEstadoOperacion().reservar(cliente, this, inmueble);
    }
}
