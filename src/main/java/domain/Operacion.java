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
}
