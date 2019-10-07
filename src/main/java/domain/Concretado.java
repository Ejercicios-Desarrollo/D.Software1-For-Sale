package domain;

public class Concretado extends EstadoOperacion {

    public Concretado(Cliente unCliente, Empleado unEmpleado){
        this.cliente = unCliente;
        this.empleado = unEmpleado;
    }

    @Override
    public void reservar(Cliente unCliente, Empleado unEmpleado, Inmueble unInmueble){

    }

    @Override
    public void concretar(Cliente unCliente, Empleado unEmpleado, Inmueble unInmueble){

    }

}