package domain;

public class Local extends Casa{
    private TipoLocal tipoLocal;
    public Local(int metrosCuadrados, int cantidadAmbientes, Zona zona, double precio, TipoLocal tipoLocal){
        super(metrosCuadrados,cantidadAmbientes, zona, precio);
        this.tipoLocal = tipoLocal;
        calcularPrecio();
    }

    @Override
    protected void calcularPrecio(){
        this.tipoLocal.calcularPrecio(this);
        super.calcularPrecio();
    }

    public void remodelarLocal() {
        this.tipoLocal.remodelar(this);
        this.calcularPrecio();
    }

    public void setTipoLocal(TipoLocal tipoLocal) {
        this.tipoLocal = tipoLocal;
    }

    @Override
    public void setOperacion(Operacion operacion) {

    }

    public void setOperacion(Alquiler alquiler) {
        this.operacion = alquiler;
        operacion.setInmueble(this);
    }
}
