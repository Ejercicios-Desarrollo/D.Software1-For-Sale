package domain;

public class Reservado extends EstadoOperacion {

    public Reservado(Cliente unCliente, Empleado unEmpleado){
        this.cliente = unCliente;
        this.empleado = unEmpleado;
    }

    @Override
    public void reservar(Cliente unCliente, Empleado unEmpleado, Inmueble unInmueble){

    }

    @Override
    public void concretar(Cliente unCliente, Empleado unEmpleado, Inmueble unInmueble){
        if(unInmueble.estaReservadoPorCliente(unCliente)){
            unInmueble.cambiarEstadoOperacion(new Concretado(unCliente, unEmpleado));
            unEmpleado.agregarOperacion(unInmueble.getOperacion());
            unEmpleado.aumentarOperacionesConcretadas();
        }
    }
}
