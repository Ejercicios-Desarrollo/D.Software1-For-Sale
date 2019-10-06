package domain;

public class NoReservado extends EstadoOperacion {

    public NoReservado(){

    }

    @Override
    public void reservar(Cliente unCliente, Empleado unEmpleado, Inmueble unInmueble){
        this.cliente = unCliente;
        this.empleado = unEmpleado;
        unInmueble.operacion.setEstadoOperacion(new Reservado());
        unEmpleado.agregarOperacion(unInmueble.getOperacion());
        unEmpleado.aumentarCantidadReservas();
    }

    @Override
    public void concretar(Cliente unCliente, Empleado unEmpleado, Inmueble unInmueble){
        this.cliente = unCliente;
        this.empleado = unEmpleado;
        unInmueble.operacion.setEstadoOperacion(new Concretado());
        unEmpleado.agregarOperacion(unInmueble.getOperacion());
        unEmpleado.aumentarOperacionesConcretadas();
    }
}