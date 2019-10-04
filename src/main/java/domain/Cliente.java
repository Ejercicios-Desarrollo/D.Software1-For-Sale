package domain;

public class Cliente {

    private String nombre;

    public Cliente(String nombre){
        this.nombre = nombre;
    }

    public void solicitarReserva(Empleado unEmpleado, Inmueble unInmueble){
        unEmpleado.reservarOperacion(unInmueble, this);
    }

    public void concretarOperacion(Empleado unEmpleado, Inmueble unInmueble){
        unEmpleado.concretarOperacion(unInmueble, this);
    }
}
