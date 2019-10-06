package domain;

public abstract class Inmueble {
    protected double metrosCuadrados;
    protected int cantidadAmbientes;
    protected Zona zona;
    protected Operacion operacion;
    protected double precio;

    protected Inmueble(int metrosCuadrados, int cantidadAmbientes){
        this.metrosCuadrados = metrosCuadrados;
        this.cantidadAmbientes = cantidadAmbientes;
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

    public double plus(){
        return this.zona.getPlus();
    }

    protected void calcularPrecio(){

    }

    public boolean estaReservadoPorCliente(Cliente unCliente){
        boolean estaReservado;
        if(this.operacion.getEstadoOperacion().cliente == unCliente){
            estaReservado = true;
        }
        else estaReservado = false;

        return estaReservado;
    }
}
