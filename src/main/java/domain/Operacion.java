package domain;

public abstract class Operacion {
    private EstadoOperacion estadoOperacion;
    private Inmueble inmueble;

    public Operacion(){
        this.estadoOperacion = new NoReservado();
    }

    public void setEstadoOperacion(EstadoOperacion estadoOperacion) {
        this.estadoOperacion = estadoOperacion;
    }

    public EstadoOperacion getEstadoOperacion() {
        return estadoOperacion;
    }

    public double calcularComision(){
        return 0;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public Empleado getUltimoEmpleado(){
        return this.estadoOperacion.getEmpleado();
    }

    public boolean reservadoPor(Cliente unCliente){
        return this.getEstadoOperacion().getCliente() == unCliente;
    }

    public void concretarPor(Empleado unEmpleado, Cliente unCliente){
        this.estadoOperacion.concretar(unCliente, unEmpleado, this.inmueble);
    }

    public void reservarPor(Empleado unEmpleado, Cliente unCliente){
        this.estadoOperacion.reservar(unCliente, unEmpleado, this.inmueble);
    }
}
