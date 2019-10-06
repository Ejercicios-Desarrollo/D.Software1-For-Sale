package domain;

public class NoReservado extends EstadoOperacion {

    public NoReservado(){

    }

    @Override
    public void reservar(Cliente unCliente, Empleado unEmpleado, Inmueble unInmueble){
        this.cliente = unCliente;
        unInmueble.operacion.setEstadoOperacion(new Reservado());
        unEmpleado.aumentarCantidadReservas();
    }

    @Override
    public void concretar(Cliente unCliente, Empleado unEmpleado, Inmueble unInmueble){
        if(unInmueble.estaAsignadoACliente(unCliente)){
            unInmueble.operacion.setEstadoOperacion(new Concretado());
            unEmpleado.aumentarOperacionesConcretadas();
        }
    }
}