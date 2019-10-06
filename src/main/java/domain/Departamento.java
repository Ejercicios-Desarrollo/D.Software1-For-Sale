package domain;

public class Departamento extends Inmueble {

    public Departamento(int metrosCuadrados, int cantidadAmbientes){
        super(metrosCuadrados,cantidadAmbientes);
    }

    @Override
    protected void calcularPrecio(){
        this.precio = plus() + this.cantidadAmbientes * 350000;
    }
}