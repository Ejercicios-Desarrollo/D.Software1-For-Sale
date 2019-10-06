package domain;

public class NoReservado extends EstadoOperacion {

    public NoReservado(){

    }

    @Override
    public void reservar(Cliente unCliente, Empleado unEmpleado, Inmueble unInmueble){
        unInmueble.operacion.setEstadoOperacion(new Reservado());
        unInmueble.operacion.getEstadoOperacion().cliente = unCliente;
        unInmueble.operacion.getEstadoOperacion().empleado = unEmpleado;
        unEmpleado.agregarOperacion(unInmueble.getOperacion());
        unEmpleado.aumentarCantidadReservas();
    }

    @Override
    public void concretar(Cliente unCliente, Empleado unEmpleado, Inmueble unInmueble){
        unInmueble.operacion.setEstadoOperacion(new Concretado());
        unInmueble.operacion.getEstadoOperacion().cliente = unCliente;
        unInmueble.operacion.getEstadoOperacion().empleado = unEmpleado;
        unEmpleado.agregarOperacion(unInmueble.getOperacion());
        unEmpleado.aumentarOperacionesConcretadas();
    }
}