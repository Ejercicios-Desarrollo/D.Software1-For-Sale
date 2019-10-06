package domain;

public class Reservado extends EstadoOperacion {

    public Reservado(){

    }

    @Override
    public void reservar(Cliente unCliente, Empleado unEmpleado, Inmueble unInmueble){

    }

    @Override
    public void concretar(Cliente unCliente, Empleado unEmpleado, Inmueble unInmueble){
        if(unInmueble.estaReservadoPorCliente(unCliente)){
            unInmueble.operacion.setEstadoOperacion(new Concretado());
            unInmueble.operacion.getEstadoOperacion().empleado = unEmpleado;
            unEmpleado.agregarOperacion(unInmueble.getOperacion());
            unEmpleado.aumentarOperacionesConcretadas();
        }
    }
}
