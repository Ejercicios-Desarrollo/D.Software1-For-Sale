package domain;

public class NoReservado extends EstadoOperacion {

    public NoReservado(){

    }

    @Override
    public void reservar(Cliente unCliente, Empleado unEmpleado, Inmueble unInmueble){
        unInmueble.cambiarEstadoOperacion(new Reservado(unCliente, unEmpleado));
        unEmpleado.agregarOperacion(unInmueble.getOperacion());
        unEmpleado.aumentarCantidadReservas();
    }

    @Override
    public void concretar(Cliente unCliente, Empleado unEmpleado, Inmueble unInmueble){
        unInmueble.cambiarEstadoOperacion(new Concretado(unCliente, unEmpleado));
        unEmpleado.agregarOperacion(unInmueble.getOperacion());
        unEmpleado.aumentarOperacionesConcretadas();
    }
}