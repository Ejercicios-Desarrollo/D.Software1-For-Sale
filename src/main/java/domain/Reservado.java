package domain;

public class Reservado extends EstadoOperacion {

    public Reservado(){

    }

    @Override
    public void reservar(Cliente unCliente, Empleado unEmpleado, Inmueble unInmueble){

    }

    @Override
    public void concretar(Cliente unCliente, Empleado unEmpleado, Inmueble unInmueble){
        if(unInmueble.estaAsignadoACliente(unCliente)){
            unInmueble.operacion.setEstadoOperacion(new Concretado());
            unEmpleado.aumentarOperacionesConcretadas();
        }
    }
}
