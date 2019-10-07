package domain;

public abstract class Inmueble {
    protected double metrosCuadrados;
    protected int cantidadAmbientes;
    protected Zona zona;
    protected Operacion operacion;
    protected double precio;

    protected Inmueble(int metrosCuadrados, int cantidadAmbientes, Zona zona){
        this.metrosCuadrados = metrosCuadrados;
        this.cantidadAmbientes = cantidadAmbientes;
        this.zona = zona;
        this.calcularPrecio();
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public Operacion getOperacion() {
        return operacion;
    }

    public void setOperacion(Operacion operacion) {
        this.operacion = operacion;
        operacion.setInmueble(this);
    }

    public void cambiarEstadoOperacion(EstadoOperacion estadoOperacion){
        this.operacion.setEstadoOperacion(estadoOperacion);
    }

    public void concretarOperacion(Empleado unEmpleado, Cliente unCliente){
        this.operacion.concretarPor(unEmpleado, unCliente);
    }

    public void reservarOperacion(Empleado unEmpleado, Cliente unCliente){
        this.operacion.reservarPor(unEmpleado, unCliente);
    }

    public double plus(){
        return this.zona.getPlus();
    }

    protected void calcularPrecio(){

    }

    public boolean estaReservadoPorCliente(Cliente unCliente){
        boolean estaReservado;
        if(this.operacion.reservadoPor(unCliente)){
            estaReservado = true;
        }
        else estaReservado = false;

        return estaReservado;
    }
}
